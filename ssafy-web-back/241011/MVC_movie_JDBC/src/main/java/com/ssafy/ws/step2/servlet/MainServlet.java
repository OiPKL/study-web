package com.ssafy.ws.step2.servlet;

import java.io.IOException;
import java.util.List;

import com.ssafy.ws.step2.dao.MovieDao;
import com.ssafy.ws.step2.dao.MovieDaoImpl;
import com.ssafy.ws.step2.dto.Movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	// 1. 싱글턴
	MovieDao dao = new MovieDaoImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 2. getParameter
		String action = request.getParameter("action");
		System.out.println("요청 왔음 | 파라미터: " + action);
		
		switch(action) {
		case "list":
			doList(request, response);
			break;
		case "detail":
			doDetail(request, response);
			break;
		case "registForm":
			doRegistForm(request, response);
			break;
		case "regist":
			doRegist(request, response);
			break;
		case "updateForm":
			doUpdateForm(request, response);
			break;
		case "update":
			doUpdateMovie(request, response);
			break;
		case "delete":
			doDeleteMovie(request, response);
			break;
		}
	}

	void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Movie> movieList = dao.selectAllMovies();
		
		// 3. setAttribute
		request.setAttribute("movies", movieList);
		// 4-1. getRequestDispatcher
		// 4-2. forward
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}
	
	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 2. getParameter
		String id = request.getParameter("id");
		
		Movie movie = dao.selectOne(id);
		
		// 3. setAttribute
		request.setAttribute("movie", movie);
		// 4-1. getRequestDispatcher
		// 4-2. forward
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
	}
	
	private void doRegistForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 4-1. getRequestDispatcher
		// 4-2. forward
		request.getRequestDispatcher("/regist.jsp").forward(request, response);
	}
	
	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 2-1. getParameter
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String genre = request.getParameter("genre");
		int runningTime = Integer.parseInt(request.getParameter("runningTime"));
		// 2-2. setter
		Movie movie = new Movie();
		movie.setTitle(title);
		movie.setDirector(director);
		movie.setGenre(genre);
		movie.setRunningTime(runningTime);
		
		int result = dao.insertMovie(movie);
		
		// 4. sendRedirect
		if (result == 1)
			response.sendRedirect("main?action=list");
	}


	private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 2. getParameter
		String id = request.getParameter("id");
		
		Movie movie = dao.selectOne(id);
		
		// 4-1. getRequestDispatcher
		// 4-2. forward
		request.setAttribute("movie", movie);
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}

	
	private void doUpdateMovie(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 2-1. getParameter
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		// 2-2. setter
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		
		dao.updateMovie(movie);
		
		// 4. sendRedirect
		response.sendRedirect("main?action=list");
	}
	
	private void doDeleteMovie(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 2. getParameter
		String id = request.getParameter("id");
		
		dao.deleteMovie(id);
		
		// 4. sendRedirect
		response.sendRedirect("main?action=list");
	}
}