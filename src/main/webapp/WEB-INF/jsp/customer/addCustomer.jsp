<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<jsp:include page="../include/headder.jsp" />
<main id="app-main" class="app-main">
    <div class="wrap">
        <section class="app-content">
            <div class="row">
                
                <div class="col-md-12" id="user_register_details_dev">

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Register Web User</h3>
                        </div>
                        <div class="panel-body">
                            <form:form role="form" class="form-horizontal" action="customer.reg" method="post"
                                       name="userreg_form" id="userreg_form"
                                       modelAttribute="addCustomer">

                                <div class="form-group">
                                    <label class="col-md-2 control-label">Customer Name<span
                                            style="color: red">*</span></label>
                                    <spring:bind path="customerName">
                                        <div class="col-md-3" class="form-horizontal">
                                            <form:input type="text" path="customerName"
                                                        class="validate[required,minSize[3]] form-control"
                                                        id="cust_name" placeholder="Enter Customer Name..." />
                                            <span style="color: red"><label id="lbl_user_fname"></label></span>
                                        </div>
                                    </spring:bind>

                                    <label class="col-md-2 control-label">Customer Mobile<span
                                            style="color: red">*</span></label>
                                    <spring:bind path="contact1">
                                        <div class="col-md-3" class="form-horizontal">
                                            <form:input type="text" class="validate[required,minSize[3]] form-control"
                                                        path="contact1" id="user_lname" placeholder="Enter Last Name..."/>
                                            <span style="color: red"><label id="lbl_user_lname"></label></span></span>
                                        </div>
                                    </spring:bind>

                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">Customer Landphone </label>
                                    

                                    <spring:bind path="contact2">
                                        <div class="col-md-3" class="form-horizontal">
                                            <form:input type="text" path="contact2"
                                                        class="validate[required,minSize[3]] form-control"
                                                        id="user_name" placeholder="Enter UserName..."/>
                                             <span style="color: red"><label id="lbl_user_name"></label></span></span>
                                        </div>
                                    </spring:bind>
                                    <label class="col-md-2 control-label">Customer NIC<span
                                            style="color: red">*</span></label>

										<spring:bind path="nic">
                                        <div class="col-md-3" class="form-horizontal">
                                            <form:input type="text" path="nic"
                                                        class="form-control" id="cust_nic" placeholder="Enter NIC No..."/>
                                            <span style="color: red"><label id="lbl_cust_nic"></label></span></span>
                                      
                                           </div>

									 </spring:bind>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">Address<span
                                            style="color: red">*</span></label>

                                    <spring:bind path="add1">
                                        <div class="col-md-1" class="form-horizontal">
                                            <form:input type="text" path="add1" class="form-control" id="add1" placeholder="No" />
                                            <span style="color: red"><label id="lbl_user_add1"></label></span>
                                        </div>
                                    </spring:bind>
           
									<spring:bind path="add2">
                                    <div class="col-md-2" class="form-horizontal">
                                        <form:input type="text" path="add2" class="form-control" id="com_add2" placeholder="Street"/>
                                        <span style="color: red"><label id="lbl_add2"></label></span>
									</div>
									</spring:bind>
									 <label class="col-md-2 control-label">Email</label>
                                    <spring:bind path="email">
                                        <div class="col-md-3" class="form-horizontal">
                                            <form:input type="text" class="form-control" path="email" id="email" placeholder="Email"/>
                                            <span style="color: red"><label id="lbl_email"></label></span></span>
                                        </div>
                                    </spring:bind>
                                </div>

                                <div class="form-group">
                                   
                                    <spring:bind path="add3">
                                     <label class="col-md-2 control-label"></label>
                                   
                                    <div class="col-md-3" class="form-horizontal">
                                        <form:input type="text" class="form-control" path="add3" id="com_add3" placeholder="City"/>
                                        <span style="color: red"><label id="lbl_add3"></label></span>
									</div>
									</spring:bind>
									
									   <label class="col-md-2 control-label">Customer Type<span
                                            style="color: red">*</span></label>
									<spring:bind path="customerType">
                                        <div class="col-md-3" class="form-horizontal">
                                         <form:select class="form-control" path="customerType" id="customerType" data-live-search="true">
                                                <form:option value="NONE"> --SELECT Type--</form:option>
                                                <form:option value="customer">Customer</form:option>
                                                <form:option value="dealer">Dealer</form:option>
                                                <form:option value="distributer">Distributer</form:option>

                                            </form:select>
                                        </div>
                                        
                                        </spring:bind>
									
									
								</div>
								 <div class="form-group">
								 <spring:bind path="description">
									 <label class="col-md-2 control-label">Remark</label>

                                        <div class="col-md-3" class="form-horizontal">
                                            <textarea class="form-control" rows="5" name="description"
                                                           id="description"></textarea>
                                            <span style="color: red"><label id="lbl_description"></label></span>
                                        </div>
									</spring:bind>
                                 <div class="form-group"> 
                                 </div>  
                                    
                                   
                                    <div style="float :right; padding-right: 200px;">
                                        <button type="button" class="btn btn-info" form="userreg_form"
                                                id="btn_reset_web_form">Reset
                                        </button>
                                        <button type="submit" class="btn btn-danger" form="userreg_form"
                                                id="registerUser_btn_submit" value="Save">Register
                                        </button>
                                    </div>
                                </div>

                            </form:form>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="widget">
                            <div class="widget-body">
                            <div class="table-responsive">
                                <table id="default-datatable" data-plugin="DataTable" class="table table-striped" cellspacing="0" width="100%">
                                    <thead>
                                    <tr>
                                        <th>Customer Name</th>
                                        <th>Customer NIC</th>
                                        <th>Customer Mobile</th>
                                        <th>Customer Land</th>
                                        <th>Customer Type</th>
                                        <th>Customer add no</th>
                                        <th>Customer Street</th>
                                        <th>Customer City</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    ${userSummary[0].add1}

                                    <c:forEach items="${userSummary}" var="summary">
                                        <tr>

                                            <td>${summary.customerName}</td>
                                            <td> ${userSummary[0].add1}</td>
                                            <td>${summary.contact1}</td>
                                            <td>${summary.contact2}</td>
                                            <th>${summary.customerType}</th>
                                            <td>${summary.add1}</td>
                                            <td>${summary.add2}</td>
                                            <td>${summary.add3}</td>


                                        </tr>
                                    </c:forEach>


                                    </tbody>
                                </table>

                            </div>
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

        /* $(document).ready(function ({}) {
            $('#user_register_details_dev').hide();
        }) */
        function ajaxCall(url,data,dataType,type,callBack){
            jQuery.ajax({
                url: url,
                data: data,
                beforeSend:�function�(xhr) {
                    /*  xhr.setRequestHeader ("Authorization", "Basic YWRtaW46YWRtaW5wYXNz" );*/
                   // alert("before response send");
                },
                error:�function() {
                    $('#info').html('<p>An error has occurred</p>');
                  //  alert("An error has occurred");
                },
                dataType: dataType,
                success:�function(data) {
                    callBack(data);
                    //alert("ERROR");
                },
                type: type
            });
        }

        

        $('#checkAdUser').click(function () {
            let adUserpicker = $("#adUserpicker").val();

            if ($("#adUserpicker").val().length > 0) {

                ajaxCall("checkAdUser", {adUserpicker: adUserpicker}, "json", "POST", function (res) {
                    if (res === "") {

                        showWithTitleMessage("Attention!","Not Found AD User.","","#ff1500")
                    } else {
                        $("#user_fname").val(res.fname);
                        //$("#userName").prop("readonly", true);

                        $("#user_lname ").val(res.surname);
                        $("#user_name").val(res.username);
                        $("#user_register_details_dev").show();
                        // $("#userNic").val(res.nic);
                        // $("#userMobNo").val(res.mobile);
                        // $("#userEmail").val(res.email);
                        //set selected value//

                      // alert(res.empno);
                       /* $('#userGender  > option').each(function() {
                            if($(this).val() == res.gender){
                                $('#userGender').val(res.gender).trigger('change');
                            }
                        });*/
                        //set selected value
                        /*$('#userBranch  > option').each(function() {
                            if($(this).val() == res.brnhCode){
                                $('#userBranch').val(res.brnhCode).trigger('change');
                            }
                        });*/
                    }
                });
            }else{
                showWithTitleMessage("Attention!","Please enter AD Username before check.","","#ff1500")
            }


        });
        let userName = $("#userName").val();




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
