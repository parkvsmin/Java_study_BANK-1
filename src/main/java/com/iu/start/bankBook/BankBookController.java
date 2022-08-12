package com.iu.start.bankBook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {

	// /bankbook/add POST / WEB-INF/views/bankbook/add.jsp
	// name, rate
	@RequestMapping(value="add.iu",method=RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO)throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(bankBookDTO.getBookName());
		System.out.println(bankBookDTO.getBookRate());
		BankBookDAO bankBookDAO = new BankBookDAO();
		int result = bankBookDAO.setBankBook(bankBookDTO);
		//상품등록 후 list 페이지로 이동
		mv.setViewName("redirect:./list.iu");
		return mv;
	}

	// /bankbook/add GET / WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value="add.iu",method=RequestMethod.GET)
	public void add()throws Exception {
		System.out.println("add 실행");
		//return "bankbook/add";
	}

	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		//ModelAndView mv = new ModelAndView();
		System.out.println("list 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();			
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		model.addAttribute("list",ar);
		return "bankbook/list";
	}

	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("detail 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO =bankBookDAO.getDetail(bankBookDTO);
		//return "bankbook/detail";
		//DB가 없으신 분들
		mv.setViewName("bankbook/detail");
		mv.addObject("dto", bankBookDTO);

		return mv;
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO,Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		BankBookDAO bankBookDAO = new BankBookDAO();
		System.out.println(bankBookDTO.getBookNum());
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		model.addAttribute("dto",bankBookDTO);
		
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public ModelAndView update(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		BankBookDAO bankBookDAO = new BankBookDAO();
		System.out.println(bankBookDTO.getBookNum());
		System.out.println(bankBookDTO.getBookName());
		System.out.println(bankBookDTO.getBookRate());
		int result = bankBookDAO.setBankBook(bankBookDTO);
		//업데이트 후 list로 이동
		mv.setViewName("redirect:./detail?bookNum="+bankBookDTO.getBookNum());
		return mv;
		
	}
	
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO,Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		BankBookDAO bankBookDAO = new BankBookDAO();
		int result = bankBookDAO.setDelete(bankBookDTO);
		mv.setViewName("redirect:./list.iu");
		return mv;
	}
	
	@RequestMapping(value = "delete.iu", method = RequestMethod.POST)
	public ModelAndView delete(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		BankBookDAO bankBookDAO = new BankBookDAO();
		System.out.println(bankBookDTO.getBookNum());
		System.out.println(bankBookDTO.getBookName());
		System.out.println(bankBookDTO.getBookRate());
		int result = bankBookDAO.setDelete(bankBookDTO);
		//업데이트 후 list로 이동
		//mv.setViewName("redirect:./detail?bookNum="+bankBookDTO.getBookNum());
		return mv;
		
	}

	//	@RequestMapping(value = "add", method = RequestMethod.GET)
	//	public String add() {
	//		
	//		System.out.println("add GET 실행");
	//		
	//		return "bankbook/add";
	//	}
	//	
	//	@RequestMapping(value = "add", method = RequestMethod.POST)
	//	public void add(BankBookDTO bankBookDTO) throws Exception {
	//		
	//		System.out.println("add Post 실행");
	//		int result = bankBookDAO.setBankBook(bankBookDTO);
	//		System.out.println(result == 1);
	//	}
}