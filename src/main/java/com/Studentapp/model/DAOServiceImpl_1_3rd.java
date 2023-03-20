package com.Studentapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl_1_3rd implements DAOService_1_2nd { //interface name impl// here we inherited the interface incomplete method
	//to complete the method we inherited the incomplete method from interface class to complete the method where i achive 
	//POLYMORPHISM..
	
    private Connection con; 
    private Statement stmnt;
  //isko yha is liye likha h ku ki vo private rhe connection db me likhte to local ho jata vo 
    
@Override
public void connectionDB() {
     try {
		Class.forName("com.mysql.cj.jdbc.Driver");//kha pr he file isliye likhga h
	   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_reg_app", "root","test");//location
	   stmnt=con.createStatement();//written type diya h
	   
     }catch(Exception e) {
    	e.printStackTrace(); 
     }
     }
@Override
public boolean verifyCredentials(String email, String password) {
	
	try {
		 ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
		 //record find krne k liye likha h 
		 return  result.next();
	} catch (Exception e) {
		e.printStackTrace();
	}
		return false;
	}
@Override
public void saveReg(String name, String city, String email, String mobile) {//method create ki h new jo ki implement hui h
	//DAOService se
	try {
         stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
         //value insert krne k liye likha h
	} catch (Exception e) {
		e.printStackTrace();
	}

}
@Override
public ResultSet listRegistration() {

	try {
		 ResultSet result = stmnt.executeQuery("select * from registration");
		 
		 return  result;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
}
@Override
public void deletebyEmail(String email) {
	try {
        stmnt.executeUpdate("Delete from registration where email='"+email+"'");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
@Override
public void updateReg(String email, String mobile) {
	try {
        stmnt.executeUpdate("UPDATE  registration SET mobile='"+mobile+"' WHERE email='"+email+"'");
	} catch (Exception e) {
		e.printStackTrace();
	}
}

	
	
}



