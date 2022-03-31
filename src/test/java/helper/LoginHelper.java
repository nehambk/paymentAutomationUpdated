package helper;

import io.restassured.response.Response;
import org.json.JSONObject;
import utilities.DatabaseUtility;
import utilities.FileUtility;
import utilities.JsonParserUtility;
import utilities.RestAssuredUtility;


public class LoginHelper extends commonHelper {

    public String strEndpoint = null;
    JSONObject requestBody;

    //Setting the url
    public String setURL()
    {
        strEndpoint = restAssuredUtility.baseURI() + fileUtility.getProperty("config", "OTP");
        System.out.println("strEndpoint -->" + strEndpoint);
        return strEndpoint;
    }

    //TO DO : PLEASE PUT HEADER VALUES IN PAYLOAD FILES/CONFIG FILES WILL BE EASY FOR YOU LATER ON
    public void header(){
        restAssuredUtility.setHeader("X-MClient", "3");
    }

    //Create a request
    public void createRequest(String key, String value){
        requestBody = jsonParserUtility.createJSONObject(key, value);
    }

    //Post response
    public Response postResponse(){
        Response response = RestAssuredUtility.postResponse(strEndpoint, requestBody);
        fetchResponse(response); //getting response after the post method is being called
        return response;
    }

    //Fetch response
    public void fetchResponse(Response response){
        RestAssuredUtility.getResponse(response);
    }

    //Reading OTP from table
    public void readOtpFromTable(String cell)
    {
        String query = FileUtility.getProperty("query" , "GETOTP");
        String getOtp = databaseUtility.fetchSingleData(query, cell);
    }

}
