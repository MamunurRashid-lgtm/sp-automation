package testrunner;

import org.testng.annotations.Test;
import pages.Login;
import pages.OfficialLetter;
import setup.Setup;

public class OfficialLetterTestRunner extends Setup {

    OfficialLetter officialLetter;

    @Test(priority = 0, description = "Verify Employee List")
    public void getEmployeeTotal() throws InterruptedException {
        Login login = new Login(driver);
        officialLetter = new OfficialLetter(driver);
        officialLetter.getTotalEmployeeList();

    }
}
