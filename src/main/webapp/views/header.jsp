<!DOCTYPE html>
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
                        <h1><a href="index.html"><img src="/images/full_logo.png" alt=""><span class="sr-only">Seniors Shoppee Ltd.</span></a></h1>
                    </div>
                    <!-- /.logo -->
                </div>
                <!-- /.col -->


                <div class="col-md-5 col-md-offset-2  col-sm-5 col-sm-offset-1 col-xs-12">

                    <ul class="nav navbar-nav pull-right">
                        <li><a href="sign_in.html">Sign In</a>
                        </li>
                        <li><a href="creat_account.html">Create Account</a>
                        </li>
                        <li><a href="my_account.html">My Account</a>
                        </li>
                        <li><a href="help.html">Help</a>
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
                    <li><a href="clothing.html">Clothing <span class="sr-only">(current)</span></a>
                    </li>
                    <li><a href="bathing_n_grooming.html">Bathing &amp; Grooming</a> </li>
                    <li><a href="health_product.html">Health Products</a> </li>
                    <li><a href="mobility.html">Mobility</a> </li>
                    <li><a href="kitchen.html">Kitchen</a> </li>
                    <li><a href="hobbies.html">Hobbies</a> </li>
                    <li><a href="phones_n_pager.html">Phones &amp; Pagers</a> </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    <!--  -->	
    
    <div class="container">
        <div class="col-xs-12 deal-of-day">
            <a href="deal-of-the-day.html"><img class="img-responsive" src="/images/deal-day01.png" alt=""> </a>
        </div>
    </div>   
