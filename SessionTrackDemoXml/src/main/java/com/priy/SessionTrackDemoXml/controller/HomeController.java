package com.priy.SessionTrackDemoXml.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.priy.SessionTrackDemoXml.service.ActiveUserStore;
import com.priy.SessionTrackDemoXml.service.LoggedUser;

  
  
@Controller  
public class HomeController {  
	
	@Autowired
    ActiveUserStore activeUserStore;
      
//    @RequestMapping(value="/", method=RequestMethod.GET)  
//    public String home() {  
//        return "home";  
//    }  
      
    
    @RequestMapping(value="/login", method=RequestMethod.GET)  
    public String login() {  
    	return "redirect:/"; 
    } 
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)  
    public String index(Model model) {  
    	 SecurityContext context = SecurityContextHolder.getContext();
    	model.addAttribute("name", context.getAuthentication().getName());
        return "welcome";  
    }  
    
    @GetMapping("/loggedUsers")
    public String getLoggedUsers(Locale locale, Model model) {
         model.addAttribute("users", activeUserStore.getUsers());
         System.out.println("loggedUsers : "+ activeUserStore.getUsers());
//        SecurityContext context = SecurityContextHolder.getContext();
//        System.out.println("You are logged in as " + context.getAuthentication().getName());
        return "users";
    }
    
    @RequestMapping(value="/logout", method=RequestMethod.GET)  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/";  
     }  
    
    @RequestMapping(value="/retry", method=RequestMethod.GET)  
    public String clogoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "logout";  
     }  
}  
