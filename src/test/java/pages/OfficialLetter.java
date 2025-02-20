package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OfficialLetter {

    @FindBy(className = "MuiStack-root")
    List<WebElement> element;

    public OfficialLetter (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void getTotalEmployeeList() throws InterruptedException {

        Thread.sleep(2000);
        element.get(4).click();
        Thread.sleep(3000);
    }

}
