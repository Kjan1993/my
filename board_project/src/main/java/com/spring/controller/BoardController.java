package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dao.BoardDAO;
import com.spring.dto.BoardVO;
import com.spring.dto.Criteria;
import com.spring.dto.PageMaker;
import com.spring.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(Model model)throws Exception{
		
		List<BoardVO> boardList=service.getBoardList();
		model.addAttribute("boardList",boardList);
	}
	
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public void create() throws Exception{}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createPOST(BoardVO board,RedirectAttributes rtts) throws Exception{
		service.create(board);
		rtts.addFlashAttribute("msg","SUCCESS"); //파라메타로 넘어감
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public void read(int bno,Model model) throws Exception{
		BoardVO board = service.read(bno);
		model.addAttribute("boardVO",board);

	}
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void modify(int bno,Model model) throws Exception{
		BoardVO board = service.getBoardByBNO(bno);
		model.addAttribute("boardVO",board);
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
		service.modify(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public String remove(int bno, RedirectAttributes rttr) throws Exception{
		service.remove(bno);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/listCri",method=RequestMethod.GET)
	public void listCri(Criteria cri, Model model) throws Exception{
		List<BoardVO> boardList = service.getListCriteria(cri);
		model.addAttribute("boardList",boardList);
	}
	
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public void listPage(Criteria cri, Model model)throws Exception{
		List<BoardVO> boardList=service.getListCriteria(cri);
		model.addAttribute("boardList", boardList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(dao.totalCountBoard());
		
		model.addAttribute("pageMaker", pageMaker);
		
	}
}
