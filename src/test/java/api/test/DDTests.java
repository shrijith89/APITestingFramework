package api.test;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.Dataproviders;
import io.restassured.response.Response;

public class DDTests {

	Dataproviders dataProviders = new Dataproviders();

	@Test(dataProvider = "Data", dataProviderClass = Dataproviders.class)
	public void testPostMultipleUser(String UserID, String UserName, String FirstName, String LastName, String Email,
			String Password, String Phone) {
		
		User userPayload = new User();
		
		userPayload.setId(UserID);
		userPayload.setUserName(UserName);
		userPayload.setFirstName(FirstName);
		userPayload.setLastName(LastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(Password);
		userPayload.setPhone(Phone);
		
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
	}
}
