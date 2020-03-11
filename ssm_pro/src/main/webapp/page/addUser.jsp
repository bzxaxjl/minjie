<%@ taglib prefix="username" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: bzx
  Date: 2020/2/20
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addUser</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/user/addUser" method="post">
    username:<input type="text" name="username"/>
    usersex:<input type="text" name="usersex"/>
    <button>提交</button>
</form>

</body>
</html>
