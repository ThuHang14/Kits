<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
          integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
          crossorigin="anonymous" referrerpolicy="no-referrer">
    <title>Title</title>
</head>


<style>
    #list1 .form-control {
        border-color: transparent;
    }

    #list1 .form-control:focus {
        border-color: transparent;
        box-shadow: none;
    }

    #list1 .select-input.form-control[readonly]:not([disabled]) {
        background-color: #fbfbfb;
    }
</style>
<body>

<%--NAVBAR--%>
<nav class="navbar navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand"><i class="fa-solid fa-clipboard-check"></i></a>
        <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
</nav>

<%--BODY--%>
<section class="vh-100">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-20">
            <div class="col">
                <div class="card" id="list1" style="border-radius: .75rem; background-color: #eff1f2;">
                    <div class="card-body py-4 px-4 px-md-5">

                        <p class="h1 text-center mt-3 mb-4 pb-3 text-primary">
                            <i class="fas fa-check-square me-1"></i>
                            <u>My Todo-s</u>
                        </p>

                        <div class="pb-2">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex flex-row align-items-center">
                                        <input type="text" class="form-control form-control-lg"
                                               id="exampleFormControlInput1"
                                               placeholder="Add new...">
                                        <a href="#!" data-mdb-toggle="tooltip" title="Set due date"><i
                                                class="fas fa-calendar-alt fa-lg me-3"></i></a>
                                        <div>
                                            <button type="button" class="btn btn-primary">Add</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <hr class="my-4">

                        <div class="d-flex justify-content-end align-items-center mb-4 pt-2 pb-3">
                            <p class="small mb-0 me-2 text-muted">Filter</p>
                            <select class="select">
                                <option value="1">All</option>
                                <option value="2">Completed</option>
                                <option value="3">Active</option>
                                <option value="4">Has due date</option>
                            </select>
                            <p class="small mb-0 ms-4 me-2 text-muted">Sort</p>
                            <select class="select">
                                <option value="1">Added date</option>
                                <option value="2">Due date</option>
                            </select>
                            <a href="#!" style="color: #23af89;" data-mdb-toggle="tooltip" title="Ascending"><i
                                    class="fas fa-sort-amount-down-alt ms-2"></i></a>
                        </div>
<%--todo check--%>
                        <ul class="list-group list-group-horizontal rounded-0 bg-transparent">
                            <c:forEach var="todo" items="${listTodo}">

                            <li
                                    class="list-group-item d-flex align-items-center ps-0 pe-3 py-1 rounded-0 border-0 bg-transparent">
                                <div class="form-check">
                                    <input class="form-check-input me-0" type="checkbox" value="" id="flexCheckChecked1"
                                           aria-label="..." checked/>
                                </div>
                            </li>
                            <li
                                    class="list-group-item px-3 py-1 d-flex align-items-center flex-grow-1 border-0 bg-transparent">
                                <p class="lead fw-normal mb-0"><c:out value="${todo.title}"/></p>
                            </li>
                            </c:forEach>
                        </ul>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%--    FOOTER--%>
<div class="container center">
    <div class="container px-4 py-5" id="icon-grid" style="position: absolute; bottom: 0;">

        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4 py-5">
            <div class="col d-flex align-items-start">
                <svg class="bi text-muted flex-shrink-0 me-3" width="1.75em" height="1.75em">
                    <use xlink:href="#bootstrap"></use>
                </svg>
                <div>
                    <h4 class="fw-bold mb-0">Featured title</h4>
                    <p>Paragraph of text beneath the heading to explain the heading.</p>
                </div>
            </div>
            <div class="col d-flex align-items-start">
                <svg class="bi text-muted flex-shrink-0 me-3" width="1.75em" height="1.75em">
                    <use xlink:href="#cpu-fill"></use>
                </svg>
                <div>
                    <h4 class="fw-bold mb-0">Featured title</h4>
                    <p>Paragraph of text beneath the heading to explain the heading.</p>
                </div>
            </div>
            <div class="col d-flex align-items-start">
                <svg class="bi text-muted flex-shrink-0 me-3" width="1.75em" height="1.75em">
                    <use xlink:href="#calendar3"></use>
                </svg>
                <div>
                    <h4 class="fw-bold mb-0">Featured title</h4>
                    <p>Paragraph of text beneath the heading to explain the heading.</p>
                </div>
            </div>
            <div class="col d-flex align-items-start">
                <svg class="bi text-muted flex-shrink-0 me-3" width="1.75em" height="1.75em">
                    <use xlink:href="#home"></use>
                </svg>
                <div>
                    <h4 class="fw-bold mb-0">Featured title</h4>
                    <p>Paragraph of text beneath the heading to explain the heading.</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
