package com.loop.test.day8_windowtables_config;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportContains;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.DocuportWebtableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class T1_webTables extends TestBase {
        /*
    1. login as an advisor
    2. go to users
    3. validate that full name for alex.de.souza@gmail.com is Alex De Souza
    4. validate that user name for alex.de.souza@gmail.com is alexdesouze
    5. validate that phone number for alex.de.souza@gmail.com is +994512060042
    6. validate that role for alex.de.souza@gmail.com is client
    7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
     */

    @Test
    public void test_webTables() throws InterruptedException {
        DocuportUtils.login(driver, DocuportContains.ADVISOR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement users = driver.findElement(By.xpath("//span[contains(text(), 'Users')]"));
        users.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String expectedFullname = "Alex De Souza";
        String actualFullName = DocuportWebtableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Full name" );
        System.out.println("actualFullName = " + actualFullName);

        Assert.assertEquals(actualFullName, expectedFullname, "TEST #001 FAILED !" + actualFullName + " NOT MATCHING WITH " + expectedFullname);

        String expectedUserName = "alexdesouze";
        String actualUserName = DocuportWebtableUtils.returnAnyField(driver,"alex.de.souza@gmail.com", "username");
        assertEquals(actualUserName,expectedUserName,"Actual does not match expected");


    }



}
