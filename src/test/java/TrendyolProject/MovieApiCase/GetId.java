package TrendyolProject.MovieApiCase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

public class GetId {
	
	private static String id;
	

	public GetId() {
		super();
	}

	public static String retriveId() {
		
		RestAssured.baseURI="http://www.omdbapi.com/";
        String response= given().queryParam("apikey", "f2bff0c3").queryParam("t", "Harry+Potter+and+the+Sorcerer's+Stone").when().get().then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=new JsonPath(response);
		id= js.getString("imdbID");
		
		return id;
		

	}

}
