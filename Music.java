package com.abc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Music")
public class Music extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
   List<String> songs=new ArrayList<String>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if(req.getParameter("gaana")!=null)
		{
		session = req.getSession();
	
		String song = req.getParameter("song");
		session.setAttribute("song",song);
	       setIntoSession(song);
//	       Iterator<String> itr = songs.iterator();
//	       while(itr.hasNext())
//	       {
//	    	   System.out.println(itr.next());
//	       }
		resp.sendRedirect("https://gaana.com/search/"+song);
		}
		else if(req.getParameter("submit_history_music") != null)
			
		{
			
			req.setAttribute("songs", songs);
			RequestDispatcher requ = req.getRequestDispatcher("/submit_history_music.jsp");
			requ.forward(req, resp);
			
		}
		
	}

	private void setIntoSession(String song) {
		if(song!=null)
		{
		   songs.add((String) session.getAttribute("song"));
		}
		
	}
         
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	songs.clear();
    	RequestDispatcher reqq = req.getRequestDispatcher("/userDetails.jsp");
    	reqq.forward(req,resp);
    }  
         
         
         
         
         
	}

