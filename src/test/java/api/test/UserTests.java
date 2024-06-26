package api.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import com.github.javafaker.*;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	static String userData;
	static String username;
	static String petId;

	@BeforeClass
	public void setUpData() { 
		Faker faker = new Faker();
		JSONObject userPayload = new JSONObject();
		
		userPayload.put("id" , faker.idNumber().hashCode());
		userPayload.put("username" , faker.name().username());
		userPayload.put("firstName" , faker.name().firstName());
		userPayload.put("lastName" , faker.name().lastName());
		userPayload.put("email" , faker.internet().safeEmailAddress());
		userPayload.put("password" , faker.internet().password(5,10));
		userPayload.put("phone", faker.phoneNumber().cellPhone());
		userPayload.put("userStatus", 0);
		
		userData = userPayload.toString();
		username = userPayload.getString("username");
	}
	
	@Test(priority = 1)
	public void testPostUser(){
		Response resp = UserEndPoints.createUser(userData);
		System.out.println("Test Post User Output:");
		resp.then().log().all();
		Assert.assertEquals(resp.getStatusCode(),200);
	}
	
	@Test(priority = 2)
	public void testgetByUsername(ITestContext context) {
		Response r = UserEndPoints.getUser(username);
		System.out.println("Test get user by username output:");
		r.then().log().all();
		
		String username = r.jsonPath().get("username").toString();
		context.setAttribute("userName", username);
	}
	
	@Test(priority = 3)
	public void testupdateByUsername(ITestContext context) {
		String username = (String) context.getAttribute("userName");
		String userData1;
		
		JSONObject userPayload = new JSONObject();
		
		userPayload.put("firstName" , "Srikar Reddy");
		userPayload.put("lastName" , "Bussu");
		userPayload.put("email" , "srikarreddy651@gmail.com");
		
		userData1 = userPayload.toString();
		
		Response r = UserEndPoints.updateUser(username, userData1);
		
		r.then().log().all();
		Assert.assertEquals(r.getStatusCode(),200);
		
		// Checking data after update
		Response r1 = UserEndPoints.getUser(username);
		r1.then().log().all();
		
		String output = r1.jsonPath().getString("username");
		context.setAttribute("username", output);
	}
	
	@Test(priority = 4)
	public void deleteByUsername(ITestContext context) {
		String username = (String)context.getAttribute("username");
		Response res = UserEndPoints.deleteUser(username);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
}
