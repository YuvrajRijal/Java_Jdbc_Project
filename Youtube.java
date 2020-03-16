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
 * Servlet implementation class Youtube
 */
@WebServlet("/Youtube")
public class Youtube extends HttpServlet {
	List<String> youtube=new ArrayList<String>();
	HttpSession session = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Youtube() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   session = request.getSession();
		
		if(request.getParameter("searchyoutube")!=null)
		{
		session = request.getSession();
		String youtube = request.getParameter("youtube");
		session.setAttribute("youtube",youtube);
	       setIntoSession(youtube);
//	       Iterator<String> itr = yout.iterator();
//	       while(itr.hasNext())
//	       {
//	    	   System.out.println(itr.next());
//	       }
		response.sendRedirect("https://www.youtube.com/results?search_query="+request.getParameter("youtube"));
		}
		
		else if(request.getParameter("submit_history_youtube")!= null)
			
		{
			
			request.setAttribute("youtube", youtube);
			RequestDispatcher requ = request.getRequestDispatcher("/search_history_youtube.jsp");
			requ.forward(request, response);
			
		}
	}
	private void setIntoSession(String search) {
		if(search!=null)
		{
		   youtube.add((String) session.getAttribute("youtube"));
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	youtube.clear();
	    	RequestDispatcher reqq = req.getRequestDispatcher("/userDetails.jsp");
	    	reqq.forward(req,resp);
	    }  

}
