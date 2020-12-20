<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户列表</title>
</head>
<body>

<table border="1">
 <tr>
  <td>用户ID</td><td>用户名</td><td>真实姓名</td>
 </tr>
 <c:forEach var="row" items="${userInfoList}">
 <tr>
  <td>${row.userId }</td><td>${row.userName }</td><td>${row.trueName}</td>
 </tr>
 </c:forEach>
</table>

</body>
</html>