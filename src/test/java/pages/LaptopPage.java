package pages;

import commons.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LaptopPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private CommonPage commonPage;
    private ProductPage productPage;

    /*Brand*/
    By brandOption = By.xpath("//div[starts-with(@class,'filter-item block-manu')]/div");
    By brandList = By.xpath("(//div[starts-with(@class, 'filter-show')])[2]/div[1]/a");
    String before_BrandItem = "(//div[@class='filter-list filter-list--hang manu'])[2]/a[";
    String after_BrandItem = "]";
    By viewBrandResult = By.xpath("(//a[@href='#'])[1]");

    /*Price*/
    By priceOption = By.xpath("//div[4]/div/span");
    By priceList = By.xpath("(//div[@class='filter-list price'])[2]/a");
    String before_PriceItem = "//div[4]/div[2]/div[1]/a[";
    String after_PriceItem = "]";
    By viewPriceResult = By.xpath("//div[3]/a[2]/b");

    /*Demand*/
    By demandOption = By.xpath("//div[@propertyid='5879']/div/span");
    By demandList = By.xpath("//div[@propertyid='5879']/div[2]/div[1]/a");
    String before_DemandItem = "//div[@propertyid='5879']/div[2]/div[1]/a[";
    String after_DemandItem = "]";
    By viewDemandResult = By.xpath("//div[@propertyid='5879']/div[2]/div[2]/a[2]/b");

    /*Screen*/
    By screenOption = By.xpath("//div[@propertyid='187']/div/span");
    By screenList = By.xpath("//div[@propertyid='187']/div[2]/div[1]/a");
    String before_ScreenItem = "//div[@propertyid='187']/div[2]/div[1]/a[";
    String after_ScreenItem = "]";
    By viewScreenResult = By.xpath("//div[@propertyid='187']/div[2]/div[2]/a[2]/b");

    /*CPU*/
    By cpuOption = By.xpath("//div[7]/div/span");
    By cpuList = By.xpath("//div[7]/div[2]/div[1]/a");
    String before_CpuItem = "//div[7]/div[2]/div/a[";
    String after_CpuItem = "]";
    By viewCpuResult = By.xpath("//div[7]/div[2]/div[2]/a[2]");

    /*RAM*/
    By ramOption = By.xpath("//div[@propertyid='146']/div/span");
    By ramList = By.xpath("//div[@propertyid='146']/div[2]/div[1]/a");
    String before_RamItem = "//div[@propertyid='146']/div[2]/div/a[";
    String after_RamItem = "]";
    By viewRamResult = By.xpath("//div[@propertyid='146']/div[2]/div[2]/a/b");

    /*Disk*/
    By diskOption = By.xpath("//div[@propertyid='11083']/div/span");
    By diskList = By.xpath("//div[@propertyid='11083']/div[2]/div[1]/a");
    String before_DiskItem = "//div[@propertyid='11083']/div[2]/div[1]/a[";
    String after_DiskItem = "]";
    By viewDiskResult = By.xpath("//div[@propertyid='11083']/div[2]/div[2]/a/b");

    public LaptopPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        commonPage = new CommonPage(driver);
        productPage = new ProductPage(driver);
    }

    public void clickBrandOption(int[] indexItemArr) {
        productPage.clickOption(brandOption, indexItemArr, brandList, before_BrandItem, after_BrandItem, viewBrandResult);
    }

    public void clickPriceOption(int[] indexItemArr) {
        productPage.clickOption(priceOption, indexItemArr, priceList, before_PriceItem, after_PriceItem, viewPriceResult);
    }

    public void clickDemandOption(int[] indexItemArr) {
        productPage.clickOption(demandOption, indexItemArr, demandList, before_DemandItem, after_DemandItem, viewDemandResult);
    }

    public void clickScreenOption(int[] indexItemArr) {
        productPage.clickOption(screenOption, indexItemArr, screenList, before_ScreenItem, after_ScreenItem, viewScreenResult);
    }

    public void clickCpuOption(int[] indexItemArr) {
        productPage.clickOption(cpuOption, indexItemArr, cpuList, before_CpuItem, after_CpuItem, viewCpuResult);
    }

    public void clickRamOption(int[] indexItemArr) {
        productPage.clickOption(ramOption, indexItemArr, ramList, before_RamItem, after_RamItem, viewRamResult);
    }

    public void clickDiskOption(int[] indexItemArr) {
        productPage.clickOption(diskOption, indexItemArr, diskList, before_DiskItem, after_DiskItem, viewDiskResult);
    }
}
