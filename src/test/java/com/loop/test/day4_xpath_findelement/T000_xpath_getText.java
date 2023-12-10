package com.loop.test.day4_xpath_findelement;

import com.loop.test.utilities.DocuportContains;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T000_xpath_getText {
         /*
    1. Open Chrome browser
    2. Go to docuport
    3. Click on forgot password
    4. validate URL contains: reset-password
    5. validate - Enter the email address associated with your account
    6. enter forgotpasswordg1@gmail.com to email box
    7. validate cancel button is displayed
    8. validate send button is displayed
    9. click send button
    10. validate - We've sent you an email with a link to reset your password. Please check your email
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app/");

        //3. Click on forgot password
        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgotPassword.click();

        //4. validate URL contains: reset-password
        String actualUrlForResetPassword = driver.getCurrentUrl();

        if(actualUrlForResetPassword.contains(DocuportContains.RESET_PASSWORD_URL)){
            System.out.println("TEST PASS: => Actual url: " + actualUrlForResetPassword + " contains expected url: " + DocuportContains.RESET_PASSWORD_URL);
        } else {
            System.out.println("TEST FAIL: => Actual url: " + actualUrlForResetPassword + " does not contain expected url: " + DocuportContains.RESET_PASSWORD_URL);

        }

        //5. validate - Enter the email address associated with your account

        WebElement validateMesage = driver.findElement(By.xpath("//div[@class ='v-messages__message']"));
        String actualValidateMessage = validateMesage.getText();

        if(actualValidateMessage.contains(DocuportContains.RESET_PASSWORD_MESSAGE)){
            System.out.println("TEST PASS: => Actual validate message: \""+actualValidateMessage+"\" contains expected message \""+DocuportContains.RESET_PASSWORD_MESSAGE);
        }else {
            System.out.println("TEST FAIL: => Actual validate message: \""+actualValidateMessage+"\" doesnt contains expected message \""+DocuportContains.RESET_PASSWORD_MESSAGE);

        }

        //6. enter forgotpasswordg1@gmail.com to email box

        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@id,'input-')]"));
        //   WebElement emailInputBox = driver.findElement(By.xpath("//input[starts-with(@id,'input-')]")); with starts-with
        emailInputBox.sendKeys(DocuportContains.EMAIL_FOR_RESET_PASSWORD);

        //7. validate cancel button is displayed
        WebElement cancelButton = driver.findElement(By.xpath("//span[text()=' Cancel ']")); //xpath by text ??tagname[text()='text']
        //    WebElement cancelButton = driver.findElement(By.xpath("//span[normalize-space() = 'Cancel']")); // xpath bty texy=t - sensitive space

        if(cancelButton.isDisplayed()){
            System.out.println("TEST PASS => Send button is displayed");
        } else {
            System.err.println("TEST FAILED => Send button is NOT displayed");
        }

        // 8. validate send button is displayed
        WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space() = 'Send']"));
        if(sendButton.isDisplayed()){
            System.out.println("TEST PASS => Send button is displayed");
        } else {
            System.err.println("TEST FAILED => Send button is NOT displayed");
        }

        //9. click send button
        sendButton.click();
        Thread.sleep(5000);


        //10. validate - We've sent you an email with a link to reset your password. Please check your email

        WebElement successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));
        Thread.sleep(10000);

        try{
            System.out.println(successMessage.getText());
        } catch (StaleElementReferenceException e){
            System.out.println("Element is not there anymore");
           // e.printStackTrace();
        }

    }
}
