package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response createUser(User payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.post_URL);

		return response;

	}

	public static Response getUser(String userName) {
		Response response = given().pathParam("userName", userName).when().get(Routes.get_URL);

		return response;
	}

	public static Response updateUser(String userName, User payload) {
		Response response = given().pathParam("userName", userName).body(payload).contentType(ContentType.JSON).put(Routes.put_URL);
		return response;
	}

}
