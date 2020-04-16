<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<jsp:include page="../include/headder.jsp" />
<main id="app-main" class="app-main">
    <div class="wrap">
        <section class="app-content">

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Find Orders</h3>
                </div>
                <div class="panel-body">
                    <form:form role="form" class="form-horizontal" action="getQuotations" method="post"
                               name="getQuotations" id="getQuotations" modelAttribute="getquotation">
                        <div class="form-group">
                            <spring:bind path="salesExeName">
                                <label class="col-md-1 control-label" for="sales_exec">Select Agent<span style="color: red">*</span></label>
                                <div class="col-md-3">
                                    <form:select class="form-control" path="salesExeName" id="sales_exec" name="sales_exec">
                                        <option value="all"> --ALL SALES EXECUTIVES--</option>
                                        <c:forEach var="element" items="${salesExecutivList}">
                                            <form:option value="${element.username}">${element.username}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </spring:bind>
                            <label class="col-md-1 control-label">Select Customer</label>
                            <spring:bind path="cutomerId">
                                <div class="col-md-3" class="form-horizontal">
                                    <form:select class="form-control" path="cutomerId" id="cutomerId" name="cutomerId">
                                        <option value="0"> --ALL CUSTOMERS--</option>
                                        <c:forEach var="element" items="${customerList}">
                                            <form:option value="${element.idcustomer}">${element.customerName} - ${element.nic}</form:option>
                                        </c:forEach>
                                    </form:select>
                                    <span style="color: red"><label id="lbl_customer"></label></span></span>
                                </div>
                            </spring:bind>
                        </div>

                        <div class="form-group">
                            <spring:bind path="fromDate">
                                <label class="col-md-1 control-label"  for="fromDate">From Date<span style="color: red">*</span></label>
                                <div class="col-md-3">

                                    <div class="input-group" >
                                        <form:input type="date" path="fromDate" id="fromDate" class="form-control datepicker" value="" data-date-format="yyyy-mm-dd" data-date-viewmode="months"/>
                                        <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                                    </div>


                                </div>
                            </spring:bind>
                            <spring:bind path="toDate">
                                <label class="col-md-1 control-label">To Date</label>
                                <div class="col-md-3">
                                    <div class="input-group" >
                                        <form:input type="date" class="form-control" path="toDate" name="toDate" id="toDate" value="" data-date-format="yyyy-mm-dd"/>
                                        <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                                    </div>
                                </div>
                            </spring:bind>
                            <div style="float :right; padding-right: 50px;">
                                <button type="button" class="btn btn-info">Reset</button>
                                <button type="submit" class="btn btn-danger" id="sales_record_btn_submit">Search</button>

                            </div>
                        </div>
                    </form:form>

                    <div class="panel-body">
                        <%--<h4 class="widget-title">--%>
                        <%--</h4>--%>

                        <div class="table-responsive">
                            <table id="paymentStable" data-plugin="DataTable" name="paymentStable" class="table table-striped" cellspacing="0" width="100%">

                                <thead>
                                <tr>
                                    <th>Create Date</th>
                                    <th>Customer Name</th>
                                    <th>Sales Person</th>
                                    <th>Sales Type</th>
                                    <th>Expected Delivery</th>
                                    <th>Edit</th>


                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${quotationList}" var="transaction">
                                    <tr>
                                        <td>${transaction.createDate}</td>
                                        <td>${transaction.customerName}</td>
                                        <td>${transaction.marketingexeName}</td>
                                        <td>${transaction.quotationType}</td>
                                        <td>${transaction.expectedDelivery}</td>
                                        <td><button type="button" class="btn btn-success btn-sm edit_data"onclick="getQuotationDetails('${transaction.quotationId}')">Edit</button></td>
                                        <%--<td style="display:none;" id="QuotationItem${transaction.quotationId}">--%>
                                            <%----%>
                                        <%--</td>--%>


                                    </tr>


                                </c:forEach>

                                </tbody>
                            </table>
                        </div>

                            <div class="col-md-12">
                                <h4 class="m-h-lg">Accordion</h4>
                                <div class="panel-group accordion" id="accordion" role="tablist" aria-multiselectable="true">

                                    <div class="panel panel-default">
                                        <div class="panel-heading" role="tab" id="heading-3">
                                            <a class="accordion-toggle" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse-3" aria-expanded="false" aria-controls="collapse-3">
                                                <h4 class="panel-title">Can I pay using PayPal?</h4>
                                                <i class="fa acc-switch"></i>
                                            </a>
                                        </div>
                                        <div id="collapse-3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading-3">
                                            <div class="panel-body">
                                                <p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.</p>
                                            </div>
                                        </div>
                                    </div>


                            </div><!-- END column -->
                    </div><!-- .row -->




                    </div>
                </div>

            </div>
    </div>
    </div>
    </section>
    </div>




    <div id="EditModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Edit Quotation Details</h4>
                </div>
                <div class="modal-body">
                    <div class="panel-body">




                                    <div  id="QuotationTable" class="table-responsive"></div>
                                            <%--<table  class="table table-striped">--%>
                                                <%--<thead>--%>
                                                <%--<tr>--%>
                                                    <%--<td>Item Code</td>--%>
                                                    <%--<td>Item Quantity</td>--%>
                                                <%--</tr>--%>
                                                <%--</thead>--%>


                                            <%--</table>--%>






                                <div class="modal-footer">

                                    <button type="button" class="btn btn-warning"
                                            id="submit_edit_quotation" value="Save">Update
                                    </button>
                                    <button type="button" class="btn btn-success"
                                            id="cancel_edit_quotation" data-dismiss="modal" >Cancel
                                    </button>


                                </div>
                    </div>

            </div>

        </div>
    </div>
    </div>
