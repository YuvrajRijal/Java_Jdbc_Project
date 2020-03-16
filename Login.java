package com.abc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private Connection connection;
	private PreparedStatement pstmt;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	   HttpSession session = req.getSession(true);
//	   session.setAttribute("email", req.getParameter("emailid"));
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		System.out.println("Caught");
	}
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_tracker", "root", "password,12345");
				pstmt= connection.prepareStatement("SELECT * FROM USER1 WHERE EMAIL_ID=? AND PASSWORD=?");
				pstmt.setString(1, req.getParameter("emailid"));
				pstmt.setString(2, req.getParameter("pass"));
				HttpSession session = req.getSession(true);
				session.setAttribute("email", req.getParameter("emailid"));       
//                System.out.println(req.getParameter("emailid"));
//                System.out.println(req.getParameter("pass"));
               ResultSet rs = pstmt.executeQuery(); 
				
				if(rs.next()==true)
				{
					resp.sendRedirect("userDetails.jsp");
				}
				else
				{
					RequestDispatcher reqq = req.getRequestDispatcher("/erroruserDetails.jsp");
					reqq.forward(req, resp);
				}
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
}