package utils;

import java.util.ResourceBundle;

/**
 * Created by Siva Garjala on 13-Mar-2022.
 */
public class GetTestProperties {
    /**
     * This method returns the input values provided in config value
     * @param propName
     * @return the properties
     */
    public static String getValue(String propName){
        ResourceBundle properties =ResourceBundle.getBundle("config");
       return properties.getString(propName);
    }
}
