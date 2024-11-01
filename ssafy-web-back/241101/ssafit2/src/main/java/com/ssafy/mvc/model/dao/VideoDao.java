package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.dto.Video;

public interface VideoDao {
	public List<Video> selectAllVideos(SearchCondition condition);

	public Video selectVideoById(int id);

	public int updateViewCnt(int id);
}
