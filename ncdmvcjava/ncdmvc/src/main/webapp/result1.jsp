<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
   <style> 
        input[type=button] {
        width: 50%;
        padding: 55px 55px;
        margin: 24px 0;
        box-sizing: border-box;
        
    
}
        </style>
</head>
<body >
   
    <h1 >The score you ${firstname} got in NCD risk assessment ${count}</h1>
    <h1>Prescription is:${ result}</h1>

    

    <form action="/back1" method=post>
        <button>Go to home page</button>
        </form>
       
</body>
</body>
</html>
</head>
