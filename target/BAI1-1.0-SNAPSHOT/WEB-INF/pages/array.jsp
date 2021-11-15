<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/14/21
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Place</th>
        <th>date_create</th>
        <th>student</th>
    </tr>
    <c:forEach var="item" items="${array}">
        <tr>
            <td>${item.id}</td>
            <td>${item.place}</td>
            <td><fmt:formatDate value="${item.date_create}" pattern="yyyy-MM-dd"/></td>
            <td>${item.student}</td>
        </tr>
    </c:forEach>
</table>
<form action="<%=request.getContextPath()%>/saveImg" enctype="multipart/form-data" method="post">
    <input type="file" name="file">
    <input type="submit">
</form>

</body>
</html>
