/*����� ���α׷��� ������ �����ϴ� �л����� ������ ������ �� �ִ� �л� ���̺�*/

CREATE TABLE IF NOT EXISTS `studentInfo`
(	`stdNm` int NOT NULL AUTO_INCREMENT, -- �л� ���� ��ȣ 
	`std_Id` int(11) NOT NULL, -- �л� �й�
	-- AUTO_IMCREMENT : PK(�⺻Ű)�� Ư¡(������)���� ���� 
	-- int Ÿ������ �ε���(������)�� �÷����ϴµ� �̶�, �ε����� üũ�� �ڵ����� �÷��ִ� �ɼ�
	`stdName` VARCHAR(10) NOT NULL, -- �л� �̸�
	`stdDep` VARCHAR(15) DEFAULT NULL, -- �л� �а�
	`stdPho` VARCHAR(16) DEFAULT NULL, -- �л� ��ȭ��ȣ
	`stdDB` VARCHAR(15) DEFAULT NULL, -- �л� mariaDB ���̵�
	`stdDate` DATE DEFAULT NULL, -- �л� DB ���� ��¥ YYYY-MM-DD ��¥(�ð�X)
	`Up_Date` TIMESTAMP NOT NULL DEFAULT current_timestamp(), 
	-- �л� ���� ������Ʈ�� YYYY-MM-DD H:M:S ��¥(�ð� ����)
	PRIMARY KEY (`stdNm`) -- �л��� ���� ��ȣ �Ӽ��� �⺻Ű
	/*PRIMARY KEY : �� ���̺� ���� 1�� ����/ Ư�� �����Ͱ� �����ڰ� �Ǳ� ���� ����*/
)ENGINE=MyISAM DEFAULT CHARSET = utf8;


INSERT INTO `studentInfo` -- INSERT sql 1
(std_Id, stdName, stdDep, stdPho, stdDB, stdDate, Up_Date)
VALUES(2020111698, '�Ӿƿ�', '����Ʈ���������а�', '01052966518', 'ay0518', '2022-03-16', current_timestamp());

INSERT INTO `studentInfo` -- INSERT sql 2
(std_Id, stdName, stdDep, stdPho, stdDB, Up_Date)
VALUES(2019100123, '�谡��', '�����а�', '01012345678', 'cute4', current_timestamp());

INSERT INTO `studentInfo` -- INSERT sql 3
(std_Id, stdName, stdDep, stdDB, stdDate, Up_Date)
VALUES(2021010518, '�̴ٶ�', '�����й̵���а�', 'beautiful1', '2021-03-13', current_timestamp());

INSERT INTO `studentInfo` -- INSERT sql 4
(std_Id, stdName, stdDep, stdPho, stdDB, stdDate, Up_Date)
VALUES(2018987654, '�ڸ���', '����Ʈ���������а�', '01098765432', 'pretty98', '2020-09-08', current_timestamp());

INSERT INTO `studentInfo` -- INSERT sql 5
(std_Id, stdName, stdDep, stdPho, stdDB, stdDate, Up_Date)
VALUES(2020011222 , '�ֻ��','������ȣ�а�', '01005180518', '1angel4', '2022-04-02', current_timestamp());

INSERT INTO `studentInfo` -- INSERT sql 6
(std_Id, stdName, stdDep, stdPho, stdDB, stdDate, Up_Date)
VALUES(2019123456, '������', '����Ʈ���������а�', '01020220403', 'avemaria', '2022-03-25', current_timestamp());


UPDATE `studentInfo` -- UPDATE sql 1
SET stdDB='avemarias2'
WHERE stdNm=6; -- stdNm�� 6�� �л��� DB���� 'avemarias2'�� ���� / �������� DB�� 'avemaria' ����


DELETE FROM `studentInfo` -- DELETE sql 1
WHERE stdDate='2020-09-08'; -- DB ���Գ�¥�� 2020-09-08 �� �л��� ���� / �ڸ����� ������ ����

SELECT std_Id, stdName, stdDB, stdDate-- SELECT sql 1
FROM `studentInfo`
WHERE stdDep = '����Ʈ���������а�' ; -- �а����� '����Ʈ���������а�'�� �л��� �й�, �̸�, DB��, DB ���Գ�¥ �˻