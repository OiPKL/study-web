package View;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Model.Video;

public class VideoManagerImpl implements IVideoManager {
    private List<Video> list = new ArrayList<Video>();
    private static IVideoManager instance;

    private VideoManagerImpl() {
        // 초기화 로직
    }

    public static IVideoManager getInstance() {
        if (instance == null) {
            instance = new VideoManagerImpl();
        }
        return instance;
    }

    @Override
    public List<Video> getList() {
    	List<Video> result = new ArrayList<Video>();
    	
    	for (int i = 0; i < list.size(); i++) {
    		result.add(list.get(i));
    	}
    	
        return result;
    }

    @Override
    public Video selectVideoByNo(int no) {
        for (Video video : list) {
            if (video.getNo() == no) {
                return video;
            }
        }
        return null;
    }

    @Override
    public void loadVideosFromJson(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            list = gson.fromJson(reader, new TypeToken<List<Video>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}
