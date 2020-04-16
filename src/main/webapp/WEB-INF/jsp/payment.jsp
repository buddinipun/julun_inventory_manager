<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="headder.jsp" />
                <!-- START BREADCRUMB -->

                <!-- PAGE CONTENT WRAPPER -->
<main id="app-main" class="app-main">
    <div class="wrap">
        <section class="app-content">

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Agent Payments</h3>
                                </div>
                                <div class="panel-body">
								 <form:form role="form" class="form-horizontal" action="paymentSearching" method="post"
									name="search_payment_form" id="search_payment_form"
									modelAttribute="searchPayments">
                                   <div class="form-group">
                                    <spring:bind path="agentName">
                                        <label class="col-md-1 control-label" for="agent_name">Agent<span style="color: red">*</span></label>
                                        <div class="col-md-3">                                                                                
                                            <form:select class="form-control" path="agentCode" id="agent_name" name="agent_name">
                                                		<option value="0"> --SELECT AGENTS--</option>
												<c:forEach var="element" items="${agentList}">
													<form:option value="${element.agentCode}">${element.agentCode}</form:option>
												</c:forEach>
                                            </form:select>
                                        </div>
                                        </spring:bind>
										<div style="float :right; padding-right: 200px;">
									<button type="submit" class="btn btn-danger" value="Search" form="search_payment_form">Search</button>	
									</div>
                                    </div>
									    </form:form>

									<div class="panel-body">
									<h3>
									Sales Records of <span style="color: red"><c:if
											test="${not empty agentUName}">
											<c:out value="${agentUName}" />
										</c:if> </span>
								</h3>
								<form:form action="paymentSubmitting" method="post"
									modelAttribute="searchPayments" id="paymentSubmitform">
                                    <table id="paymentStable" name="paymentStable" class="table datatable">
                                        <thead>
                                            <tr>
                                               <th>Receipt Date</th>
												<th>Policy Number</th>
												<th>Paid Amount</th>
												<th>Agent Code</th>
												<th>SMS mobile</th>
												<th>Cash Received
												<label class="switch">
                                                    <input type="checkbox" id="checkAll" value="0"/>
                                                    <span></span>
                                                </label>
												</th>
                                            </tr>
                                        </thead>
                                        <tbody>
											<c:forEach items="${transacList}" var="transaction">
												<tr>
													<td>${transaction.reciptDate}</td>
													<td>${transaction.policyNum}</td>
													<td>${transaction.paidAmount}</td>
													<td>${transaction.agentCode}</td>
													<td>${transaction.smsMobi}</td>
													<td><form:checkbox path="checkValue" class="checkBoxClass" id="status_cekbox"
															value="${transaction.receiptId}" name="satus"/></td>

												</tr>

											</c:forEach>

										</tbody>
                                    </table>
                                  
                                    <h4>
										<b>Total Amount Rs: <span style="color: red"><c:if
													test="${not empty totalValue}">
													<c:out value="${totalValue}" />
												</c:if> </span></b>
									</h4> 
								
									<h4 style="float :right; padding-right: 200px;">
									<b>Settling Amount Rs: <p id="test1" style="color: red; font-weight: bold"></p></b>
									</h4> 
									
									<div class="form-group">                                 
                                    <c:if test="${not empty transacList}">
										<spring:bind path="remark">
											
												<label class="col-md-1 control-label" for="upload_remark">Remark</label>
													 <div class="col-md-3" class="form-horizontal">
												<form:textarea path="remark" class="form-control" rows="4" cols="50"
													name="comment" id="remark"></form:textarea>
												<span style="color: red"><label id="lbl_remark"></label></span>
											</div>
										</spring:bind>
									

										<div style="float :right; padding-right: 400px;">  
										
											<input type="reset" value="Reset" form="paymentSubmitform" class="btn btn-info" id="payment_reset_btn">
											<input type="button" value="Save" form="paymentSubmitform" class="btn btn-danger" id="payment_submit_btn">
										</div>
										</div>
									</c:if>
									</form:form>
                                </div>									
                             
                                   <div class="block">
                                                   
                                                        
                            </div> 
                                </div>
                            </div>

                        </div>
                    </div>
    </div>
    </section>
    </div>
        <!-- END PAGE CONTAINER -->
