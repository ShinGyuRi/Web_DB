<%@page import="test.com.vo.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="test.com.jsp.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="test.com.jsp.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	EmpDAO dao = new EmpDAO();
	List<DeptVO> list = dao.select();	

	StringBuffer buffer = new StringBuffer();
	buffer.append("<dept>");
	for(DeptVO dto : list) {
		String deptno = dto.getDeptno();
		String dname = dto.getDname();
		String loc = dto.getLoc();
		buffer.append("<record>");
		buffer.append("<deptno>"+deptno+"</deptno>");
		buffer.append("<dname>"+dname+"</dname>");
		buffer.append("<loc>"+loc+"</loc>");
		buffer.append("</record>");
	}
	buffer.append("</dept>");
%>
<%= buffer.toString()%>