package com.ssafy.schedule.model.service;

import java.util.List;

import com.ssafy.schedule.model.dao.ScheduleDao;
import com.ssafy.schedule.model.dao.ScheduleDaoImpl;
import com.ssafy.schedule.model.dto.Schedule;

public class ScheduleServiceImpl implements ScheduleService {
	
	private static ScheduleService service = new ScheduleServiceImpl();
	private ScheduleDao dao = ScheduleDaoImpl.getInstance();
	
	private ScheduleServiceImpl() {
		
	}
	
	public static ScheduleService getInstance() {
		return service;
	}

	@Override
	public List<Schedule> getList() {
		return dao.selectAll();
	}

	@Override
	public Schedule getSchedule(int id) {
		return dao.selectOne(id);
	}

	@Override
	public void writeSchedule(Schedule schedule) {
		dao.insertSchedule(schedule);
	}

	@Override
	public void modifySchedule(Schedule schedule) {
		dao.updateSchedule(schedule);
	}

	@Override
	public void removeSchedule(int id) {
		dao.deleteSchedule(id);
	}

	@Override
	public List<Schedule> findcont(String str) {
		return dao.findByContent(str);
	}

}
