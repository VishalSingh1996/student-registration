package com.Studentapp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Studentapp.model.DAOServiceImpl_1_3rd;
import com.Studentapp.model.DAOService_1_2nd;

@WebServlet("/delete")
public class Delete_Registration_Controller_4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Delete_Registration_Controller_4() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//controller
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
		String email = request.getParameter("email");//reading email id
		
		DAOService_1_2nd service=new DAOServiceImpl_1_3rd();     // model layer/ model delete the record based on email 
		service.connectionDB();  //connected to database
		service.deletebyEmail(email);
		
		
		ResultSet result = service.listRegistration();
		
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/List_All_4.jsp");
		rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login_1.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
