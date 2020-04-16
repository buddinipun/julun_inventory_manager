package com.aptota.app.controller;

import com.aptota.app.model.order.OrderItemList;
import com.aptota.app.model.order.ViewQuotation;
import com.aptota.app.model.requests.GetQuotation;
import com.aptota.app.model.response.AjaxResponse;
import com.aptota.app.model.response.GetQuotationItem;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.UserLogin.CustomerService;
import com.aptota.app.service.UserLogin.QuotationService;
import com.aptota.app.service.UserLogin.UserService;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.aptota.app.model.Quotation;
import com.aptota.app.model.order.OrderForm;
import com.aptota.app.service.UserLogin.ItemService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RequestMapping("/orders")
@Controller
public class QuotationController {
	
	@Autowired
	ItemService itemService;


	@Autowired
	QuotationService quotationService;

	@Autowired
	CustomerService customerService;

	@Autowired
	UserService userService;
	
	@RequestMapping("/order/create")
	public String placeOrcer(Model model) {
		System.out.println("test");
		model.addAttribute("placeOrder", new OrderForm());
		model.addAttribute("itemList", itemService.getAllItems());
		return "order/placeOrder";
	}
	
	@RequestMapping("/order/view")
	public String viewOrcer(Model model) {
		System.out.println("test");
		model.addAttribute("getquotation", new GetQuotation());
		model.addAttribute("customerList", customerService.getAllCustomersServ());
		model.addAttribute("salesExecutivList",userService.getexecutiveUsers());
		return "order/viewOrders";
	}

	@RequestMapping(value = "/order/create.do", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse createNewOrder(@RequestParam(value = "jsonString") JSONArray jsonString, @RequestParam(value = "order_type") String order_type,
								@RequestParam(value = "expectedDeliveryDate") String expectedDeliveryDate, @RequestParam(value = "customerId") Integer customerId, @RequestParam(value = "saleType") String saleType ,@RequestParam(value = "totalQuotationValue") String totalQuotationValue, HttpServletRequest request) throws JSONException, ParseException {
		AjaxResponse ajaxResponse = new AjaxResponse(null,false);
        Quotation quotation = new Quotation();
        Date expectedDate = null;
		String username = null;
		Response response = null;
		Response response2 = null;
		System.out.println(" jsonString is : " + jsonString + "&& order_type is " +order_type + "expectedDeliveryDate : " + expectedDeliveryDate + "totalQuotationValue is : " + totalQuotationValue );
//
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if(!(auth instanceof AnonymousAuthenticationToken)) {
			if(auth != null) {
				UserDetails userDetails = (UserDetails) auth.getPrincipal();
				Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) auth.getAuthorities();
				System.out.println("success");
				username = userDetails.getUsername();

			}

			}else System.out.println(auth);

			if (expectedDeliveryDate != null && !expectedDeliveryDate.isEmpty() && !expectedDeliveryDate.equals("") && expectedDeliveryDate.trim().length() > 0) {
			expectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(expectedDeliveryDate);

			if (order_type != null && !order_type.isEmpty() && !order_type.equals("") && order_type.trim().length() > 0) {
				
				if (saleType != null && !saleType.isEmpty() && !saleType.equals("") && saleType.trim().length() > 0) {
					
					if (totalQuotationValue != null && !totalQuotationValue.isEmpty() && !totalQuotationValue.equals("") && totalQuotationValue.trim().length() > 0) {
						
					Double doubleQuotaationValue = Double.parseDouble(totalQuotationValue);

				Date c_date = new Date();
				quotation.setExpDeliveryDate(expectedDate);
				quotation.setQuatationType(order_type);
				quotation.setCDate(c_date);
				quotation.setCUser(username);
				quotation.setCustomerRefId(customerId);
				quotation.setSalesType(saleType);
				quotation.setAmount(doubleQuotaationValue);

				response = quotationService.createQuotationMaindet(quotation);
				
				if(response != null && response.getResCode() == 200) {
				
				response2 = quotationService.saveQuotationItemDetails(jsonString, (int) response.getResponse());
				System.out.println("rescode is : " + response.getResponse() +  " and  : response.getResDes() is : " + response.getResDes());
				ajaxResponse = new AjaxResponse("Error on saving response main data " , response , true);
				} else {
					ajaxResponse = new AjaxResponse("Error on saving response main data " , response , false);
				}
				
			} else {
					ajaxResponse = new AjaxResponse("Null value forTotal Quotgation value" , false);
					}	
			} else {
				ajaxResponse = new AjaxResponse("Null value for Sales Type" , false);
			}
			} else {
				ajaxResponse = new AjaxResponse("Null value for Order Type" , false);
			}
		} else {
			ajaxResponse = new AjaxResponse("Null value for expected date" , false);
		}
		return ajaxResponse;

	}

