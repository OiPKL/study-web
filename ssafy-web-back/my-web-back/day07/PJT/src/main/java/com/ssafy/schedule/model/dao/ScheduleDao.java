package com.ssafy.schedule.model.dao;

import java.util.List;

import com.ssafy.schedule.model.dto.Schedule;


public interface ScheduleDao {
	//전체 일정 가져오기
	public abstract List<Schedule> selectAll();

	//일정 조회하기
	public abstract Schedule selectOne(int id);

	//일정 삽입
	public abstract void insertSchedule(Schedule schedule);

	//일정 수정하기
	public abstract void updateSchedule(Schedule schedule);

	//게시글 삭제하기
	public abstract void deleteSchedule(int id);
	
	//게시글 조회
	public abstract List<Schedule> findByContent(String str);
}
