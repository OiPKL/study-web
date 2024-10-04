package com.ssafy.schedule.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.schedule.model.dto.Schedule;
import com.ssafy.schedule.util.DBUtil;

public class ScheduleDaoImpl implements ScheduleDao {
	
	private DBUtil util = DBUtil.getInstance();
	private static ScheduleDao dao = new ScheduleDaoImpl();
	
	
	private ScheduleDaoImpl() {
	}
	
	public static ScheduleDao getInstance() {
		return dao;
	}

	@Override
	public List<Schedule> selectAll() {
		List<Schedule> tmp = new ArrayList<>();
		ResultSet rs = null;
		ResultSet rs2 = null;
		String sql = "SELECT * FROM list ORDER BY date DESC";
		String sql2 = "SELECT * FROM fortune WHERE date=?";
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		Connection conn = null;
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, rs.getString(2));
				rs2 = pstmt2.executeQuery();
				while(rs2.next()) {
					Schedule schedule = new Schedule();
					schedule.setId(rs.getInt(1));
					schedule.setDate(rs.getString(2));
					schedule.setContent(rs.getString(3));
					schedule.setSemicontent(rs.getString(4));
					schedule.setToday_luck(rs2.getString(2));
					
					tmp.add(schedule);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt,pstmt2,conn,rs,rs2);
		}
		return tmp;
	}

	@Override
	public Schedule selectOne(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		String sql = "SELECT * FROM list WHERE id=?"; 
		String sql2 = "SELECT * FROM fortune WHERE date=?";
		Schedule schedule = new Schedule();
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		try {
			conn = util.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
			
			pstmt.setInt(1,id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pstmt2.setString(1, rs.getString(2));
				rs2 = pstmt2.executeQuery();
				while(rs2.next()) {
					schedule.setId(rs.getInt(1));
					schedule.setDate(rs.getString(2));
					schedule.setContent(rs.getString(3));
					schedule.setSemicontent(rs.getString(4));
					schedule.setToday_luck(rs2.getString(2));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt,rs,conn);
		}
		return schedule;
	}

	@Override
	public void insertSchedule(Schedule schedule) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql="INSERT INTO list(date, content, semicontent) VALUES (?,?,?)";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schedule.getDate());
			pstmt.setString(2,schedule.getContent());
			pstmt.setString(3, schedule.getSemicontent());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn,pstmt);
		}
	}

	@Override
	public void updateSchedule(Schedule schedule) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="UPDATE list SET date =? ,content=?,semicontent=? WHERE id=?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schedule.getDate());
			pstmt.setString(2,schedule.getContent());
			pstmt.setString(3, schedule.getSemicontent());
			pstmt.setInt(4, schedule.getId());
			int result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn,pstmt);
		}
	}

	@Override
	public void deleteSchedule(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="DELETE FROM list WHERE id=?";
		
		try {
			conn = util.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Schedule> findByContent(String str) {
		List<Schedule> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		Schedule schedule = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String sql = "SELECT * FROM list WHERE content LIKE ?";
		String sql2 = "SELECT * FROM fortune WHERE date =? ";
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			System.out.println(str);
			pstmt.setString(1, "%" + str + "%");
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1,rs.getString(2));
				rs2 = pstmt2.executeQuery();
				while(rs2.next()) {
					System.out.println("call");
					schedule = new Schedule();
					schedule.setId(rs.getInt(1));
					schedule.setDate(rs.getString(2));
					schedule.setContent(rs.getString(3));
					schedule.setSemicontent(rs.getString(4));
					schedule.setToday_luck(rs2.getString(2));
					list.add(schedule);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn,pstmt,pstmt2,rs,rs2);
		}
		System.out.println(list);
		return list;
	}
	
}
