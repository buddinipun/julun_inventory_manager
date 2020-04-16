<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../include/headder.jsp" />
<main id="app-main" class="app-main">
    <div class="wrap">
        <section class="app-content">
            <div class="row">
                <div class="col-md-12">
                    <div class="widget">
                       
                    
                       
                    </div><!-- .widget -->
                </div><!-- END column -->
                <div class="col-md-12">

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Register Web User</h3>
                        </div>
                        <div class="panel-body">
                            <form:form role="form" class="form-horizontal" action="webuser.reg" method="post"
                                       name="userreg_form" id="userreg_form"
                                       modelAttribute="userregform">

                                <div class="form-group">
                                    <label class="col-md-2 control-label">First Name<span
                                            style="color: red">*</span></label>
                                    <spring:bind path="fname">
                                        <div class="col-md-3" class="form-horizontal">
                                            <form:input type="text" path="fname"
                                                        class="validate[required,minSize[3]] form-control"
                                                        id="user_fname" placeholder="Enter First Name..."
                                                        ng-modal="user.firstname" ng-required="true"/>
                                            <span style="color: red"><label id="lbl_user_fname"></label></span></span>
                                        </div>
                                    </spring:bind>

                                    <label class="col-md-2 control-label">Last Name<span
                                            style="color: red">*</span></label>
                                    <spring:bind path="lname">
                                        <div class="col-md-3" class="form-horizontal">
                                            <form:input type="text" class="validate[required,minSize[3]] form-control"
                                                        path="lname" id="user_lname" placeholder="Enter Last Name..."/>
                                            <span style="color: red"><label id="lbl_user_lname"></label></span></span>
                                        </div>
                                    </spring:bind>

                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">UserName<span
                                            style="color: red">*</span></label>

                                    <spring:bind path="uname">
                                        <div class="col-md-3" class="form-horizontal">
                                            <form:input type="text" path="uname"
                                                        class="validate[required,minSize[3]] form-control"
                                                        id="user_name" placeholder="Enter UserName..."/>
                                            <span class="help-block">Required, min size = 8, max size = 20</span>
                                            <span style="color: red"><label id="lbl_user_name"></label></span></span>
                                        </div>
                                    </spring:bind>
                                    <label class="col-md-2 control-label">Select User Role <span
                                            style="color: red">*</span></label>


                                        <div class="col-md-3" class="form-horizontal">
                                            <select class="form-control" name="userRole" id="user_role" data-live-search="true">
                                                <option value="NONE"> --SELECT ROLE--</option>
                                                <option value="SuperAdmin">Super Admin</option>
                                                <option value="Admin">Admin</option>
                                                <option value="Accountant">Accountant</option>
                                                <option value="MarketingMng">Marketing Manager</option>
                                                <option value="SalesExcecutive">MSales Executive</option>
                                                <option value="Coordinator">Coordinator</option>
                                                <option value="Stores">Stores</option>

                                            </select>
                                            <span style="color: red"><label id="lbl_user_role"></label></span></span>
                                        </div>


                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">Password<span
                                            style="color: red">*</span></label>

                                    <spring:bind path="password">
                                        <div class="col-md-3" class="form-horizontal">
                                            <form:input type="password" path="password"
                                                        class="validate[required,minSize[8],maxSize[20]] form-control"
                                                        id="password"/>
                                            <span class="help-block">Required, min size = 8, max size = 20</span>
                                            <span style="color: red"><label id="lbl_user_password"></label></span>
                                        </div>
                                    </spring:bind>
                                    <label class="col-md-2 control-label">Confirm Password<span
                                            style="color: red">*</span></label>


                                    <div class="col-md-3" class="form-horizontal">
                                        <input type="password" class="validate[required,equals[password]] form-control"
                                               id="com_password"/>
                                        <span class="help-block">Required, equals Password</span>
                                        <span style="color: red"><label id="lbl_com_password"></label></span>


                                    </div>


                                </div>

                                <div class="form-group">

                                    <label class="col-md-2 control-label">Remark</label>

                                        <div class="col-md-3" class="form-horizontal">
                                            <textarea class="form-control" rows="5" name="remark"
                                                           id="remark"></textarea>
                                            <span style="color: red"><label id="lbl_remark"></label></span>
                                        </div>

                                    <div style="float :right; padding-right: 200px;">
                                        <button type="button" class="btn btn-info" form="userreg_form"
                                                id="btn_reset_web_form">Reset
                                        </button>
                                        <button type="button" class="btn btn-danger" form="userreg_form"
                                                id="registerUser_btn_submit" value="Save">Register
                                        </button>
                                    </div>
                                </div>

                            </form:form>
                            <div class="table-responsive">
                                <table id="default-datatable" data-plugin="DataTable" class="table table-striped" cellspacing="0" width="100%">
                                    <thead>
                                    <tr>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>User Name</th>
                                        <th>User Role</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${userSummary}" var="summary">
                                        <tr>

                                            <td>${summary.firstname}</td>
                                            <td>${summary.lastname}</td>
                                            <td>${summary.username}</td>
                                            <td>${summary.setUserRole}</td>


                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>

                        </div>
                    </div>

                </div>
            </div>
        </section>
    </div>



    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title" style="color: red"><span class="glyphicon glyphicon-remove-sign"></span>ERROR</h4>
                </div>
                <div class="modal-body">
                    <p id="error" style="color: #0b0b0b; font-size: medium; font-family: 'Raleway', sans-serif"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>
