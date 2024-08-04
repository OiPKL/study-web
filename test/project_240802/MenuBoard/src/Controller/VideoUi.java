package Controller;

import java.util.List;

import Model.Video;
import View.IVideoManager;
import View.VideoManagerImpl;

public class VideoUi {
	private static VideoUi instance;

	private VideoUi() {
	}

	public static VideoUi getInstance() {
		if (instance == null) {
			instance = new VideoUi();
		}
		return instance;
	}

	// Application.java 의 loadVideosFromJson 을 이쪽으로 옮김
	public static IVideoManager vm = VideoManagerImpl.getInstance();
	public static List<Video> list;

	static {
		vm.loadVideosFromJson("data/video.json");
		list = vm.getList();
	}

	public static void 영상정보메인화면(String nickname) {
		Util.printLine();
		System.out.println("1. 영상목록");
		System.out.println("0. 이전으로");
		Util.printLine();
		int menu = Util.inputInt("메뉴를 선택하세요: ");

		switch (menu) {
		case 1:
			영상목록화면(list, nickname);
			break;
		case 0:
			MainUi.앱메뉴화면(nickname);
			break;
		default:
			System.out.println("다시 고르세요");
			영상정보메인화면(nickname);
			break;
		}
	}

	public static void 영상목록화면(List<Video> list, String nickname) {
		Util.printLine();
		System.out.println("전체 " + list.size() + "개");
		Util.printLine();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1 + "\t" + list.get(i).getTitle());
		}

		Util.printLine();
		System.out.println("0. 이전으로");
		int videoNo = Util.inputInt("영상번호를 입력하세요: ");

		if (videoNo > 0 && videoNo <= list.size()) {
			영상상세화면(list.get(videoNo - 1), nickname); // 인덱스 처리
		} else if (videoNo == 0) {
			영상정보메인화면(nickname);
		} else {
			System.out.println("다시 고르세요");
			영상목록화면(list, nickname);
		}

	}

	public static void 영상상세화면(Video video, String nickname) {
		Util.printLine();
		System.out.println("번호 : " + video.getNo());
		System.out.println("제목 : " + video.getTitle());
		System.out.println("운동 : " + video.getPart());
		System.out.println("영상 URL : " + video.getUrl());
		Util.printLine();

		int videoNo = ReviewUi.리뷰상세화면(video.getNo());
		ReviewUi.리뷰메뉴화면(videoNo, nickname);
	}
}
