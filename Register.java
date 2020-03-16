package com.abc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	int i=1;
	private Connection connection;
	private PreparedStatement pstmt;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		System.out.println("Caught");
	}
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_tracker", "root", "password,12345");
				pstmt = connection.prepareStatement("INSERT INTO USER1 VALUES(?,?,?)");
				pstmt.setString(1, req.getParameter("name"));
				pstmt.setString(2, req.getParameter("emailid"));
				pstmt.setString(3, req.getParameter("pass"));
				int m = pstmt.executeUpdate();
				if(m==1)
				{
					resp.sendRedirect("register.jsp");
				}
			
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
}