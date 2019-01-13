<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:lecturingCourse pageTitle="Students ${course.name}" course="${course}" active="students">
  <div class="container">
    <h1>Students ${course.name}</h1>
    <c:choose>
      <c:when test="${empty invites}">
        <p>No students invited to the course yet</p>
      </c:when>
      <c:otherwise>
        <div class="table-responsive">
          <table class="table">
            <thread>
              <tr>
                <th>Email</th>
                <th>Name</th>
                <th>Login</th>
                <th>Status</th>
                <th>Invite date</th>
              </tr>
            </thread>
            <tbody>
            <c:forEach items="${invites}" var="invite">
              <tr>
                <td>${invite.email}</td>
                <td>${invite.user.name}</td>
                <td>${invite.user.login}</td>
                <td>${invite.status}</td>
                <td>${invite.date}</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </c:otherwise>
    </c:choose>
  </div>
</tags:lecturingCourse>