	@RequestMapping("order/getQuotations")
	public String loadCompletePaymentRecords(@ModelAttribute("salesrecord") @Validated GetQuotation getQuotation,
											 BindingResult bindingResult, HttpServletRequest request, Model model) {
		String loginUserName = null;
		String userRole = null;
		List<ViewQuotation> viewQuotations = new ArrayList<>();
		Response response = null;

		String loginusername = (String) request.getSession().getAttribute("username");
		getQuotation.setExecutiveName(loginusername);
		List<String> authorities = (List<String>) request.getSession().getAttribute("userrole");
		if (authorities != null && !authorities.isEmpty() && authorities.size() > 0) {

			for (int i = 0; i < authorities.size(); i++) {
				userRole = authorities.toArray()[i] + "";
				getQuotation.setLoginUserRole(userRole);


			}

		}else {

		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.... getQuotation : " + getQuotation.getCutomerId());
		 response = quotationService.getQuotationList(getQuotation);
		if (response != null && response.getResCode() == 200) {
			viewQuotations = (List<ViewQuotation>) response.getResponse();
		}

		model.addAttribute("quotationList", viewQuotations);
		model.addAttribute("getquotation", new GetQuotation());
		model.addAttribute("customerList", customerService.getAllCustomersServ());
		model.addAttribute("salesExecutivList",userService.getexecutiveUsers());
		return "order/viewOrders";
	}


    @RequestMapping(value = "/order/getQuotationDetails", method = RequestMethod.GET)
    public @ResponseBody
    List<GetQuotationItem> getQuotationDetails(@RequestParam(value = "quotationId") int quotationId){
        //System.out.println("access on method user get By Id" + username);

        List<GetQuotationItem> orderItemList = new ArrayList();

        Response response = quotationService.getQuatationItemList(quotationId);

        if (response != null && response.getResCode() == 200) {
            orderItemList = (List<GetQuotationItem>) response.getResponse();
        }
        return orderItemList;
    }


	@RequestMapping(value = "/order/updateQuotation", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse updateQuotation(@RequestParam(value = "jsonString") JSONArray jsonString,
													  @RequestParam(value = "quotationId") int quotationId, HttpServletRequest request) throws JSONException, ParseException {
		AjaxResponse ajaxResponse = new AjaxResponse(null,false);
		Quotation quotation = new Quotation();
		String username = null;
		Response response = null;
		System.out.println(" jsonString is : " + jsonString);
//
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if(!(auth instanceof AnonymousAuthenticationToken)) {
			if(auth != null) {
				UserDetails userDetails = (UserDetails) auth.getPrincipal();
				Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) auth.getAuthorities();
				System.out.println("success");
				username = userDetails.getUsername();

				System.out.println("username is " + username);

			}

		}else System.out.println(auth);


			if (jsonString != null) {

				response = quotationService.updateQuotationItemDetails(jsonString, quotationId);

			}

//		if (expectedDeliveryDate != null && !expectedDeliveryDate.isEmpty() && !expectedDeliveryDate.equals("") && expectedDeliveryDate.trim().length() > 0) {
//			expectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(expectedDeliveryDate);
//
//			if (order_type != null && !order_type.isEmpty() && !order_type.equals("") && order_type.trim().length() > 0) {
//
//
//				Date c_date = new Date();
//				quotation.setExpDeliveryDate(expectedDate);
//				quotation.setQuatationType(order_type);
//				quotation.setCDate(c_date);
//				quotation.setCUser(username);
//				quotation.setCustomerRefId(customerId);
//
//				response = quotationService.createQuotationMaindet(quotation);
//				if(response != null && response.getResCode() == 200) {
//
//					response2 = quotationService.saveQuotationItemDetails(jsonString, (int) response.getResponse());
//
//				} else {
//					ajaxResponse = new AjaxResponse("Error on saving response main data " + response.getResDes() , false);
//				}
//			} else {
//				ajaxResponse = new AjaxResponse("Null value for Order Type" , false);
//			}
//		} else {
//			ajaxResponse = new AjaxResponse("Null value for expected date" , false);
//		}
		return ajaxResponse;

	}
}
