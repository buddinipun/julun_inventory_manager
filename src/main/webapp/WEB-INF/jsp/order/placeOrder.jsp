<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<jsp:include page="../include/headder.jsp" />
<main id="app-main" class="app-main">
    <div class="wrap">
        <section class="app-content">
            <div class="row">
            <div class="col-md-12">
                    <div class="widget">
                        <header class="widget-header">
                            <h4 class="widget-title">Check JL Customer</h4>
                        </header><!-- .widget-header -->
                        <hr class="widget-separator">
                        <div class="widget-body">
                            <form action="checkAdUser" method="post" name="validate_ad_user" class="form-inline">
                                <div class="form-group">
                                    <label for="adUserpicker">Customer NIC:</label>

                                            <input id="adUserpicker" class="form-control" data-minute-step="1" type="text"/>

                                </div>
                                <button type="button" class="btn btn-info" id="getCustomer"><i class="glyphicon glyphicon-search"></i> Select Customer
                                </button>
                                        <p class="m-h-md">
                                            <small>Search for JL Existing customers</small>
                                        </p>
                            </form>
                        </div><!-- .widget-body -->
                    </div><!-- .widget -->
                </div><!-- END column -->
               <form:form role="form" class="form-horizontal" action="customer.reg" method="post"
                                       name="userreg_form" id="userreg_form">
                                       
                <div class="col-md-12" id="user_register_details_dev">

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Place Order</h3>
                        </div>
                        <div class="panel-body">
                           

                                <div class="form-group">
                                    <label class="col-md-2 control-label">Expected Delivery Date<span
                                            style="color: red">*</span></label>

                                        <div class="col-md-3" class="form-horizontal">
                                            <input type="date" name="expDeliveryDate"
                                                        class="form-control"
                                                        id="expectedDeliveryDate"
                                                         data-plugin="datetimepicker" data-options="{ defaultDate: '3/27/2016' }"/>

                                            <span style="color: red"><label id="lbl_delivery_date"></label></span></span>
                                        </div>

                                    
                                    <label class="col-md-2 control-label">Customer Type<span
                                            style="color: red">*</span></label>

                                        <div class="col-md-3" class="form-horizontal">
                                        
                                         <input type="text" name="customerType"
                                                        class="form-control"
                                                        id="customerType" readonly="true"/>
                                        </div>


                                </div>
                            <div class="form-group">
                                    <label class="col-md-2 control-label">Customer Name<span
                                            style="color: red">*</span></label>

                                        <div class="col-md-3" class="form-horizontal">
                                            <input type="text" name="customerName"
                                                        class="form-control"
                                                        id="customerName" readonly="true"/>
                                                         
                                            <%--<span style="color: red"><label id="lbl_delivery_date"></label></span></span>--%>
                                        </div>
                                    <label class="col-md-2 control-label">Customer NIC<span
                                            style="color: red">*</span></label>

                                        <div class="col-md-3" class="form-horizontal">
                                            <input type="text" name="customerNic"
                                                   class="form-control"
                                                   id="customerNic" readonly="true"
                                                   />
                                            <%--<span style="color: red"><label id="lbl_delivery_date"></label></span></span>--%>
                                        </div>

                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">Sales Type<span
                                            style="color: red">*</span></label>

                                        <div class="col-md-3" class="form-horizontal">
                                           
											<select class="form-control" name="saleType" id="saleType" data-live-search="true">
												<option value="marketingSale">Marketing Sale</option>
												<option value="directSale">Direct Sale</option>
											</select>
											
                                            <span style="color: red"><label id="lbl_sales_type"></label></span></span>
                                        </div>

                                </div>
                               