<%@include file="../include/footer.jsp" %>

    <script !src="">


        $(function () {

            $('button[type=submit]').click(function (e) {

                //Prevent default submission of form
                e.preventDefault();

                //Remove all errors
                $('input').next().remove();

                $.post({
                    url : 'checkAdUser',
                    data : $('form[name=validate_ad_user]').serialize(),
                    sucess : function (res) {

                        if (res.validated) {

                            $('#resultContainer pre code').text(JSON.stringify(res.employee));
                            $('#resultContainer').show();

                        }
                        else {
                            $.each(res.errorMessages,function (key,value) {

                                $('input[name='+key+']').after('<span class="error">'+value+'</span>')

                            });
                        }
                    }
                })
            });
        });


        $('#registerUser_btn_submit').click(function() {
            validateForm();

        });

        $('#btn_reset_web_form').click(function() {
            resetForm();

        });
        $('#user_lname').focus(
            function() {
                var fnameVal = $('#user_fname').val();

                if (fnameVal == "") {
                    $("#lbl_user_fname").text(
                        "Please insert valid value for First Name");
                    $("#user_fname").val("");
                    $("#user_fname").focus();

                } else {
                    $("#lbl_user_fname").text("");
                    $("#user_lname").focus();
                }
            });
        $('#user_name').focus(
            function() {
                var lnameVal = $('#user_lname').val();

                if (lnameVal == "") {
                    $("#lbl_user_lname").text(
                        "Please insert valid value for Last Name");
                    $("#user_lname").val("");
                    $("#user_lname").focus();

                } else {
                    $("#lbl_user_lname").text("");
                    $("#user_name").focus();
                }
            });


        $('#user_role').change(
            function() {
                var username = $('#user_name').val();


                if (username == "") {
                    $("#lbl_user_name").text(
                        "Please insert your username");
                    $("#user_name").val("");
                    $("#user_name").focus();

                } else {
                    $("#lbl_user_name").text("");
                }
            });


        $('#password').focus(
            function() {
                var userrole = $('#user_role').val();


                if (userrole == "NONE") {
                    $("#lbl_user_role").text(
                        "Please Select user role");
                    $("#user_role").val("");
                    $("#user_role").focus();

                } else {
                    $("#lbl_user_role").text("");
                    $('#password').focus();
                }
            });

        $('#com_password').change(
            function() {
                var password = $('#password').val();


                if (password == "") {
                    $("#lbl_user_password").text(
                        "Please enter your password");
                    $("#com_password").val("");
                    $("#password").focus();

                } else {
                    $("#lbl_user_password").text("");
                    $("#com_password").focus();
                }
            });
        $('#com_password').change(
            function() {
                var checkpassword = $('#com_password').val();
                var password = $('#password').val();
                if (password != checkpassword) {
                    $("#lbl_com_password")
                        .text(
                            "Password mismatches");
                    $("#com_password").val("");
                    $("#com_password").focus();
                }

                else {
                    $("#lbl_com_password")
                        .text("");

                }
            });

        $('#password').change(
            function() {

                var password = $('#password').val();
                if (password.length < 8 || password.length > 20) {
                    $("#lbl_user_password")
                        .text(
                            "Password should be between 8 to 20");
                    $("#password").val("");
                    $("#password").focus();
                }

                else {
                    $("#lbl_user_password")
                        .text("");

                }
            });
        $('#user_name').change(
            function() {

                var user_name = $('#user_name').val();
                if (user_name.length < 8 || user_name.length > 20) {
                    $("#lbl_user_name")
                        .text(
                            "Username should be between 8 to 20");
                    $("#user_name").val("");
                    $("#user_name").focus();
                }

                else {
                    $("#lbl_user_name")
                        .text("");

                }
            });

        $('#remark').change(
            function() {
                var compassword = $('#com_password').val();


                if (compassword == "") {
                    $("#lbl_com_password").text(
                        "Please enter your password");
                    $("#com_password").val("");
                    $("#com_password").focus();

                } else {
                    $("#lbl_com_password").text("");
                    $("#remark").focus();
                }
            });

        function resetForm() {

            $('#user_fname').val("");
            $('#user_lname').val("");
            $('#user_name').val("");
            $('#user_role').val("");
            $('#password').val("");
            $('#com_password').val("");
            $('#remark').val("");


            $('#lbl_user_fname').text("");
            $('#lbl_user_lname').text("");
            $('#lbl_user_name').text("");
            $('#lbl_user_role').text("");
            $('#lbl_user_password').text("");
            $('#lbl_com_password').text("");
            $('#lbl_remark').text("");

        }

        function validateForm() {

            var fname = $('#user_fname').val().trim();
            var lname = $('#user_lname').val().trim();
            var uname = $('#user_name').val().trim();
            var role = $('#user_role').val().trim();
            var password = $('#password').val().trim();
            var com_password = $('#com_password').val().trim();


            if(fname == "") {

                $("#error").html("Please fill Agent First Name required fields!");
                $('#myModal').modal("show");
                document.getElementById("user_fname").focus();
            }
            else if(lname == "") {
            $("#error").html("Please fill Agent Last Name required fields!");
            $('#myModal').modal("show");
            document.getElementById("user_fname").focus();

            }else if(uname == "") {
            $("#error").html("Please fill Agent Username required fields!");
            $('#myModal').modal("show");
            document.getElementById("user_fname").focus();

            }else if(password == "") {
            $("#error").html("Please fill Agent Password required fields!");
            $('#myModal').modal("show");
            document.getElementById("user_fname").focus();


            }else if(com_password == "") {
            $("#error").html("Please fill Agent Confirm Password required fields!");
            $('#myModal').modal("show");
            document.getElementById("user_fname").focus();


            } else {
                $("#userreg_form").submit();

            }

            console.log(role);
        }
    </script>
