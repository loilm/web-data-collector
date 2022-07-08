package testcases.tgdd;

import commons.Browser;
import commons.CommonTest;
import commons.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LaptopByBrandPage;
import pages.LaptopByCpuPage;
import pages.ProductPage;

import java.io.IOException;

@Listeners(TestListener.class)
public class LaptopDataCrawl extends CommonTest {
    private WebDriver driver;
    private LaptopByBrandPage laptopByBrandPage;
    private LaptopByCpuPage laptopByCpuPage;
    private ProductPage productPage;

    @BeforeClass
    public void setup() {
        driver = Browser.getDriver();
        driver.get("https://www.thegioididong.com/laptop");
        laptopByBrandPage = new LaptopByBrandPage(driver);
        laptopByCpuPage = new LaptopByCpuPage(driver);
        productPage = new ProductPage(driver);
    }

    /**
     * get list laptop:
     * - Asus
     * - i7
     */
    @Test
    public void laptopTestcase01() throws InterruptedException, IOException {
        laptopByBrandPage.selectByBrand("asus");
        laptopByCpuPage.selectByCpu("i7");
        productPage.getListProduct();
    }
}