<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직책 목록</title>
</head>
<body>
	${list }
	<h2>직책 목록</h2>
	<table border="1">
		<thead>
			<tr>
				<td>사원 번호</td>
				<td>사원 이름</td>
				<td>사원 직책</td>
				<td>직속 상사</td>
				<td>사원 월급</td>
				<td>사원 부서</td>
				<td>입사일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${emp }">
				<tr>
					<td>${emp.empNo}</td>
					<td><a href="EmpGetServlet?empNo=${emp.empNo}">${emp.empName}</a></td>
					<td><a href="EmpGetServlet?empNo=${emp.empNo}">${emp.title.titleNo}(${emp.title.titleName })</a></td>
					<td>
					<a href="EmpGetServlet?empNo=${emp.empNo}">
					<c:if test="${emp.manager.empNo != 0 }">
						${emp.manager.empNo}(${emp.manager.empName})
					</c:if>
					<c:if test="${emp.manager.empNo == 0 }"></c:if>
					</a>
					</td>
					<td><a href="EmpGetServlet?empNo=${emp.empNo}"><fmt:formatNumber value = "${emp.salary}" pattern="\#,###" /></a></td>
					<td><a href="EmpGetServlet?empNo=${emp.empNo}">${emp.dept.deptNo}(${emp.dept.deptName })</a></td>
					<td><a href="EmpGetServlet?empNo=${emp.empNo}"><fmt:formatDate value="${emp.hiredate}" pattern="yyyy-MM-dd" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="7"><a href="empInput.jsp">사원 추가</a></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>