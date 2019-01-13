<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:main pageTitle="${course.name}">
  <div class="container">
    <h1>Course ${course.name}</h1>
    <p>
      ${course.description}
    </p>
  </div>
</tags:main>
