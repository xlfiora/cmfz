<%--
  Created by IntelliJ IDEA.
  User: xl
  Date: 2018/7/4 0004
  Time: 下午 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>register</h1>
    <form action="${pageContext.request.contextPath}/manager/addManager" method="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="text" name="pwd"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="submit>>"></td>
            </tr>
        </table>
    </form>
</body>
</html>
