package com.abc.servlet;

import java.io.IOException;
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

/**
 * Servlet implementation class Google
 */
@WebServlet("/Google")
public class Google extends HttpServlet {
	List<String> google=new ArrayList<String>();
	HttpSession session = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Google() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   session = request.getSession();
		
		if(request.getParameter("searchgoogle")!=null)
		{
		session = request.getSession();
		String google1 = request.getParameter("google");
		session.setAttribute("google",google1);
	       setIntoSession(google1);
	       Iterator<String> itr = google.iterator();
	       while(itr.hasNext())
	       {
	    	   System.out.println(itr.next());
	       }
		response.sendRedirect("https://google.com/search?q="+request.getParameter("google"));
		}
		
		else if(request.getParameter("submit_history_google")!= null)
			
		{
			
			request.setAttribute("google", google);
			RequestDispatcher requ = request.getRequestDispatcher("/submit_history_google.jsp");
			requ.forward(request, response);
			
		}
	}
	private void setIntoSession(String search) {
		if(search!=null)
		{
		   google.add((String) session.getAttribute("google"));
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	google.clear();
	    	RequestDispatcher reqq = req.getRequestDispatcher("/userDetails.jsp");
	    	reqq.forward(req,resp);
	    }  

}
