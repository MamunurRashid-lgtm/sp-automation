package setup;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.Login;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;

public class Setup {

    public WebDriver driver;
    public Login login;

    @BeforeSuite
    public void setUp() throws IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException {
        driver = DriverManager.getDriver();
        driver.get(Utils.getBaseUrl());

        // Read user credentials from JSON
        List<?> data = Utils.readJSONArray("./src/test/resources/Users.json");
        JSONObject userObj = (JSONObject) data.get(data.size() - 3);
        String username = (String) userObj.get("userName");
        String password = (String) userObj.get("password");

        // Perform Login once for all tests
        login = new Login(driver);
        login.doLogin(username, password);
    }

    @AfterSuite
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
