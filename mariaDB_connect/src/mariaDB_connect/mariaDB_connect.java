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
                System.out.println("DB ���� ����");
            }

        } catch (ClassNotFoundException e) { 
            System.out.println("����̹� �ε� ����");
        } catch (SQLException e) {
            System.out.println("DB ���� ����");
            e.printStackTrace();
        }
    }
  //����
  	void insertData() {
  		try {
  			String insertStr = "INSERT INTO studentInfo(std_Id, stdName, stdDep, stdPho, stdDB) VALUES('2055111789', 'īŸ����', '��ǻ�Ͱ��а�', '01020220410', 'qwer1234')";
  			state.executeUpdate(insertStr);
  			System.out.println("������ �߰� ����!");
  		} catch(Exception e) {
  			System.out.println("������ �߰� ���� ���� : " + e.toString());
  		}
  	}

  	//����
  	void removeData() {
  		try {
  			String removeStr = "DELETE FROM studentInfo where stdName='īŸ����'";
  			state.executeUpdate(removeStr);
  			System.out.println("������ ���� ����!");
  		} catch(Exception e) {
  			System.out.println("������ ���� ���� ���� : " + e.toString());
  		}
  	}

  	//����
  	void changeData() {
  		try {
  			String changeStr = "UPDATE studentInfo SET stdPho='010-0000-0000'";
  			state.executeUpdate(changeStr);
  			System.out.println("������ ���� ����!");
  		} catch(Exception e) {
  			System.out.println("������ ���� ���� ���� : " + e.toString());
  		}
  	}

  	//��ȸ
  	void viewData() {
  		try {
            
         	String sql = "SELECT * FROM studentInfo"; //SQL���� ������ String
         	ResultSet rs = state.executeQuery(sql); //SQL���� �����Ͽ� ����
         	
         	while(rs.next()){
         		String stdNm = rs.getString("stdNm");
         		String std_Id = rs.getString("std_Id");
         		String stdName = rs.getString("stdName");
         		String stdDep = rs.getString("stdDep");
         		String stdPho = rs.getString("stdPho");
         		String stdDB = rs.getString("stdDB");
                System.out.println("stdNm(�л� ��ȣ): "+stdNm+" ��");
         		System.out.println("student_Id(�й�): "+ std_Id + "\nstdName(�̸�): " + stdName + "\nstdDep(�а�): " + stdDep); 
         		System.out.println("stdPho(�ڵ���): "+ stdPho + "\nstdDB(DB ���̵�): " + stdDB + "\n-----------------------------\n");
         	}
         	rs.close();
  		} catch(Exception e) {
  			System.out.println("������ ��ȸ ���� ���� : " + e.toString());
  		}
  	}
    
    public static void main(String[] args) {
    	mariaDB_connect db = new mariaDB_connect();
    	
    	boolean run = true;
    	while(run) {
    		//�޴� ����Ʈ
    		System.out.println("[1] ������ �߰�");
    		System.out.println("[2] ������ ����");
    		System.out.println("[3] ������ ����");
    		System.out.println("[4] ������ ��ȸ");
    		System.out.println("[5] ����");
    		
    		System.out.print("= ��ȣ �Է� : ");
    		Scanner s = new Scanner(System.in);
    		int num = s.nextInt();
    		
    		switch(num) {
    			case 1 :
    				db.insertData(); 	//���̺� ����
    				break;
    			case 2 :
    				db.removeData();	//������ ����
    				break;
    			case 3 :
    				db.changeData();	//������ ����
    				break;
    			case 4 :
    				db.viewData();	//������ ����
    				break;
    			case 5 :
    				run = false;
    		}
    		s.close();
    	}
    }
}