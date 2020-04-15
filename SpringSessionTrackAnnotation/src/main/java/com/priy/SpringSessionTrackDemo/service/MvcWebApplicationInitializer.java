package com.priy.SpringSessionTrackDemo.service;



import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;  
public class MvcWebApplicationInitializer extends  
        AbstractAnnotationConfigDispatcherServletInitializer {  
    @Override  
    protected Class<?>[] getRootConfigClasses() {  
        return new Class[] { WebSecurityConfig.class };  
    }  
    @Override  
    protected Class<?>[] getServletConfigClasses() {  
        // TODO Auto-generated method stub  
       // return new Class[] {AppConfig.class} ;  
        return null ;
    }  
    @Override  
    protected String[] getServletMappings() {  
        return new String[] { "/" };  
    }  
    
//    @Override
//    public void onStartup(ServletContext servletContext) {
//    servletContext.addListener(LoggedUser.class);
//    }
}  