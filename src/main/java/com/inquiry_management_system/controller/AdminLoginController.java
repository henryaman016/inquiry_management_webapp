package com.inquiry_management_system.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inquiry_management_system.bean.DAOService;
import com.inquiry_management_system.bean.DAOServiceImpl;


@WebServlet("/AdminLogin")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		DAOService service=new DAOServiceImpl();
		service.connectDB();
		boolean status=service.verifyCredential(username,password);


		if(status) {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/create_inquiryForm.jsp");
			rd.forward(request, response);
			
		}else {
			request.setAttribute("erorr", "Invalid username/password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
