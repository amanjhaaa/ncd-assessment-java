package com.aman;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NcdServlet extends HttpServlet {
	public void service(HttpServletRequest req ,HttpServletResponse res) throws IOException {
		int age = Integer.parseInt(req.getParameter("age"));
		int smoke = Integer.parseInt(req.getParameter("smoke"));
		int alcohol = Integer.parseInt(req.getParameter("alcohol"));
		int measurement = Integer.parseInt(req.getParameter("measurement"));
		int physical = Integer.parseInt(req.getParameter("physical"));
		int history = Integer.parseInt(req.getParameter("history"));
		
		int total = age+smoke+alcohol+measurement+physical+history;
//		req.setAttribute('total', total);
//		RequestDispatcher rd = req.getRequestDispatcher("sq");
//		rd.forward(req, res);
		
		
		PrintWriter out = res.getWriter();
		out.println("The result is "+ total);
		
		if (total>4) {
			out.println("YOU NEED SCREENING");
		}
		else {
			out.println("YOU NEED NOT TO BE SCREENED");
		}
	}
	out.println("</h2><br><br><button type=\"reset\"  onclick=history.back() align=center>Go Back</button>");
	//String referer = request.getHeader("Referer");
}
