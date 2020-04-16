package com.aptota.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aptota.app.model.order.ViewQuotation;
import com.aptota.app.model.requests.QuotationReportReqest;
import com.aptota.app.model.response.AjaxResponse;
import com.aptota.app.model.response.GetQuotationItem;
import com.aptota.app.model.response.Response;
import com.aptota.app.report.ExcelOrderDetailsReport;
import com.aptota.app.service.UserLogin.QuotationService;

@RequestMapping("/reports")
@Controller
public class ReportController {
	
	@Autowired
	QuotationService quotationService;
	
	 @RequestMapping(value = "/getquotationReport", method = RequestMethod.GET)
	    public @ResponseBody
	   // ModelAndView generateExcelPdfReports(@RequestParam(value = "quotationId") int quotationId, @RequestParam (value="reportType") String reportType){
	        //System.out.println("access on method user get By Id" + username);
		 ModelAndView generateExcelPdfReports(HttpServletRequest req, HttpServletResponse res){
		        //System.out.println("access on method user get By Id" + username);

	        List<GetQuotationItem> orderItemList = new ArrayList();
	        ViewQuotation quotation = new ViewQuotation();
	        Response responseQuotationDet = null;
	        AjaxResponse ajaxResponse = null;
	      
	        String stringQuotationId = req.getParameter("quotationId");
	        
	        
	        int quotationId = Integer.parseInt(stringQuotationId);
	        Response responseQuotation = quotationService.getQuotationById(quotationId);
	        
	        if (responseQuotation != null && responseQuotation.getResCode() == 200) {
	        	
	        	quotation = (ViewQuotation) responseQuotation.getResponse();

	        	System.out.println("quotation.getCustomerName() : " + quotation.getCustomerName());
	        	System.out.println("quotation.getMarketingexeName() : " + quotation.getMarketingexeName());
	        	System.out.println("quotation.getQuotationType() : " + quotation.getQuotationType());
	        	System.out.println("quotation.getCreateDate() : " + quotation.getCreateDate());
	        	System.out.println("quotation.getExpectedDelivery() : " + quotation.getExpectedDelivery());
	            responseQuotationDet = quotationService.getQuatationItemList(quotationId);
	            //System.out.println("" + quotation.get);
	            ajaxResponse = new AjaxResponse("only received quatation main details", false);
	            
	        if (responseQuotationDet != null && responseQuotationDet.getResCode() == 200) {
	        	orderItemList = (List<GetQuotationItem>) responseQuotationDet.getResponse();
	        	
	        	QuotationReportReqest reportReqest = new QuotationReportReqest(quotation,orderItemList);
	        	
	        	
	        	return new ModelAndView(new ExcelOrderDetailsReport(), "quotationReport", reportReqest);
	        	
	        } else {
	        	 ajaxResponse = new AjaxResponse("null value for quatation item list", false);
	        }
	        
	        } else {
	        	
	        	ajaxResponse = new AjaxResponse("error in getting quatation main details for quatation ID : " + quotationId, false);
	        }
	        return null;
	    }

}
