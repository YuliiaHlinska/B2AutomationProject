package com.loop.test.day5_testNG_checkbox_radioButton_dropdown;
import com.google.common.annotations.VisibleForTesting;

import com.loop.test.utilities.DocuportContains;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import java.time.Duration;

public class T6_dropdown_without_select {
       /*
    1. login as an advisor
    2. go to received document
    3. click search
    4. click status dropdown
    5. choose in progress
     */

    WebDriver driver;


    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public void testDropdown() throws InterruptedException {
        WebElement userName = driver.findElement(By.xpath("//input[@id='input-14']"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));

        userName.sendKeys(DocuportContains.USERNAME_ADVISOR);
        password.sendKeys(DocuportContains.PASSWORD_ADVISOR);

        login.click();
        WebElement receivedDocuments = driver.findElement(By.xpath("//span[.='Received docs']"));
        receivedDocuments.click();

        WebElement searchButton = driver.findElement(By.xpath("//span[contains(text(),'Search')]"));
        searchButton.click();

        WebElement statusButton = driver.findElement(By.xpath("(//label[.='Status']/../div/following-sibling::div)[2]"));
        statusButton.click();

        Thread.sleep(3000);
        WebElement inProgress = driver.findElement(By.xpath("//div[contains(text(),'In progress')]"));
        inProgress.click();



    }


}

