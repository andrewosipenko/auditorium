<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/"><i class="fas fa-code mr-1"></i>Auditorium</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Courses
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Java 8</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Servlet API</a>
          <a class="dropdown-item" href="#">Spring MVC</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About</a>
      </li>
    </ul>
    <form class="form-inline ml-auto collapse" id="search-form">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    </form>
    <ul class="navbar-nav ml-0">
      <li class="nav-item mr-1">
        <a class="nav-link" data-toggle="collapse" datatarget="#search-form" href="#search-form"><i class="fas fa-search"></i></a>
      </li>
      <c:choose>
        <c:when test="${empty pageContext.request.remoteUser}">
          <li class="nav-item">
            <a class="nav-link" href="/login">Login or register</a>
          </li>
        </c:when>
        <c:otherwise>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <img src="${pageContext.request.userPrincipal.userAuthentication.details.avatar_url}&s=20" width="20" height="20"/>
                ${pageContext.request.remoteUser}
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="/logout">Logout</a>
                <%--Workaround. Do not know how to implement logging in as a different user.
                If you simply logout / login a redirect to github is triggered which picks up
                 SSO cookie and logs the user in without any prompts --%>
              <a class="dropdown-item" href="#"
                 onclick="alert('To login as a different user \n- logout on github.com site first\n- then do logout and login here')">
                Login as a different user
              </a>
            </div>
          </li>
        </c:otherwise>
      </c:choose>
    </ul>
  </div>
</nav>