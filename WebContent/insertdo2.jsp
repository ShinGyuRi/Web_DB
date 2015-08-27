<%@page import="test.com.vo.DeptVO"%>
<%@page import="test.com.jsp.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	//한글처리
	request.setCharacterEncoding("UTF-8");

	// 폼데이터 얻기
	String deptno2 = request.getParameter("deptno");
	String dname2 = request.getParameter("dname");
	String loc2 = request.getParameter("loc");
	
	// 오라클로 저장
	DeptVO vo = new DeptVO();
	EmpDAO dao = new EmpDAO();
	vo.setDeptno(deptno2);
	vo.setDname(dname2);
	vo.setLoc(loc2);
	
	dao.insert(vo);
	
%>

</body>
</html>