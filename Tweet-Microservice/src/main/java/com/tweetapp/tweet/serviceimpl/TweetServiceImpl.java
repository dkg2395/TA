package com.tweetapp.tweet.serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.tweet.model.Tweet;
import com.tweetapp.tweet.model.TweetReply;
import com.tweetapp.tweet.repository.TweetRepository;
import com.tweetapp.tweet.service.TweetService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TweetServiceImpl implements TweetService{
	
	@Autowired
	TweetRepository repo;
	Logger log = LoggerFactory.getLogger(TweetServiceImpl.class);
	public List<Tweet> getAllTweets(){
		log.info("Inside get all tweets service");
		List<Tweet> tweets = new ArrayList<Tweet>();
		for(Tweet t:repo.findAll()) tweets.add(t);
		return tweets;
	}
	
	public Tweet addTweet(Tweet tweet, String userName) {
		log.info("Inside add new tweet service");
		tweet.setUserName(userName);
		List<TweetReply> replies=new ArrayList<TweetReply>();
		tweet.setReply(replies);
		List<String> likes=new ArrayList<>();
		tweet.setLikes(likes);
		tweet.setDate(LocalDateTime.now());
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
	//	tweet.setDate(currentDateTime.format(formatter));
		return repo.save(tweet);
	}
	
	public boolean deleteTweet(String tweetId) {
		log.info("Inside delete tweet service");
		if(repo.findById(tweetId).isPresent()) 
		{
		repo.deleteById(tweetId);
		return true;
		}
		else return false;
	}
	
	public Tweet updateTweet(String tweetId, Tweet tweet) {
		log.info("Inside update tweet service");
		String tweetbody=tweet.getTweet();
		Tweet updatedTweet=repo.findByTweetId(tweetId);
		log.info(updatedTweet.getTweetId());
		updatedTweet.setTweet(tweetbody);
		repo.save(updatedTweet);
		return updatedTweet;
	}
	
	public List<Tweet> tweetsOfUsername(String username){
		log.info("Inside find tweets by username service");
		
		return repo.findByUserName(username);
		
	}
	
	public void reply(String id, TweetReply reply, String userName) {
		log.info("Inside reply to a tweet service");
		Tweet tweet = repo.findByTweetId(id);
		List<TweetReply> replies=tweet.getReply();
		TweetReply tweetReply= new TweetReply();
		tweetReply.setUserName(userName);
		tweetReply.setReply(reply.getReply());
//		tweetReply.setDate(LocalDateTime.now());
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		tweetReply.setDate(currentDateTime.format(formatter));
		replies.add(tweetReply);
		tweet.setReply(replies);
		repo.save(tweet);
	}
	
	public boolean like(String id, String username) {
		log.info("Inside like a tweet service");
		Tweet tweet = repo.findByTweetId(id);
		List<String> like = tweet.getLikes();
		if(!like.contains(username)) 
		{	
			log.info("like the tweet");
			like.add(username);
			tweet.setLikes(like);
			repo.save(tweet);
			return true;
		}
		else{
			log.info("Unlike the tweet service");
			like.remove(username);
			tweet.setLikes(like);
			repo.save(tweet);
			return false;
		}
	}

}
