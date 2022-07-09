package commons;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(TestListener.class)
public class CommonTest {
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
