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
저장중입니다...
<%

	//한글처리
	request.setCharacterEncoding("UTF-8");

	// 폼데이터 얻기
	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	// 오라클로 저장
	DeptVO vo = new DeptVO();
	EmpDAO dao = new EmpDAO();
	vo.setDeptno(deptno);
	vo.setDname(dname);
	vo.setLoc(loc);
	
	dao.insert(vo);
	
	//포워드
	response.sendRedirect("select.jsp");

%>

</body>
</html>
