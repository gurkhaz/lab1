package com.lab.waa.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.RequestDispatcher;

import com.lab.waa.model.Users;
import com.lab.waa.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		response.sendRedirect(request.getContextPath() + "/login.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		
		UserService service = new UserService();
		Users user = new Users();
		user.setUsername(userName);
		user.setPassword(passWord);
		
		Boolean checkResult = service.validate(user);
		
		if(checkResult){
			
			//request.setAttribute("smessage", "you are successfully login");
			HttpSession session = request.getSession();
			session.setAttribute("user1", userName);
			session.setAttribute("pass", passWord);
			
			response.sendRedirect(request.getContextPath() + "/welcome.jsp");
			
		}
		else
		{	
			javax.servlet.RequestDispatcher rd =  request.getRequestDispatcher("/login.jsp");
			request.setAttribute("msg","please enter correct username or password");
			rd.forward(request, response);
			//doGet(request, response);
		}
	}

}
