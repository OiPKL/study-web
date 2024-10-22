package com.ssafy.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.service.BoardService;

@Controller
public class BoardController {
	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Board> boards = boardService.getBoardList();
		model.addAttribute("boards", boards);
		
		return "/board/list";
	}
	
	@GetMapping("writeform")
	public String writeform() {
		return "/board/writeform";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute Board board) {
		boardService.writeBoard(board);
		
		return "redirect:list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id") int id, Model model) {
		Board board = boardService.readBoard(id);
		model.addAttribute("board", board);
		
		return "/board/detail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		boardService.removeBoard(id);
		
		return "redirect:list";
	}
	
	@GetMapping("/updateform")
	public String updateform(@RequestParam("id") int id, Model model) {
		// readBoard -> 게시글 조회 시 조회수 +1 ..
		// 업데이트는 조회수가 안오르는 메서드가 필요해보임
		Board board = boardService.readBoard(id);
		model.addAttribute("board", board);
		
		return "/board/updateform";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Board board) {
		boardService.modifyBoard(board);
		
		return "redirect:detail?id="+board.getId();
	}
	
	@GetMapping("/search")
	public String search(@ModelAttribute SearchCondition condition, Model model) {
		model.addAttribute("boards", boardService.search(condition));
		
		return "/board/list";
	}
}
