package PayconiqRestAssuredBDDFramework.util;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;
import static io.restassured.RestAssured.*;

public class Base {
	
	static String username="rohit1212s";
	static String password="Winnner1";
	
 
    //Set base URI before test
    public static void setBaseURI (String baseURI){
        RestAssured.baseURI = baseURI;
    }
 
    //Set Content Type
    public static void setContentType (ContentType Type){
        given().contentType(Type);
    }
 
    //Reset base URI after test
    public static void resetBaseURI (){
        RestAssured.baseURI = null;
    }
    
    //Fetch the API Response
    public static Response getResponse(String baseURI,String apiBody,String methodType) {
    	
    	RequestSpecBuilder builder = new RequestSpecBuilder();
    	Response response=null;
		// Setting API's Body
		builder.setBody(apiBody);
		
		// Setting content type as application/json
		builder.setContentType("application/json; charset=UTF-8");
		
		RequestSpecification requestSpec = builder.build();
		
		if (methodType=="Post")
		{
		response=given().auth().preemptive().basic(username,password).spec(requestSpec).when().post(baseURI);	
		}
		else if (methodType=="Get")
		{
		response=given().auth().preemptive().basic(username,password).spec(requestSpec).when().get(baseURI);		
		}
		else if (methodType=="Patch")
		{
		response=given().auth().preemptive().basic(username,password).spec(requestSpec).when().patch(baseURI);	
		}
		else if (methodType=="Delete")
		{
		response=given().auth().preemptive().basic(username,password).spec(requestSpec).when().delete(baseURI);		
		}
		return response;
    }
    
    
    //Convert API Response to String
    public static JSONObject getResponseBody(Response response) {
    	JSONObject JSONResponseBody = new JSONObject(response.body().asString());
    	return JSONResponseBody;
    }
}