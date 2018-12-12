<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:main pageTitle="Lectures">
  <div class="container-fluid">
    <div class="row flex-xl-nowrap">
      <div class="col-12 col-md-3 col-xl-3 bd-sidebar">
        <nav class="navbar navbar-light bg-light sticky-top" style="z-index: 900;  max-height: 94vh; overflow-y: auto;">
          <nav id="navbar-main" class="nav nav-pills flex-column">
            <a id="a-1" class="nav-link" href="#item-1">Lecture 1: Introduction</a>
            <nav id="nav-1"  class="nav nav-pills flex-column">
              <a id="a-1-1" class="nav-link ml-3 my-1" href="#item-1-1">Audience</a>
              <a id="a-1-2" class="nav-link ml-3 my-1" href="#item-1-2">Goal</a>
              <a id="a-1-3" class="nav-link ml-3 my-1" href="#item-1-3">Task 1.1: Download phoneshop...</a>
              <a id="a-1-4" class="nav-link ml-3 my-1" href="#item-1-4">Task 1.2: Build and run</a>
              <a id="a-1-5" class="nav-link ml-3 my-1" href="#item-1-5">Task 1.3: Configure IDE</a>
            </nav>
            <a id="a-2" class="nav-link" href="#item-2">Lecture 2: PLP & Demodata & PDP</a>
            <nav id="nav-2" class="nav nav-pills flex-column">
              <a id="a-2-1" class="nav-link ml-3 my-1" href="#item-2-1">Task 2.1: Implement product search</a>
              <a id="a-2-2" class="nav-link ml-3 my-1" href="#item-2-2">Task 2.2: Implement sorting</a>
            </nav>
          </nav>
        </nav>
      </div>
      <div class="col-12 col-md-9 col-xl-8 py-md-3 pl-md-5 bd-content" role="main">
        <div class="container p-3">
          <h1>Course: Servlet API</h1>
          <h2>Lectures</h2>
        </div>
        <div class="container p-3">
          <div data-spy="scroll" data-target="#navbar-example3" data-offset="0" id="mainContainer">
            <div id="item-1">
                <hr>
                <div style="float:right; position: relative">
                    <a id="item-1-save" onclick='StopEditing()' href="#item-1" style="color: lightblue" hidden>save</a>
                    <a id="item-1-edit" onclick='StartEditingLecture("item-1")' href="#item-1" style="color: lightblue">edit</a>
                    <a href="#item-0" onclick='Swap("item-0","item-1")' style="color: lightblue">up</a>
                    <a href="#item-2" onclick='Swap("item-1","item-2")' style="color: lightblue">down</a>
                    <a href="#item-0" style="color: lightblue" onclick='DeleteLecture("1")'>delete</a>
                </div>
                <h4 id="item-1-name" style="width:80%; word-wrap: break-word;">Lecture 1: Introduction</h4>
                <div id="item-1-content">
                    <div id="item-1-1">
                        <div style="float:right; position: relative">
                            <a id="item-1-1-save" onclick='StopEditing()' href="#item-1-1" style="color: lightblue" hidden>save</a>
                            <a id="item-1-1-edit" onclick='StartEditing("item-1-1")' href="#item-1-1" style="color: lightblue">edit</a>
                            <a href="#item-1-0" style="color: lightblue" onclick='Swap("item-1-0","item-1-1")'>up</a>
                            <a href="#item-1-2" style="color: lightblue" onclick='Swap("item-1-1","item-1-2")'>down</a>
                            <a href="#item-1" style="color: lightblue" onclick='DeleteItem("1-1")'>delete</a>
                        </div>
                        <h5 id="item-1-1-name" style="width:80%; word-wrap: break-word;">Audience</h5>
                        <div id="item-1-1-content"><p>Junior developers.</p></div>
                    </div>

                    <div id="item-1-2">
                        <div style="float:right; position: relative">
                            <a id="item-1-2-save" onclick='StopEditing()' href="item-1-2#" style="color: lightblue" hidden>save</a>
                            <a id="item-1-2-edit" onclick='StartEditing("item-1-2")' href="#item-1-2" style="color: lightblue">edit</a>
                            <a href="#item-1-1" style="color: lightblue" onclick='Swap("item-1-1","item-1-2")'>up</a>
                            <a href="#item-1-3" style="color: lightblue" onclick='Swap("item-1-2","item-1-3")'>down</a>
                            <a href="#item-1" style="color: lightblue" onclick='DeleteItem("1-2")'>delete</a>
                        </div>
                        <h5 id="item-1-2-name" style="width:80%; word-wrap: break-word;">Goal</h5>
                        <div id="item-1-2-content">
                            <p>Study:</p>
                            <ul>
                              <li>servlet-api 3.x</li>
                              <li>ecommerce concepts: product, stock, cart, order, PLP, PDP and so on</li>
                              <li>Java 8 streams</li>
                              <li>JSP</li>
                              <li>design patterns: singleton, DAO, MVC, decorator</li>
                              <li>JSTL</li>
                              <li>HTML</li>
                              <li>Build tools: maven</li>
                            </ul>
                            <p>Prove knowledge by implementing phoneshop ecommerce web app.</p>
                        </div>
                    </div>

                    <div id="item-1-3">
                        <div style="float:right; position: relative">
                            <a id="item-1-3-save" onclick='StopEditing()' href="#item-1-3" style="color: lightblue" hidden>save</a>
                            <a id="item-1-3-edit" onclick='StartEditing("item-1-3")' href="#item-1-3" style="color: lightblue">edit</a>
                            <a href="#item-1-2" style="color: lightblue" onclick='Swap("item-1-2","item-1-3")'>up</a>
                            <a href="#item-1-4" style="color: lightblue" onclick='Swap("item-1-3","item-1-4")'>down</a>
                            <a href="#item-1" style="color: lightblue" onclick='DeleteItem("1-3")'>delete</a>
                        </div>
                        <h5 id="item-1-3-name" style="width:80%; word-wrap: break-word;">Task 1.1: Download phoneshop project sources</h5>
                        <div id="item-1-3-content">
                            <p>Fork git repository
                              Fork repository <a href="https://github.com/andrewosipenko/phoneshop-servlet-api">https://github.com/andrewosipenko/phoneshop-servlet-api</a>
                              You can achieve this by clicking “fork” in the top right corner of the page <a href="https://github.com/andrewosipenko/phoneshop-servlet-api">https://github.com/andrewosipenko/phoneshop-servlet-api</a>
                            </p>
                            <p>
                              Clone the forked repository on you local environment by running
                            </p>
                            <p>
                              <code>git clone https://github.com/&lt;your_github_username&rt;/phoneshop-servlet-api</code>
                            </p>
                        </div>
                    </div>

                    <div id="item-1-4">
                        <div style="float:right; position: relative">
                            <a id="item-1-4-save" onclick='StopEditing()' href="#item-1-4" style="color: lightblue" hidden>save</a>
                            <a id="item-1-4-edit" onclick='StartEditing("item-1-4")' href="#item-1-4" style="color: lightblue">edit</a>
                            <a href="#item-1-3" style="color: lightblue" onclick='Swap("item-1-3","item-1-4")'>up</a>
                            <a href="#item-1-5" style="color: lightblue" onclick='Swap("item-1-4","item-1-5")'>down</a>
                            <a href="#item-1" style="color: lightblue" onclick='DeleteItem("item-1-4")'>delete</a>
                        </div>
                        <h5 id="item-1-4-name" style="width:80%; word-wrap: break-word;">Task 1.2: Build and run the project</h5>
                        <div id="item-1-4-content">
                            <p>Install maven 3.x
                               Execute run.bat from the root of the project.</p>
                        </div>
                    </div>

                    <div id="item-1-5">
                        <div style="float:right; position: relative">
                            <a id="item-1-5-save" onclick='StopEditing()' href="#item-1-5" style="color: lightblue" hidden>save</a>
                            <a id="item-1-5-edit" onclick='StartEditing("item-1-5")' href="#item-1-5" style="color: lightblue">edit</a>
                            <a href="#item-1-4" style="color: lightblue" onclick='Swap("item-1-4","item-1-5")'>up</a>
                            <a href="#item-1-6" style="color: lightblue" onclick='Swap("item-1-5","item-1-6")'>down</a>
                            <a href="#item-1" style="color: lightblue" onclick='DeleteItem("1-5")'>delete</a>
                        </div>
                         <h5 id="item-1-5-name" style="width:80%; word-wrap: break-word;">Task 1.3: Configure IDE</h5>
                         <div id="item-1-5-content">
                            <p>Open the project in your favourite IDE: Intellij or Eclipse by selection “import project from existing source” or something like that.
                               If the IDE recognizes maven then it should pick maven project with configured classpath. See how it looks in Intellij for example.
                            </p>
                         </div>
                    </div>
                </div>
            </div>

            <div id="item-2">
                <hr>
                <div style="float:right; position: relative">
                    <a id="item-2-save" onclick='StopEditing()' href="#item-2" style="color: lightblue" hidden>save</a>
                    <a id="item-2-edit" onclick='StartEditingLecture("item-2")' href="#item-2" style="color: lightblue">edit</a>
                    <a href="#item-1" onclick='Swap("item-1","item-2")' style="color: lightblue">up</a>
                    <a href="#item-3" onclick='Swap("item-2","item-3")' style="color: lightblue">down</a>
                    <a href="#item-1" style="color: lightblue" onclick='DeleteLecture("2")'>delete</a>
                </div>
                <h4 id="item-2-name" style="width:80%; word-wrap: break-word;">Lecture 2: PLP & Demodata & PDP</h4>
                <div id="item-2-content">
                    <div id="item-2-1">
                        <div style="float:right; position: relative">
                            <a id="item-2-1-save" onclick='StopEditing()' href="#item-2-1" style="color: lightblue" hidden>save</a>
                            <a id="item-2-1-edit" onclick='StartEditing("item-2-1")' href="#item-2-1" style="color: lightblue">edit</a>
                            <a href="#item-2-0" style="color: lightblue" onclick='Swap("item-2-0","item-2-1")'>up</a>
                            <a href="#item-2-2" style="color: lightblue" onclick='Swap("item-2-1","item-2-2")'>down</a>
                            <a href="#item-2" style="color: lightblue" onclick='DeleteItem("2-1")'>delete</a>
                        </div>
                        <h5 id="item-2-1-name" style="width:80%; word-wrap: break-word;" id="item-2-1-name">Task 2.1: Implement product search</h5>
                        <div id="item-2-1-content">
                            <p>
                              The search must work using OR clause. The example above means: search all products having description containing “Samsung” or “S” or “II”. Products having all search terms must come first in the search result.
                            </p>
                            <p>
                              Implementation hint: Use java8 streams.
                            </p>
                        </div>
                    </div>

                    <div id="item-2-2">
                        <div style="float:right; position: relative">
                            <a id="item-2-2-save" onclick='StopEditing()' href="#item-2-2" style="color: lightblue" hidden>save</a>
                            <a id="item-2-2-edit" onclick='StartEditing("item-2-2")' href="#item-2-2" style="color: lightblue">edit</a>
                            <a href="#item-2-1" style="color: lightblue" onclick='Swap("item-2-1","item-2-2")'>up</a>
                            <a href="#item-2-3" style="color: lightblue" onclick='Swap("item-2-2","item-2-3")'>down</a>
                            <a href="#item-2" style="color: lightblue" onclick='DeleteItem("2-2")'>delete</a>
                        </div>
                        <h5 id="item-2-2-name" style="width:80%; word-wrap: break-word;">Task 2.2: Implement sorting</h5>
                        <div id="item-2-2-content">
                            <p>
                              It should be possible to sort PLP on product description or price.
                              By default there is no sorting.
                              PLP sorted by description ascending shall look like:
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <button id="AddLecture" class="btn btn-primary btn-lg btn-block mt-5" onclick='AddLecture()'>Add new lecture</button>
          </div>
        </div>
      </div>
    </div>
  </div>

   <template>
        <button id="AddItem" class="btn btn-primary mt-3">New item </button>
   </template>

