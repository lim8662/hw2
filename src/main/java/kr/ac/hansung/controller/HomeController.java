package kr.ac.hansung.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller // = @Component + 컨트롤러 역할
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET) // url이 "root/"인 경우 메서드 수행
	public String showhome(Locale locale, Model model) {
		/*
		 * date = new Date(); DateFormat dateFormat =
		 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		 * String formattedDate = dateFormat.format(date);
		 * 
		 * model.addAttribute("serverTime", formattedDate ); // 주소로 참조하여 model에 key 와
		 * value 저장
		 */
		return "home"; // view name
	}

}
