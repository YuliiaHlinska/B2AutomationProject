package com.loop.test.utilities;

import org.openqa.selenium.WebDriver;
import java.util.Set;
import static org.testng.Assert.*;

public class BrowserUtils {

    /**
     * validate if driver switched to expected url and titile
     * param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author Yuliia Hlinska
     * implements assertion
     */

    public static void switchwindowandvalidate (WebDriver driver, String expectedUrl, String expectedTitle){
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();
        Set <String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles){
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }
        }
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    }

