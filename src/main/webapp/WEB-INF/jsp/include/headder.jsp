<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<head>

	<title>Inventory Manager- Apptota portal</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
	<meta name="description" content="Admin, Dashboard, Bootstrap" />
	<link rel="shortcut icon" sizes="196x196" href="../../UnipointWeb/resources/assets/images/logo.png">
	
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>        
        <!-- META SECTION -->
        <title>Insurance PA</title>            
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        
        
	<link rel="stylesheet" href="../../resource/static/libs/bower/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="../../resource/static/libs/bower/material-design-iconic-font/dist/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" href="../../resource/static/libs/bower/animate.css/animate.min.css">
	<link rel="stylesheet" href="../../resource/static/css/bootstrap.css">
	<link rel="stylesheet" href="../../resource/static/css/core.css">
	<link rel="stylesheet" href="../../resource/static/css/jquery-ui.css">
	<link rel="stylesheet" href="../../resource/static/css/misc-pages.css">
	<!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900,300"> -->
    <link rel="stylesheet" href="../../resource/static/libs/bower/fullcalendar/dist/fullcalendar.min.css"/>
	<link rel="stylesheet" href="../../resource/static/libs/bower/perfect-scrollbar/css/perfect-scrollbar.css"/>
	<link rel="stylesheet" href="../../resource/static/css/app.css"/>
	<link rel="stylesheet" href="../../resource/static/libs/misc/datatables/datatables.min.css"/>
	<link rel="stylesheet" href="../../resource/static/libs/bower/fullcalendar/dist/fullcalendar.min.css">
    <script type="text/javascript" src="../../resource/static/libs/bower/jquery/dist/jquery.js"></script>
    <script type="text/javascript" src="../../resource/static/libs/bower/jquery-ui/jquery-ui.min.js"></script>
    <script type="text/javascript" src="../../resource/static/libs/bower/jQuery-Storage-API/jquery.storageapi.min.js"></script>
    <script type="text/javascript" src="../../resource/static/libs/bower/bootstrap-sass/assets/javascripts/bootstrap.js"></script>
    <script type="text/javascript" src="../../resource/static/libs/bower/breakpoints.js/dist/breakpoints.min.js"></script>
</head>

<body class="">
<!--============= start main area -->
<%-- /////////////////////////response alert boxes end //////////////////////////// --%>
<!-- APP NAVBAR ==========-->
<nav id="app-navbar" class="navbar navbar-inverse navbar-fixed-top primary">

    <!-- navbar header -->
    <div class="navbar-header">
        <button type="button" id="menubar-toggle-btn"
                class="navbar-toggle visible-xs-inline-block navbar-toggle-left hamburger hamburger--collapse js-hamburger">
            <span class="sr-only">Toggle navigation</span>
            <span class="hamburger-box"><span class="hamburger-inner"></span></span>
        </button>

        <button type="button" class="navbar-toggle navbar-toggle-right collapsed" data-toggle="collapse"
                data-target="#app-navbar-collapse" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="zmdi zmdi-hc-lg zmdi-more"></span>
        </button>

        <button type="button" class="navbar-toggle navbar-toggle-right collapsed" data-toggle="collapse"
                data-target="#navbar-search" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="zmdi zmdi-hc-lg zmdi-search"></span>
        </button>
<%-- 
        <a href="<%=request.getContextPath()%>/home" class="navbar-brand">
            <span class="brand-icon"><i class="fa fa-gg"></i></span>
            <span class="brand-name">Inventory Manager</span>
        </a> --%>
    </div><!-- .navbar-header -->

    <div class="navbar-container container-fluid">
        <div class="collapse navbar-collapse" id="app-navbar-collapse">
            <ul class="nav navbar-toolbar navbar-toolbar-left navbar-left">
				<a href="<%=request.getContextPath()%>/home">
                <li>
                  
                    <h2 class="page-title hidden-menubar-top hidden-float">Dashboard</h2>
                 
                </li>
                 </a>
            </ul>

            <ul class="nav navbar-toolbar navbar-toolbar-right navbar-right">


                <li>
                    <h3 class="page-title hidden-menubar-top hidden-float">Hello ${sessionScope.username} you logged as ${sessionScope.userrole}</h3>
                </li>
                <li class="dropdown">
                    <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false"><i class="zmdi zmdi-hc-lg zmdi-settings"></i></a>
                    <ul class="dropdown-menu animated flipInY">

                        <li><a href="<%=request.getContextPath()%>/logout"><i class="zmdi m-r-md zmdi-hc-lg zmdi-info"></i>Logout</a>
                        </li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="javascript:void(0)" class="side-panel-toggle" data-toggle="class" data-target="#side-panel"
                       data-class="open" role="button"><i class="zmdi zmdi-hc-lg zmdi-apps"></i></a>
                </li>
            </ul>
        </div>
    </div><!-- navbar-container -->
</nav>

