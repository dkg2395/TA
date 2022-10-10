package com.tweetapp.tweet.model;

import java.time.LocalDateTime;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;
import com.tweetapp.tweet.converter.DateTimeConverter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class TweetReply {

	private String reply;
	private String userName;
//	@DynamoDBTyped(DynamoDBAttributeType.S)
//	private LocalDateTime date;
	private String date;

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public TweetReply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TweetReply(String reply, String userName, String date) {
		super();
		this.reply = reply;
		this.userName = userName;
		this.date = date;
	}

	@Override
	public String toString() {
		return "TweetReply [reply=" + reply + ", userName=" + userName + ", date=" + date + "]";
	}

}
