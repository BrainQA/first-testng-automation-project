package google.ru.googleTests.basePage;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    private static final String PROP_FILE_CHROMEDRIVER = "/drivers/chromedriver.exe";

    public static String loadProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(PropertyLoader.class.getResourceAsStream(PROP_FILE_CHROMEDRIVER));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String value = "";

        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }
}