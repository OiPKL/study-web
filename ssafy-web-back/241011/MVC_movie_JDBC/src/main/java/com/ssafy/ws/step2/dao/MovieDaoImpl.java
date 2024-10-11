package com.ssafy.ws.step2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step2.dto.Movie;
import com.ssafy.ws.step2.util.DBUtil;

public class MovieDaoImpl implements MovieDao {

	DBUtil util = DBUtil.getInstance();
	
	@Override
	public List<Movie> selectAllMovies() {
		List<Movie> movies = new ArrayList<>();
		
		String sql = "SELECT * FROM movies";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getString("id"));
				movie.setTitle(rs.getString("title"));
				movie.setDirector(rs.getString("director"));
				movie.setGenre(rs.getString("genre"));
				movie.setRunningTime(rs.getInt("runningTime"));
				
				movies.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return movies;
	}
	
	@Override
	public Movie selectOne(String id) {
		Movie movie = new Movie();
		
		String sql = "SELECT * FROM movies WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				movie.setId(rs.getString("id"));
				movie.setTitle(rs.getString("title"));
				movie.setDirector(rs.getString("director"));
				movie.setGenre(rs.getString("genre"));
				movie.setRunningTime(rs.getInt("runningTime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return movie;
	}

	@Override
	public int insertMovie(Movie movie) {
		String sql = "INSERT INTO movies (id, title, genre, director, runningTime) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			// 1부터 시작
			pstmt.setString(1, "0");					// AutoIncrement
			pstmt.setString(2, movie.getTitle());
			pstmt.setString(3, movie.getGenre());
			pstmt.setString(4, movie.getDirector());
			pstmt.setInt(5, movie.getRunningTime());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
		
		return 1;
	}

	@Override
	public void deleteMovie(String id) {
		String sql = "DELETE FROM movies WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			// 1부터 시작
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public void updateMovie(Movie movie) {
		String sql = "UPDATE movies SET title = ? WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			// 1부터 시작
			pstmt.setString(1, movie.getTitle());
			pstmt.setString(2, movie.getId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}
}
