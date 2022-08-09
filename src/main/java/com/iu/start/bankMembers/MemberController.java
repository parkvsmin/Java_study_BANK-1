package com.iu.start.bankMembers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.start.bankBook.BankBookDTO;

@Controller 
@RequestMapping(value="/member/*")
//이 클래스는 Controller역할, 
//Container에게 이 클래스의 객체를 생성 위임
public class MemberController {
	
	// annotation
	// @ : 설명+실행
	
	//  /member/login // 절대경로 작성
	@RequestMapping(value = "login")
	public String login() {
		System.out.println("로그인 실행");
		return "member/login";
	}
	
	// join  /member/join Get
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("조인 Get 실행");
		
		return "member/join";
	}
	
	//Post
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
//		System.out.println(request.getParameter("name"));
		System.out.println("조인 Post 실행");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		//String username = request.getParameter("username");
//		bankMembersDTO.setUsername(username);
//		bankMembersDTO.setPassword(password);
//		bankMembersDTO.setName(name);
//		bankMembersDTO.setEmail(email);
//		bankMembersDTO.setPhone(phone);
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		System.out.println(result==1);
		return "member/join";
	}

}
