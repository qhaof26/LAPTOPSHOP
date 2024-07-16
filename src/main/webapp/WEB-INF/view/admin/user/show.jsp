<html lang="en">
<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
                <meta name="author" content="Hỏi Dân IT" />
                <title>Product</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Dashboard</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Users</li>
                                </ol>
                                <!--Content-->
                                <div class="row">
                                    <div class="col-12 mx-auto">
                                        <div class="d-flex justify-content-between">
                                            <h3>Table User</h3>
                                            <a href="/admin/user/create"><button class="btn btn-primary">Create
                                                    user</button></a>
                                        </div>
                                        <table class="table table-hover table-bordered">
                                            <thead>
                                                <tr>
                                                    <th scope="col" style="text-align: center;">ID</th>
                                                    <th scope="col" style="text-align: center;">Email</th>
                                                    <th scope="col" style="text-align: center;">Full Name</th>
                                                    <th scope="col" style="text-align: center;"> Role</th>
                                                    <th scope="col-3" style="text-align: center;">Action</th>
                                                </tr>
                                            </thead>
                                            <tbody class="table-group-divider">
                                                <c:forEach items="${listUser}" var="user">
                                                    <tr>
                                                        <th style="text-align: center;">${user.id}</th>
                                                        <td>${user.email}</td>
                                                        <td>${user.fullName}</td>
                                                        <td>${user.role.name}</td>
                                                        <td class="d-flex justify-content-between">
                                                            <a href="/admin/user/${user.id}"
                                                                class="btn btn-info">View</a>
                                                            <a href="/admin/user/update/${user.id}"
                                                                class="btn btn-warning">Update</a>
                                                            <a href="/admin/user/delete/${user.id}"
                                                                class="btn btn-danger">Delete</a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
            </body>

</html>