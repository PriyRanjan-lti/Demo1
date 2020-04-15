package com.priy.SessionTrackDemoXml.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ActiveUserStore {
	
    public static List<String> users;
    
    public ActiveUserStore() {
        users = new ArrayList<String>();
    }

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}
    
    

}
