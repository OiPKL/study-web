DROP DATABASE IF EXISTS ssafy_monster;
CREATE DATABASE ssafy_monster DEFAULT CHARACTER SET utf8mb4;

USE ssafy_monster;

CREATE TABLE IF NOT EXISTS player (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    hp INT DEFAULT 100,
    atk INT DEFAULT 20,
    status BOOLEAN DEFAULT True
);

CREATE TABLE IF NOT EXISTS monster (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
    hp INT NOT NULL,
    atk INT NOT NULL,
    status BOOLEAN DEFAULT True
);

INSERT INTO player(name)
VALUES ("박싸피");

INSERT INTO monster(name, hp, atk)
VALUES
("피카츄", 50, 20), ("라이츄", 60, 40), ("파이리", 30, 10), ("꼬부기", 30, 12),
("버터플", 40, 8), ("이상해씨", 30, 6);

commit;

SELECT * FROM player;
SELECT * FROM monster;