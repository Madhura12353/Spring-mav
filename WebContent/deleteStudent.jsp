<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Delete student jsp page
<form:form id="regForm" modelAttribute="dstudent"  action="deleteStudentProcess" method="get">
<table align="center">
			<tr>
				<td><form:label path="id">Enter ID:</form:label></td>
				<td><form:input path="id" name="id" id="id" />
				</td>
			</tr>
			<td></td>
				<td><form:button id="submit" name="submit">submit</form:button>
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="home.jsp">Home</a></td>
			</tr>
		</table>
	</form:form>
			 
</body>
</html>