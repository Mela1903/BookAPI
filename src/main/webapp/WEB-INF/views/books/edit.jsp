<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book add</title>
</head>
<body>

<form:form method="post"  action="/admin/books/edit" modelAttribute="book">

    <form:hidden path="id" value="${bookEdited.get().id}"/>

    <label for="isbn">isbn</label>
    <form:input path="isbn" value="${bookEdited.get().isbn}"/>
    <form:errors path="isbn"/><br/>

    <label for="title">title</label>
    <form:input path="title" value="${bookEdited.get().title}"/>
    <form:errors path="title"/><br/>

    <label for="author">author</label>
    <form:input path="author" value="${bookEdited.get().author}"/>
    <form:errors path="author"/><br/>

    <label for="publisher">publisher</label>
    <form:input path="publisher" value="${bookEdited.get().publisher}"/>
    <form:errors path="publisher"/><br/>

    <label for="type">type</label>
    <form:input path="type" value="${bookEdited.get().type}"/>
    <form:errors path="type"/><br/>

    <input type="submit" value="Zapisz">
</form:form>

</body>
</html>

