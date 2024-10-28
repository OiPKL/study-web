#'spring_test' 이름의 DB가 존재한다면 삭제하고 새로 생성 후 사용
DROP DATABASE IF EXISTS spring_test;
CREATE DATABASE spring_test;
USE spring_test;

#'specialty' 이름의 테이블 생성
#'specialty_code' = INT 값을 가지는 기본키
#'specialty_name' = 필수로 작성해야 하는 크기 100의 VARCHAR
CREATE TABLE specialty (
    specialty_code INT PRIMARY KEY, 
    specialty_name VARCHAR(100) NOT NULL  
);

#'doctor' 이름의 테이블 생성
#'doctor_id' = INT 값을 가지는 기본키
#'name' = 필수로 작성해야 하는 크기 100의 VARCHAR
#'age' = 필수로 작성해야 하는 INT
#'specialty_code', 'experience_years' = 필수가 아닌 INT
#'specialty_code' = 'specialty' 테이블의 'specialty_code'를 참조하는 외래키
CREATE TABLE doctor (
    doctor_id INT PRIMARY KEY, 
    name VARCHAR(100) NOT NULL, 
    age INT NOT NULL, 
    specialty_code INT, 
    experience_years INT, 
    specialty_name VARCHAR(100) -- JOIN 대신 임시로 테이블 칼럼명을 수정함..
    -- FOREIGN KEY (specialty_code) REFERENCES specialty(specialty_code) 
);

-- TEST --
INSERT INTO specialty(specialty_code, specialty_name)
VALUES (1, "TEST");

SELECT * FROM specialty;

SELECT * FROM specialty
WHERE specialty_code = 1;