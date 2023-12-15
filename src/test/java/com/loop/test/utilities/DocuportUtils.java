package com.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.InputMismatchException;

public class DocuportUtils {

    /**
     * logins to docuport application
     *
     * @param driver, which initialized at TestBase
     * @param role,   comes from docuport constans
     * @author Yuliia Hlinska
     */

    public static void login(WebDriver driver, String role) throws InterruptedException {
        driver.get("https://beta.docuport.app/");
        WebElement username = driver.findElement(By.xpath("//label[contains(text(), 'Username or email')]/following-sibling::input"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        switch (role.toLowerCase()) {
            case "client":
                username.sendKeys(DocuportContains.USERNAME_CLIENT);
                password.sendKeys(DocuportContains.PASSWORD);
                break;
            case "supervisor":
                username.sendKeys(DocuportContains.USERNAME_SUPERVISOR);
                password.sendKeys(DocuportContains.PASSWORD);
                break;
            case "advisor":
                username.sendKeys(DocuportContains.USERNAME_ADVISOR);
                password.sendKeys(DocuportContains.PASSWORD);
                break;
            case "employee":
                username.sendKeys(DocuportContains.USERNAME_EMPLOYEE);
                password.sendKeys(DocuportContains.PASSWORD);
                break;
            default:
                throw new InputMismatchException("There is not such a role" + role);

        }

        loginButton.click();

        if (role.toLowerCase().equals("client")) {
            Thread.sleep(3000);
            WebElement cont = driver.findElement(By.xpath("//button[@type='submit']"));
            cont.click();
            Thread.sleep(3000);
        }
    }

    /**
     * logs out from the application
     * @param driver
     * @author Yullia Hlinska
     */
    public static void logOut(WebDriver driver){
        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement logOut = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}

