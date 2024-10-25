package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.service.BoardService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api-board")
@Tag(name="BoardRestful API", description = "게시판 CRUD")
public class BoardRestController {
	// 서비스 의존성 주입
	private final BoardService boardService;

	@Autowired
	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}
	
//	// 게시글 전체 조회
//	@GetMapping("/board")
//	public ResponseEntity<List<Board>> list() {
//		
//		List<Board> list = boardService.getBoardList();
//		return new ResponseEntity<>(list, HttpStatus.OK);
//	}
	
	// 게시글 상세 보기
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable("id") int id) {
		
		Board board = boardService.readBoard(id);
		System.out.println(board);
		
		if (board != null)
			return ResponseEntity.ok(board);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	// 게시글 등록 (Form 데이터)
	@PostMapping("/board")			// json 데이터 -> @RequestBody 필요
	public ResponseEntity<?> write(@ModelAttribute Board board) {
		
		boardService.writeBoard(board);
		System.out.println(board);
		
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
//		return new ResponseEntity<>(result, result == 1 ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
	}
	
	// 게시글 삭제
	@DeleteMapping("/board/{id}")
//	@Hidden
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		
		boolean isDeleted = boardService.removeBoard(id);
		
		if (isDeleted)
			return ResponseEntity.status(HttpStatus.OK).body("Board Deleted");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
//		return new ResponseEntity<>(result, result == 1 ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
	}
	
	// 게시글 수정
	@PutMapping("/board/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Board board) {
		
		board.setId(id);
		boardService.modifyBoard(board);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
//		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
	
	// 게시글 검색
	@GetMapping("/board")
	@Operation(summary="게시글검색", description="조건설정가능")
	public ResponseEntity<?> list(@ModelAttribute SearchCondition condition){
		System.out.println(condition);
		
		List<Board> list = boardService.search(condition);
		
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Board>> (list, HttpStatus.OK);
	}
}
