package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {

		super.init(config);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// read request parameters
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		PrintWriter out = response.getWriter();
		// db operations
		try {
			UserDao udao = new UserDao();
			Connection con = udao.getMysqlConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into Student values(?,?,?,?)");
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, contact);

			pstmt.executeUpdate();

			out.println("congratulation you have sucessfully registered!!");
			
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);

		}

		catch (Exception e) {
			e.printStackTrace();
			out.println("sorry you have Not sucessfully registered!!");
			
		}

	}

	public void destroy() {

	}

}
