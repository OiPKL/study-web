package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.VideoDao;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.dto.Video;

@Service
public class VideoService {
	private final VideoDao videoDao;

	public VideoService(VideoDao videoDao) {
		this.videoDao = videoDao;
	}

	public List<Video> getVideos(SearchCondition condition) {
		return videoDao.selectAllVideos(condition);
	}

	public Video getVideoById(int id) {
		Video video = videoDao.selectVideoById(id);
		if (video != null) {
			videoDao.updateViewCnt(id);
		}
		return video;
	}
}
