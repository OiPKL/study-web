package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.util.DBUtil;

public class BoardDaoImpl implements BoardDao {
	
	private DBUtil util = DBUtil.getInstance();

	private static BoardDao dao = new BoardDaoImpl();
	
	private BoardDaoImpl() {
		
	}
	
	public static BoardDao getInstance() {
		return dao;
	}
	
	@Override
	public List<Board> selectAll() {
		List<Board> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM board";
		Board board = null;
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				board = new Board();
				board.setId(rs.getInt("id"));
				board.setWriter(rs.getString("writer"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}

		return list;
	}

	@Override
	public Board selectOne(int id) {
		
		// 데이터가 없어도 null 값 반환 가능하도록
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// PreparedStatement를 사용하자!
//			String sql = "SELECT * FROM board WHERE id=" + id;
		String sql = "SELECT * FROM board WHERE id=?";
		Board board = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id); 	// 인덱스는 1부터 시작
			rs = pstmt.executeQuery(); // 사전에 미리 sql 문을 작성함 -> sql 전달 필요 X
			board = new Board();
			
			while(rs.next()) {
//				board.setId(rs.getInt("id"));				// 라벨명
				board.setId(rs.getInt(1));					// 인덱스
				board.setWriter(rs.getString(2));
				board.setTitle(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setViewCnt(rs.getInt(5));
				board.setRegDate(rs.getString(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return board;
	}

	@Override
	public void insertBoard(Board board) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// PreparedStatement를 사용하자!
//		String sql = "INSERT INTO board (title, writer, content) VALUES('" + board.getTitle() + "'.....";
		String sql = "INSERT INTO board (title, writer, content) VALUES(?, ?, ?)";
		
		try {
			conn = util.getConnection();
			
//			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			// result 값을 통해 데이터 삽입 성공여부 확인 가능 -> commit? rollback?
			int result = pstmt.executeUpdate();
			
//			conn.commit();
//			conn.rollback();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public void deleteBoard(int id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM board WHERE id=?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			int result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
		
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateViewCnt(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