</head>
<body>

                                        <p class="m-h-md">
                                            <small>Search for JL Existing customers</small>
                                        </p>
                          
                           
                        </div>
                    </div>
                </div>

                <div class="row" id="product_details_tbl">
                    <div class="col-md-12">
                        <div class="widget">
                            <div class="widget-body">
                             <button type="button" class="btn btn-info" id="add_item" onclick="addRow('order_details')">Add order Item
                                			 </button>
                              <button type="button" class="btn btn-danger" id="add_item" onclick="deleteRow('order_details')">Delete Selected Item
                                			 </button>
                            <div class="table-responsive">
					<table id="order_details" data-plugin="DataTable"
						class="table table-striped" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th></th>
								<th>Item Code</th>
								<th>Quantity</th>
								<th>Price</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox" name="chk" /></td>
								<td>
									<div class="col-md-7" class="form-horizontal">
									<%--  <c:forEach items="${placeOrder.orderList}" var= "item" varStatus="vs"> --%> 
										<select class="form-control degree_accept_id item_code" id="item_code"
											data-live-search="true" path="orderList.itemCode">
											<option value="NONE">-- SELECT ITEM --</option>
											 <c:forEach items="${itemList}" var="itemList">
												<option value="${itemList.iditem}">${itemList.itemDescription}
													- ${itemList.itemCode}</option>
													
											</c:forEach> 
										</select>
										<%-- </c:forEach> --%>
									</div>
								</td>
								<td>
								<div class="col-md-5" class="form-horizontal">
								<%-- <c:forEach items="${placeOrder.orderList}" var= "item" varStatus="vs"> --%>
								<input type="text" name="quantitytest" class="validate[required,minSize[3]] form-control"
                                                        id="quantity" onchange="getItemCost(this)"/>
                               <%--  </c:forEach>  --%>
                                </div>
                                </td>
                                <td>
								<div class="col-md-5" class="form-horizontal">
								<%-- <c:forEach items="${placeOrder.orderList}" var= "item" varStatus="vs"> --%>
								<input type="text"  class="validate[required,minSize[3]] form-control"
                                                        id="price" name="pricetextmy"/>
                               <%--  </c:forEach>  --%>
                                </div>
                                </td>
							</tr>
						</tbody>
					</table>
					<div class="form-group">   
                                         
                                    <label class="col-md-2 control-label"><h1 style="font-size: 15px; color: red">TOTAL</h1></label>
                                   
                                    <div style="float :right; padding-right: 200px;">
                                      <label class="col-md-2 control-label" id="totalQuotationValue"><h1 style="font-size: 15px; color: red">0</h1></label>
                                      
                                    </div>
                                </div>
					
					<br/>
					<div class="form-group">   
                                    
                                   
                                    <div style="float :right; padding-right: 200px;">
                                      	<input type = "hidden" id="savedQuotationId">
                                        <!-- <button type="button" class="btn btn-danger" form="userreg_form"
                                                id="btn_download_pdf">Download PDF
                                        </button>
                                        <button type="button" class="btn btn-success" form="userreg_form"
                                                id="btn_download_excel" >Download Excel
                                        </button> -->
                                        <button type="button" class="btn btn-info" id="add_item" onclick="GetCellValues('order_details')">Place Order
                                        </button>
                                        
											 <a id="hrefpdfreport" runat="server" rel="zoom-width:600px; zoom-height:600px" class="btn btn-danger">Download PDF</a>
											 <a id="hrefexcelreport" runat="server" rel="zoom-width:600px; zoom-height:600px" class="btn btn-success">Download Excel</a>
                                    </div>
                                </div>

                            </div>
                            </div>

                        </div>

                </div>
                                    </div>
 </form:form>
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
     <SCRIPT language="javascript">

    //< --------------------------------------------------             page onload              ----------------------------------------->
         $(document).ready(function() {
             $("#user_register_details_dev").hide();
             $("#product_details_tbl").hide();
             $("#hrefexcelreport").hide();
             $("#hrefpdfreport").hide();
             var priceType;
            
         });

   // < --------------------------------------------------             add order item table row              ----------------------------------------->
         
        function addRow(tableID) {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
            var colCount = table.rows[0].cells.length;
            for(var i=0; i<colCount; i++) {
                var newcell = row.insertCell(i);
                newcell.innerHTML = table.rows[1].cells[i].innerHTML;
                //alert(newcell.childNodes);
                switch(newcell.childNodes[0].type) {
                    case "text":
                            newcell.childNodes[0].value = "";
                            break;
                    case "checkbox":
                            newcell.childNodes[0].checked = false;
                            break;
                    case "select-one":
                            newcell.childNodes[0].selectedIndex = 0;
                            break;
                }
            }
        }


   // < -------------------------------------------------             delete order item from table                  ----------------------------------------->
        
        function deleteRow(tableID) {
            try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
            for(var i=0; i<rowCount; i++) {
                var row = table.rows[i];
                var chkbox = row.cells[0].childNodes[0];
                if(null != chkbox && true == chkbox.checked) {
                    if(rowCount <= 1) {
                        alert("Cannot delete all the rows.");
                        break;
                    }
                    table.deleteRow(i);
                    rowCount--;
                    i--;
                }
            }
            }catch(e) {
                alert(e);
            }
        }
    </SCRIPT>

