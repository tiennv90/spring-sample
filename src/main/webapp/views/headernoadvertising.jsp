<!DOCTYPE html>
<%@page import="com.spring.sample.model.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Seniors Shoppee Ltd.</title>

    <!-- Bootstrap -->
    <link href="<c:url value="/stylesheets/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/stylesheets/custom.css" />" rel="stylesheet">
    <link href="<c:url value="/stylesheets/responsive.css" />" rel="stylesheet">
    
    <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,400,600,700' rel='stylesheet' type='text/css'>
	<script src="/js/1.11.2/jquery.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <header id="header" class="container-fluid">

        <div class="container">
            <div class="row">
                <div class="col-md-5 col-sm-6 col-xs-12">
                    <div class="logo text-md-center">
                        <h1><a href="/"><img src="/images/full_logo.png" alt=""><span class="sr-only">Seniors Shoppee Ltd.</span></a></h1>
                    </div>
                    <!-- /.logo -->
                </div>
                <!-- /.col -->


                <div class="col-md-5 col-md-offset-2  col-sm-5 col-sm-offset-1 col-xs-12">

                    <ul class="nav navbar-nav pull-right">
                    <%
                    	User user = (User) request.getSession().getAttribute("user");
                    	if (user == null) {
                    %>
                        <li><a href="/user/signin">Sign In</a>
                        </li>
                        <li><a href="/user/create">Create Account</a>
                        </li>
                        <% } else {
                        	if (user.isAdmin()) {
                        		%>
                        		<li><a href="/admin/product">My Account</a>
                        		<% 
                        	}
                        %>
                        <li><a href="/user/myaccount">My Account</a>
                        </li>
                        <li><a href="/login/logout">Logout</a>
                        </li>                        
                        <% } %>
                        <li><a href="/help">Help</a>
                        </li>
                    </ul>
                    <!-- /.nav navbar-nav pull-right -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container -->

    </header>
    <!-- //HEADER -->
    
    <nav id="navbar" class="navbar navbar-default">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
	                <c:forEach var="category" items="${categories}">
		                <c:choose>
		                	<c:when test="${currentCategory eq  category.name}">
		                	 	<li class="active"><a href="/category/${category.id}">${category.name}</a></li>
		                	</c:when>
		                	<c:otherwise>
		                		<li><a href="/category/${category.id}">${category.name}</a></li>
		                	</c:otherwise>
		                </c:choose>	 
	                </c:forEach>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    <!--  -->	
    
