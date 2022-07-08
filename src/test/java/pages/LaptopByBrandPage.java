package pages;

import commons.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LaptopByBrandPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private CommonPage commonPage;

    By brandOption = By.xpath("//span[contains(text(),'Hãng')]");
    //    By brandFilterBox = By.xpath("(//div[@class='filter-show'])[1]");
    By brandFilterBox = By.xpath("(//div[starts-with(@class,'filter-show')])[2]");
    By macBookOption = By.xpath("(//img[@alt='MacBook'])[2]");
    //    By macBookOption = By.xpath("(//img[contains(@alt='MacBook')])[2]");
    //    By asusOption = By.xpath("(//img[@alt='Asus'])[2]");
    By asusOption = By.xpath("//div[3]/div[2]/div/a[2]/img");
    By hpOption = By.xpath("(//img[@alt='HP'])[2]");
    By lenovoOption = By.xpath("(//img[@alt='Lenovo'])[2]");
    By acerOption = By.xpath("(//img[@alt='Acer'])[2]");
    By dellOption = By.xpath("(//img[@alt='Dell'])[2]");
    By msiOption = By.xpath("(//img[@alt='MSI'])[2]");
    By surfaceOption = By.xpath("(//img[@alt='Surface'])[2]");
    By lgOption = By.xpath("(//img[@alt='LG'])[2]");
    By gigabyteOption = By.xpath("(//img[@alt='GIGABYTE'])[2]");
    By intelOption = By.xpath("(//img[@alt='Intel'])[2]");
    By itelOption = By.xpath("(//img[@alt='itel'])[2]");
    By chuwiOption = By.xpath("(//img[@alt='Chuwi'])[2]");
    By viewResult = By.xpath("(//a[@href='#'])[1]");
    //    By viewResult = By.xpath("(//a[contains(@href, '#')])[2]");
    //    By viewResult = By.xpath("//div[3]/div[2]/div[2]/a[2]");

    public LaptopByBrandPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        commonPage = new CommonPage(driver);
    }

    public void selectByBrand(String brandName) throws InterruptedException {
        commonPage.clickElement(brandOption);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(brandFilterBox)));
        switch (brandName.trim().toLowerCase()) {
            case "macbook":
                commonPage.clickElement(macBookOption);
                break;
            case "asus":
                commonPage.clickElement(asusOption);
                break;
            case "hp":
                commonPage.clickElement(hpOption);
                break;
            case "lenovo":
                commonPage.clickElement(lenovoOption);
                break;
            case "acer":
                commonPage.clickElement(acerOption);
                break;
            case "dell":
                commonPage.clickElement(dellOption);
                break;
            case "msi":
                commonPage.clickElement(msiOption);
                break;
            case "surface":
                commonPage.clickElement(surfaceOption);
                break;
            case "lg":
                commonPage.clickElement(lgOption);
                break;
            case "gigabyte":
                commonPage.clickElement(gigabyteOption);
                break;
            case "intel":
                commonPage.clickElement(intelOption);
                break;
            case "itel":
                commonPage.clickElement(itelOption);
                break;
            case "chuwi":
                commonPage.clickElement(chuwiOption);
                break;
        }
        commonPage.clickElement(viewResult);
        commonPage.waitForPageLoaded();
    }
}