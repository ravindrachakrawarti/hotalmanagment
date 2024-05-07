package AgriMarketBackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AgriMarketBackend.Entity.Customer;
import AgriMarketBackend.daos.CustomerDao;



@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired private CustomerDao dao;

	@Override
	public void registerCustomer(Customer cust) {
		dao.save(cust);
	}

	@Override
	public List<Customer> allCustomers() {
		
		return dao.findAll();
	}

	@Override
	public Customer findById(int id) {
		
		return dao.getReferenceById(id);
	}

	@Override
	public Customer validate(String userid, String pwd) {
		Customer cc=dao.findByUserid(userid);
		if(cc!=null && cc.getPwd().equals(pwd)) {
			return cc;
		}
		return null;
	}
	
	@Override
	public boolean verifyUserId(String userid) {
		
		return dao.findByUserid(userid)!=null;
	}

	@Override
	public void updateProfile(Customer cust) {
		
		if(cust.getPwd().equals("") || cust.getPwd()==null) {
			cust.setPwd(findById(cust.getId()).getPwd());
		}
		dao.save(cust);	
	}
	
}
