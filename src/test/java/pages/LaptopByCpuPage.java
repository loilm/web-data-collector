package pages;

import commons.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LaptopByCpuPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private CommonPage commonPage;
    By cpuOption = By.xpath("//span[contains(text(),'CPU')]");
    By filterBox = By.xpath("//div[@propertyid='6241']/div[@class='filter-show']");
    By i7Option = By.xpath("//div[@propertyid='6241']/div[2]/div[1]/a[1]");
    By viewResult = By.xpath("//div[@propertyid='6241']/div[2]/div[2]/a[2]");

    public LaptopByCpuPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        commonPage = new CommonPage(driver);
    }

    public void selectByCpu(String cpuName) throws InterruptedException {
        commonPage.clickElement(cpuOption);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(filterBox)));
        switch (cpuName.trim().toLowerCase()) {
            case "i7":
                commonPage.clickElement(i7Option);
                break;
        }
        commonPage.clickElement(viewResult);
        commonPage.waitForPageLoaded();
    }

}
