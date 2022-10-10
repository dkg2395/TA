package com.tweetapp.user.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

//import org.springframework.data.mongodb.core.index.Indexed;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

//@Getter @Setter @NoArgsConstructor @AllArgsConstructor
//@Document(collection = "user")
@DynamoDBTable(tableName = "user")
public class User {

	// @Id
	// @NotEmpty
	@DynamoDBHashKey
	private String userName;

	@DynamoDBAttribute
	@NotEmpty(message = "Password cannot be null")
	private String password;

	@DynamoDBAttribute
	@NotEmpty(message = "First Name cannot be null")
	private String firstName;

	@DynamoDBAttribute
	@NotEmpty(message = "Last Name cannot be null")
	private String lastName;

	@DynamoDBAttribute
	@NotEmpty(message = "Email Id cannot be null")
	// @Indexed(unique = true)
	@Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Email is not valid")
	private String emailId;

	@DynamoDBAttribute
	@NotEmpty(message = "Contact Number cannot be null")
	private String contactNumber;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public User(String userName, @NotEmpty(message = "Password cannot be null") String password,
			@NotEmpty(message = "First Name cannot be null") String firstName,
			@NotEmpty(message = "Last Name cannot be null") String lastName,
			@NotEmpty(message = "Email Id cannot be null") @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Email is not valid") String emailId,
			@NotEmpty(message = "Contact Number cannot be null") String contactNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailId=" + emailId + ", contactNumber=" + contactNumber + "]";
	}

}
