package pages;

import commons.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;

import java.time.Duration;

public class LaptopByCpuPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private CommonPage commonPage;

    By cpuOption = By.xpath("//div[@propertyid='6241']/div/span");
    By filterBox = By.xpath("//div[@propertyid='6241']/div[@class='filter-show']");
    By i7Option = By.xpath("(//a[contains(text(),'Intel Core i7')])[2]");
    By i5Option = By.xpath("(//a[contains(text(),'Intel Core i5')])[2]");
    By i3Option = By.xpath("(//a[contains(text(),'Intel Core i3')])[2]");
    By celeronPentiumOption = By.xpath("(//a[contains(text(),'Intel Celeron/Pentium')])[2]");
    By ryzen7Option = By.xpath("(//a[contains(text(),'AMD Ryzen 7')])[2]");
    By ryzen5Option = By.xpath("(//a[contains(text(),'AMD Ryzen 5')])[2]");
    By ryzen3Option = By.xpath("(//a[contains(text(),'AMD Ryzen 3')])[2]");
    By m1Option = By.xpath("(//a[contains(text(),'Apple M1')])[2]");
    By m2Option = By.xpath("(//a[contains(text(),'Apple M2')])[2]");
    By m1proOption = By.xpath("(//a[contains(text(),'Apple M1 Pro')])[2]");
    By m1maxOption = By.xpath("(//a[contains(text(),'Apple M1 Max')])[2]");
    By viewResult = By.xpath("//div[@propertyid='6241']/div[2]/div[2]/a[2]");

    public LaptopByCpuPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        commonPage = new CommonPage(driver);
    }

    public void selectByCpu(String cpuName) {
        commonPage.clickElement(cpuOption);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(filterBox)));
        switch (cpuName.trim().toLowerCase()) {
            case "i7":
                commonPage.clickElement(i7Option);
                break;
            case "i5":
                commonPage.clickElement(i5Option);
                break;
            case "i3":
                commonPage.clickElement(i3Option);
                break;
            case "celeronPentium":
                commonPage.clickElement(celeronPentiumOption);
                break;
            case "ryzen7":
                commonPage.clickElement(ryzen7Option);
                break;
            case "ryzen5":
                commonPage.clickElement(ryzen5Option);
                break;
            case "ryzen3":
                commonPage.clickElement(ryzen3Option);
                break;
            case "m1":
                commonPage.clickElement(m1Option);
                break;
            case "m2":
                commonPage.clickElement(m2Option);
                break;
            case "m1pro":
                commonPage.clickElement(m1proOption);
                break;
            case "m1max":
                commonPage.clickElement(m1maxOption);
                break;
            default:
                Log.error("| " + new Throwable()
                        .getStackTrace()[0]
                        .getMethodName() + ": '" + cpuName + "' not found");
        }
        commonPage.clickElement(viewResult);
        Log.info("| " + new Throwable()
                .getStackTrace()[0]
                .getMethodName() + ": wait for page load after click viewResult");
        commonPage.waitForPageLoaded();
    }
}
