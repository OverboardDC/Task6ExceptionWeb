<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.03.2018
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login form</title>
</head>
<body>
<div>
    <div>
        <h2>${applicationScope.locale.getMessage('sign.up')}</h2>
        <form method="post" action="addUser">
            <p style="color: red">${sessionScope.error}</p>
            <c:remove var="error" scope="session"/>
            <input title="name" name="name" placeholder="${applicationScope.locale.getMessage('your.name')}">
            <input title="login" name="login" placeholder="${applicationScope.locale.getMessage('your.login')}">
            <button type="submit">${applicationScope.locale.getMessage('submit')}</button>
        </form>
    </div>
    <div>
        <h2>${applicationScope.locale.getMessage('users')}</h2>
        <ul>
            <c:forEach var="user" items="${requestScope.users}">
                <li>
                    <p>${applicationScope.locale.getMessage('name')} ${user.name}</p>
                    <p>${applicationScope.locale.getMessage('login')} ${user.login}</p>
                </li>

            </c:forEach>
        </ul>
    </div>
</div>
</body>

</html>
