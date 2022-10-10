package com.tweetapp.tweet.converter;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tweetapp.tweet.model.TweetReply;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReplyConverter implements DynamoDBTypeConverter<String , List<TweetReply>> {
	Logger log = LoggerFactory.getLogger(ReplyConverter.class);
	private static final ObjectMapper MAPPER = new ObjectMapper();
	@Override
	public String convert(List<TweetReply> replies) {
		try {
			return MAPPER.writeValueAsString(replies);
		} catch (JsonProcessingException e) {
			log.info("ran into problem Reply-19");
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<TweetReply> unconvert(String object) {
		// TODO Auto-generated method stub
		// List<String> likes = new ArrayList<>();
		try {
			return  MAPPER.readValue(object, new TypeReference<List<TweetReply>>(){});
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
