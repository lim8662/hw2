package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.OfferDAO;
import kr.ac.hansung.model.Offer;

@Service // Service bean으로 등록
public class OfferService {
	
	@Autowired // D.I
	private OfferDAO offerDao;
	
	public List<Offer> getCurrent() {
		return offerDao.getOffers();
	}
	
	public List<Offer> getSuboffers(int year, int semester) {
		return offerDao.getSuboffers(year, semester);
	}

	public void insert(Offer offer) {
		offerDao.insert(offer);
		
	}

}
