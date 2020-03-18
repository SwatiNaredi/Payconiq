package PayconiqRestAssuredBDDFramework.util;

import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;
import org.json.JSONObject;
import org.testng.Assert;
 
 
public class UtilMethods {
	
	//Verify whether status code is as expected
    public static void checkResponseStatusCode(Response res, int expectedResponseCode) {
    	assertEquals(expectedResponseCode, res.getStatusCode(),"Status is not as expected");
    }
 
    public static void assertParameterValue (JSONObject JSONResponseBody,String parameterName,String ExpectedValue) {
    	Assert.assertEquals(JSONResponseBody.getString(parameterName), ExpectedValue);
    }
 
   }
