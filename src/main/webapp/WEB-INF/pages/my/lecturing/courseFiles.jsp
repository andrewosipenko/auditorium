<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:lecturingCourse pageTitle="Files ${course.name}" course="${course}" active="files">

    <c:if test="${not empty status}">
        <div class="alert alert-success rounded-0" role="alert">
          Action successful
        </div>
    </c:if>

  <div class="container">
    <h1>Files ${course.name}</h1>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal" data-backdrop="false">Add file</button>
    <c:choose>
      <c:when test="${empty files}">
        <p>No files added to the course yet</p>
      </c:when>
      <c:otherwise>
        <div class="table-responsive">
          <table class="table">
            <thread>
              <tr>
                <th>File name</th>
                <th>Preview</th>
                <th>File size(MB)</th>
                <th>Date added</th>

              </tr>
            </thread>
            <tbody>
            <c:set var = "totalSize" value = "${0}"/>
            <c:forEach items="${files}" var="file">
              <tr>
                <td>
                    <a href="${file.getFileLocation()}">${file.name}</a>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${file.isImage()}">
                            <img src="${file.getFileLocation()}" height="250" width="250"/>
                        </c:when>
                        <c:otherwise>
                            no preview
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${String.format("%.2f", file.size)}</td>
                <td>${file.date}</td>
                <td>
                    <button type="button" class="btn btn-danger" onClick="DeleteFile('${file.name}')">Delete</button>
                </td>
              </tr>
              <c:set var = "totalSize" value = "${totalSize + file.size}"/>
            </c:forEach>
            </tbody>
          </table>
          <div>
            <h5>Total size: ${String.format("%.2f", totalSize)} MB</h5>
          </div>
        </div>
      </c:otherwise>
    </c:choose>
  </div>

    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="inviteModalTitle">Are you sure you want to delete this file?</h5>
                </div>
                <div class="modal-body">
                    <form id="deleteForm"  method="post">
                        <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                        <button type="submit" class="btn btn-danger" >Yes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addModalTitle">Upload file</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input type="file" class="d-none" id="file">
                    <div class="form-group">
                        <div class="input-group input-file" name="Fichier1">
                            <input id="filename" type="text" class="form-control" placeholder='Choose a file...' readonly/>
                            <span class="input-group-btn">
                                <button class="btn btn-default btn-choose" type="button" onClick="document.getElementById('file').click()">Choose</button>
                            </span>
                        </div>
                    </div>
                    <button type="button" class="btn btn-primary" onClick="AddFile()" data-dismiss="modal">Upload</button>
                </div>
            </div>
        </div>
    </div>

 <script>

    document.getElementById('file').onchange = function () {
      document.getElementById('filename').value=this.value;
    };

    function DeleteFile(name){
        document.getElementById("deleteForm").action = "/my/lecturing-courses/${course.code}/files/"+name+"/delete";
        $('#deleteModal').modal('show');
    }

    function AddFile(){
        var xhr, formData;
        xhr = new XMLHttpRequest();
        xhr.withCredentials = false;
        xhr.open('POST', '/my/lecturing-courses/${course.id}/files',true);
        xhr.onload = function() {
          if (xhr.status < 200 || xhr.status >= 300) {
              $('#addModal').modal('dispose');
              document.getElementById("addModalTitle").innerHTML = "Failed to upload file. Try again?";
              $('#addModal').modal({
                backdrop: false
              });
          }else{
              location.reload();
          }
        };
        formData = new FormData();
        var file = document.getElementById("file").files[0];
        formData.append('file', file);
        xhr.send(formData);
    }
 </script>

</tags:lecturingCourse>