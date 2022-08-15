package com.iu.start.board;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.iu.start.board.BoardDAO;
import com.iu.start.board.BoardDTO;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		//ModelAndView mv = new ModelAndView();
		System.out.println("list 실행");
		BoardDAO boardDAO = new BoardDAO();			
		ArrayList<BoardDTO> ar = boardDAO.getList();
		model.addAttribute("list",ar);
		return "board/list";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("detail 실행");
		BoardDAO boardDAO = new BoardDAO();
		boardDTO =boardDAO.getDetail(boardDTO);
		mv.setViewName("board/detail");
		mv.addObject("list",boardDTO);
		return mv;

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(BoardDTO boardDTO) throws Exception {	
		System.out.println("add Post 실행");
		BoardDAO boardDAO = new BoardDAO();
		System.out.println(boardDTO.getTitle());
		System.out.println(boardDTO.getTitle());
		System.out.println(boardDTO.getWriter());
		int result = boardDAO.setUpdate(boardDTO);
		System.out.println(result == 1);
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(BoardDTO boardDTO,Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		BoardDAO boardDAO = new BoardDAO();
		System.out.println(boardDTO.getNum());
		boardDTO = boardDAO.getDetail(boardDTO);
		model.addAttribute("dto",boardDTO);

	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		BoardDAO boardDAO = new BoardDAO();
		System.out.println(boardDTO.getTitle());
		System.out.println(boardDTO.getContent());
		System.out.println(boardDTO.getNum());
		int result = boardDAO.setUpdate(boardDTO);
		return mv;

	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(BoardDTO boardDTO,Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		BoardDAO boardDAO = new BoardDAO();
		System.out.println(boardDTO.getNum());
		int result = boardDAO.setDelete(boardDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}

}
