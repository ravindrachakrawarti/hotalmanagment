package AgriMarketBackend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AgriMarketBackend.Entity.Admin;
import AgriMarketBackend.daos.AdminDao;



@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired AdminDao dao;

	@Override
	public Admin validate(String userid, String pwd) {
		// TODO Auto-generated method stub
		Optional<Admin> admin=dao.findById(userid);
		if(admin.isPresent() && admin.get().getPwd().equals(pwd)) {
			return admin.get();
		}
		return null;
	}

	@Override
	public void updateAdmin(Admin admin) {
		if(admin.getPwd().equals("") || admin.getPwd()==null) {
			admin.setPwd(dao.getReferenceById(admin.getUserid()).getPwd());
		}
		dao.save(admin);		
	}

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public void createAdmin() {
		Admin admin=new Admin();
		admin.setUserid("admin@gmail.com");
		admin.setPwd("admin");
		admin.setUname("Administrator");
		dao.save(admin);
	}

}
