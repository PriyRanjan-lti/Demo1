package com.priy.SpringSessionTrackDemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounterListener implements HttpSessionListener {

  private static int totalActiveSessions;
	
//  public static int getTotalActiveSession(){
//	return totalActiveSessions;
//  }
//	
//  @Override
//  public void sessionCreated(HttpSessionEvent arg0) {
//	totalActiveSessions++;
//	System.out.println("sessionCreated - add one session into counter");
//  }
//
//  @Override
//  public void sessionDestroyed(HttpSessionEvent arg0) {
//	totalActiveSessions--;
//	System.out.println("sessionDestroyed - deduct one session from counter");
//  }	
  
	  private static List<String> sessions = new ArrayList<>();
	  public static final String COUNTER = "session-counter";

	
	  public void sessionCreated(HttpSessionEvent event) {
	        
	      System.out.println("SessionCounter.sessionCreated");
	      HttpSession session = event.getSession();
	      if(session.isNew()) {
		      sessions.add(session.getId());
		      session.setAttribute(SessionCounterListener.COUNTER, this);
	      }

	  }
	
	  public void sessionDestroyed(HttpSessionEvent event) {

	      System.out.println("SessionCounter.sessionDestroyed");
	      HttpSession session = event.getSession();
	      sessions.remove(session.getId());
	      session.setAttribute(SessionCounterListener.COUNTER, this);
	  }
	
	  public static int getActiveSessionNumber() {
	      return sessions.size();
	  }
	  
	  
}
