<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/3/21
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Xin chào</h1>
<form action="<%=request.getContextPath()%>/hello" method="get">
    <input type="text" name="hello">
    <input type="submit">
    <c:if test="${hello ne null}">
        <h3>xin chào ${hello}</h3>
    </c:if>
</form>
</body>
</html>
