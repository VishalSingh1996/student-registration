package com.Studentapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Studentapp.model.DAOServiceImpl_1_3rd;
import com.Studentapp.model.DAOService_1_2nd;


@WebServlet("/newReg")
public class New_Registration_Controller_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public New_Registration_Controller_2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/New_Registration_2.jsp");
		rd.forward(request, response);
//Controller have do-get controller and in that hme ye use krna h jisse k hme new registration wali detail mile
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession(false);
		session.setMaxInactiveInterval(10);
		if(session.getAttribute("email")!=null) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String mobile = request.getParameter("mobile");
// ye sara data model layer ko dega servlet jo ki DAOService he 
		
		DAOService_1_2nd service=new DAOServiceImpl_1_3rd();
		service.connectionDB();
		service.saveReg(name,email,city,mobile);//new method ka nam diya he yha hmne jo ki DAOService me jakr banegi
		request.setAttribute("msg", "Record is Saved");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/New_Registration_2.jsp");
		rd.forward(request, response);
		//ye NEW_Registration ko call kregi jsp me
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login_1.jsp");
			rd.forward(request, response);
		}
		}catch(Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("login_1.jsp");
			rd.forward(request, response);
		}
	}

}