<%@include file="../include/footer.jsp" %>



    <script !src="">
        function getQuotationDetails(quotationId) {
           // $("#tbodyid").empty();

            if(quotationId != ''){


                $.ajax({

                    url:"getQuotationDetails",
                    method: "GET",
                    data:{quotationId:quotationId},
                    dataType:"json",
                    success:function (data) {


                        var i;
                       // var td = document.getElementById("QuotationItem" + quotationId)
                        var tableRef = document.getElementById("QuotationTable");
                        var table = document.createElement("table");
                        table.setAttribute("class", "table");
                        table.setAttribute("cellspacing", "0");
                        table.setAttribute("width", "100%");
                        table.setAttribute("id", "QuotationItem" + quotationId);
                        var thead = document.createElement("thead");
                        $("#QuotationTable thead").remove();
                        tableRef.appendChild(table);
                        table.appendChild(thead);
                        var tdtr = thead.insertRow();
                        var td1 = tdtr.insertCell();
                        var td2 = tdtr.insertCell();
                        var td3 = tdtr.insertCell();
                        td1.appendChild(document.createTextNode('Item Code'));
                        td2.appendChild(document.createTextNode('Item Quantity'));
                        td3.appendChild(document.createTextNode('Item Amount'));

                        var tbdy = document.createElement('tbody');
                        $("#QuotationTable tbody").remove();
                        table.appendChild(tbdy);



            for(i = 0; i < data.length; i ++) {
                        var newRow = document.createElement('tr');
                            tbdy.appendChild(newRow);
                          //console.log(data[i].itemRefId);

                          // create input element for item code
                          var inputItemCode = document.createElement("input");
                          inputItemCode.setAttribute("type", "text");
                          inputItemCode.setAttribute("name", "points");
                          inputItemCode.setAttribute('id', "itemCode");
                          inputItemCode.setAttribute('class', "form-control");
                          //inputItemCode.setAttribute("value", "test");



                          // create input element for item quantity
                          var inputItemQuantity = document.createElement("input");
                          inputItemQuantity.setAttribute("type", "text");
                          inputItemQuantity.setAttribute("name", "points");
                          inputItemQuantity.setAttribute("id", "itemQuontity");
                          inputItemQuantity.setAttribute("class", "form-control");
                          //inputItemQuantity.readOnly = true;
                          
                          
                           // create input element for item amount
                          var inputItemAmount = document.createElement("input");
                          inputItemAmount.setAttribute("type", "text");
                          inputItemAmount.setAttribute("name", "points");
                          inputItemAmount.setAttribute("id", "itemAmount");
                          inputItemAmount.setAttribute("class", "form-control");
                          inputItemAmount.readOnly = true;

                          // create input element for item quantity_item_id
                          var inputhiddenId = document.createElement("input");
                          inputhiddenId.setAttribute("type", "text");
                          inputhiddenId.setAttribute("name", "points");
                          inputhiddenId.setAttribute("id", "quotation_item_id");
                          //inputhiddenId.setAttribute("value", "test");
                          inputhiddenId.setAttribute("class", "form-control");
                          inputhiddenId.style.display = "none";

                            // create input element for item refId
                            var inputhiddenItemRefId = document.createElement("input");
                            inputhiddenItemRefId.setAttribute("type", "text");
                            inputhiddenItemRefId.setAttribute("name", "points");
                            inputhiddenItemRefId.setAttribute("id", "item_ref_id");
                            //inputhiddenId.setAttribute("value", "test");
                            inputhiddenItemRefId.setAttribute("class", "form-control");
                            inputhiddenItemRefId.style.display = "none";

	                          // Insert a row in the table at the last row
	                          //var newRow   = tableRef.insertRow();
	                          // Insert a cell in the row
	                          var ItemCell  = newRow.insertCell(0);
	                          var quantityCell  = newRow.insertCell(1);
	                          var amountCell = newRow.insertCell(2);
	                          var hiddenIdCell  = newRow.insertCell(3);
	                          var hiddenItemRefCell  = newRow.insertCell(4);


                          // Append a text node to the cell
                         // var itemText = document.createTextNode(data[i].itemName + slash +  data[i].itemCode );

                         // ItemCell.appendChild(itemText);
                          inputItemCode.setAttribute("value", data[i].itemCode);
                          ItemCell.appendChild(inputItemCode);

                         // var quontityText = document.createTextNode(data[i].amount);
                          inputItemQuantity.setAttribute("value", data[i].quantity);
                          quantityCell.appendChild(inputItemQuantity);

                          inputItemAmount.setAttribute("value", data[i].amount);
                          amountCell.appendChild(inputItemAmount);

                          inputhiddenId.setAttribute("value", data[i].quotationItemId);
                          hiddenIdCell.appendChild(inputhiddenId);

                          inputhiddenItemRefId.setAttribute("value",data[i].itemRefId);
                          hiddenItemRefCell.appendChild(inputhiddenItemRefId);
                        tbdy.appendChild(newRow);

             }

                        document.getElementById('submit_edit_quotation').setAttribute('onclick','editQuotation('+ quotationId +')');
                        $('#EditModal').modal('show');


                    },

                    error:function(data){
                        console.log("failure"+data);
                        alert("failure"+JSON.stringify(data));
                        console.log("failure"+JSON.stringify(data));
                    }
                })
            }
        }


    </script>


    <script>
        function editQuotation(quotationId){

            var jsonObj = [];
           var table = $("#QuotationItem" + quotationId);
           // console.log(table);
           var body = table.find('tbody');
           var rows = body.find('tr');
            console.log(" rows.length is " +  rows.length);
                for (var i = 0 ; i < rows.length ; i++) {
                    var item = {};

                     console.log("itemCode" + $(rows[i]).find('#itemCode').val());
                     item ["itemCode"] =  $(rows[i]).find('#itemCode').val();
                     console.log("quantity" + $(rows[i]).find('#itemQuontity').val());
                     item ["quantity"] =  + $(rows[i]).find('#itemQuontity').val();
                     console.log("amount" + $(rows[i]).find('#itemAmount').val());
                     item ["amount"] =  + $(rows[i]).find('#itemAmount').val();
                     item ["quotation_item_id"] =  + $(rows[i]).find('#quotation_item_id').val();
                     console.log("quotation_item_id" + $(rows[i]).find('#quotation_item_id').val());
                    console.log("itemrefId" + $(rows[i]).find('#item_ref_id').val());
                     item ["itemrefId"] =  + $(rows[i]).find('#item_ref_id').val();
                    //console.log(" rows.length is " +  rows.length);


                    jsonObj.push(item);

                }

            console.log(jsonObj);
            jsonString = JSON.stringify(jsonObj);

            $.ajax({
                method: "GET",
                url : "updateQuotation",
                data:{jsonString:jsonString, quotationId:quotationId},
                dataType: "json",
                success: function(data){
                    $("#").html(data);
                    // $("#btn_download_excel").show();
                    // $("#btn_download_pdf").show();
                    alert("success");


                },
                error:function(data){
                    console.log("failure"+data);
                    alert("failure"+JSON.stringify(data));
                    console.log("failure"+JSON.stringify(data));
                }
            });

        }
    </script>
