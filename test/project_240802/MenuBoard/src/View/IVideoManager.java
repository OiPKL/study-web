package View;

import java.util.List;

import Model.Video;

public interface IVideoManager {

	List<Video> getList();

	Video selectVideoByNo(int no);

	void loadVideosFromJson(String filePath);

}
