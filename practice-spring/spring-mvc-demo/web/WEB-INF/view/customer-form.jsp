<%--
  Created by IntelliJ IDEA.
  User: azaharia
  Date: 04/03/19
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Customer Registration form</title>
    <style>
        .error {
            color: red
        }
    </style>
</head>
    <body>
    <i>Fill out the form. Asterisk (*) means required.</i>
    <br><br>

        <form:form action="processForm" commandName="customer" modelAttribute="customer">

            First name: <form:input path="firstName"/>

            <br><br>

            Last name (*): <form:input path="lastName"/>
            <form:errors path="lastName" cssClass="error"/>

            <br><br>

            Free passes: <form:input path="freePasses"/>
            <form:errors path="freePasses" cssClass="error"/>

            <br><br>

            Postal code: <form:input path="postalCode"/>
            <form:errors path="postalCode" cssClass="error"/>

            <br><br>

            Course code: <form:input path="courseCode"/>
            <form:errors path="courseCode" cssClass="error"/>

            <br><br>

            <input type="submit" value="Submit"/>

        </form:form>
    </body>
</html>
