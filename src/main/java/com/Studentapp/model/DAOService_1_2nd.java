package com.Studentapp.model;

import java.sql.ResultSet;

public interface DAOService_1_2nd {
// interface abstraction
	public void connectionDB();//incomplete classes
	public boolean verifyCredentials(String email, String password);//incomplete classes
	public void saveReg(String name, String email, String city, String mobile);
	public ResultSet listRegistration();
	public void deletebyEmail(String email);
	public void updateReg(String email, String mobile);
	
}
