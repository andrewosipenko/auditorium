<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:main pageTitle="Courses">
  <div class="list-group">
  <c:forEach items="${courses}" var="course">
    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start  rounded-0">
        <h5 class="mb-1">${course.getName()}</h5>
        <p class="mb-1"><small>${course.getCode()}</small><p>
        <p class="mb-1">${course.getDescription()}</p>
     </a>
   </c:forEach>
  </div>
</tags:main>