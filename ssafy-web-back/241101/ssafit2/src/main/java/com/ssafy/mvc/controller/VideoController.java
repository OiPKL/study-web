package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.dto.Video;
import com.ssafy.mvc.model.service.VideoService;

@RestController
@RequestMapping("/video")
public class VideoController {
	private final VideoService vService;

	public VideoController(VideoService vService) {
		this.vService = vService;
	}

	@GetMapping("/list")
	public ResponseEntity<List<Video>> list(@ModelAttribute SearchCondition condition) {
		List<Video> videos = vService.getVideos(condition);

		if (videos == null || videos.size() == 0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.ok(videos);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Video> detail(@PathVariable("id") int id) {
		Video video = vService.getVideoById(id);

		if (video == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.ok(video);
	}
}
