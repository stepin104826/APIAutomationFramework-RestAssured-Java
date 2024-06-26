package api.endpoints;


import org.testng.Assert;


import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.json.JSONObject;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;

import api.payload.User;


// Created to perform CRUD requests for the User Endpoints.

public class UserEndPoints {
	
	public static Response createUser(String payload) {
		Response resp = 
		given()
			.contentType("application/json")
			.accept("application/json")
			.body(payload)
		.when()
			.post(Routes.postUrlUser);
			
		return resp;
	}
	
	public static Response getUser(String userName) {
		Response resp = 
		given()
			.pathParam("username", userName)
		
		.when()
			.get(Routes.getUrlUser);
			
		return resp;
	}
	
	public static Response updateUser(String userName, String payload) {
		Response resp = 
		given()
			.contentType("application/json")
			.accept("application/json")
			.pathParams("username", userName)
			.body(payload)
			
		.when()
			.put(Routes.updateUrlUser);
			
		return resp;
	}
	
	public static Response deleteUser(String userName) {
		Response resp = 
		given()
			.pathParam("username", userName)
		
		.when()
			.delete(Routes.deleteUrlUser);
			
		return resp;
	}
	
}
