package com.ssafy.board.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.board.config.MyBatisConfig;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		
		System.out.println("selectAll");
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
			List<Board> boards = session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll");
			for (Board board : boards) {
				System.out.println(board);
			}
		}
		
		System.out.println("selectOne");
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
			
			Board board = dao.selectOne(1);
			System.out.println(board);
		}
		
		System.out.println("insertBoard");
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
			
			Board board = new Board("응애", "김싸피", "응애응애");
			dao.insertBoard(board);
		}
		
		System.out.println("selectAll");
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
			List<Board> boards = session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll");
			for (Board board : boards) {
				System.out.println(board);
			}
		}
		
		System.out.println("deleteBoard");
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
			
			dao.deleteBoard(3);
		}
		
		System.out.println("selectAll");
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
			List<Board> boards = session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll");
			for (Board board : boards) {
				System.out.println(board);
			}
		}
		
		System.out.println("updateViewCnt");
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
			
			dao.updateViewCnt(2);
		}
		
		System.out.println("selectOne");
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
			
			Board board = dao.selectOne(2);
			System.out.println(board);
		}
		
		System.out.println("updateBoard");
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
			Board board = dao.selectOne(1);
			
			board.setTitle("응애2");
			dao.updateBoard(board);
		}
		
		
		System.out.println("selectOne");
		try(SqlSession session = MyBatisConfig.getFactory().openSession(true)) {
			BoardDao dao = session.getMapper(BoardDao.class);
			
			Board board = dao.selectOne(1);
			System.out.println(board);
		}
		
	}
}