<%@include file="../include/footer.jsp" %>




    <script type="text/javascript">

    // < -------------------------------------------------             save order               ----------------------------------------->
    
     
        function GetCellValues(dataTable)
        {
            var expectedDeliveryDate = document.getElementById("expectedDeliveryDate").value;
            var order_type = document.getElementById("customerType").value;
            var saleType = document.getElementById("saleType").value;
            var totalQuotationValue = document.getElementById("totalQuotationValue").innerHTML;
            var jsonObj = [];
            var jsonString;
            var table = document.getElementById(dataTable);
            
            for (var r = 1, n = table.rows.length; r < n; r++) {
                var item = {};
                for (var c = 0, m = table.rows[r].cells.length; c < m; c++){
                    if(c == 1){
                         e =table.rows[r].cells[c].getElementsByTagName('select')[0];
                        item ["itemCode"] = e.options[e.selectedIndex].value;

                       }

                    else if(c==2){
                        item ["quantity"] = table.rows[r].cells[c].innerHTML;
                        item ["quantity"] = table.rows[r].cells[c].getElementsByTagName('input')[0].value;

                    }
                    else if(c==3){
                        item ["amount"] = table.rows[r].cells[c].innerHTML;
                        item ["amount"] = table.rows[r].cells[c].getElementsByTagName('input')[0].value;

                    }

                }
                jsonObj.push(item);
            }
            jsonString = JSON.stringify(jsonObj);
     
            $.ajax({
                method: "GET",
                url : "create.do",
                data:{jsonString:jsonString,order_type:order_type,expectedDeliveryDate:expectedDeliveryDate,customerId:customerId,saleType:saleType,totalQuotationValue:totalQuotationValue},
                dataType: "json",
                success: function(data){
                    $("#").html(data);
                   

                    if(data.validated){
							
							/*  $("#btn_download_excel").show();
			                 $("#btn_download_pdf").show(); */

			                 $("#hrefexcelreport").show();
			                 $("#hrefpdfreport").show();
			               
				               // document.getElementById('savedQuotationId').value = data.response.response;

				                document.getElementById("hrefexcelreport").href =  "../../reports/getquotationReport?quotationId=" + data.response.response;
				            
                        }else {
								alert("Error");
						   }


                },
                error:function(data){
                    console.log("failure"+data);
                    alert("failure"+JSON.stringify(data));
                    console.log("failure"+JSON.stringify(data));
                }
            });

        }

    </script>

    <script>

 // < -------------------------------------------------             get customer details                  ----------------------------------------->
    
    var customerId;
    $("#getCustomer").click(function(){

        var adUserpicker = document.getElementById("adUserpicker").value;

    $.ajax({
    method: "GET",
    url: "../../customers/getcustomerbyNic",
    data: {adUserpicker: adUserpicker},
    dataType: "json",
    success: function (data) {

        document.getElementById("customerName").value = data.customer.customerName;
        document.getElementById("customerNic").value = data.customer.nic;
        document.getElementById("customerType").value = data.customer.customerType;
        customerId = data.customer.idcustomer;
        $("#user_register_details_dev").show();
        $("#product_details_tbl").show();

        if(data.customer.customerType == 'distributer') {
        	$('#price').attr('readonly',true);
        	priceType = 'distributer';
            }
        else if(data.customer.customerType == 'customer') {
        	$('#price').attr('readonly',false);
        	priceType = 'customer';
            }

        else if(data.customer.customerType == 'dealer') {
        	$('#price').attr('readonly',false);
        	priceType = 'dealer';
            }

        else {
        	$('#price').attr('readonly',true);
        	alert("Contact System administrator");
            }
        
        
    },
    error: function (data) {
    console.log("failure" + data);
  //  alert("failure" + JSON.stringify(data));
    }
    });

    });

    </script>

     <script>
  $( function() {

    $( "#adUserpicker" ).autocomplete({
      source: "../../customers/searchCustomer"
    });
  } );

  

