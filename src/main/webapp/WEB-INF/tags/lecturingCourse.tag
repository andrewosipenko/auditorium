<%@ attribute name="pageTitle" required="true" type="java.lang.String" %>
<%@ attribute name="course" required="true" type="com.ao.auditorium.model.course.Course" %>
<%@ attribute name="active" required="true" type="java.lang.String" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:main pageTitle="${pageTitle}">
  <div class="container mb-4">
    <ul class="nav nav-pills">
      <li class="nav-item">
        <a class="nav-link ${active == 'basic' ? 'active' : ''}" href="/my/lecturing-courses/${course.code}">Basic</a>
      </li>
      <li class="nav-item">
        <a class="nav-link ${active == 'lectures' ? 'active' : ''}" href="/my/lecturing-courses/${course.code}/lectures">Lectures</a>
      </li>
      <li class="nav-item">
        <a class="nav-link ${active == 'students' ? 'active' : ''}" href="/my/lecturing-courses/${course.code}/students">Students</a>
      </li>
      <li class="nav-item">
        <a class="nav-link ${active == 'mentors' ? 'active' : ''}" href="/my/lecturing-courses/${course.code}/mentors">Mentors</a>
      </li>
      <li class="nav-item">
        <a class="nav-link ${active == 'files' ? 'active' : ''}" href="/my/lecturing-courses/${course.code}/files">Files</a>
      </li>
    </ul>
  </div>
  <jsp:doBody/>
</tags:main>