<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:main pageTitle="All courses">
  <div class="container">
    <h1>All courses</h1>
    <div class="table-responsive">
      <table class="table">
        <thread>
          <tr>
            <th>Course</th>
            <th>Description</th>
            <th>&nbsp;</th>
          </tr>
        </thread>
        <tbody>
          <c:forEach items="${courses}" var="course">
            <tr>
              <td>${course.name}</td>
              <td>${course.description}</td>
              <td>
                <a class="btn btn-primary" href="/courses/${course.code}" role="button">Learn more</a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</tags:main>
