package utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RestAssuredUtility {

    private static RequestSpecification httpRequest;
    private static Map<String, String> headers;

    //READ THE URI
    public static String baseURI() {
        return FileUtility.getProperty("config", "QA_SP1");
    }

    //Setting headers using hashmap so that in future you can add multiple headers
    public Map<String, String> setHeader(String key, String value) {
        headers = new HashMap<>();
        headers.put(key, value);
        return headers;
    }

    //post response
    public static Response postResponse(String strEndpoint, JSONObject requestBody)
    {
        httpRequest = RestAssured.given();
        httpRequest.headers(headers);//set header
        httpRequest.accept(ContentType.JSON).
                contentType(ContentType.JSON).
                body(requestBody.toString()); //passing content type and request body
        Response response = httpRequest.post(strEndpoint);
        return response; // Return string
    }

    public static String getResponse(Response response)
    {
        String convertResponseObjToString = response.asString();
        System.out.println(convertResponseObjToString);
        return convertResponseObjToString;
    }

}
