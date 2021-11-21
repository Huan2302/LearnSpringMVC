<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/21/21
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/multi-upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file" multiple="multiple">
    <input type="submit">
</form>
<c:if test="${not empty listFileName}">
    <c:forEach items="${listFileName}" var="fileName">
        <img src="${pageContext.request.contextPath}/img/${fileName}" alt="" width="200px">
    </c:forEach>
</c:if>

</body>
</html>
