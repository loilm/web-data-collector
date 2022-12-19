package pages;

import commons.CommonPage;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private CommonPage commonPage;

    By productList = By.xpath("//div[@class='container-productbox']/ul/li");
    By viewMore = By.xpath("(//div/a[contains(text(),'Xem thêm')])[1]");
    /*the last item of list is displayed then viewMoreDisable ON*/
    By viewMoreDisable = By.xpath("(//div[@style='display: none;']/a[contains(text(),'Xem thêm')])[1]");
    /*list <=20 then viewMoreHide ON*/
    By viewMoreHide = By.xpath("//div[@class='view-more hide']");

    /*For get info product*/
    String beforeXpath_LaptopName = "//*[@id='categoryPage']/div[3]/ul/li[";
    String afterXpath_LaptopName = "]/a[1]/h3";
    String beforeXpath_RamInfo = "//li[";
    String afterXpath_RamInfo = "]/a/div[3]/span[1]";
    String beforeXpath_SsdInfo = "//li[";
    String afterXpath_SsdInfo = "]/a/div[3]/span[2]";
    String beforeXpath_ScreenInfo = "//li[";
    String afterXpath_ScreenInfo = "]/div[@class='utility']/p[1]";
    String beforeXpath_CpuInfo = "//li[";
    String afterXpath_CpuInfo = "]/div[@class='utility']/p[2]";
    String beforeXpath_VgaInfo = "//li[";
    String afterXpath_VgaInfo = "]/div[@class='utility']/p[3]";
    String beforeXpath_BatteryInfo = "//li[";
    String afterXpath_BatteryInfo = "]/div[@class='utility']/p[4]";
    String beforeXpath_ProductPrice = "//li[";
    String afterXpath_ProductPrice = "]/a/strong";
    String beforeXpath_ProductLink = "(//a[@class='main-contain'])[";
    String afterXpath_ProductLink = "]";

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        commonPage = new CommonPage(driver);
    }

    /*For click brand, ram, cpu....*/
    public void clickOption(By optionLocator, int[] indexItemArr, By itemListLocator, String beforeItemPath, String afterItemPath, By viewResultBtn) {
        commonPage.clickElementWithJS(optionLocator);
        clickOptionByArray(indexItemArr, itemListLocator, beforeItemPath, afterItemPath);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        commonPage.clickElementWithJS(viewResultBtn);
        Log.info("| " + new Throwable()
                .getStackTrace()[0]
                .getMethodName() + ": wait for page load after click viewResult");
        commonPage.waitForPageLoaded();
    }

    /**
     * input: index array {x, z}
     * output: click item in list at index = x, index = z
     */
    public void clickOptionByArray(int[] indexItemArr, By itemListLocator, String beforeItemPath, String afterItemPath) {
        for (int i = 0; i < indexItemArr.length; i++) {
            clickItemInList(itemListLocator, beforeItemPath, indexItemArr[i], afterItemPath);
        }
    }

    public void clickItemInList(By itemListLocator, String beforeItemPath, int index, String afterItemPath) {
        String itemPath = beforeItemPath + index + afterItemPath;
        By itemLocator = By.xpath(itemPath);
        List<WebElement> list = driver.findElements(itemListLocator);
        for (int i = 1; i <= list.size(); i++) {
            if (i == index) {
                commonPage.clickElementWithJS(itemLocator);
            }
        }
        Log.info("| " + new Throwable().getStackTrace()[0].getMethodName() + ": " + index);
    }

    public void getListProduct() {
        int count = 0;
        while (driver.findElements(viewMoreDisable).size() == 0 &&
                driver.findElements(viewMoreHide).size() == 0) {
            WebElement viewMoreElement = driver.findElement(viewMore);
            if (viewMoreElement.isDisplayed()) {
                commonPage.clickElementWithJS(viewMore);
                count++;
            }
            Log.info("| Wait list load AFTER click viewMore");
            commonPage.waitForPageLoaded();
        }
        List<WebElement> listOfProduct = driver.findElements(productList);
        System.out.println("Click: " + count + " times. List total: " + listOfProduct.size());

//        exportExcel(listOfProduct, "Sheet1");

        for (int i = 1; i <= listOfProduct.size(); i++) {
            getInfoProduct(i);
        }
    }

    public void getInfoProduct(int i) {
        String laptopNamePath = beforeXpath_LaptopName + i + afterXpath_LaptopName;
        String laptopName = commonPage.getText(By.xpath(laptopNamePath));
        System.out.println(i + " - " + laptopName);

        String ramInfoPath = beforeXpath_RamInfo + i + afterXpath_RamInfo;
        String ramInfo = commonPage.getText(By.xpath(ramInfoPath));
        System.out.println("RAM: " + ramInfo);

        String ssdInfoPath = beforeXpath_SsdInfo + i + afterXpath_SsdInfo;
        String ssdInfo = commonPage.getText(By.xpath(ssdInfoPath));
        System.out.println("SSD: " + ssdInfo);

        String screenInfoPath = beforeXpath_ScreenInfo + i + afterXpath_ScreenInfo;
        String screenInfo = commonPage.getText(By.xpath(screenInfoPath));
        System.out.println("Man Hinh: " + screenInfo);

        String cpuInfoPath = beforeXpath_CpuInfo + i + afterXpath_CpuInfo;
        String cpuInfo = commonPage.getText(By.xpath(cpuInfoPath));
        System.out.println("CPU: " + cpuInfo);

        String vgaInfopath = beforeXpath_VgaInfo + i + afterXpath_VgaInfo;
        String vgaInfo = commonPage.getText(By.xpath(vgaInfopath));
        System.out.println("VGA: " + vgaInfo);

        String batteryInfoPath = beforeXpath_BatteryInfo + i + afterXpath_BatteryInfo;
        String batteryInfo = commonPage.getText(By.xpath(batteryInfoPath));
        System.out.println("Pin: " + batteryInfo);

        String productPricePath = beforeXpath_ProductPrice + i + afterXpath_ProductPrice;
        String productPrice = commonPage.getText(By.xpath(productPricePath));
        String productPriceTxt = productPrice.substring(0, productPrice.length() - 1).replace(".", "");
        System.out.println("Gia tien: " + productPriceTxt);

        String productLinkPath = beforeXpath_ProductLink + i + afterXpath_ProductLink;
        String productLink = driver.findElement(By.xpath(productLinkPath)).getAttribute("href").trim();
        System.out.println("Link san pham: " + productLink);
    }

    public void exportExcel(List<WebElement> list, String sheetName) {
        Log.info("| Start export excel...");
        int rows = list.size();
        // Create a workbook and a sheet
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet1 = wb.createSheet(sheetName);

        // Create a table header
        Row row = sheet1.createRow(0);
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Ram");
        row.createCell(3).setCellValue("Disk");
        row.createCell(4).setCellValue("Screen");
        row.createCell(5).setCellValue("CPU");
        row.createCell(6).setCellValue("VGA");
        row.createCell(7).setCellValue("Battery");
        row.createCell(8).setCellValue("Price");
        row.createCell(9).setCellValue("Link");

        for (int i = 1; i <= rows; i++) {
            String laptopNamePath = beforeXpath_LaptopName + i + afterXpath_LaptopName;
            String laptopName = commonPage.getText(By.xpath(laptopNamePath));

            String ramInfoPath = beforeXpath_RamInfo + i + afterXpath_RamInfo;
            String ramInfo = commonPage.getText(By.xpath(ramInfoPath));

            String ssdInfoPath = beforeXpath_SsdInfo + i + afterXpath_SsdInfo;
            String ssdInfo = commonPage.getText(By.xpath(ssdInfoPath));

            String screenInfoPath = beforeXpath_ScreenInfo + i + afterXpath_ScreenInfo;
            String screenInfo = commonPage.getText(By.xpath(screenInfoPath));

            String cpuInfoPath = beforeXpath_CpuInfo + i + afterXpath_CpuInfo;
            String cpuInfo = commonPage.getText(By.xpath(cpuInfoPath));

            String vgaInfopath = beforeXpath_VgaInfo + i + afterXpath_VgaInfo;
            String vgaInfo = commonPage.getText(By.xpath(vgaInfopath));

            String batteryInfoPath = beforeXpath_BatteryInfo + i + afterXpath_BatteryInfo;
            String batteryInfo = commonPage.getText(By.xpath(batteryInfoPath));

            String productPricePath = beforeXpath_ProductPrice + i + afterXpath_ProductPrice;
            String productPrice = commonPage.getText(By.xpath(productPricePath));
            String productPriceTxt = productPrice.substring(0, productPrice.length() - 1).replace(".", "");

            String productLinkPath = beforeXpath_ProductLink + i + afterXpath_ProductLink;
            String productLink = driver.findElement(By.xpath(productLinkPath)).getAttribute("href").trim();

            Row row1 = sheet1.createRow(i);
            row1.createCell(0).setCellValue(i);
            row1.createCell(1).setCellValue(laptopName);
            row1.createCell(2).setCellValue(ramInfo);
            row1.createCell(3).setCellValue(ssdInfo);
            row1.createCell(4).setCellValue(screenInfo);
            row1.createCell(5).setCellValue(cpuInfo);
            row1.createCell(6).setCellValue(vgaInfo);
            row1.createCell(7).setCellValue(batteryInfo);
            row1.createCell(8).setCellValue(productPriceTxt);
            row1.createCell(9).setCellValue(productLink);
            System.out.println("Progress: " + i * 100 / rows + " %");
        }
        try {
            FileOutputStream fileOut = new FileOutputStream("output/reports/TestData.xls");
            wb.write(fileOut);
            fileOut.close();
            Log.info("| Export excel success");
        } catch (IOException e) {
            Log.error("| Error export excel: " + e.getMessage());
        }
    }
}
