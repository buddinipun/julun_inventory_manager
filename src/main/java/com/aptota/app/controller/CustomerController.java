package com.aptota.app.controller;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.aptota.app.model.Customer;
import com.aptota.app.model.response.AjaxResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aptota.app.dao.CustomerDao;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.UserLogin.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/customer/create")
    public String addCustomer(HttpServletRequest request, Model model) {
        List<Customer> custlist = customerService.getAllCustomersServ();

        for (Customer cust : custlist) {
            System.out.println("Customer name : " + cust.getCustomerName());
        }
        model.addAttribute("addCustomer", new Customer());
        model.addAttribute("userSummary", custlist);
        return "customer/addCustomer";
    }


    @RequestMapping(value = "customer/customer.reg", method = RequestMethod.POST)
    public ModelAndView webUserRegister(
            @ModelAttribute("userregform") @Validated Customer customer,
            BindingResult bindingResult, HttpServletRequest request,
            Model model, RedirectAttributes redirectAttributes) {
        System.out.println("with in webuser.reg");
        ModelAndView modelAndView = new ModelAndView();
        Response response = customerService.registercustomer(customer);
        System.out.println("with in webuser.reg response : " + response);
        if (response.getResCode() == 200) {
            try {
            	redirectAttributes.addFlashAttribute("insertStatus", "Success");
                modelAndView.setViewName("redirect:create");
                System.out.println("modelAndView is : " + modelAndView.getViewName());
            } catch (Exception e) {
                System.out.println("modelAndView exception is :" + e);
            }
            return modelAndView;
        } else if (response.getResCode() == 304) {

            redirectAttributes.addFlashAttribute("ErrinsertStatus", "User Already Exists");
            modelAndView.setViewName("redirect:create");
            return modelAndView;
        } else {
            try {
                redirectAttributes.addFlashAttribute("ErrinsertStatus", "Failed");
                redirectAttributes.addFlashAttribute("ErrinsertStatus", "Fails");
                modelAndView.setViewName("redirect:create");
                System.out.println("modelAndView is : " + modelAndView);
            } catch (Exception e) {
                System.out.println("modelAndView exception is :" + e);
            }
            return modelAndView;
        }

    }

    @RequestMapping(value = "/searchCustomer", method = RequestMethod.GET)
    public ResponseEntity<List<String>> searchAssessor(@RequestParam(value = "term") String q) {
        System.out.println("Testing String" + q);
        return new ResponseEntity<List<String>>(customerService.serachCustomer(q), HttpStatus.OK);
    }

    @RequestMapping(value = "/getcustomerbyNic", method = RequestMethod.GET)
    public @ResponseBody
    AjaxResponse getcustomerbyNic(@RequestParam(value = "adUserpicker") String nic,
                                  HttpServletRequest request) throws JSONException, ParseException {
        System.out.println("within getcustomerbyNic");
        AjaxResponse ajaxResponse = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            if (auth != null) {
                UserDetails userDetails = (UserDetails) auth.getPrincipal();
                Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) auth.getAuthorities();
              //  System.out.println("success");
                Response response = customerService.getCustomerByNic(nic);

                if (response.getResCode() == 200) {
                    System.out.println("response.getResCode() == 200");
                    ajaxResponse = new AjaxResponse("success", (Customer) response.getResponse());
                    return ajaxResponse;
                } else {
                    System.out.println("response.getResCode() == 300");
                    ajaxResponse = new AjaxResponse("Fails", new Customer());
                }


            } else System.out.println("auth null");



        } else System.out.println("AnonymousAuthenticationToken");
        return ajaxResponse;
    }

}
