package testcases.tgdd;

import commons.Browser;
import commons.CommonTest;
import commons.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LaptopPage;
import pages.ProductPage;

@Listeners(TestListener.class)
public class LaptopDataCrawl extends CommonTest {
    private WebDriver driver;
    private LaptopPage laptopPage;
    private ProductPage productPage;

    @BeforeClass
    public void setup() {
        driver = Browser.getDriver();
        driver.get("https://www.thegioididong.com/laptop");
        laptopPage = new LaptopPage(driver);
        productPage = new ProductPage(driver);
    }

    /**
     * get list laptop:
     * - Asus, Dell
     * - Core i7, Ryzen 7
     */
    @Test(priority = 1)
    public void laptopByBrandAndCpu() {
        driver.get("https://www.thegioididong.com/laptop");
        /*Brand: Asus, Dell*/
        int[] brandArr = new int[]{2, 6};
        laptopPage.clickBrandOption(brandArr);
        /*CPU: Core i7, Ryzen 7*/
        int[] cpuArr = new int[]{1,5};
        laptopPage.clickCpuOption(cpuArr);
        productPage.getListProduct();
    }

    /**
     * get list laptop:
     * - price < 15 milion
     */
//    @Test(priority = 2)
//    public void laptopByPrice() {
//        driver.get("https://www.thegioididong.com/laptop");
//        int[] array = new int[]{1};
//        laptopPage.clickPriceOption(array);
//        productPage.getListProduct();
//    }

//    @Test(priority = 3)
//    public void laptopByDemand() {
//        driver.get("https://www.thegioididong.com/laptop");
//        int[] array = new int[]{2,5};
//        laptopPage.clickDemandOption(array);
//        productPage.getListProduct();
//    }

//    @Test(priority = 4)
//    public void laptopByScreen() {
//        driver.get("https://www.thegioididong.com/laptop");
//        int[] array = new int[]{1,2};
//        laptopPage.clickScreenOption(array);
//        productPage.getListProduct();
//    }

//    @Test(priority = 5)
//    public void laptopByCpu() {
//        driver.get("https://www.thegioididong.com/laptop");
//        int[] array = new int[]{1,2};
//        laptopPage.clickCpuOption(array);
//        productPage.getListProduct();
//    }

//    @Test(priority = 6)
//    public void laptopByRam() {
//        driver.get("https://www.thegioididong.com/laptop");
//        int[] array = new int[]{1,3};
//        laptopPage.clickRamOption(array);
//        productPage.getListProduct();
//    }

//    @Test(priority = 7)
//    public void laptopByDisk() {
//        driver.get("https://www.thegioididong.com/laptop");
//        int[] array = new int[]{1,3};
//        laptopPage.clickDiskOption(array);
//        productPage.getListProduct();
//    }
}