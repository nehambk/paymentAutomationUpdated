package utilities;


import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.Json;
import io.cucumber.messages.JSON;
import io.restassured.response.Response;
import org.json.JSONObject;

public class JsonParserUtility {

    private static JSONObject jsonObject;

    public JSONObject createJSONObject(String key, String value)
    {
        jsonObject = new JSONObject();
        jsonObject.put(key, value);
        System.out.println("jsonObject ->" + jsonObject);
        return jsonObject;
    }




}
