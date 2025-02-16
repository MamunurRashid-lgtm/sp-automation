package testrunner;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import pages.Login;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class LoginTestRunner extends Setup {

    Login login;

    @Test(priority = 0, description = "User can login with valid credential")
    public void doLogin() throws IOException, ParseException, IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException, ParseException {
        driver.get(Utils.getBaseUrl());
        List<?> data = Utils.readJSONArray("./src/test/resources/Users.json");
        login = new Login(driver);
        JSONObject userObj = (JSONObject) data.get(data.size()-3);
        String username = (String) userObj.get("userName");
        String password = (String) userObj.get("password");
        login.doLogin(username, password);
    }
}
