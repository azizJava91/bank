<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Login Page </title>
    <style>
        body {
            background-color: white;
            font-size: 16px;
            color: black;
        }
    </style>
</head>
<body>
<c:if test="${not empty message}">
<div style= "margin-bottom: 10px">
<p style="color: red">${message}</p>
</div>
</c:if>
<form action="${pageContext.request.contextPath}/login"  method="post">
<div>
<input type= "text" name= "username" placeholder= "enter username"required> <br>
<input type= "password" name= "password" placeholder= "enter password"required> <br>
<div>
<button type="submit">Submit</button>
</div>
</div>
</form>
</body>
</html>
