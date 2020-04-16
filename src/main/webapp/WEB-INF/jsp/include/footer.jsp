<!-- APP FOOTER -->
<div class="wrap p-t-0">
    <footer class="app-footer">
        <div class="clearfix">
            <ul class="footer-menu pull-right">
                <li><a href="javascript:void(0)">Careers</a></li>
                <li><a href="javascript:void(0)">Privacy Policy</a></li>
                <li><a href="javascript:void(0)">Feedback <i class="fa fa-angle-up m-l-md"></i></a></li>
            </ul>
            <div class="copyright pull-left">Copyright @APTOTA - WEB SOLUTIONS -  2019 &copy;</div>
        </div>
    </footer>
</div>
<!-- /#app-footer -->
</main>
<!--========== END app main -->

<!-- APP CUSTOMIZER -->
<div id="app-customizer" class="app-customizer">
    <a href="javascript:void(0)"
       class="app-customizer-toggle theme-color"
       data-toggle="class"
       data-class="open"
       data-active="false"
       data-target="#app-customizer">
        <i class="fa fa-gear"></i>
    </a>
    <div class="customizer-tabs">
        <!-- tabs list -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#menubar-customizer" aria-controls="menubar-customizer"
                                                      role="tab" data-toggle="tab">Menubar</a></li>
            <li role="presentation"><a href="#navbar-customizer" aria-controls="navbar-customizer" role="tab"
                                       data-toggle="tab">Navbar</a></li>
        </ul><!-- .nav-tabs -->

        <div class="tab-content">
            <div role="tabpanel" class="tab-pane in active fade" id="menubar-customizer">
                <div class="hidden-menubar-top hidden-float">
                    <div class="m-b-0">
                        <label for="menubar-fold-switch">Fold Menubar</label>
                        <div class="pull-right">
                            <input id="menubar-fold-switch" type="checkbox" data-switchery data-size="small"/>
                        </div>
                    </div>
                    <hr class="m-h-md">
                </div>
                <div class="radio radio-default m-b-md">
                    <input type="radio" id="menubar-light-theme" name="menubar-theme" data-toggle="menubar-theme"
                           data-theme="light">
                    <label for="menubar-light-theme">Light</label>
                </div>

                <div class="radio radio-inverse m-b-md">
                    <input type="radio" id="menubar-dark-theme" name="menubar-theme" data-toggle="menubar-theme"
                           data-theme="dark">
                    <label for="menubar-dark-theme">Dark</label>
                </div>
            </div><!-- .tab-pane -->
            <div role="tabpanel" class="tab-pane fade" id="navbar-customizer">
                <!-- This Section is populated Automatically By javascript -->
            </div><!-- .tab-pane -->
        </div>
    </div><!-- .customizer-taps -->
    <hr class="m-0">
    <div class="customizer-reset">
        <button id="customizer-reset-btn" class="btn btn-block btn-outline btn-primary">Reset</button>
  <!--       <a href="https://themeforest.net/item/infinity-responsive-web-app-kit/16230780"
           class="m-t-sm btn btn-block btn-danger">Buy Now</a> -->
    </div>
</div>
<!-- #app-customizer -->

<!-- build:js ../assets/js/core.min.js -->
<!-- <spring:url value="/resources/libs/bower/jquery/dist/jquery.js" var="jqueryJS"/> -->
<script type="text/javascript" src="../../resource/static/libs/bower/jquery/dist/jquery.js"></script>

<!-- <spring:url value="/resources/libs/bower/jquery-ui/jquery-ui.min.js" var="jqueryMinJS"/> -->
<script type="text/javascript" src="../../resource/static/libs/bower/jquery-ui/jquery-ui.min.js"></script>

<!-- <spring:url value="/resources/libs/bower/jQuery-Storage-API/jquery.storageapi.min.js" var="jqueryStorageapi"/> -->
<script type="text/javascript" src="../../resource/static/libs/bower/jQuery-Storage-API/jquery.storageapi.min.js"></script>

<!-- <spring:url value="/resources/libs/bower/bootstrap-sass/assets/javascripts/bootstrap.js" var="bootstrapJS"/> -->
<script type="text/javascript" src="../../resource/static/libs/bower/bootstrap-sass/assets/javascripts/bootstrap.js"></script>

<!-- <spring:url value="/resources/libs/bower/jquery-slimscroll/jquery.slimscroll.js" var="jquerySlimscroll"/> -->
<script type="text/javascript" src="../../resource/static/libs/bower/jquery-slimscroll/jquery.slimscroll.js"></script>

<!-- <spring:url value="/resources/libs/bower/perfect-scrollbar/js/perfect-scrollbar.jquery.js" var="perfectScrollbar"/> -->
<script type="text/javascript" src="../../resource/static/libs/bower/perfect-scrollbar/js/perfect-scrollbar.jquery.js"></script>

<!-- <spring:url value="/resources/libs/bower/PACE/pace.min.js" var="paceMin"/> -->
<script type="text/javascript" src="../../resource/static/libs/bower/PACE/pace.min.js"></script>

<!-- <spring:url value="/resources/assets/js/library.js" var="libraryJS"/> -->
<script type="text/javascript" src="../../resource/static/js/library.js"></script>

<!-- <spring:url value="/resources/assets/js/plugins.js" var="pluginsJS"/> -->
<script type="text/javascript" src="../../resource/static/js/plugins.js"></script>

<!-- <spring:url value="/resources/assets/js/app.js" var="appJS"/> -->
<script type="text/javascript" src="../../resource/static/js/app.js"></script>

<!-- <spring:url value="/resources/libs/bower/moment/moment.js" var="momentJS"/> -->
<!-- <script type="text/javascript" src="../../resource/static/libs/bower/moment/moment.js"></script> -->

<!-- <spring:url value="/resources/libs/bower/fullcalendar/dist/fullcalendar.min.js" var="fullcalendarJS"/> -->
<!-- <script type="text/javascript" src="../../resource/static/libs/bower/fullcalendar/dist/fullcalendar.min.js"></script>

<script src="../../resource/static/libs/bower/fullcalendar/dist/fullcalendar.min.js"></script>
	<script src="../../resource/static/js/fullcalendar.js"></script> -->

<ul>
    <li class="active"><c:if test="${not empty ErrinsertStatus}">
        <!--<c:out value="${insertStatus}"/> -->
        <script>
            console.log("ErrinsertStatus");
            $('#responseErrvalue').text("${ErrinsertStatus}");
            $('#errorModal').modal('show');

        </script>
    </c:if>
        <c:if test="${not empty insertStatus}">
            <!--<c:out value="${insertStatus}"/> -->
            <script>
                $('#responseSuccvalue').text("${insertStatus}");
                $('#sucessModal').modal('show');

            </script>
        </c:if></li>
</ul>


</body>
</html>