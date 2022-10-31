<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>PATIENT REGISTRATION PAGE</h1>
<form method = "post" action = "/NcdAssessment/NcdServlet1">


<label> Firstname </label> <br>        
<input type="text" name="firstname" size="15"/> <br> <br>  
<label> Middlename: </label><br>   
<input type="text" name="middlename" size="15"/> <br> <br>  
<label> Lastname: </label><br>      
<input type="text" name="lastname" size="15"/> <br> <br> 


<br>  
  
<label>   
Gender :  
</label><br>  
<input type="radio" name="gender"/> Male <br>  
<input type="radio" name="gender"/> Female <br>  
<input type="radio" name="gender"/> Other  
<br>  
<br>  


<label for="birthday">Birthday:</label><br>
 <input type="date" id="birthday" name="birthday">
 <br>
 <br>
 
 <label>pincode </label><br>
 <input type="number" id="pincode" name="pincode" />
 <br>
 <br>
    <!-- <button type="submit" class="btn btn-primary">Submit</button>--> 
    <input type = "submit" value = "submit">
    <button type="reset" value="reset">Clear</button>
</form>
</body>
</html>