package com.ssafy.board.test;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		BoardDao dao = BoardDaoImpl.getInstance();
		
		System.out.println(dao.selectAll());

		System.out.println(dao.selectOne(1));
		System.out.println(dao.selectOne(5));
		
//		Board board = new Board("응애응애", "김싸피", "응애응애");
//		dao.insertBoard(board);
		
		for (int i = 0; i < 100; i++) {
			Board board = new Board("응애응애" + i, "김싸피", "응애응애");
			dao.insertBoard(board);
		}
		
		dao.deleteBoard(1);
	}
}
