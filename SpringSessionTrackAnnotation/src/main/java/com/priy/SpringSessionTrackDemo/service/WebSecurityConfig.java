package com.priy.SpringSessionTrackDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;  
//import org.springframework.security.config.annotation.authentication.builders.*;  
import org.springframework.security.config.annotation.web.builders.HttpSecurity;  
import org.springframework.security.config.annotation.web.configuration.*;  
import org.springframework.security.core.userdetails.User;  
import org.springframework.security.core.userdetails.UserDetailsService;  
import org.springframework.security.provisioning.InMemoryUserDetailsManager;  
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;  
@EnableWebSecurity  
@ComponentScan("com.priy")  
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {  
	
	@Bean
	public ActiveUserStore activeUserStore(){
	    return new ActiveUserStore();
	}
	
	@Autowired
	MySimpleUrlAuthenticationSuccessHandler mySimpleUrlAuthenticationSuccessHandler;
	
	@Autowired
	MyLogoutSuccessHandler myLogoutSuccessHandler;
    
  @Bean  
  public UserDetailsService userDetailsService() {  
      InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();  
      manager.createUser(User.withDefaultPasswordEncoder()  
      .username("user1").password("user1").roles("ADMIN").build());  
      manager.createUser(User.withDefaultPasswordEncoder()  
      .username("user2").password("user2").roles("ADMIN").build()); 
      manager.createUser(User.withDefaultPasswordEncoder()  
      .username("user3").password("user3").roles("ADMIN").build()); 
      return manager;  
  }  
    
  @Override  
  protected void configure(HttpSecurity http) throws Exception {  
                
      http                              
      .authorizeRequests()  
          .anyRequest().hasRole("ADMIN")  
          .and().formLogin().successHandler(mySimpleUrlAuthenticationSuccessHandler)
          .and()         
      .httpBasic()  
      .and()  
      .logout()  
      .logoutUrl("/j_spring_security_logout") 
      //.logoutUrl("/logout") 
      .logoutSuccessHandler(myLogoutSuccessHandler); 
     // .logoutSuccessUrl("/")  
      ;  
  }  
}  
