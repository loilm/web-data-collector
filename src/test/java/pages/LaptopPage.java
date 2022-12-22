package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LaptopPage {
    private ProductPage productPage;

    /*Brand*/
    By brandOption = By.xpath("//div[starts-with(@class,'filter-item block-manu')]/div");
    By brandList = By.xpath("(//div[starts-with(@class, 'filter-show')])[2]/div[1]/a");
    String before_BrandItem = "(//div[@class='filter-list filter-list--hang manu'])[2]/a[";
    String after_BrandItem = "]";
    By viewBrandResult = By.xpath("(//a[@href='#'])[1]");

    /*Price*/
    By priceOption = By.xpath("//div[4]/div/span");
    By priceList = By.xpath("//div[4]/div[2]/div[1]/a");
    String before_PriceItem = "//div[4]/div[2]/div[1]/a[";
    String after_PriceItem = "]";
    By viewPriceResult = By.xpath("//div[4]/div[2]/div[3]/a[2]");

    /*Demand*/
    By demandOption = By.xpath("//div[5]/div/span");
    By demandList = By.xpath("//div[5]/div[2]/div[1]/a");
    String before_DemandItem = "//div[5]/div[2]/div[1]/a[";
    String after_DemandItem = "]";
    By viewDemandResult = By.xpath("//div[5]/div[2]/div[2]/a[2]");

    /*Screen*/
    By screenOption = By.xpath("//div[6]/div/span");
    By screenList = By.xpath("//div[6]/div[2]/div[1]/a");
    String before_ScreenItem = "//div[6]/div[2]/div[1]/a[";
    String after_ScreenItem = "]";
    By viewScreenResult = By.xpath("//div[2]/div[5]/a[2]");

    /*CPU*/
    By cpuOption = By.xpath("//div[7]/div/span");
    By cpuList = By.xpath("//div[7]/div[2]/div[1]/a");
    String before_CpuItem = "//div[7]/div[2]/div/a[";
    String after_CpuItem = "]";
    By viewCpuResult = By.xpath("//div[7]/div[2]/div[2]/a[2]");

    /*RAM*/
    By ramOption = By.xpath("//div[8]/div/span");
    By ramList = By.xpath("//div[8]/div[2]/div[1]/a");
    String before_RamItem = "//div[8]/div[2]/div[1]/a[";
    String after_RamItem = "]";
    By viewRamResult = By.xpath("//div[8]/div[2]/div[2]/a[2]");

    /*Disk*/
    By diskOption = By.xpath("//div[9]/div/span");
    By diskList = By.xpath("//div[9]/div[2]/div[1]/a");
    String before_DiskItem = "//div[9]/div[2]/div[1]/a[";
    String after_DiskItem = "]";
    By viewDiskResult = By.xpath("//div[9]/div[2]/div[2]/a[2]");

    public LaptopPage(WebDriver driver) {
        productPage = new ProductPage(driver);
    }

    /*input: 1, 3, 4
     * in brand option: click brand with position 1, 3, 4 */
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
