package com.JavaWebApplication.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JavaWebApplication.Beans.RegisterBean;
import com.JavaWebApplication.Model.UserDetails;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		UserDetails user = new UserDetails();

		String uname = request.getParameter("emailId");
		String password = request.getParameter("password");
		RegisterBean regUser = new RegisterBean();
		regUser.setEmail(uname);
		regUser.setPassword(password);
		String str;
		try {
			str = user.readUserDetails(regUser);
			if (str.equalsIgnoreCase("Success")) {

				HttpSession session = request.getSession();
				session.setAttribute("uname", uname);
				System.out.println(uname);
				response.sendRedirect("http://localhost:8080/JavaWebApplication/jsp/Welcome.jsp");
			} else {
				out.println("Wrong User name or Password!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
