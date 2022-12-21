package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.Log;

import java.time.Duration;

public class CommonPage {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static final int timeForPageLoad = 30;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getText(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText().trim();
    }

    public void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
        Log.info("| " + new Throwable().getStackTrace()[0].getMethodName() + ": " + locator);
    }

    public void clickElementWithJS(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement webElement = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);
        Log.info("| " + new Throwable().getStackTrace()[0].getMethodName() + ": " + locator);
    }

    public static void waitForPageLoaded() {
        // wait for jQuery to loaded
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long) ((JavascriptExecutor) driver)
                        .executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                return true;
            }
        };

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .toString().equals("complete");

        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(timeForPageLoad));
            Log.info("| Wait for page load");
            wait.until(jQueryLoad);
            wait.until(jsLoad);
        } catch (Throwable error) {
            Log.warn("| Wait for page load FAIL: " + error.getMessage());
        }
        /*Scroll to the bottom*/
        Log.info("| Scroll to the bottom");
        ((JavascriptExecutor)
                driver).executeScript ("window.scrollTo( 0, document.body.scrollHeight)");
    }
}
