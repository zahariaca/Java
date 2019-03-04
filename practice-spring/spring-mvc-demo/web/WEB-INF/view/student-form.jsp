<%--
  Created by IntelliJ IDEA.
  User: azaharia
  Date: 26/09/18
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Student Registration form</title>
</head>
<body>

    <form:form action="processForm" modelAttribute="student">

        First name: <form:input path="firstName"/>

        <br/><br/>

        Last name: <form:input path="lastName"/>

        <br/><br/>

        Country:
        <form:select path="country">
            <form:options items="${theCountryOptions}" />
        </form:select>

        <br/><br/>

        <%--Java: <form:radiobutton path="favoriteLanguage" value="Java"/>--%>
        <%--C#: <form:radiobutton path="favoriteLanguage" value="C#"/>--%>
        <%--PHP: <form:radiobutton path="favoriteLanguage" value="PHP"/>--%>
        <%--Ruby: <form:radiobutton path="favoriteLanguage" value="Ruby"/>--%>
        Favorite language:
        <form:radiobuttons path="favoriteLanguage" items="${languageOptions}"/>

        <br/><br/>

        Operating System:

        Linux: <form:checkbox path="operatingSystems" value="Linux"/>
        MacOS: <form:checkbox path="operatingSystems" value="MacOS"/>
        Windows: <form:checkbox path="operatingSystems" value="Windows"/>

        <br/><br/>

        <input type="submit" value="Submit"/>


    </form:form>

</body>
</html>
