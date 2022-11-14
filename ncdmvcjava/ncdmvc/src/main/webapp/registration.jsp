<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title><style>  
    body
    .container {  
        padding: 50px;  
      background-color: #26CECB;  
    }  
      
    input[type=text], input[type=password], textarea {  
      width: 50%;  
      padding: 15px;  
      margin: 5px 0 22px 0;  
      display: inline-block;  
      border: none;  
      background: #f1f1f1;  
    }  
    input[type=text]:focus, input[type=password]:focus {  
        
      outline: none;  
    }  
     div {  
                padding: 10px 0;  
             }  
    hr {  
      border: 1px solid #f1f1f1;  
      margin-bottom: 25px;  
    }  
    .registerbtn {  
      background-color: #911797;  
      color: white;  
      padding: 16px 20px;  
      margin: 8px 0;  
      border: none;  
      cursor: pointer;  
      width: 100%;  
      opacity: 0.9;  
    }  
    .registerbtn:hover {  
      opacity: 1;  
    }  
    </style>
  </head>  
  <body>  
  <center>
  <form action="/registration",method = "get" , modelAttribute="patientinfo" >
    <div class="container">  
    <center>  <h1> Registration Form</h1> </center>  
    <hr>  
    <label> Firstname </label>   
  <input type="text" name="firstname" required placeholder= "Firstname"pattern="[a-zA-Z]+[a-zA-Z]+" title="First Name should only be character and with length less than 50"class="form-control" required/>   </br>
  <!--<p style="color:rgb(25, 219, 64)">${ error_firstname }</p> -->
  <label> Lastname: </label>    
  <input type="text" name="lastname" required placeholder="Lastname" pattern="[a-zA-Z]+[a-zA-Z ]+" title="last Name should only be character and with length less than 50 "class="form-control" required/>    </br>
  <!-- <p style="color:rgb(25, 219, 64)">${ error_lastname }</p> -->
  <div>   
  <label>   
  Gender :  
  </label><br>  
  <input type="radio" required value="Male" name="gender" checked > Male   
  <input type="radio" required value="Female" name="gender"> Female   
  <input type="radio" required value="Other" name="gender"> Other  
    
  </div>   </br>
  <label >Email Id:</label>
  <input type="text" id="email" name="email" required  placeholder="enter email"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="Extension should br @gmail.com" ><br><br> </br>
  <label >Date Of Birth:</label>
  <input type="date" id="birthday" required  min="1900-01-01" max="3000-01-01" onfocus="this.max=new Date().toISOString().split('T')[0]" name="birthday"><br><br> </br>
  <label>   
  PinCode :  
  </label>  
  <input type="text" name="pincode" required placeholder="Enter PinCode."  pattern="[0-9]{6}" title="6 digit pin code note: only numbers are allowed ">    </br>
  
  <button type="submit" class="btn btn-primary btn-block mb-4">login </button> 
  </form>
 </center>
  </body>  
  </html>