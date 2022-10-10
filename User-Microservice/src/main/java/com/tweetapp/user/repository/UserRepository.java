package com.tweetapp.user.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.user.model.User;

@EnableScan
@Repository
public interface UserRepository extends CrudRepository<User, String>
//MongoRepository<User, String> 
{
	
	User findByUserName(String userName);
	
	User findByEmailId(String emailid);
	
//	@Query("{},{'userName':1,}")
//	List<User> findusers();

//	@Query("{userName:/?0.*/}")
	List<User> findByUserNameStartsWith(String username);
}