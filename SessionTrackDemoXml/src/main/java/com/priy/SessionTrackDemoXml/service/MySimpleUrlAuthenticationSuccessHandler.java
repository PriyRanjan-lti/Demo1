package com.priy.SessionTrackDemoXml.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

//@Component("myAuthenticationSuccessHandler")
public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
 
    @Autowired
    ActiveUserStore activeUserStore;
     
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication) 
      throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            LoggedUser user = new LoggedUser(authentication.getName(), activeUserStore);
            session.setAttribute("user", user);
            if(activeUserStore.getUsers().size()>2) {
            	response.sendRedirect(request.getContextPath()+"/retry");
            }else
            	response.sendRedirect(request.getContextPath()+"/welcome");
        }
    }
}
