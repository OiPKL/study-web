package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	// final X + Autowired
//	@Autowired
//	private BoardDao boardDao;

	// final + 생성자
	private final BoardDao boardDao;
	
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<Board> getBoardList() {
		System.out.println("리스트 반환 완료");
		return boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) {
		System.out.println(id+"번 글 읽기");
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글 작성 완료");
		boardDao.insertBoard(board);
	}

	@Override
	public void removeBoard(int id) {
		System.out.println("게시글 삭제 완료");
		boardDao.deleteBoard(id);
	}

	@Override
	public void modifyBoard(Board board) {
		System.out.println("게시글 수정 완료");
		boardDao.updateBoard(board);
	}
	
}
