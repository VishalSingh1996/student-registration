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

@WebServlet("/listall")
public class Get_All_Registration_3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Get_All_Registration_3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
		DAOService_1_2nd service=new DAOServiceImpl_1_3rd();
		service.connectionDB();
		
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