package api.endpoints;

/*
 * Swagger URI -> https://petstore.swagger.io
 * 
 * User:
 * Create User(POST) -> https://petstore.swagger.io/v2/user
 * Get User(GET)-> https://petstore.swagger.io/v2/user/{username}
 * Update User(PUT)-> https://petstore.swagger.io/v2/user/{username}
 * Delete User(DELETE) -> https://petstore.swagger.io/v2/user/{username}
 * 
 * Pet:
 * Create Pet(POST) -> https://petstore.swagger.io/v2/pet
 * Get Pet(GET) -> https://petstore.swagger.io/v2/pet/{petId}
 * Update Pet(PUT) -> https://petstore.swagger.io/v2/pet
 * Delete Pet(DELETE) -> https://petstore.swagger.io/v2/pet/{petId}
 */


public class Routes {
	
	public static String baseUrl = "https://petstore.swagger.io/v2";
	
	// User module
	public static String postUrlUser = baseUrl + "/user";
	public static String getUrlUser = baseUrl + "/user/{username}";
	public static String updateUrlUser = baseUrl + "/user/{username}";
	public static String deleteUrlUser = baseUrl + "/user/{username}";	
	
	// Pet module
	public static String postUrlPet = baseUrl + "/pet";
	public static String getUrlPet = baseUrl + "/pet/{petId}";
	public static String updateUrlPet = baseUrl + "/pet";
	public static String deleteUrlPet = baseUrl + "/pet/{petId}";	

}
