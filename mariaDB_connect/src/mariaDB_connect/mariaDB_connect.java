package mariaDB_connect;

import java.sql.*;
import java.util.*;

public class mariaDB_connect {
	String driver = "org.mariadb.jdbc.Driver";
	String DB_URL = "jdbc:mariadb://sc1.swu.ac.kr:13306/ay0518_ts";
	String USER_NAME = "ay0518";
	String PASSWORD = "ay051822";
	
    Connection conn = null;
    Statement state = null;
			
    ResultSet rs;
 
    public mariaDB_connect () {
         try {
            Class.forName(driver);
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println(" [ MySQL Connection ]\n");
            state = conn.createStatement();
            
            if( conn != null ) {
                System.out.println("DB 접속 성공");
            }

        } catch (ClassNotFoundException e) { 
            System.out.println("드라이버 로드 실패");
        } catch (SQLException e) {
            System.out.println("DB 접속 실패");
            e.printStackTrace();
        }
    }
  //삽입
  	void insertData() {
  		try {
  			String insertStr = "INSERT INTO studentInfo(std_Id, stdName, stdDep, stdPho, stdDB) VALUES('2055111789', '카타파하', '컴퓨터공학과', '01020220410', 'qwer1234')";
  			state.executeUpdate(insertStr);
  			System.out.println("데이터 추가 성공!");
  		} catch(Exception e) {
  			System.out.println("데이터 추가 실패 이유 : " + e.toString());
  		}
  	}

  	//삭제
  	void removeData() {
  		try {
  			String removeStr = "DELETE FROM studentInfo where stdName='카타파하'";
  			state.executeUpdate(removeStr);
  			System.out.println("데이터 삭제 성공!");
  		} catch(Exception e) {
  			System.out.println("데이터 삭제 실패 이유 : " + e.toString());
  		}
  	}

  	//수정
  	void changeData() {
  		try {
  			String changeStr = "UPDATE studentInfo SET stdPho='010-0000-0000'";
  			state.executeUpdate(changeStr);
  			System.out.println("데이터 변경 성공!");
  		} catch(Exception e) {
  			System.out.println("데이터 변경 실패 이유 : " + e.toString());
  		}
  	}

  	//조회
  	void viewData() {
  		try {
            
         	String sql = "SELECT * FROM studentInfo"; //SQL문을 저장할 String
         	ResultSet rs = state.executeQuery(sql); //SQL문을 전달하여 실행
         	
         	while(rs.next()){
         		String stdNm = rs.getString("stdNm");
         		String std_Id = rs.getString("std_Id");
         		String stdName = rs.getString("stdName");
         		String stdDep = rs.getString("stdDep");
         		String stdPho = rs.getString("stdPho");
         		String stdDB = rs.getString("stdDB");
                System.out.println("stdNm(학생 번호): "+stdNm+" 번");
         		System.out.println("student_Id(학번): "+ std_Id + "\nstdName(이름): " + stdName + "\nstdDep(학과): " + stdDep); 
         		System.out.println("stdPho(핸드폰): "+ stdPho + "\nstdDB(DB 아이디): " + stdDB + "\n-----------------------------\n");
         	}
         	rs.close();
  		} catch(Exception e) {
  			System.out.println("데이터 조회 실패 이유 : " + e.toString());
  		}
  	}
    
    public static void main(String[] args) {
    	mariaDB_connect db = new mariaDB_connect();
    	
    	boolean run = true;
    	while(run) {
    		//메뉴 리스트
    		System.out.println("[1] 데이터 추가");
    		System.out.println("[2] 데이터 삭제");
    		System.out.println("[3] 데이터 변경");
    		System.out.println("[4] 데이터 조회");
    		System.out.println("[5] 종료");
    		
    		System.out.print("= 번호 입력 : ");
    		Scanner s = new Scanner(System.in);
    		int num = s.nextInt();
    		
    		switch(num) {
    			case 1 :
    				db.insertData(); 	//테이블 생성
    				break;
    			case 2 :
    				db.removeData();	//데이터 삽입
    				break;
    			case 3 :
    				db.changeData();	//데이터 삭제
    				break;
    			case 4 :
    				db.viewData();	//데이터 수정
    				break;
    			case 5 :
    				run = false;
    		}
    		s.close();
    	}
    }
}