package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;

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

	@Transactional
	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글 작성 완료");
		boardDao.insertBoard(board);
	}

	@Transactional
	@Override
	public boolean removeBoard(int id) {
		System.out.println("게시글 삭제 완료");
		
		// boardDao 에서 int 반환 => 변경된 레코드 개수 => delete 에서는 0과 1 만 존재
		int result = boardDao.deleteBoard(id);
		System.out.println(result);
		
		return (result == 1);
	}

	@Transactional
	@Override
	public void modifyBoard(Board board) {
		System.out.println("게시글 수정 완료");
		
		// 해당 id의 게시글을 가져와서 업데이트해야 null 방지됨
//		Board tmp = boardDao.selectOne(board.getId());
//		tmp.setTitle(board.getTitle());
		boardDao.updateBoard(board);
	}

	@Override
	public List<Board> search(SearchCondition condition) {
		
		return boardDao.search(condition);
	}
}
