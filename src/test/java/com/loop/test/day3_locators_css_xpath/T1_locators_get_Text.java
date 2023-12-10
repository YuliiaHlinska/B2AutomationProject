package com.loop.test.day3_locators_css_xpath;

import com.loop.test.utilities.DocuportContains;
import com.loop.test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;

import javax.print.Doc;
/*
 * go to docuport
 * enter username
 * do NOT enter password
 * click on login button
 * verify error message - please enter password
 */
public class T1_locators_get_Text {

    public static void main(String[] args) {
        //setup the driver
        WebDriverManager.chromedriver().setup();

        //create driver object
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app");

        WebElement userNAme = driver.findElement(By.id("input-14"));
        userNAme.sendKeys(DocuportContains.USERNAME_CLIENT);

        WebElement loginButton = driver.findElement(By.className("v-btn__content"));
        loginButton.click();

        WebElement errorMessageForEmptyPassword = driver.findElement(By.className("v-meseges__messege"));
        String actualErrorMessage = errorMessageForEmptyPassword.getText();

        if(actualErrorMessage.equals(DocuportContains.ERROR_MESSAGE_FOR_EMPTY_PASSWORD)){
            System.out.println("Expected error message: " + DocuportContains.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ", matches actual error message: " + actualErrorMessage + ". Test PASSED");
        } else {
            System.out.println("Expected error message: " + DocuportContains.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ", DOES NOT match actual error message: " + actualErrorMessage);
            System.err.println("TEST FAILED");
        }





    }
}
