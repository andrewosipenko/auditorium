<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:main pageTitle="Auditorium">
  <div class="container">
      <div class="jumbotron jumbotron-fluid">
        <div class="container">
          <h1>You are invited to pass ${course.getName()} course.<h1>
          <p class="lead">
            ${course.getDescription()}
          </p>
          <p class="lead">
            Please <a href="/login">login</a> with your github account to continue.
            The github account is required to proceed as long as the course contains lots of practical tasks and is highly integrated with github.
          </p>
        </div>
      </div>
  </div>
</tags:main>

