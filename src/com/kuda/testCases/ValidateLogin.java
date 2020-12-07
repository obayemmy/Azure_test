package com.kuda.testCases;

import java.io.IOException;

import com.kuda.utility.Log;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.kuda.base.TestBase;
import com.kuda.utility.Utility;


public class ValidateLogin extends TestBase {

    @Test(description = "This TestCase will perform valid login")
    public void googleSign() throws InterruptedException, IOException {

//		WebElement signInBtn = 	driver.findElement(By.xpath(Utility.fetchLocator("googleSignBtn")));
//		signInBtn.click();

//		WebDriverWait customerAcctMgtBtn= new WebDriverWait(driver, 30);
//		customerAcctMgtBtn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("googleSignBtn"))));
//		WebElement signInBtn = 	driver.findElement(By.xpath(Utility.fetchLocator("googleSignBtn")));
//     	signInBtn.click();
        click("googleSignBtn_XPATH");
        String mainWindowHandle = driver.getWindowHandle();
        for (String childWindowHandle : driver.getWindowHandles()) {
            //If window handle is not main window handle then close it
            if (!childWindowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(childWindowHandle);
                // Close child windows
            }
        }
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        //Enter Email Address
        type("googleEmailField_ID", "emailAddressText");
        //Click Next Button
        click("nextButton_XPATH");
        //Enter Password
        chooseElement("passwordField_XPATH").clear();
        type("passwordField_XPATH", "passwordText");
        chooseElement("passwordField_XPATH").sendKeys(Keys.ENTER);
        Log.captureScreenshot(driver,"The test failed");
        Thread.sleep(2000);
        //switch to Main Window
        driver.switchTo().window(mainWindowHandle);
        System.out.println(driver.getTitle());
        //	System.out.println(driver.getTitle());
        Reporter.log("Login Test Completed Successfully", true);


    }
}
