package com.ssafy.schedule.control;

import java.io.IOException;

import com.ssafy.schedule.model.dto.Schedule;
import com.ssafy.schedule.model.service.ScheduleService;
import com.ssafy.schedule.model.service.ScheduleServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/schedule")
public class ScheduleController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ScheduleService service = ScheduleServiceImpl.getInstance();
	private final String prefix = "WEB-INF/schedule/";
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		switch (action) {
		
		case "writeform" : 
			doWriteForm(request, response);
			break;
		case "write" :
			doWrite(request, response);
			break;
		case "list" :
			doList(request, response);
			break;
		case "detail" :
			doDetail(request, response);
			break;
		case "delete" :
			doRemove(request, response);
			break;
		case "updateform" :
			doUpdateForm(request, response);
			break;
		case "update" :
			doUpdate(request, response);
			break;
		case "find":
			doFind(request,response);
			break;
		default:
			System.out.println("에러에러에러");
			break;
		}
		
	}

	private void doFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("str");
		request.setAttribute("list", service.findcont(str));
		request.getRequestDispatcher(prefix+"list.jsp").forward(request, response);
		
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Schedule schedule = service.getSchedule(Integer.parseInt(request.getParameter("id")));
		schedule.setDate(request.getParameter("date"));
		schedule.setContent(request.getParameter("content"));
		schedule.setContent(request.getParameter("semicontent"));
		
		service.modifySchedule(schedule);
		
		response.sendRedirect("schedule?action=list");
	}

	private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Schedule schedule = service.getSchedule(id);
		request.setAttribute("schedule", schedule);
		request.getRequestDispatcher("WEB-INF/schedule/updateform.jsp").forward(request, response);
	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		service.removeSchedule(id);
		response.sendRedirect("schedule?action=list");
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("schedule", service.getSchedule(id));
		request.getRequestDispatcher("WEB-INF/schedule/detail.jsp").forward(request, response);
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", service.getList());
		request.getRequestDispatcher("WEB-INF/schedule/list.jsp").forward(request, response);
	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String date = request.getParameter("date");
		String content = request.getParameter("content");
		String semicontent = request.getParameter("semicontent");
		String today_luck = request.getParameter("today_luck");
		
		Schedule schedule = new Schedule(date, content, semicontent,today_luck);
		
		service.writeSchedule(schedule);
		
		response.sendRedirect("schedule?action=list");
	}

	private void doWriteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/schedule/writeform.jsp").forward(request, response);
	}
}
