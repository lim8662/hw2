package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.OfferService;

@Controller
public class OfferController {
	
	@Autowired //D.I
	private OfferService offerService;
	
	@RequestMapping(value = "/offers") //이 url로 request가 오면 showOffers가 수행
	public String showOffers(Model model)  {
		List<Offer> offers = offerService.getCurrent();
		model.addAttribute("offers", offers);
		
		return "offers"; //view name
	}
	
	@RequestMapping("/suboffers")
	public String showSubjects(Model model, @RequestParam(value="year") String year,
			@RequestParam(value="semester") String semester) {
		
		List<Offer> offers = offerService.getSuboffers(Integer.parseInt(year), Integer.parseInt(semester));
		model.addAttribute("offers", offers);
		
		return "suboffers";
	}
	
	
	@RequestMapping(value = "/createoffer") 
	public String createOffer(Model model)  {
		
		model.addAttribute("offer", new Offer());
		return "createoffer"; 
	}
	
	@RequestMapping(value = "/docreate") 
	//Data Binding에 의해 Offer 객체가 만들어지고 form data가 저장되서 넘어옴
	//valid 가 검증해서 결과를 result로 반환
	public String doCreate(Model model, @Valid Offer offer, BindingResult result)  { 
		
		if(result.hasErrors()) {
			System.out.println("===Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "createoffer";
		}
		
		offerService.insert(offer);
		
		return "offercreated"; 
	}
	
}
