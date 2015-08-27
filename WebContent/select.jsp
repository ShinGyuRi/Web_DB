<%@page import="java.util.List"%>
<%@page import="test.com.vo.DeptVO"%>
<%@page import="test.com.jsp.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="test.com.jsp.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	EmpDAO dao = new EmpDAO();
	List<DeptVO> list = dao.select();	
	
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td>부서번호</td>
		<td>부서명</td>
		<td>위치</td>
	</tr>
<%
	for(DeptVO vo : list) {
		String deptnum = vo.getDeptno();
		String dname = vo.getDname();
		String loc = vo.getLoc();
	

%>
	<tr>
		<td><a href="/99JSP_myEMP/retrieve.jsp?deptno=<%= deptnum %>"><%= deptnum %></a></td>
		<td><%= dname %></td>
		<td><%= loc %></td>
	</tr>
<%
	}
%>
</table>
<a href="insert.jsp">글쓰기</a>


</body>
</html>