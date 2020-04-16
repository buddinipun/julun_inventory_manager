package com.aptota.app.controller;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aptota.app.dao.ItemDao;
import com.aptota.app.model.Customer;
import com.aptota.app.model.Item;
import com.aptota.app.model.Quotation;
import com.aptota.app.model.response.AjaxResponse;
import com.aptota.app.model.response.GetQuotationItem;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.UserLogin.ItemService;

@RequestMapping("products/")
@Controller
public class ItemManagement {
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping("product/create")
	public String addItem(Model model) {
		System.out.println("in products");
		List<Item> itemList = itemService.getAllItems();
 		model.addAttribute("itemSummery", itemList);
		model.addAttribute("item", new Item());
		return  "item/addItem";
	}
	
	
	 @RequestMapping(value = "product/item.reg", method = RequestMethod.POST)
    public ModelAndView webUserRegister(
            @ModelAttribute("item") @Validated Item item,
            BindingResult bindingResult, HttpServletRequest request,
            Model model, RedirectAttributes redirectAttributes) {
        
        ModelAndView modelAndView = new ModelAndView();
        Response response = itemService.registerItem(item);
       
        if(response.getResCode() == 200) {
            try {
//                redirectAttributes.addFlashAttribute("insertStatus", "Success");
//                Response responseusers = userDao.getAllWebUsers();
//                List<RecoveryTblUser> usersonInsu= (List<RecoveryTblUser>) responseusers.getData();
//                model.addAttribute("userSummary",usersonInsu);
                redirectAttributes.addFlashAttribute("insertStatus", "Success");
                modelAndView.setViewName("redirect:create");
                System.out.println("modelAndView is : " + modelAndView.getViewName());
            } catch (Exception e) {
                System.out.println("modelAndView exception is :" + e);
            }
            return modelAndView;
        } else if(response.getResCode() == 304){

            redirectAttributes.addFlashAttribute("ErrinsertStatus", "Item Already Exists");
            modelAndView.setViewName("redirect:create");
            return modelAndView;
        }  else {
            try {
          redirectAttributes.addFlashAttribute("ErrinsertStatus", "Failed");
                redirectAttributes.addFlashAttribute("ErrinsertStatus", "Fails");
                modelAndView.setViewName("redirect:create");
                System.out.println("modelAndView is : "  + modelAndView);
            } catch (Exception e) {
                System.out.println("modelAndView exception is :" + e);
            }
            return modelAndView;
        }

    }
	 
	 
		@RequestMapping(value = "/product/getItemById", method = RequestMethod.GET)
		public @ResponseBody AjaxResponse updateQuotation(@RequestParam(value = "itemId") int itemId, HttpServletRequest request) throws JSONException, ParseException {
			Item item = new Item();
			Quotation quotation = new Quotation();
			String username = null;
			Response response = null;
			AjaxResponse ajaxResponse = null;
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();

			if(!(auth instanceof AnonymousAuthenticationToken)) {
				if(auth != null) {
					UserDetails userDetails = (UserDetails) auth.getPrincipal();
					Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) auth.getAuthorities();
					System.out.println("success");
					username = userDetails.getUsername();

					System.out.println("username is " + username);

				}



				if (itemId != 0) {
					
					response = itemService.getItemByItemId(itemId);

				        if (response != null && response.getResCode() == 200) {
				        	ajaxResponse = new AjaxResponse("success", (Item) response.getResponse());
		                    return ajaxResponse;
				        } 
	                else {
	                    System.out.println("response.getResCode() == 300");
	                    ajaxResponse = new AjaxResponse("test", new Item());
	                }
				      
				}
				} else System.out.println("AnonymousAuthenticationToken");

			return ajaxResponse;

		}

}