<%@include file="footer.jsp" %>
<script>
		$(document)
				.ready(
						function() {

							function validateForm() {
								var remark = $('#remark').val();
								 if (remark.length > 200) {
									Alert
											.render("You are entering too much text, please enter short remark.");
									return;
								} else {
									$("#paymentSubmitform").submit();
								}
							}

							function resetForm() {
								$('#remark').val("");
								$("test1").val("");

							}
							$('#payment_submit_btn').click(function() {
								validateForm();

							});
							$('#remark')
									.change(
											function() {
												var remark = $('#remark').val();
												if (remark.length > 200) {
													$("#lbl_remark")
															.text(
																	"You are entering too much text, please enter short remark.");
													$("#remark").focus();

												} else {
													$("#lbl_remark").text("");
												}
											});
						});
		
		
		

		
		function getagents(value){
			$.ajax({
				type : "GET",
                contentType : "application/json",
			    url: "getBranchAgents",
			    data: {
			        name: value
			    },
			    success: function(response) {

			        var agents = $.parseJSON(response);
			        var html = '<option value="0"> --SELECT AGENT--</option>';
			        for(i =0; i <agents.length; i++){
			        	html += '<option value="' + agents[i].agentCode + '">' + agents[i].agentUName + '</option>';
			        	
			        	
			        }
			        html += '</option>';
			        $('#agent_name').html(html);
			        // server response
		
			       
			        
			    },
			    error: function(){
			    	
			    	alert("error");
			    }
			});
		}
		//<-------------------------------------------------------------Check all radio buttons --------------------------------------------------------------------------->
		$("#checkAll").click(function () {
		
		    $(".checkBoxClass").prop('checked', $(this).prop('checked'));
		    if(this.checked){
		    	var txt = getsumOfValues('paymentStable', 2);
		    	console.log(txt);
		    	 document.getElementById("test1").innerHTML = txt;
		    	
		    }
		    else
		    {
		    	document.getElementById("test1").innerHTML = 0;
			}
		    
		    
		});


        $('#payment_reset_btn').click(function() {

            document.getElementById("test1").innerHTML = 0;

        });

	//<------------------------------------------------------Sum value for pament amount on select all--------------------------------------------------------------->	
		function getsumOfValues(table_id, col) {

		    var tab = document.getElementById(table_id);
		    var n = tab.rows.length;
		    var i, s = null, tr, td;

		   
		    if (col < 0) {
		        return null;
		    }
		var total = 0;
		   for (i = 1; i < n; i++) {
			
		        tr = tab.rows[i];
		        if (tr.cells.length > col) { 
		            td = tr.cells[col];     
		            s += td.innerText;
				
					var x = 12;
					total += parseInt(td.innerHTML);
				
					
		        } 
		         
		    }
			
			return total;
		    
		}
		
	//<-------------------------------------------------------Change payment amount on check box select --------------------------------------------------------------->
		var total =0;
$(document).ready(function(){

    // code to read selected table row cell data (values).
    $("#paymentStable").on('change','.checkBoxClass',function(){
		var total = 0;
		 if(this.checked) {
		 var currentRow=$(this).closest("tr"); 
		 var col1=currentRow.find("td:eq(2)").text();
		 var txtvalue = document.getElementById("test1").innerHTML;
		 console.log("txtvalue" + txtvalue);
		 console.log("col1" + col1);
		 var total = Number(col1) + Number(txtvalue);
		 document.getElementById("test1").innerHTML = total;
		 }
		 else{
		 var currentRow=$(this).closest("tr"); 
		 var col1=currentRow.find("td:eq(2)").text();
		 var txtvalue = document.getElementById("test1").innerHTML;
		 var total =  Number(txtvalue) - Number(col1);
		 document.getElementById("test1").innerHTML = total;
		 }
		
    });
});
//*
	</script>