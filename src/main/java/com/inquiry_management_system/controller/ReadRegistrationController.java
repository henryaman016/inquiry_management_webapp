package com.inquiry_management_system.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inquiry_management_system.bean.DAOService;
import com.inquiry_management_system.bean.DAOServiceImpl;

@WebServlet("/readRegistration")
public class ReadRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ReadRegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
try {
		HttpSession session = request.getSession(false);
if(session.getAttribute("email")!=null) {
	
	DAOService service=new DAOServiceImpl();
	service.connectDB();

ResultSet result = service.readRegistration();
request.setAttribute("result",result);
RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Search_inquiry.jsp");
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
