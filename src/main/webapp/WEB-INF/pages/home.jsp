<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:main pageTitle="Auditorium">
  <div class="container">
    <div class="jumbotron pb-5 pt-5">
      <h1>Welcome!</h1>
      <p class="lead">
        Welcome to auditorium online learning platform. Let's learn and code together!
      </p>
      <p>
        Our primary focus is to give ultimate coding skills on top of a relevant domain knowledge.
        Passing a course you will write a lot of code. Each line of which will be code reviewed
        according to industry standard.
      </p>
      <p>If you already applied for the course proceed to
        <a href="/my/lecturing-courses/xxx/lectures">my courses</a> section.
      </p>
    </div>
  </div>
  <div class="container">
    <div class="card-columns">
      <c:forEach items="${courses}" var="course" end="3">
        <div class="card mb-4 shadow-sm">
          <div class="card-body">
            <h2>
                ${course.name}
            </h2>
            <p class="card-text">${course.description}</p>
            <p class="card-text">
              <a class="btn btn-primary" href="/courses/${course.code}" role="button">Learn more</a>
            </p>
          </div>
        </div>
      </c:forEach>
    </div>
    <p>
      You can also <a href="/courses">view all courses</a> to get more information
      on all course available.
    </p>
  </div>
</tags:main>
