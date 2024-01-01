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

@WebServlet("/inqForm")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/create_inquiryForm.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		try {
			
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(10);
			if(session.getAttribute("email")!=null) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		String inqTable = request.getParameter("inqTable");
		String inqDesc = request.getParameter("inqDesc");
	
		DAOService service=new DAOServiceImpl();
		service.connectDB();
		service.inquiryCredential(name,email,date,inqTable,inqDesc);
		
		request.setAttribute("msg", "record is saved!");
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/create_inquiryForm.jsp");
	rd.forward(request, response);
	}else {
		RequestDispatcher rd = request.getRequestDispatcher("admin-login.jsp");
		rd.forward(request, response);
	}
	}catch(Exception e) {
		RequestDispatcher rd = request.getRequestDispatcher("admin-login.jsp");
		rd.forward(request, response);
	}
	}
}
