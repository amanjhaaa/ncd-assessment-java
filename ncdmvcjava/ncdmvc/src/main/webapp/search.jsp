<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>  
  
  
 
 td {
        width: 150px;
        text-align: center;
        border: 1px solid black;
        padding: 5px;
      }

        body
        .container {  
            padding: 50px;  
          background-color: purple;  
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
    <form action="searching1">
   <div class="input-group mb-3">
    <div class="container">
     <center>  <h1> SEARCH BELOW</h1> </center>  </div></br>
    <select  name="choice" class="input-group-text" id="inputGroup-sizing-default">
      <option><a class="dropdown-item" value="patient_id" >PATIENT ID</a></option>
      <option><a class="dropdown-item" value="firstname">FIRST NAME</a></option>
      <option><a class="dropdown-item" value="lastname">LAST NAME</a></option>
    </select>
    <input name="pk" type="text" class="form-control" aria-label="Sizing example input"
      aria-describedby="inputGroup-sizing-default">
    <button class="btn btn-outline-success" type="submit">Search</button>  
  </div>
		</form>
		<form action=/searching1 method="post">

				<button type="submit" class="btn btn-secondary">clear</button>

			</form>
<div class="user_box error" style="text-align:center;border:0px;color:red;">
  ${error}
</div>
<div class="user_box error" style="text-align:center;display:'${ error_display_patient_id }';border:0px;color:red;">
  ${ error_patient_id }
</div>

<div class="user_box error" style="text-align:center;display:'${ error_display_firstname }';border:0px;color:red;">
  ${ error_firstname }
</div>
<div class="user_box error" style="text-align:center;display:'${ error_display_lastname }';border:0px;color:red;">
  ${ error_lastname }
</div> 

<table border="1" cellspacing="0" bgcolor="lightblue">
  <thead class="table-dark">
    <tr>
      <th scope="col">Patient ID</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Email</th>
      
      <th scope="col">Gender</th>
      <th scope="col">D.O.B</th>
      <th scope="col">Pincode</th>
      
      <th scope="col">Count</th>
      <th scope="col">Prescription</th>
    </tr>
  </thead>
  <tbody>
 <c:forEach items="${records}" var="row">
    <tr>
      
      <td scope="col">${ row.getPatient_id() }</td>
      <td scope="col">${ row.getFirstname() }</td>
      <td scope="col">${ row.getLastname() }</td>
      <td scope="col">${ row.getEmail() }</td>
      <td scope="col">${ row.getGender() }</td>
      <td scope="col">${ row.getBirthday() }</td>
      <td scope="col">${ row.getPincode() }</td>
      <td scope="col">${ row.getCount() }</td>
      <td scope="col">${ row.getResult() }</td>

    </tr>
    </c:forEach>  
 
  </tbody>
</table>
</thead> 
<tbody>
<!-- 
        {% for row in data%}
            <tr>
                <td>{{row[0]}}</td>
                <td>{{row[1]}}</td>
                <td>{{row[2]}}</td>
                <td>{{row[3]}}</td>
                <td>{{row[4]}}</td>
                <td>{{row[5]}}</td>
                <td>{{row[6]}}</td>
                <!-- <td>{{row[7]}}</td> 
                <td>{{row[13]}}</td>
                <td>{{row[14]}}</td>
            </tr>
        {% endfor %}
    </tbody>
</table>-->
<form action="/back1" method=post>
        <button>Go to home page</button>
        </form>
</html>