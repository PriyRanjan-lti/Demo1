package com.priy.SessionTrackDemoXml.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
 

	//InMemoryUserDetailsManager manager=;
	
	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		return new InMemoryUserDetailsManager();
	}
     
    @Bean  
    public UserDetailsService userDetailsService() {  
        InMemoryUserDetailsManager manager = inMemoryUserDetailsManager();  
        manager.createUser(User.withDefaultPasswordEncoder()  
        .username("priy").password("priy123").roles("ADMIN").build());  
        manager.createUser(User.withDefaultPasswordEncoder()  
        .username("ranjan").password("ranjan123").roles("ADMIN").build()); 
        manager.createUser(User.withDefaultPasswordEncoder()  
        .username("cbdt").password("cbdt123").roles("ADMIN").build()); 
        return manager;  
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		return inMemoryUserDetailsManager().loadUserByUsername(username);
	} 
     
}

