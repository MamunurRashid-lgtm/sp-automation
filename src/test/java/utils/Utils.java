package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class Utils {

    @SuppressWarnings("unchecked") // Suppresses unchecked warnings
    public void saveJsonList(String username, String password) throws IOException, ParseException, org.json.simple.parser.ParseException {
        String fileName = "./src/test/resources/Users.json";
        JSONParser parser = new JSONParser();

        JSONArray jsonArray;
        try (FileReader reader = new FileReader(fileName)) {
            Object obj = parser.parse(reader);
            jsonArray = (JSONArray) obj;
        } catch (IOException e) {
            jsonArray = new JSONArray(); // Initialize if file does not exist
        }

        JSONObject userObject = new JSONObject();
        userObject.put("userName", username);
        userObject.put("password", password);

        jsonArray.add(userObject);

        try (FileWriter file = new FileWriter(fileName)) {
            file.write(jsonArray.toJSONString());
        }

        System.out.println("Saved data");
    }

    public static List<?> readJSONArray(String filename) throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filename)) {
            return (JSONArray) parser.parse(reader);
        }
    }

    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fileInput = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base_url");
    }

    public static WebElement waitForElement(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
