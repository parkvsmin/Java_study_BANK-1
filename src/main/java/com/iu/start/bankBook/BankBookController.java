package com.iu.start.bankBook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list() {
		System.out.println("list 실행");
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Long booknum) {
		System.out.println("detail 실행");
		System.out.println("booknum : "+booknum);
		return "bankbook/detail2";
	}

}
