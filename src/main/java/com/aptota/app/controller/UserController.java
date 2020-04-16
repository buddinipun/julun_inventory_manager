package com.aptota.app.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aptota.app.dao.UserDao;
import com.aptota.app.model.Item;
import com.aptota.app.model.User;
import com.aptota.app.model.UserRole;
import com.aptota.app.model.UIModel.UIUser;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.UserLogin.UserService;



@Controller
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping(value ="/signup")
	public String loadSingUp(Map<String, Object> map,Model userModel) {
		System.out.println("calll signup");
		User sysUser = new User();
		sysUser.setEmail("buddinipun@gmail.com");
		sysUser.setUsername("buddi");;
		sysUser.setPassword("12343546678");
		
		
		//userinfoService.createSysUser(sysUser, null);
		map.put("SysUser", new User());
		userModel.addAttribute("SysUser",new User());
		//userTyprModel.addAttribute("SysUserType", new SysUserType());
		return "signup";
	}
	
	@RequestMapping(value = "web/webuser.reg", method = RequestMethod.POST)
    public ModelAndView webUserRegister(
            @ModelAttribute("userregform") @Validated UIUser userModel,
            BindingResult bindingResult, HttpServletRequest request,
            Model model, RedirectAttributes redirectAttributes) {
       // System.out.println("with in webuser.reg");
        ModelAndView modelAndView = new ModelAndView();
        Response response = userService.saveSalesUser(userModel, "uname");
       // System.out.println("with in webuser.reg response : " + response);
        if(response.getResCode() == 200) {
            try {
//           
                redirectAttributes.addFlashAttribute("insertStatus", "Success");
                modelAndView.setViewName("redirect:create");
                System.out.println("modelAndView is : " + modelAndView.getViewName());
            } catch (Exception e) {
                System.out.println("modelAndView exception is :" + e);
            }
            return modelAndView;
        } else if(response.getResCode() == 304){

            redirectAttributes.addFlashAttribute("ErrinsertStatus", "User Already Exists");
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
	
	
	
	@RequestMapping("/web/create")
	public String loadCreateWebUser(Model model) {
		
		
		model.addAttribute("userregform", new UIUser());
		return "users/createWebUser";
	}
	
	
	@RequestMapping("/salesAgent/create")
	public String loadCreateSalesAgent(Model model) {
		
		System.out.println("sales users 1");
		List<User> salesUsers = userService.getSalesUsers();
		
 		model.addAttribute("salesUsers", salesUsers);
 		
 		System.out.println("sales users 2" + salesUsers);
		model.addAttribute("userregform", new UIUser());
		return "users/createSalesPerson";
	}
	
	@RequestMapping(value = "salesAgent/user.reg", method = RequestMethod.POST)
    public ModelAndView salesAgentRegister(
            @ModelAttribute("userregform") @Validated UIUser userModel,
            BindingResult bindingResult, HttpServletRequest request,
            Model model, RedirectAttributes redirectAttributes) {
       System.out.println("with in salesAgent .reg");
        ModelAndView modelAndView = new ModelAndView();
        Response response = userService.saveSalesUser(userModel, "uname");
       System.out.println("with in webuser.reg response : " + response);
        if(response.getResCode() == 200) {
            try {
//           
                redirectAttributes.addFlashAttribute("insertStatus", "Success");
                modelAndView.setViewName("redirect:create");
                System.out.println("modelAndView is : " + modelAndView.getViewName());
            } catch (Exception e) {
                System.out.println("modelAndView exception is :" + e);
            }
            return modelAndView;
        } else if(response.getResCode() == 304){

            redirectAttributes.addFlashAttribute("ErrinsertStatus", "User Already Exists");
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
	


}
