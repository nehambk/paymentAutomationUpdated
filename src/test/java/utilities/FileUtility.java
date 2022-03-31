package utilities;

import helper.GlobalVariables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileUtility {

    // #TO DO make this function in SWITCH CASE TO READ MORE FILES IN RESOURCES
    private static String strPropertyValue;

    //Property Type is file and prop name is the prop inside the file
    public static String getProperty(String strPropertyType, String strPropName){

        try {
            InputStream input = new FileInputStream(GlobalVariables.CONFIG_PROPERTIES);
            Properties properties = new Properties();

            //Load property file
            properties.load(input);

            //Get property value
            strPropertyValue = properties.getProperty(strPropName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strPropertyValue;
    }
}
