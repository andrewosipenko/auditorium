<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:main pageTitle="Auditorium">
  <div class="container">
    <div class="jumbotron jumbotron-fluid">
      <div class="container">
        <h1 class="display-4">Welcome!</h1>
        <p class="lead">
          Welcome to auditorium online learning platform.
          Select a course to proceed.
        </p>
      </div>
      <div class="container">
        Available courses: ${courses}
        <p><a href="/my/lecturing-courses/xxx/lectures">Course lectures markup</a></p>
      </div>
    </div>
  </div>
</tags:main>

