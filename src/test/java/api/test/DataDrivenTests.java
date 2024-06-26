package api.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import com.github.javafaker.*;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {
		
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostDataDriven(String[] data) {
		JSONObject jo = new JSONObject();
		for(int i = 0; i < data.length; i++) {
			if(i == 0) {
				jo.put("id", data[i]);
			}
			else if(i == 1) {
				jo.put("username", data[i]);
			}
			else if(i == 2) {
				jo.put("firstName", data[i]);
			}
			else if(i == 3) {
				jo.put("lastName", data[i]);
			}
			else if(i == 4) {
				jo.put("email", data[i]);
			}
			else if(i == 5) {
				jo.put("password", data[i]);
			}
			else if(i == 6) {
				jo.put("phone", data[i]);
			}
			else {
			jo.put("userStatus", 0);
			}
		}
		String payload = jo.toString();
		Response r = UserEndPoints.createUser(payload);
		Assert.assertEquals(r.statusCode(), 200);
	}

	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUsers(String username) {
		Response r = UserEndPoints.deleteUser(username);
		Assert.assertEquals(r.statusCode(), 200);
	}

}
