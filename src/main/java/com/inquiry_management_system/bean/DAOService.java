package com.inquiry_management_system.bean;

import java.sql.ResultSet;

public interface DAOService {

public	void connectDB();

public	boolean verifyCredential(String username, String password);

public void inquiryCredential(String name, String email, String date, String inqTable, String inqDesc);

public ResultSet readRegistration();

}
