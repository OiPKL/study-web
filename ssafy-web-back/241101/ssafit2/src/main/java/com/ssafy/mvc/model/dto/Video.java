package com.ssafy.mvc.model.dto;

public class Video {
	int videoId;
	String title;
	String part;
	String channelName;
	String img;
	int viewCnt;

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", title=" + title + ", part=" + part + ", channelName=" + channelName
				+ ", img=" + img + ", viewCnt=" + viewCnt + "]";
	}
}
