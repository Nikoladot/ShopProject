<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
    <%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title>Cubes school - Shop project</title>


  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  <!-- Select -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/select2/css/select2.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
  <!-- Bootstrap4 duallistbox -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/bootstrap4-duallistbox/bootstrap-duallistbox.min.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <jsp:include page="include-admin-header-profile.jsp"/>  

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
  
<!-- Sidebar -->
      <jsp:include page="include-admin-menu.jsp"/>
    
      <!-- /.sidebar-menu -->
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Products Form</h1>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12">
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Product Form</h3>
              </div>
              <!-- /.card-header -->
              
                    
              
              <!-- form start -->
             
              
              <form:form action="product-save" role="form" modelAttribute="product">
              	<form:hidden path="id"/>
                <div class="card-body">
                  <div class="row">
                    <div class="col-md-6">
                      <div class="form-group">
                        <label>Title</label>
                        <form:input type="text" class="form-control" placeholder="Enter name" path="title"/>
                      </div>
                      <div class="form-group">
                        <label>Description</label>
                        <form:textarea class="form-control" placeholder="Enter Description" path="description" />
                      </div>
                       <div class="form-group">
                        <label>Manual Description</label>
                        <form:textarea class="form-control" placeholder="Enter Description" path="manual.description" />
                      </div>
                      
					<div class="form-group">
                        <label>Product Category</label>
                        <form:select class="form-control" path="category.id" itemLabel="name" itemValue="id" items="${categories}" />
                      </div>
                      <div class="form-group">
                        <label>Price</label>
                        <div class="input-group">
                          <form:input type="number" class="form-control" placeholder="Enter price" path="price" />
                          <div class="input-group-append">
                            <span class="input-group-text">$</span>
                          </div>
                        </div>
                      </div>
                       <div class="form-group">
                        <label>Quantity</label>
                        <div class="input-group">
                          <form:input type="number" class="form-control" placeholder="Enter quantity" path="quantity" />
                          <div class="input-group-append">
                            <span class="input-group-text">#</span>
                          </div>
                      </div>
                      </div>
						<div class="form-group">
                        <label>Image</label>
                        <form:input type="text" class="form-control" placeholder="Enter image url" path="image"/>
                      </div>
                      
                      
                      <div class="form-group" data-select2-id="61">
                  <label>Multiple</label>
                  <form:select path="stickers" itemLabel="title" itemValue="id" items="${stickers}" 
                  class="select2bs4 select2-hidden-accessible" multiple="true" data-placeholder="Select Sticker" 
                  style="width: 100%;" data-select2-id="23" tabindex="-1" aria-hidden="true">
                  
                   <form:option value="-" label="-Please select"/>
                   <form:options items="${stickers}"/>

                  </form:select>
  
                </div>
            <div class="form-group">
                        <label>Is product on main page:</label>
                        <form:checkbox  class="form-control"  path="homepage"/>
                      </div>
                        
                     
                    </div>
                    
                  </div>
                  
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Save</button>
                  <a href="product-list" class="btn btn-outline-secondary">Cancel</a>
                </div>
              </form:form>
              <!-- Form end -->
              
              
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="float-right d-none d-sm-inline">
      Java
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2019 <a href="https://cubes.edu.rs">Cubes School</a>.</strong> All rights reserved.
  </footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/admin/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/admin/dist/js/adminlte.min.js"></script>
<!-- Select2  -->
<script src="${pageContext.request.contextPath}/admin/plugins/select2/js/select2.full.min.js"></script>
<!-- Bootstrap duallistblock -->
<script src="${pageContext.request.contextPath}/admin/plugins/bootstrap4-duallistbox/jquery.bootstrap-duallistbox.min.js"></script>


<script>
$(function () {
    //Initialize Select2 Elements
    $('.select2').select2()

    //Initialize Select2 Elements
    $('.select2bs4').select2({
      theme: 'bootstrap4'
    })
    
        //Bootstrap Duallistbox
    $('.duallistbox').bootstrapDualListbox()

    

    $("input[data-bootstrap-switch]").each(function(){
      $(this).bootstrapSwitch('state', $(this).prop('checked'));
    });



})
</script>


</body>
</html>

