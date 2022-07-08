package commons;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Listeners(TestListener.class)
public class CommonTest {
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
    private Date date = new Date();

    /*Setting browser and run testcase with .xml file*/
    @Parameters("browser")
    @BeforeClass
    public void baseSetup(String browserName) {
        Browser.browserSetup(browserName);
    }

    @AfterClass
    public void tearDown() {
        Browser.getDriver().quit();
    }
}
