package com.tweetapp.tweet.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.tweet.model.Tweet;

@EnableScan
@Repository
public interface TweetRepository extends CrudRepository<Tweet, String>
//MongoRepository<Tweet, String>
{

	Tweet findByTweetId(String tweetId);
	
	List<Tweet> findByUserName(String userName);
	
}
