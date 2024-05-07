package AgriMarketBackend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.razorpay.*;



import org.json.JSONObject;


@RestController

@CrossOrigin("http://localhost:3000")
public class PaymentController {
	
	
	@Value("${rzp_key_id}")
    private String keyId;

    @Value("${rzp_key_secret}")
    private String secret;
    
    @GetMapping("/payment/{amount}")
    public String Payment(@PathVariable String amount) throws RazorpayException {
        

		 var client=  new RazorpayClient("rzp_test_4xOJiuPbQ8GlQA", "qZNEUVLZPz9p7aTxVAayL5rT");
		
		    JSONObject ob=new JSONObject();
		    ob.put("amount",amount);
		    ob.put("currency", "INR");
		    ob.put("receipt", "txn_235425");
		 
		 //create new order
		    
		    Order order=client.Orders.create(ob);
		    
        String orderId = order.get("id");

        return orderId;
    }
	
	
	

}
