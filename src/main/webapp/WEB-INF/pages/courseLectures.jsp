<%@ page trimDirectiveWhitespaces="true" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:main pageTitle="Auditorium">
  <div class="container-fluid">
    <div class="row flex-xl-nowrap">
      <div class="col-12 col-md-3 col-xl-3 bd-sidebar">
        <nav id="navbar-example3" class="navbar navbar-light bg-light sticky-top anyClass">
          <nav class="nav nav-pills flex-column">
            <a class="nav-link" href="#item-1">Lecture 1: Introduction</a>
            <nav class="nav nav-pills flex-column">
              <a class="nav-link ml-3 my-1" href="#item-1-1">Audience</a>
              <a class="nav-link ml-3 my-1" href="#item-1-2">Goal</a>
              <a class="nav-link ml-3 my-1" href="#item-1-3">Task 1.1: Download phoneshop...</a>
              <a class="nav-link ml-3 my-1" href="#item-1-4">Task 1.2: Build and run</a>
              <a class="nav-link ml-3 my-1" href="#item-1-5">Task 1.3: Configure IDE</a>
            </nav>
            <a class="nav-link" href="#item-2">Lecture 2: PLP & Demodata & PDP</a>
            <nav class="nav nav-pills flex-column">
              <a class="nav-link ml-3 my-1" href="#item-2-1">Task 2.1: Implement product search</a>
              <a class="nav-link ml-3 my-1" href="#item-2-2">Task 2.2: Implement sorting</a>
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
          <div data-spy="scroll" data-target="#navbar-example3" data-offset="0">
            <%--Start Lecture1--%>
            <hr><div style="float:right; position: relative"><a href="#" style="color: lightblue">edit</a> <a href="#" style="color: lightblue">up</a> <a href="#" style="color: lightblue">down</a></div>
            <h4 id="item-1">Lecture 1: Introduction</h4>
            
            <%--Start Lecture1.lectureItem1--%>
            <div style="float:right; position: relative"><a href="#" style="color: lightblue">edit</a> <a href="#" style="color: lightblue">up</a> <a href="#" style="color: lightblue">down</a></div>
            <h5 id="item-1-1">Audience</h5>
            <p>Junior developers.</p>
            <%--End Lecture1.lectureItem1--%>
            <%--Start Lecture1.lectureItem2--%>
            <div style="float:right; position: relative"><a href="#" style="color: lightblue">edit</a> <a href="#" style="color: lightblue">up</a> <a href="#" style="color: lightblue">down</a></div>
            <h5 id="item-1-2">Goal</h5>
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
            <%--End Lecture1.lectureItem2--%>
            <%--Start Lecture1.lectureItem3--%>
            <div style="float:right; position: relative"><a href="#" style="color: lightblue">edit</a> <a href="#" style="color: lightblue">up</a> <a href="#" style="color: lightblue">down</a></div>
            <h5 id="item-1-3">Task 1.1: Download phoneshop project sources</h5>
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
            <%--End Lecture1.lectureItem3--%>
            <%--Start Lecture1.lectureItem4--%>
            <h5 id="item-1-4">Task 1.2: Build and run the project</h5>
            <p>Install maven 3.x
              Execute run.bat from the root of the project.</p>
            <h5 id="item-1-5">Task 1.3: Configure IDE</h5>
            <p>Open the project in your favourite IDE: Intellij or Eclipse by selection “import project from existing source” or something like that.
              If the IDE recognizes maven then it should pick maven project with configured classpath. See how it looks in Intellij for example.
            </p>
            <%--End Lecture1.lectureItem4--%>
            <%--End Lecture1--%>
            <hr>
            <%--Start Lecture2--%>
            <h4 id="item-2">Lecture 2: PLP & Demodata & PDP</h4>
            <%--Start Lecture2.lectureItem1--%>
            <h5 id="item-2-1">Task 2.1: Implement product search</h5>
            <p>
              The search must work using OR clause. The example above means: search all products having description containing “Samsung” or “S” or “II”. Products having all search terms must come first in the search result.
            </p>
            <p>
              Implementation hint: Use java8 streams.
            </p>
            <%--End Lecture2.lectureItem1--%>
            <%--Start Lecture2.lectureItem2--%>
            <h5 id="item-2-2">Task 2.2: Implement sorting</h5>
            <p>
              It should be possible to sort PLP on product description or price.
              By default there is no sorting.
              PLP sorted by description ascending shall look like:
            </p>
            <%--End Lecture2.lectureItem2--%>
            <%--End Lecture2--%>
          </div>
        </div>
      </div>
    </div>
  </div>
</tags:main>

