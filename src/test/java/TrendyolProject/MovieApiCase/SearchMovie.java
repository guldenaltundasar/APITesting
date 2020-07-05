package TrendyolProject.MovieApiCase;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;



public class SearchMovie extends GetId {
	
	
	  public static void main(String[] args) {
		
		RestAssured.baseURI="http://www.omdbapi.com/";
		String search= given().queryParam("apikey", "f2bff0c3").queryParam("i", retriveId()).when().get().then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		
		JsonPath cs=new JsonPath(search);
		
		String title = cs.getString("Title");
		String year= cs.getString("Year");
		String released = cs.getString("Released");
		
		Assert.assertNotNull(title);
		Assert.assertNotNull(year);
		Assert.assertNotNull(released);

		
	}
	
	

}
