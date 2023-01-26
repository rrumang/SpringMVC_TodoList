<%--
  Created by IntelliJ IDEA.
  User: rrumang
  Date: 2023/01/19
  Time: 9:40 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>LIST</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Navbar</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                        <a class="nav-link" href="#">Features</a>
                        <a class="nav-link" href="#">Pricing</a>
                        <a class="nav-link disabled">Disabled</a>
                    </div>
                </div>
            </div>
        </nav>
    </div>
    <div class="row content">
        <div class="col">
            <div class="card">
                <div class="card-header">
                    Featured
                </div>
                <div class="card-body">
                    <form action="/todo/modify" method="post">

                    <div class="input-group mb-3">
                        <span class="input-group-text">TNO</span>
                        <input type="text" name="tno" class="form-control"
                               value='<c:out value="${dto.tno}"></c:out>' readonly>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">Title</span>
                        <input type="text" name="title" class="form-control"
                               value='<c:out value="${dto.title}"></c:out>'>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">DueDate</span>
                        <input type="date" name="dueDate" class="form-control"
                               value='<c:out value="${dto.dueDate}"></c:out>'>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">WRITER</span>
                        <input type="text" name="writer" class="form-control"
                               value='<c:out value="${dto.writer}"></c:out>' readonly>
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            Finished &nbsp;
                        </label>
                        <input type="checkbox" name="finished" class="form-check-input"
                        ${dto.finished?"checked":""}>
                    </div>

                    <div class="my-4">
                        <div class="float-end">
                            <button type="button" class="btn btn-danger">Remove</button>
                            <button type="button" class="btn btn-primary">Modify</button>
                            <button type="button" class="btn btn-secondary">List</button>
                        </div>
                    </div>
                    </form>
                </div>
                <script>
                    const serverValidResult = {}

                    <c:forEach items="${errors}" var="error">
                    serverValidResult['${error.getField()}'] = '${error.defaultMessage}'
                    </c:forEach>

                    console.log(serverValidResult)
                </script>
                <script>
                    const formObj = document.querySelector("form")

                    document.querySelector(".btn-danger").addEventListener("click", function (e) {
                        e.preventDefault()
                        e.stopPropagation()

                        formObj.action = `/todo/remove?${pageRequestDTO.link}`
                        formObj.method = "post"

                        formObj.submit()
                    }, false)

                    document.querySelector(".btn-primary").addEventListener("click", function (e) {
                        e.preventDefault()
                        e.stopPropagation()

                        formObj.action = "/todo/modify"
                        formObj.method = "post"

                        formObj.submit()
                    }, false)

                    document.querySelector(".btn-secondary").addEventListener("click", function (e) {
                        e.preventDefault()
                        e.stopPropagation()

                        selr.location = `/todo/list?${pageRequestDTO.link}`;
                    }, false)

                </script>
            </div>
        </div>
    </div>
    <div class="row footer">
        <!--<h1>Footer</h1>-->
        <div class="row fixed-bottom" style="z-index: -100">
            <footer class="py-1 my-1">
                <p class="text-center text-muted">Footer</p>
            </footer>
        </div>
    </div>
</div>
</body>
</html>