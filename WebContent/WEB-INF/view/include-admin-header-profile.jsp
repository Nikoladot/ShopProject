<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

 
 <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
    </ul>

    
    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
      <!-- Messages Dropdown Menu -->
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-user"></i>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media align-items-center">
              <img src="${pageContext.request.contextPath}/admin/dist/img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  
                  <sec:authentication property="principal.username"/>
                  
                </h3>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="user-myupdate" class="dropdown-item">
            <i class="fas fa-user"></i> Your Profile
          </a>
          
          <div class="dropdown-divider"></div>
          <a href="user-change-password" class="dropdown-item">
            <i class="fas fa-key"></i> Change password
          </a>
          
        
          
          <form:form action="${pageContext.request.contextPath}/logout" >
          
          <input type="submit" value="Log Out"  >
           </form:form>
          
          
        </div>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->