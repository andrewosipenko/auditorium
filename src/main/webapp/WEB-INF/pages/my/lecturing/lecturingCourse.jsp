<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:lecturingCourse pageTitle="Course" course="${course}" active="basic">
    <div class="container">
        <form action="/my/lecturing-courses/${course.code}" method="post" autocomplete="off">
          <div class="form-group">
            <label for="courseName">Course Name</label>
            <input type="text" class="form-control" id="courseName" name="name" placeholder="Enter course name" required <c:if test="${not empty course}">
                                                                                                                  value="${course.name}"
                                                                                                             </c:if>>
          </div>
          <div class="form-group">
            <label for="courseCode">Course Code</label>
            <input type="text" class="form-control" id="courseCode"  name="code" placeholder="Enter course code" required <c:if test="${not empty course}">
                                                                                                                  value="${course.code}"
                                                                                                             </c:if>>
          </div>
          <div class="form-group">
            <label for="courseDescription">Course Description</label>
            <textarea class="form-control" id="courseDescription" name="description" rows="5"><c:if test="${not empty course}">${course.description}</c:if></textarea>
          </div>
          <button type="submit" class="btn btn-primary">Save</button>
          <c:if test="${not empty course}">
            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">Delete</button>
          </c:if>
        </form>
    </div>

     <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="inviteModalTitle">Are you sure you want to delete this course?</h5>
              </div>
              <div class="modal-body">
                 <form action="/my/lecturing-courses/${course.code}/delete" method="post">
                      <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                      <button type="submit" class="btn btn-danger" >Yes</button>
                 </form>
              </div>
          </div>
      </div>
     </div>

</tags:lecturingCourse>