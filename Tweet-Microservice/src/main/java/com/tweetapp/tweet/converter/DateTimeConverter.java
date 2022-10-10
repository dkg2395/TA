package com.tweetapp.tweet.converter;

import java.time.LocalDateTime;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DateTimeConverter implements DynamoDBTypeConverter<String, LocalDateTime>{

	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	@Override
	public String convert(LocalDateTime object) {
//		try {
			//return MAPPER.writeValueAsString(object);
			return object.toString();
//		} catch (JsonProcessingException e) {
//			throw new RuntimeException(e);
//		}
	}

	@Override
	public LocalDateTime unconvert(String object) {
//		try {
//			return  MAPPER.readValue(object, LocalDateTime.class);
		return LocalDateTime.parse(object);
//		} catch (JsonMappingException e) {
//			throw new RuntimeException(e);
//		} catch (JsonProcessingException e) {
//			throw new RuntimeException(e);
//		}
	}

}