<!-- APP ASIDE ==========-->
<!-- <aside id="menubar" class="menubar light">
    <div class="app-user">
        <div class="media">
            <div class="media-left">

            </div>

        </div>.media
    </div> --><!-- .app-user -->

    <%-- <div class="menubar-scroll">
        <div class="menubar-scroll-inner">
            <ul class="app-menu">
                <a href="<%=request.getContextPath()%>/home">
                    <i class="menu-icon zmdi zmdi-view-dashboard zmdi-hc-lg"></i>
                    <span class="menu-text">Dashboard</span>
                </a>

                <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
                <li class="has-submenu">
                   <a href="javascript:void(0)" class="submenu-toggle">
                     <i class="menu-icon zmdi zmdi-shopping-cart-plus zmdi-hc-lg"></i>
                     <span class="menu-text">Customer Management</span>
                     <i class="menu-caret zmdi zmdi-hc-sm zmdi-chevron-right"></i>
                   </a>
                   <ul class="submenu">
                     <li><a href="<%=request.getContextPath()%>/customers/customer/create">add Customer</a></li>
                   </ul>
                 </li>
                </security:authorize>
                <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
                <li class="has-submenu">
                   <a href="javascript:void(0)" class="submenu-toggle">
                     <i class="menu-icon zmdi zmdi-shopping-cart-plus zmdi-hc-lg"></i>
                     <span class="menu-text">Product Management</span>
                     <i class="menu-caret zmdi zmdi-hc-sm zmdi-chevron-right"></i>
                   </a>
                   <ul class="submenu">
                      <li><a href="<%=request.getContextPath()%>/products/product/create">add Product</a></li>
                   </ul>
                 </li>
                </security:authorize>
                 <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
                <li class="has-submenu">
                   <a href="javascript:void(0)" class="submenu-toggle">
                     <i class="menu-icon zmdi zmdi-shopping-cart-plus zmdi-hc-lg"></i>
                     <span class="menu-text">Order Management</span>
                     <i class="menu-caret zmdi zmdi-hc-sm zmdi-chevron-right"></i>
                   </a>
                   <ul class="submenu">
                     <li><a href="<%=request.getContextPath()%>/orders/order/create">Place order</a></li>
                   </ul>
                 </li>
                </security:authorize>
               <security:authorize access="hasRole('ROLE_ADMIN')">
                <li class="has-submenu">
                    <a href="javascript:void(0)" class="submenu-toggle">
                        <i class="menu-icon zmdi zmdi-accounts-add zmdi-hc-lg"></i>
                        <span class="menu-text">User Management</span>
                        <i class="menu-caret zmdi zmdi-hc-sm zmdi-chevron-right"></i>
                    </a>
                    <ul class="submenu">
                        <li><a href="<%=request.getContextPath()%>/users/web/create">Create Web User</a></li>
                    </ul>
                </li>
                 </security:authorize> 
                <li class="has-submenu">
                    <a href="javascript:void(0)" class="submenu-toggle">
                        <i class="menu-icon zmdi zmdi-accounts-list-alt zmdi-hc-lg"></i>
                        <span class="menu-text">Agent Management</span>
                        <i class="menu-caret zmdi zmdi-hc-sm zmdi-chevron-right"></i>
                    </a>
                    <ul class="submenu">
                        <li><a href="<%=request.getContextPath()%>/users/mobile/create">Create Mobile User</a></li>
                        <li><a href="<%=request.getContextPath()%>/users/mobile/edit">Edit Mobile User</a></li>
                   </ul>
               </li>
               </security:authorize>
               <li class="has-submenu">
                 <a href="javascript:void(0)" class="submenu-toggle">
                   <i class="menu-icon zmdi zmdi zmdi-chart zmdi-hc-lg"></i>
                   <span class="menu-text">Reports</span>
                   <i class="menu-caret zmdi zmdi-hc-sm zmdi-chevron-right"></i>
                 </a>
                 <ul class="submenu">
                 <li><a href="<%=request.getContextPath()%>/Demograpic">Demographic Report</a></li>
                   <li><a href="<%=request.getContextPath()%>/LoyaltyTier">Loyalty Tier</a></li>
                 </ul>
               </li>
            </ul><!-- .app-menu -->
        </div><!-- .menubar-scroll-inner -->
    </div><!-- .menubar-scroll --> --%>
</aside>
<!--========== END app aside -->

<!-- navbar search -->
<div id="navbar-search" class="navbar-search collapse">
    <div class="navbar-search-inner">
        <form action="#">
            <span class="search-icon"><i class="fa fa-search"></i></span>
            <input class="search-field" type="search" placeholder="search..."/>
        </form>
        <button type="button" class="search-close" data-toggle="collapse" data-target="#navbar-search"
                aria-expanded="false">
            <i class="fa fa-close"></i>
        </button>
    </div>
    <div class="navbar-search-backdrop" data-toggle="collapse" data-target="#navbar-search" aria-expanded="false"></div>
</div><!-- .navbar-search -->

<!-- APP Content here  /////////////////////////////////////////////////////////////////////////////////////////////////////////////==========-->


<!--========== END app Content  /////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
