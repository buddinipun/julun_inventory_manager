<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="headder.jsp" />
<!-- APP MAIN ==========-->
<main id="app-main" class="app-main">
    <div class="wrap">
        <section class="app-content">
            <div class="row">
                <div class="col-md-6 col-sm-6">
                    <div class="widget p-md clearfix">
                        <div class="pull-left">
                            <h3 class="widget-title">Welcome to Ceylon Julun Group</h3>
                            <small class="text-color">Number of views</small>
                        </div>
                        <span class="pull-right fz-lg fw-500 counter" data-plugin="counterUp">102</span>
                    </div><!-- .widget -->
                </div>

                <div class="col-md-6 col-sm-6">
                    <div class="widget p-md clearfix">
                        <div class="pull-left">
                            <h3 class="widget-title">Active Users</h3>
                            <small class="text-color">Loads / contact</small>
                        </div>
                        <span class="pull-right fz-lg fw-500 counter" data-plugin="counterUp">325</span>
                    </div><!-- .widget -->
                </div>
            </div><!-- .row -->

            <div class="row">
            <div class="col-md-3 col-sm-6">
				<a href="<%=request.getContextPath()%>/orders/order/create">
					<div class="widget">
					<header class="widget-header">
						<h4 class="widget-title">QUOTATION</h4>
					</header><!-- .widget-header -->
					<hr class="widget-separator">
					<div class="widget-body text-center">
						<!-- <div class="big-icon"><i class="fa fa-5x fa-exclamation-circle"></i></div> -->
							<!-- <div class="avatar avatar-lg avatar-circle">
									<img class="img-responsive" src="resource/static/images/dashboard/quotation.png" alt="avatar"/>
								</div>.avatar -->
											<img class="stream-img" src="resource/static/images/dashboard/quotation.png" alt="">
						
						<p class="text-muted m-b-lg">Add, View or Edit Quotations</p>
					</div><!-- .widget-body -->
					
				</div><!-- .widget -->
				</a>
			</div><!-- END column -->

			<div class="col-md-3 col-sm-6">
				<div class="widget">
					<header class="widget-header">
						<h4 class="widget-title">INVOICE</h4>
					</header><!-- .widget-header -->
					<hr class="widget-separator">
					<div class="widget-body text-center">
						<!-- <div class="big-icon"><i class="fa fa-5x fa-dribbble"></i></div> -->
						<!-- <div class="avatar avatar-lg avatar-circle">
									<img class="stream-img" src="resource/static/images/dashboard/invoice.png" alt="avatar"/>
								</div>.avatar -->
									<a href="../assets/images/original/102.jpg" data-lightbox="feed-img-1">
											<img class="stream-img" src="resource/static/images/dashboard/invoice.png" alt="">
										</a>
						
						<p class="text-muted m-b-lg">Add invoice.</p>
						
					</div><!-- .widget-body -->
				</div><!-- .widget -->
			</div><!-- END column -->
			
			<div class="col-md-3 col-sm-6">
				<div class="widget">
					<header class="widget-header">
						<h4 class="widget-title">DELIVERY ORDER</h4>
					</header><!-- .widget-header -->
					<hr class="widget-separator">
					<div class="widget-body text-center">
						<a href="../assets/images/original/102.jpg" data-lightbox="feed-img-1">
											<img class="stream-img" src="resource/static/images/dashboard/order.png" alt="">
										</a>
						
						<p class="text-muted m-b-lg">Review Delivery.</p>
						
					</div><!-- .widget-body -->
				</div><!-- .widget -->
			</div><!-- END column -->

			<div class="col-md-3 col-sm-6">
				<div class="widget">
					<header class="widget-header">
						<h4 class="widget-title">REPORT</h4>
					</header><!-- .widget-header -->
					<hr class="widget-separator">
					<div class="widget-body text-center">
						<a href="../assets/images/original/102.jpg" data-lightbox="feed-img-1">
											<img class="stream-img" src="resource/static/images/dashboard/report.png" alt="">
										</a>
						
						<p class="text-muted m-b-lg">View Reports.</p>
					</div><!-- .widget-body -->
				</div><!-- .widget -->
			</div><!-- END column -->
			
            </div><!-- .row -->
              <div class="row">
              <security:authorize access="hasRole('ROLE_ADMIN')">
            <div class="col-md-3 col-sm-6">
				<a href="<%=request.getContextPath()%>/products/product/create">
				 <div class="widget">
					<header class="widget-header">
						<h4 class="widget-title">PRODUCTS</h4>
					</header><!-- .widget-header -->
					<hr class="widget-separator">
					<div class="widget-body text-center">
							<img class="stream-img" src="resource/static/images/dashboard/products.png" alt="">
						
						<p class="text-muted m-b-lg">Manage products.</p>
					</div><!-- .widget-body -->
				</div><!-- .widget -->
				</a>
			</div><!-- END column -->
			

			<div class="col-md-3 col-sm-6">
				<a href="<%=request.getContextPath()%>/customers/customer/create">
				<div class="widget">
					<header class="widget-header">
						<h4 class="widget-title">USERS</h4>
					</header><!-- .widget-header -->
					<hr class="widget-separator">
					<div class="widget-body text-center">
						
							 <img class="stream-img" src="resource/static/images/dashboard/users.png" alt="">
									
						<p class="text-muted m-b-lg">User Management</p>
					</div><!-- .widget-body -->
				</div><!-- .widget -->
				</a>
			</div><!-- END column -->
			</security:authorize>
			</div>


<%@include file="footer.jsp" %>