<script type="text/javascript" src='https://cloud.tinymce.com/stable/tinymce.min.js'></script>
  <script>
      let editingItem = '';
      let LectureCount = 2;

      function StartEditing(element){

        if( editingItem !== '') {
            StopEditing();
        }

        editingItem = element;

         tinymce.init({
            selector: "#"+element+"-name",
            menubar: false,
            inline: true,
            browser_spellcheck: true,
            width: '80%',
            plugins:[
                'textcolor'
            ],
            toolbar: 'undo redo | bold italic underline | forecolor backcolor'
          });

        tinymce.init({
            selector: "#"+element+"-content",
            browser_spellcheck: true,
            plugins: [
              'advlist autolink link image lists charmap codesample  preview hr anchor ',
              'searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking',
              'save table contextmenu directionality  template paste textcolor'
            ],
            toolbar: " undo redo | bold italic | forecolor backcolor |  codesample | alignleft aligncenter alignright alignjustify | bullist numlist | link image "
        });

        let item = document.getElementById(editingItem+"-save");
        item.hidden = false;
        item = document.getElementById(editingItem+"-edit");
        item.hidden = true;
      }

      function StopEditing(){
        tinymce.remove();
        let item = document.getElementById(editingItem+"-save");
        item.hidden = true;
        item = document.getElementById(editingItem+"-edit");
        item.hidden = false;
        if (document.getElementById(editingItem).getElementsByTagName("button")[0])
            document.getElementById(editingItem).getElementsByTagName("button")[0].remove();
        item = document.getElementById(editingItem+"-edit");
        var refName = editingItem.substring(4);
        document.getElementById("a"+refName).innerText = document.getElementById(editingItem+"-name").innerText;
        editingItem = '';
      }

      function StartEditingLecture(element){

        if( editingItem !== '') {
            StopEditing();
        }

        editingItem = element;

        tinymce.init({
            selector: "#"+element+"-name",
            browser_spellcheck: true,
            menubar: false,
            inline: true,
            width: '80%',
            plugins:[
                'textcolor'
            ],
            toolbar: 'undo redo | bold italic underline | forecolor backcolor'
        });

        let item = document.getElementById(editingItem+"-save");
        item.hidden = false;
        item = document.getElementById(editingItem+"-edit");
        item.hidden = true;
        var temp = document.getElementsByTagName("template")[0];
        item = temp.content.cloneNode(true);
        document.getElementById(editingItem).appendChild(item);
        document.getElementById(editingItem).getElementsByTagName("button")[0].onclick = function() { AddItem(editingItem.substring(5)); };
      }

      function AddLecture(){
        LectureCount++;
        var newLecture = document.createElement("div");
        newLecture.id = 'item-'+LectureCount;
        newLecture.innerHTML = `<hr>
                             <div style="float:right; position: relative">
                                <a id="item-`+LectureCount+`-save" onclick="StopEditing()" href="#item-`+LectureCount+`" style="color: lightblue" hidden>save</a>
                                <a id="item-`+LectureCount+`-edit" onclick="StartEditingLecture('item-`+LectureCount+`')" href="#item-`+LectureCount+`" style="color: lightblue">edit</a>
                                <a href="#item-`+(LectureCount-1)+`" onclick='Swap("item-`+(LectureCount-1)+`","item-`+(LectureCount)+`")' style="color: lightblue">up</a>
                                <a href="#item-`+(LectureCount+1)+`" onclick='Swap("item-`+(LectureCount)+`","item-`+(LectureCount+1)+`")' style="color: lightblue">down</a>
                                <a href="#item-`+(LectureCount-1)+`" style="color: lightblue" onclick='DeleteLecture("`+LectureCount+`")'>delete</a>
                             </div>
                             <h4 id="item-`+LectureCount+`-name" style="width:80%; word-wrap: break-word;">New Lecture</h4>
                             <div id="item-`+LectureCount+`-content"></div>`;
        var button = document.getElementById("AddLecture");
        document.getElementById("mainContainer").insertBefore(newLecture,button);
        CreateLectureRef();

        StartEditingLecture('item-'+LectureCount);
      }

      function CreateLectureRef(){
        var a = document.createElement("a");
        a.classList.add("nav-link");
        a.id = "a-"+LectureCount;
        a.href="#item-"+LectureCount;
        document.getElementById("navbar-main").appendChild(a)
        var nav = document.createElement("nav");
        nav.classList.add("nav", "nav-pills", "flex-column");
        nav.id ="nav-"+LectureCount;
        document.getElementById("navbar-main").appendChild(nav);
      }

      function AddItem(container){
        var itemCount = document.getElementById("nav-"+container).getElementsByTagName("a").length+1;
        var ItemName = container+"-"+itemCount;
        var newItem = document.createElement("div");
        newItem.id = 'item-'+ItemName;
        newItem.innerHTML = `<div style="float:right; position: relative">
                                <a id="item-`+ItemName+`-save" onclick="StopEditing()" href="#item-`+ItemName+`" style="color: lightblue" hidden>save</a>
                                <a id="item-`+ItemName+`-edit" onclick="StartEditing('item-`+ItemName+`')" href="#item-`+ItemName+`" style="color: lightblue">edit</a>
                                <a href="#item-`+container+`-`+(itemCount-1)+`" style="color: lightblue" onclick='Swap("item-`+container+`-`+(itemCount-1)+`","item-`+ItemName+`")'>up</a>
                                <a href="#item-`+container+`-`+(itemCount+1)+`" style="color: lightblue" onclick='Swap("item-`+ItemName+`","item-`+container+`-`+(itemCount+1)+`")'>down</a>
                                <a href="#item-`+container+`" style="color: lightblue" onclick='DeleteItem("`+ItemName+`")'>delete</a>
                             </div>
                             <h5 id="item-`+ItemName+`-name" style="width:80%; word-wrap: break-word;">New Item</h5>
                             <div id="item-`+ItemName+`-content"></div>`;
        document.getElementById("item-"+container+"-content").appendChild(newItem);
        CreateItemRef("nav-"+container,ItemName);
        StartEditing('item-'+ItemName);
      }

      function CreateItemRef(nav,name){
        var a = document.createElement("a");
        a.classList.add("nav-link","ml-3","my-1");
        a.id = "a-"+name;
        a.href="#item-"+name;
        document.getElementById(nav).appendChild(a)
      }

      function Swap(first,second){
        if( editingItem !== '') {
            StopEditing();
        }
        var name = document.getElementById(first+"-name").innerText
        document.getElementById(first+"-name").innerText = document.getElementById(second+"-name").innerText
        document.getElementById(second+"-name").innerText = name;
        var content = document.getElementById(first+"-content").innerHTML;
        document.getElementById(first+"-content").innerHTML = document.getElementById(second+"-content").innerHTML
        document.getElementById(second+"-content").innerHTML = content;
        var refName = first.substring(4);
        document.getElementById("a"+refName).innerText = document.getElementById(first+"-name").innerText;
        refName = second.substring(4);
        document.getElementById("a"+refName).innerText = document.getElementById(second+"-name").innerText;
        if (refName.length==2)
            SwapLectures(first,second)
      }

      function SwapLectures(first,second){
        var refName1 = first.substring(4);
        var refName2 = second.substring(4);
        var content = document.getElementById("nav"+refName1).innerHTML;
        document.getElementById("nav"+refName1).innerHTML = document.getElementById("nav"+refName2).innerHTML
        document.getElementById("nav"+refName2).innerHTML = content;
      }

      function DeleteItem(element){
          if( editingItem == "item-"+element) {
              StopEditing();
          }
          Delete(element);
      }

      function Delete(element){
          var array = element.split("-");
          var itemNumber = Number(array.pop())+1;
          var lectureNumber = "";
          if (array.length>0)
            lectureNumber = array.pop()+"-";
          var next = document.getElementById("item-"+lectureNumber+itemNumber)
          if (next == null){
            document.getElementById("item-"+element).remove();
            document.getElementById("a-"+element).remove();
          }else{
            Swap("item-"+element,"item-"+lectureNumber+itemNumber)
            Delete(lectureNumber+itemNumber);
          }

      }

      function DeleteLecture(element){
        DeleteItem(element);
        document.getElementById("nav-"+LectureCount).remove();
        LectureCount--;
      }

  </script>

</tags:main>

