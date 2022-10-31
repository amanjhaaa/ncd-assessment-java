package com.aman;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
//	public static String birthday;
	public static String birthday;
	public static String id;
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 PrintWriter out=response.getWriter();
	 
	 out.println("<!DOCTYPE html>");
     out.println("<html>");
     out.println("<head>");
     out.println("<title>NCD Risk Assessment Checklist</title> ");
     out.println("</head>");
     out.println("<body>");
	

	  
     String firstname = request.getParameter("firstname");
		String middlename = request.getParameter("middlename");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		 birthday = request.getParameter("birthday");
		String pincode = request.getParameter("pincode");
		String result=" ";
		  String count=" ";
		
		  
		    long  min = 99999999999999L;
		    long  max = 10000000000000L;
		    
		    
		    long random_int = (long)(Math.random() * (max - min + 1) + min);
		     id = Long.toString(random_int);
		
		    out.println("partient: "+id); 
		    
		request.getSession().setAttribute("firstname", firstname);
		request.getSession().setAttribute("middlename", middlename);
		request.getSession().setAttribute("lastname", lastname);
		request.getSession().setAttribute("gender" , gender);
		request.getSession().setAttribute("birthday" , birthday);
		request.getSession().setAttribute("pincode" , pincode);
	  

//	  displaying the data in the data base
	  out.println("Name: "+firstname+" "+middlename);

	  
	  out.println("<br><br>");
//	  birthday
//	  out.println("<a href=\"index.html\" class=\"sign\">calculate data </a>");
	  
	  out.println("</h2><br><br><button onclick=\"location.href = 'Html/page2.html';\" id=\"myButton\" class=\"float-left submit-button\" >CALCULATE</button>\r\n"
		  		+ "");
//	  out.println("</h2><br><br><button onclick=\"location.href = 'signup.jsp';\" id=\"myButton\" class=\"float-left submit-button\" >Home</button>\r\n"
//		  		+ "");
		  
		/* int j1=Integer.parseInt(req.getParameter("2pp")); */
     out.println("</h2><br><br><button type=\"reset\"  onclick=history.back() align=center>Go Back</button>");
     out.println("</body>");
     out.println("</html>");
		
		
		 Connection con=null;
	      try{
	    		Class.forName("com.mysql.jdbc.Driver");
//	    		con =DriverManager.getConnection("jdbc:mqsql://localhost:3306/pat_info","sqluser","password");
	    		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "aman1", "1234");
	    		PreparedStatement ps=con.prepareStatement("INSERT INTO pat_info" + "(id,firstname,middlename,lastname,gender,birthday,pincode,result,count) values(?,?,?,?,?,?,?,?,?)");
//	    		String INSERT_USERS_SQL = "INSERT INTO patientinfo" +
//	    	            "  (id, first_name, last_name, gender, aadhaar_uid, phone_no, dob, pincode) VALUES " +
//	    	            " (?, ?, ?, ?, ?,?,?,?);";
//	    		ps.setInt(1, 1);cr
	    		ps.setString(1,id);
	    		ps.setString(2,firstname);
	    		ps.setString(3,middlename);
	    		ps.setString(4,lastname);
	    		ps.setString(5,gender);
	    		ps.setString(6,birthday);
	    		ps.setString(7,pincode);
	    		ps.setString(8,count);
	    		ps.setString(9,result);
	    		
	      
	      
   		int rowCount=ps.executeUpdate();
   		if (rowCount>0)
   		{
   			out.print(rowCount+" created indb");
   		}
   		else {
   			out.print(rowCount+" zero afftected indb");
   			
   		}
	      }
	      catch(Exception e)
	      {
	    	  
	    	  out.print(" exception occurren :::::"+e);
	    	  
	      }
	      finally {
	    	  try {
	    		  
	    		  con.close();
	    	  }
	    	  catch(Exception e)
		      {
		    	  
		    	  out.print(e);
		    	  
		      }  
	      }
	      
	    	
//		response.sendRedirect("jsp/printout.jsp");
		response.sendRedirect("Html/page2.jsp");
		
		
		
	}

}




