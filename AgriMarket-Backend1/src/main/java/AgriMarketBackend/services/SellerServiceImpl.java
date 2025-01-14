package AgriMarketBackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import AgriMarketBackend.Entity.Seller;
import AgriMarketBackend.daos.SellerDao;
import AgriMarketBackend.models.UpdateStatusDTO;
import AgriMarketBackend.utils.StorageService;



@Service
public class SellerServiceImpl implements SellerService {

	@Autowired private SellerDao dao;
	@Autowired private StorageService storage;
	@Override
	public void registerSeller(Seller seller,MultipartFile photo) {
		// TODO Auto-generated method stub
		byte[] filename=storage.store(photo);
		seller.setCertificate(filename);
		dao.save(seller);
	}

	@Override
	public List<Seller> allSellers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Seller findById(int id) {
		// TODO Auto-generated method stub
		return dao.getReferenceById(id);
	}

	@Override
	public Seller validate(String userid, String pwd) {
		Seller seller=dao.findByUserid(userid);
		if(seller!=null && seller.getPwd().equals(pwd)) {
			return seller;
		}
		return null;
	}

	@Override
	public void deleteSeller(int id) {
		// TODO Auto-generated method stub
		Seller seller=dao.getReferenceById(id);
		dao.delete(seller);
	}

	@Override
	public void updateStatus(UpdateStatusDTO dto) {
		// TODO Auto-generated method stub
		Seller seller=findById(dto.getSellerid());
		seller.setIsactive(dto.getStatus());
		dao.save(seller);
	}

	@Override
	public Seller getSellerById(int sellerId) {
        return dao.findById(sellerId)
                .orElseThrow();
    }

}
