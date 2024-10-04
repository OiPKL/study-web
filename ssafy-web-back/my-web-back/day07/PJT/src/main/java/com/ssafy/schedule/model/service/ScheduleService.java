package com.ssafy.schedule.model.service;

import java.util.List;

import com.ssafy.schedule.model.dto.Schedule;

public interface ScheduleService {
	// 전체 게시글 조회
	public abstract List<Schedule> getList();
	// 게시글 조회
	public abstract Schedule getSchedule(int id);

	// 게시글 작성
	public abstract void writeSchedule(Schedule schedule);

	// 게시글 수정
	public abstract void modifySchedule(Schedule schedule);

	// 게시글 삭제
	public abstract void removeSchedule(int id);

	// 특정 제목가진 게시글 조회
	public abstract List<Schedule> findcont(String str);
}
