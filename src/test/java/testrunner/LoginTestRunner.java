package testrunner;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.OfficialLetter;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class LoginTestRunner extends Setup {

    Login login;

    @Test(priority = 0, description = "Verify Dashboard appears after login")
    public void verifyDashboard() {
        By dashboard = By.xpath("//h5[normalize-space()='Dashboard']");
        WebElement clickDashboard = Utils.waitForElement(driver, dashboard, 10);
        Assert.assertTrue(clickDashboard.isDisplayed(), "Dashboard is visible.");
    }
    @Test(priority = 1, description = "Verify Employee List")
    public void getEmployeeTotal() throws InterruptedException {
        login = new Login(driver);
        login.getTotalEmployeeList();

    }
}
