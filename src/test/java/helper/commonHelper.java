package helper;

import io.restassured.response.Response;
import netscape.javascript.JSObject;
import utilities.DatabaseUtility;
import utilities.FileUtility;
import utilities.JsonParserUtility;
import utilities.RestAssuredUtility;

import java.util.HashMap;
import java.util.Map;

public class commonHelper {

    RestAssuredUtility restAssuredUtility;
    JsonParserUtility jsonParserUtility;
    FileUtility fileUtility;
    DatabaseUtility databaseUtility;

    public commonHelper()
    {
       restAssuredUtility = new RestAssuredUtility();
       jsonParserUtility = new JsonParserUtility();
       fileUtility = new FileUtility();
       databaseUtility = new DatabaseUtility();
    }


}
