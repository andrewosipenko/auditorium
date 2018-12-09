<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/">Auditorium</a>
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
      
      <c:choose>
        <c:when test="${empty pageContext.request.remoteUser}">
          <li class="nav-item">
            <a class="nav-link" href="/login">Login or register</a>
          </li>
        </c:when>
        <c:otherwise>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <img src="${pageContext.request.userPrincipal.userAuthentication.details.avatar_url}&s=20"/>
                ${pageContext.request.remoteUser}
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
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
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>