package AgriMarketBackend.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AgriMarketBackend.Entity.Address;
import AgriMarketBackend.Entity.Customer;
import AgriMarketBackend.Entity.Order;
import AgriMarketBackend.Entity.OrderDetails;
import AgriMarketBackend.Entity.Payment;
import AgriMarketBackend.Entity.Product;
import AgriMarketBackend.models.CartDTO;
import AgriMarketBackend.models.OrderDetailsDTO;
import AgriMarketBackend.models.OrderResponseDTO;
import AgriMarketBackend.models.PlaceOrderDTO;
import AgriMarketBackend.models.Response;
import AgriMarketBackend.services.AddressService;
import AgriMarketBackend.services.CustomerService;
import AgriMarketBackend.services.OrderService;
import AgriMarketBackend.services.OrderdetailService;
import AgriMarketBackend.services.PaymentService;
import AgriMarketBackend.services.ProductService;



@CrossOrigin
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

	@Autowired OrderService orderService;
	@Autowired CustomerService customerService;
	@Autowired AddressService addressService;
	@Autowired PaymentService paymentService;
	@Autowired OrderdetailService orderDetailsService;	
	@Autowired ProductService pservice;	
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody PlaceOrderDTO dto) {	
		Address address=addressService.saveAddress(dto.getAddress());
		dto.getPayment().setPaymentdate(new Date());
		Payment payment=paymentService.savePayment(dto.getPayment());
		Order order=new Order();
		order.setOrderDate(new Date());
		order.setAddress(address);
		order.setPayment(payment);
		Customer customer=customerService.findById(dto.getCustomerid());
		order.setCustomer(customer);
		Order orders=orderService.saveOrder(order);
		
		for(CartDTO cart : dto.getCart()) {
			OrderDetails od=new OrderDetails();
			od.setOrder(orders);
			od.setQty(cart.getQty());
			od.setSelectedItem(cart.getSelectedItem());
			Product product=pservice.findProductById(cart.getProdid());
			od.setProduct(product);			
			orderDetailsService.saveOrderDetails(od);
			product.setQty(product.getQty()-cart.getQty());
			product.setSelectedItem(product.getSelectedItem());
			pservice.updateProduct(product);
		}
		
		return Response.status(HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllOrders(Optional<Integer> custid) {
		List<Order> result=null;
		if(custid.isPresent()) {
			Customer customer=customerService.findById(custid.get());
			 result= orderService.getCustomerOrders(customer);
		}else {
			result = orderService.getAllOrders();
		}
		return Response.success(result);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findOrderById(@PathVariable("id") int id) {
		Order order = orderService.findById(id);
		List<OrderDetails> details=orderDetailsService.findByOrder(order);
		List<OrderDetailsDTO> detailsdto=new ArrayList<OrderDetailsDTO>();
		details.forEach(od -> {
			OrderDetailsDTO dto=OrderDetailsDTO.fromEntity(od);
			detailsdto.add(dto);
		});
		OrderResponseDTO result=new OrderResponseDTO();
		result.setOrder(order);
		result.setDetails(detailsdto);
		return Response.success(result);
	}
}
