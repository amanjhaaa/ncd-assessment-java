package com.aman;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NcdServlet1
 */
@WebServlet("/NcdServlet1")
public class NcdServlet1 extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstname");
		String middlename = request.getParameter("middlename");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String pincode = request.getParameter("pincode");
		
		request.getSession().setAttribute("firstname", firstname);
		request.getSession().setAttribute("middlename", middlename);
		request.getSession().setAttribute("lastname", lastname);
		request.getSession().setAttribute("gender" , gender);
		request.getSession().setAttribute("birthday" , birthday);
		request.getSession().setAttribute("pincode" , pincode);
		
//		response.sendRedirect("jsp/printout.jsp");
		response.sendRedirect("Html/page2.html");
	}

}
