<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:main pageTitle="Courses">
    <c:if test="${not empty status}">
        <div class="alert alert-success rounded-0" role="alert">
          Action successful
        </div>
    </c:if>
    <div class="container-fluid">
      <div class="list-group">
      <c:forEach items="${courses}" var="course">
        <a href="/my/lecturing-courses/${course.code}" class="list-group-item list-group-item-action flex-column align-items-start  rounded-0">
            <h5 class="mb-1">${course.getName()}</h5>
            <p class="mb-1"><small>${course.getCode()}</small><p>
            <p class="mb-1">${course.getDescription()}</p>
         </a>
      </c:forEach>
       <a href="/my/lecturing-courses/" class="list-group-item list-group-item-action flex-column align-items-start  rounded-0">
           <h3 class="mb-1">Add new course</h5>
        </a>
      </div>
    </div>
</tags:main>