package testcases.vietlott;

import commons.Browser;
import commons.CommonTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.VietlottPage;

import java.util.List;

public class DataCrawl extends CommonTest {
    private WebDriver driver;
    private VietlottPage vietlottPage;

    @BeforeClass
    public void setup() {
        driver = Browser.getDriver();
        driver.get("https://vietlott.vn/vi/trung-thuong/ket-qua-trung-thuong/winning-number-645");
        vietlottPage = new VietlottPage(driver);
    }

    @Test
    public void getListOf05Page() {
        List<String> list = vietlottPage.getDataByPage(5,8);
        vietlottPage.getListLastTwoDigitsWithFrequent(list);
//        System.out.println(list.size());
        for (int i = 0; i < list.size();i++){
            System.out.println(i+" | "+list.get(i));
        }
    }
}
