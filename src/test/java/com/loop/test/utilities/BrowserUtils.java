package com.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import static org.testng.Assert.*;

public class BrowserUtils {

    /**
     * validate if driver switched to expected url and titile
     * param driver
     *
     * @param expectedUrl
     * @param expectedTitle
     * @author Yuliia Hlinska
     * implements assertion
     */

    public static void switchwindowandvalidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * swithches to the new window by the exact title
     * return to original window if the window with given title not found
     *
     * @param driver
     * @param targetTitle
     */

    public static void switchToWindow(WebDriver driver, String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targetTitle)) {
                return;

            }
        }
        driver.switchTo().window(origin);

    }

    /**
     * @param driver
     * @param expectedTitle return void, assertion is implemented
     * @author Yuliia
     */
    public static void validateTitle(WebDriver driver, String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains(expectedTitle));

        //assertTrue(driver.getTitle().contains(expectedTitle));
    }

    /**
     * Click any link from Loop practive
     *
     * @param nameOfPage
     * @author Yuliia
     */

    public static void loopLinkClick(String nameOfPage) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='" + nameOfPage + "']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    /**
     * Moves the mouse to given element
     *
     * @param element on which to hover
     * @author Yuliia
     */

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();

    }

    /**
     * Acrolls down to an element using LavaScript
     *
     * @param element
     * @author Yuliia
     */

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     * @author Yuliia
     */

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Performs double click action on an element
     *
     * @param element
     * @author Yuliia
     */

    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Waits for the provided element to be visible on the page
     *
     * @param element
     * @param timeTowaitInSec
     * @return
     * @aythor Yuliia
     */

    public static WebElement waitForVisibility(WebElement element, int timeTowaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeTowaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for the provided element to be invisible on the page
     *
     * @param element
     * @param timeToWaitInSec
     * @return
     * @author Yuliia
     */

    public static void waitForInVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Waits for provided element to be clickable
     * @param element
     * @param timeout
     * @return
     * @author Yuliia
     */
    public static WebElement waitForClickable (WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * permorms a pause
     * @param seconds
     *
     * @author Yuliia
     */

    public static void justWait(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

















}













