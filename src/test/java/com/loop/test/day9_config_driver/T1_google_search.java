package com.loop.test.day9_config_driver;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class T1_google_search {

    /*
    go to "https://www.google.com/"
    write "Loop Academy" ans search
    validate title: Loop Academy - Google Search

     */

    @Test
    public void google_search(){

        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        searchBox.sendKeys("Loop Academy" + Keys.ENTER);
        assertEquals(Driver.getDriver().getTitle(), "Loop Academy - Google Search");

    }

    @Test
    public void docuport_search() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) Driver.getDriver()).getSessionId());
        DocuportUtils.login(Driver.getDriver(), "advisor");
        WebElement myUploads = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'My ')]"));
        myUploads.click();


    }
}
