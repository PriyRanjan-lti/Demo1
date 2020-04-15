package com.priy.cassandrademo;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CreateCluster {

	public static void main(String[] args) {
	
	      //Query
//	      String query = "CREATE KEYSPACE castest WITH replication "
//	         + "= {'class':'SimpleStrategy', 'replication_factor':3};";
	      
	      String query = "CREATE KEYSPACE demo2 WITH replication "
	 	         + "= {'class':'NetworkTopologyStrategy', 'dc1':3, 'dc2':3};";
	      
	           
	      //creating Cluster object
	      Cluster cluster = Cluster.builder().withoutJMXReporting().addContactPoint("110.82.155.4").build();
	    
	      //Creating Session object
	      Session session = cluster.connect();
	     
	      //Executing the query
	      session.execute(query);
	     
	      //using the KeySpace
	      session.execute("USE demo2");
	      System.out.println("Keyspace created"); 

	}

}
