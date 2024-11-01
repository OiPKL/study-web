DROP DATABASE IF EXISTS ssafit;
CREATE DATABASE ssafit;
USE ssafit;

CREATE TABLE user (
	user_id VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20) NOT NULL,
    name VARCHAR(10) NOT NULL
);

CREATE TABLE video (
	video_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    part VARCHAR(20) NOT NULL,
    channel_name VARCHAR(20) NOT NULL,
    img VARCHAR(40) NOT NULL,
    view_cnt INT DEFAULT 0
);

CREATE TABLE review (
	review_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(40) NOT NULL,
    content VARCHAR(1000) NOT NULL,
    video_id INT NOT NULL,
    user_id VARCHAR(20) DEFAULT "비로그인유저",
    FOREIGN KEY (video_id) REFERENCES video(video_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE likes (
	user_id VARCHAR(20) NOT NULL,
    video_id INT NOT NULL,
	FOREIGN KEY (video_id) REFERENCES video(video_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES user(user_id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO video (title, part, channel_name, img, view_cnt) VALUES
('전신 HIIT 운동', '전신', '피트라이프', 'img1.jpg', 15300),
('복근 & 코어 10분 루틴', '복근', '코어파워', 'img2.jpg', 8400),
('상체 근력 강화 운동', '상체', '스트렝스프로', 'img3.jpg', 4200),
('하체 운동 루틴', '하체', '레그마스터즈', 'img4.jpg', 6700),
('유연성을 위한 요가', '전신', '요가나우', 'img5.jpg', 9100),
('15분 심장 강화 운동', '유산소', '카디오킹스', 'img6.jpg', 10400),
('가슴과 등 운동', '상체', '피트니스월드', 'img7.jpg', 8700);


    
    
    
	
    

