<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:lecturingCourse pageTitle="Course" course="${course}" active="basic">
    <div class="container">
        <form:form modelAttribute="courseForm" method="post" autocomplete="off">
          <div class="form-group">
            <label for="name">Course Name</label>
            <form:input path="name" cssClass="form-control" placeholder="Enter course name" required="required"/>
          </div>
          <div class="form-group">
            <label for="code">Course Code</label>
            <form:input path="code" cssClass="form-control" placeholder="Enter course code" required="required" />
          </div>
          <div class="form-group">
            <label for="description">Course Description</label>
            <form:textarea path="description" cssClass="form-control" rows="5" placeholder="Enter course description" required="required" />
          </div>
          <button type="submit" class="btn btn-primary">Save</button>
          <c:if test="${not empty courseForm}">
            <button type="submit" class="btn btn-danger" onclick='return confirm("Are you sure you want to delete this course?")' form="deleteForm">Delete</button>
          </c:if>
        </form:form>
        <form id="deleteForm" action="/my/lecturing-courses/${course.code}/delete" method="post"></form>
    </div>
</tags:lecturingCourse>