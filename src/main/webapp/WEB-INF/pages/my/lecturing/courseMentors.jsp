<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:lecturingCourse pageTitle="Mentors ${course.name}" course="${course}" active="mentors">
  <div class="container">
    <h1>Mentors ${course.name}</h1>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#inviteModal" data-backdrop="false">Invite mentor</button>
    <c:choose>
      <c:when test="${empty invites}">
        <p>No mentors invited to the course yet</p>
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
                <td>${invite.user.mentor.name}</td>
                <td>${invite.user.mentor.login}</td>
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

 <div class="modal fade" id="inviteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="inviteModalTitle">Invite mentor</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
             <label for="email" >Email:</label>
             <input type="email" id="email" name="email"><br>
             <button class="btn btn-primary" onclick='SendInvite()' data-dismiss="modal">Send invite</button>
          </div>
      </div>
  </div>
 </div>

 <script>
    function SendInvite(){
        var xhr, formData;
        xhr = new XMLHttpRequest();
        xhr.withCredentials = false;
        xhr.open('POST', '/my/lecturing-courses/${course.id}/invite-mentor',true);
        xhr.onload = function() {
          if (xhr.status < 200 || xhr.status >= 300) {
            $('#inviteModal').modal('dispose');
            document.getElementById("inviteModalTitle").innerHTML = "Failed to send invite. Try again?";
            $('#inviteModal').modal({
              backdrop: false
            });
          }else{
              location.reload();
          }
        };
        formData = new FormData();
        var email = document.getElementById("email").value;
        formData.append('email', email);
        xhr.send(formData);
    }
 </script>

</tags:lecturingCourse>