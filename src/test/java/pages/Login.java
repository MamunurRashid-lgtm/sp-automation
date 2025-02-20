package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import java.util.List;

public class Login {

    @FindBy(name = "username")
    WebElement txtUserName;
    @FindBy(css = "[type=password]")
    WebElement txtPassword;
    @FindBy(css = "[type=submit]")
    WebElement btnSubmit;
    @FindBy(className = "MuiStack-root")
    List<WebElement> element;

    public Login (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public void doLogin(String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        txtUserName.sendKeys(username);
        Thread.sleep(2000);
        txtPassword.sendKeys(password);
        Thread.sleep(2000);
        btnSubmit.click();
        Thread.sleep(2000);
    }

    public void getTotalEmployeeList() throws InterruptedException {
        Thread.sleep(2000);
        element.get(4).click();
        Thread.sleep(3000);
    }
}
