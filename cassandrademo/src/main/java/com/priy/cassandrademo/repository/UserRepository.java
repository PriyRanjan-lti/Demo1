package com.priy.cassandrademo.repository;


import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.priy.cassandrademo.model.User;

public interface UserRepository extends CassandraRepository<User, UUID>{
	@AllowFiltering
	User findByUsername(String username);

}
