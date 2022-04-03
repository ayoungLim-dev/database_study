/*모바일 프로그래밍 수업을 수강하는 학생들의 정보를 저장할 수 있는 학생 테이블*/

CREATE TABLE IF NOT EXISTS `studentInfo`
(	`stdNm` int NOT NULL AUTO_INCREMENT, -- 학생 고유 번호 
	`std_Id` int(11) NOT NULL, -- 학생 학번
	-- AUTO_IMCREMENT : PK(기본키)의 특징(고유성)으로 인해 
	-- int 타입으로 인덱스(정수값)을 올려아하는데 이때, 인덱스를 체크해 자동으로 올려주는 옵션
	`stdName` VARCHAR(10) NOT NULL, -- 학생 이름
	`stdDep` VARCHAR(15) DEFAULT NULL, -- 학생 학과
	`stdPho` VARCHAR(16) DEFAULT NULL, -- 학생 전화번호
	`stdDB` VARCHAR(15) DEFAULT NULL, -- 학생 mariaDB 아이디
	`stdDate` DATE DEFAULT NULL, -- 학생 DB 가입 날짜 YYYY-MM-DD 날짜(시간X)
	`Up_Date` TIMESTAMP NOT NULL DEFAULT current_timestamp(), 
	-- 학생 정보 업데이트일 YYYY-MM-DD H:M:S 날짜(시간 포함)
	PRIMARY KEY (`stdNm`) -- 학생의 고유 번호 속성이 기본키
	/*PRIMARY KEY : 한 테이블에 오직 1개 존재/ 특정 데이터가 구분자가 되기 위해 설정*/
)ENGINE=MyISAM DEFAULT CHARSET = utf8;


INSERT INTO `studentInfo` -- INSERT sql 1
(std_Id, stdName, stdDep, stdPho, stdDB, stdDate, Up_Date)
VALUES(2020111698, '임아영', '소프트웨어융합학과', '01052966518', 'ay0518', '2022-03-16', current_timestamp());

INSERT INTO `studentInfo` -- INSERT sql 2
(std_Id, stdName, stdDep, stdPho, stdDB, Up_Date)
VALUES(2019100123, '김가나', '경제학과', '01012345678', 'cute4', current_timestamp());

INSERT INTO `studentInfo` -- INSERT sql 3
(std_Id, stdName, stdDep, stdDB, stdDate, Up_Date)
VALUES(2021010518, '이다라', '디지털미디어학과', 'beautiful1', '2021-03-13', current_timestamp());

INSERT INTO `studentInfo` -- INSERT sql 4
(std_Id, stdName, stdDep, stdPho, stdDB, stdDate, Up_Date)
VALUES(2018987654, '박마바', '소프트웨어융합학과', '01098765432', 'pretty98', '2020-09-08', current_timestamp());

INSERT INTO `studentInfo` -- INSERT sql 5
(std_Id, stdName, stdDep, stdPho, stdDB, stdDate, Up_Date)
VALUES(2020011222 , '최사아','정보보호학과', '01005180518', '1angel4', '2022-04-02', current_timestamp());

INSERT INTO `studentInfo` -- INSERT sql 6
(std_Id, stdName, stdDep, stdPho, stdDB, stdDate, Up_Date)
VALUES(2019123456, '양자차', '소프트웨어융합학과', '01020220403', 'avemaria', '2022-03-25', current_timestamp());


UPDATE `studentInfo` -- UPDATE sql 1
SET stdDB='avemarias2'
WHERE stdNm=6; -- stdNm이 6인 학생의 DB명을 'avemarias2'로 수정 / 양자차의 DB명 'avemaria' 수정


DELETE FROM `studentInfo` -- DELETE sql 1
WHERE stdDate='2020-09-08'; -- DB 가입날짜가 2020-09-08 인 학생을 삭제 / 박마바의 데이터 삭제

SELECT std_Id, stdName, stdDB, stdDate-- SELECT sql 1
FROM `studentInfo`
WHERE stdDep = '소프트웨어융합학과' ; -- 학과명이 '소프트웨어융합학과'인 학생의 학번, 이름, DB명, DB 가입날짜 검색