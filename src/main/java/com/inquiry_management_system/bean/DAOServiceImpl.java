package com.inquiry_management_system.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
private Connection con;
private Statement stmnt;
	@Override
	public void connectDB() {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_documents_10","root","Aman@1998");
	 stmnt = con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifyCredential(String username, String password) {
  try {
	ResultSet result = stmnt.executeQuery("select * from adminLogin where username='"+username+"' and password='"+password+"'");
return result.next();

  } catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

		
		return false;
	}

	@Override
	public void inquiryCredential(String name, String email, String date, String inqTable, String inqDesc) {
		// TODO Auto-generated method stub
		 try {
				 stmnt.executeUpdate("insert into studentInquiry values('"+name+"','"+email+"','"+date+"','"+inqTable+"','"+inqDesc+"')");
			

			  } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public ResultSet readRegistration() {
		// TODO Auto-generated method stub
		try {
			ResultSet result = stmnt.executeQuery("select * from studentInquiry");
		return result;

		  } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return null;
	}

}
