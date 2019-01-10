<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:main pageTitle="Auditorium">
  <div class="container">
      <div class="jumbotron jumbotron-fluid">
        <div class="container">
          <c:choose>
            <c:when test="${empty courseInvite}">
              <h1>Can't find course invite</h1>
              <p class="lead">
                Sorry but your invite is outdated or missing.
              </p>
            </c:when>
            <c:otherwise>
              <h1>You are invited to pass ${courseInvite.course.name} course.</h1>
              <p class="lead">
                ${courseInvite.course.getDescription()}
              </p>
              <c:choose>
                <c:when test="${empty pageContext.request.remoteUser}">
                  <p class="lead">
                    Please click <a href="/apply-to-course/${courseInvite.uuid}/apply" class="btn btn-primary">login and apply</a> to login with your github account to proceed with the course applying.
                  </p>
                  <p class="lead">
                    The github account is required as long as the course contains lots of practical tasks and is highly integrated with github.
                  </p>
                </c:when>
                <c:otherwise>
                  <p class="lead">
                    Please click <a href="/apply-to-course/${courseInvite.uuid}/apply" class="btn btn-primary">apply</a> to apply to the course.
                  </p>
                </c:otherwise>
              </c:choose>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
  </div>
</tags:main>

