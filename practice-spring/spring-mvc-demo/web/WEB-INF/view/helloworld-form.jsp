<%--
  Created by IntelliJ IDEA.
  User: azaharia
  Date: 26/09/18
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Hello World - Input Form</title>
</head>
<body>

    <form action="processFormVersionTwo" method="GET">
        <input type="text" name="studentName" placeholder="What's your name? "/>
        <input type="submit"/>
    </form>

    <hr/>

    <form action="processFormVersionThree" method="GET">
        <input type="text" name="studentName" placeholder="What's your name? "/>
        <input type="submit" value="Submit V3"/>
    </form>

</body>
</html>
