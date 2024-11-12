package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.dto.Board;
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.service.BoardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


/*
 * 게시판 기능을 위한 컨트롤러
 * 게시글 목록 조회, 게시글 상세 조회, 게시글 작성, 게시글 수정, 게시글 삭제 기능을 제공
 */

// BoardController 클래스를 컨트롤러 Bean으로 등록하고, 정의된 모든 요청 URL은 "/board"로 시작하도록 매핑
@Tag(name = "Board", description = "게시글 관리")
@RestController
@RequestMapping("/board")
@CrossOrigin("*")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Operation(summary = "게시글 목록 조회", description = "모든 게시글의 정보를 조회합니다.")
    @GetMapping("")
    public ResponseEntity<?> list() {
        List<Board> boards = boardService.getBoardList();
    	return ResponseEntity.ok(boards);
    }

	@Operation(summary = "게시글 상세 조회", description = "게시글의 상세 정보를 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable int id) {
		Board board = boardService.readBoard(id);
		return new ResponseEntity<>(board, board == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
    
	@Operation(summary = "게시글 작성", description = "게시글을 작성합니다.")
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Board board) {
		int result = boardService.writeBoard(board);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

	@Operation(summary = "게시글 수정", description = "게시글을 수정합니다.")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Board updatedBoard) {
        updatedBoard.setId(id);
        int result = boardService.modifyBoard(updatedBoard);
        return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

	@Operation(summary = "게시글 삭제", description = "게시글을 삭제합니다.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
		int result = boardService.removeBoard(id);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
    
	@Operation(summary = "게시글 검색", description = "게시글을 검색합니다.")
	@PostMapping("/search")
	public ResponseEntity<?> search(@RequestBody SearchCondition condition) {
		System.out.println(condition);
		List<Board> boards = boardService.searchBoard(condition);
		return ResponseEntity.ok(boards);
	}
}