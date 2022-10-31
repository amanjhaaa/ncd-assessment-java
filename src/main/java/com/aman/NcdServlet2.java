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


@WebServlet("/NcdServlet2")
public class NcdServlet2 extends HttpServlet {

		public void doPost(HttpServletRequest req , HttpServletResponse res)throws ServletException ,  IOException{
			
			  String result;
			  res.setContentType("text/html;charset=UTF-8");
			  PrintWriter out = res.getWriter();
			
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
		PrintWriter out1 = res.getWriter();
		
		int total = age+smoke+alcohol+measurement+physical+history;
		out1.println("The result is "+ total);
		
		if (total>4) {
			result="NEED TO SCRINNING";
			out1.println("YOU NEED SCREENING");
		}
		else {
			result=" NO NEED TO SCRINNING";
			out1.println("YOU NEED NOT TO BE SCREENED");
		}
		
//		res.sendRedirect("Html/page2.html");
		//res.sendRedirect("jsp/printout.jsp");
		
		Connection con=null;
	      try{
	    		Class.forName("com.mysql.jdbc.Driver");
//	    		
	    		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "aman1", "1234");
	    		PreparedStatement ps=con.prepareStatement("UPDATE pat_info SET result = ? , count = ? WHERE birthday = ? ;") ;
	    		 
	    		
	    		String s=String.valueOf(total);

	    		ps.setString(1,result);
	    		ps.setString(2,s);
	    		ps.setString(3,NcdServlet1.birthday);

	      
	      
  		int rowCount=ps.executeUpdate();
  		if (rowCount>0)
  		{
  			out1.print(rowCount+" created indb");
		    
   		}
  		else {
  			out1.print(rowCount+" zero afftected indb");
  			
  		}
	      }
	      catch(Exception e)
	      {
	    	  
	    	  out1.print(" exception occurren :::::"+e);
	    	  
	      }
	      finally {
	    	  try {
	    		  
	    		  con.close();
	    	  }
	    	  catch(Exception e)
		      {
		    	  
		    	  out1.print(e);
		    	  
		      } 
	      }//finnaly block

	   
//end of handel function
	}
	   
//	end of http function   	    
 


}

