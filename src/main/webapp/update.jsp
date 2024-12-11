<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Employee Record Table</h1>
<form action="update" method="post">
				<input type="number" name="id" value="${list.id}" hidden>
			Name: <input type="text" name="name"  value="${list.name}"><br> <br>
			Email: <input type="email" name="email" value="${list.email}"><br> <br>
			Mobile: <input type="number" name="mobile" value="${list.mobile}"><br> <br>
			Salary: <input type="number" name="salary" value="${list.salary}"><br> <br>
			 <a href="update"><button>update</button></a>
		</form>
<br>
  
   <a href="fetch"><button>Back</button></a>
</div>
</body>
</html>