//< -------------------------------------------------             get cost for select item                  ----------------------------------------->
  
 var totalQuotation = 0;
 var itemOldPrice = 0;
  function getItemCost(test) {
//alert(test.value);

 var quantity = test.value;
 //var priceinput = $(test).closest('tr').find('input[name="pricetextmy"]').val(0);
     itemOldPrice = $(test).closest('tr').find('input[name="pricetextmy"]').val();
 var itemId = $(test).closest('tr').find('#item_code option:selected').val();
console.log("itemOldPrice is : " + itemOldPrice);

 if(itemId == 'NONE') {
		alert("please select Item");
		//$(this).closest('tr').find('input[name="quantitytest"]').val() = "";
		
	   }

 else{

	   $.ajax({
		    method: "GET",
		    url: "../../products/product/getItemById",
		    data: {itemId: itemId},
		    dataType: "json",
		    success: function (data) {

		      
			   var Itemprice;
		       var itemTotalPrice;
		       

		       if(priceType == 'distributer') {
		    	   Itemprice = data.item.distributerPrice;
		        	
		            }
		        else if(priceType == 'customer') {
		        	Itemprice = data.item.customerPrice;
		            }

		        else if(priceType == 'dealer') {
		        	Itemprice = data.item.dealerPrice;
		            }

		        else {
		        //	$('#price').attr('readonly',true);
		        	alert("Contact System administrator");
		            }


	           itemTotalPrice = Itemprice * quantity;
	           //priceinput.val(itemTotalPrice);
			 //  console.log("Itemprice is : " + Itemprice);
	           console.log("itemTotalPrice is :  " + itemTotalPrice);
	           //itemOldPrice
	           totalQuotation = totalQuotation - itemOldPrice;
	           totalQuotation = totalQuotation + itemTotalPrice;
	           $(test).closest('tr').find('input[name="pricetextmy"]').val(itemTotalPrice);
	           console.log("totalQuotation is :  " + totalQuotation);
	           document.getElementById('totalQuotationValue').innerHTML = totalQuotation;
	           document.getElementById('totalQuotationValue').style = "color: blue;";
		       
		       
		    },
		    error: function (data) { 
		   // console.log("failure" + data);
		  //  alert("failure" + JSON.stringify(data));
		    }
		    });
		
	   }
 


	  }

//< -------------------------------------------------             get excel                  ----------------------------------------->
  
  
  $('#btn_download_pdf').click(function(){
		var quotationId = document.getElementById('savedQuotationId').value;
		 $.ajax({
			    method: "GET",
			    url: "../../customers/getcustomerbyNic",
			    data: {adUserpicker: adUserpicker},
			    dataType: "json",
			    success: function (data) {

			      
			    },
			    error: function (data) {
			    console.log("failure" + data);
			    alert("failure" + JSON.stringify(data));
			    }
			    });
		
	  });



//< -------------------------------------------------             get pdf                  ----------------------------------------->
  
  
  $('#btn_download_excel').click(function(){

	  
		var quotationId = document.getElementById('savedQuotationId').value;
		
		alert("quotationId is : " + quotationId);
		  $.ajax({
			    method: "GET",
			    url: "../../reports/getquotationReport",
			    data: {quotationId: quotationId, reportType:'excel'},
			    dataType: "json",
			    success: function (data) {
				//alert(data);
			      
			    },
			    error: function (data) {
			   /*  console.log("failure" + data);
			    alert("failure" + JSON.stringify(data)); */
			    }
			    });
		
	  });
  </script>
