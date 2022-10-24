package com.aman;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NcdServlet2")
public class NcdServlet2 extends HttpServlet {

		public void doPost(HttpServletRequest req , HttpServletResponse res)throws ServletException ,  IOException{
			int age = Integer.parseInt(req.getParameter("age"));
			int smoke = Integer.parseInt(req.getParameter("smoke"));
			int alcohol = Integer.parseInt(req.getParameter("alcohol"));
			int measurement = Integer.parseInt(req.getParameter("measurement"));
			int physical = Integer.parseInt(req.getParameter("physical"));
			int history = Integer.parseInt(req.getParameter("history"));
		req.getSession().setAttribute("age",age);
		req.getSession().setAttribute("smoke",smoke);
		req.getSession().setAttribute("alochol",alcohol);
		req.getSession().setAttribute("measurement",measurement);
		req.getSession().setAttribute("physical",physical);
		req.getSession().setAttribute("history",history);
		PrintWriter out = res.getWriter();
		
		int total = age+smoke+alcohol+measurement+physical+history;
		out.println("The result is "+ total);
		
		if (total>4) {
			out.println("YOU NEED SCREENING");
		}
		else {
			out.println("YOU NEED NOT TO BE SCREENED");
		}
		
//		res.sendRedirect("Html/page2.html");
		//res.sendRedirect("jsp/printout.jsp");
	}
}
