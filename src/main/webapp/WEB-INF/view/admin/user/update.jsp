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
                <title>Update User</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#avatarFile");
                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imgURL);
                            $("#avatarPreview").css({ "display": "block" });
                        });
                    });
                </script>
            </head>

            <body class="sb-nav-fixed">
                <!--Header-->
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
                                <div class="container mt-5">
                                    <div class="row">
                                        <div class="col-md-6 col-12 mx-auto">
                                            <h2>UPDATE USER</h2>
                                            <form:form action="/update" method="post" modelAttribute="user"
                                                enctype="multipart/form-data">
                                                <div class="mb-3">
                                                    <form:input type="text" class="form-control" path="id"
                                                        style="display: none;" />
                                                </div>
                                                <div class="col-12 mb-3">
                                                    <label for="exampleInputEmail1" class="form-label">Email
                                                        address</label>
                                                    <form:input type="email" class="form-control"
                                                        aria-describedby="emailHelp" path="email" disabled="true" />
                                                </div>
                                                <div class="col-12 mb-3">
                                                    <label for="exampleInputFullName" class="form-label">Full
                                                        name</label>
                                                    <form:input type="text" class="form-control" path="fullName" />
                                                </div>
                                                <div class="col-12 mb-3">
                                                    <label for="exampleInputPhone" class="form-label">Phone
                                                        numbers</label>
                                                    <form:input type="number" class="form-control" path="phone" />
                                                </div>
                                                <div class="col-12 mb-3">
                                                    <label for="exampleInputAddress" class="form-label">Address</label>
                                                    <form:input type="text" class="form-control" path="address" />
                                                </div>
                                                <div class="col-6 mb-3">
                                                    <label class="form-label">Role:</label>
                                                    <form:select class="form-select" path="role.name">
                                                        <form:option value="ADMIN">ADMIN</form:option>
                                                        <form:option value="USER">USER</form:option>
                                                    </form:select>
                                                </div>
                                                <div class="col-6 mb-3">
                                                    <label for="formFile" class="form-label">Avatar</label>
                                                    <input class="form-control" type="file" id="avatarFile"
                                                        accept=".png, .jpg, .jpeg" name="fileAvatar" />
                                                </div>
                                                <div class="col-12">
                                                    <img style="max-height:250px; display: none;" alt="avatar"
                                                        id="avatarChange">
                                                </div>
                                                <div>
                                                    <button type="submit" class="btn btn-warning">Update</button>
                                                </div>
                                            </form:form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--Footer-->
                            <jsp:include page="../layout/footer.jsp" />
                        </main>
                    </div>
                </div>


            </body>

</html>