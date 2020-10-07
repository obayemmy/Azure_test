package com.kuda.testCases;

import com.kuda.base.TestBase;
import com.kuda.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GeneralLedgerManagement extends TestBase {
    public ValidateLogin login;
    @Test(priority=1)
    public void viewGLAccounts() throws IOException, InterruptedException {
        login = new ValidateLogin();
        login.googleSign();
        //Click  General Ledger Management Button
        WebElement glManagementlBtn = driver.findElement(By.xpath(Utility.fetchLocator("generalLedgerMgtBtn_XPATH")));
        glManagementlBtn.click();
        // Click view GL accounts button
        WebElement viewGlBtn = driver.findElement(By.id(Utility.fetchLocator("viewLedgerAccountsBtn_ID")));
        viewGlBtn.click();
    }
    @Test(priority=2)
    public void searchGLByName() throws IOException, InterruptedException {
        //Enter text into search field
        WebElement searchField1 = driver.findElement(By.xpath(Utility.fetchLocator("searchGLAccountField_XPATH")));
        searchField1.sendKeys(Utility.fetchLocator("glSearchByNameText"));
        //Select search parameter
        Select searchParameterDropdown1 = new Select(driver.findElement(By.xpath(Utility.fetchLocator("glAccountSearchParamDrpdwn_XPATH"))));
        searchParameterDropdown1.selectByVisibleText("Name");
        //Select secondary Category
        Select secondaryCategory1 = new Select(driver.findElement(By.id(Utility.fetchLocator("secondaryCategoryDrpdwnField_ID"))));
        secondaryCategory1.selectByVisibleText("Plant And Machinery");
        //Select Primary Category
        Select primaryCategory1 = new Select(driver.findElement(By.xpath(Utility.fetchLocator("primaryCategoryDrpdwnField_XPATH"))));
        primaryCategory1.selectByVisibleText("Assets");
        //Click search button
        WebElement searchBtn = driver.findElement(By.xpath(Utility.fetchLocator("gLSearchBtn_XPATH")));
        searchBtn.click();
        Thread.sleep(2000);
        //Validate the expected result is displayed
        String glNameSearchResult = driver.findElement(By.xpath(Utility.fetchLocator("glNameSearchResult_XPATH"))).getText();
        Assert.assertEquals(glNameSearchResult,"Generator");
    }

    @Test(priority=3)
    public void searchGLByCode() throws IOException, InterruptedException {
        //Enter text into search field
        WebElement searchField = null;
        try {
            searchField = driver.findElement(By.xpath(Utility.fetchLocator("searchGLAccountField_XPATH")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        searchField.clear();
        searchField.sendKeys(Utility.fetchLocator("glSearchByCodeText"));
        //Select search parameter
        Select searchParameterDropdown = new Select(driver.findElement(By.xpath(Utility.fetchLocator("glAccountSearchParamDrpdwn_XPATH"))));
        searchParameterDropdown.selectByVisibleText("Code");
        //Select secondary Category
        Select secondaryCategory = new Select(driver.findElement(By.id(Utility.fetchLocator("secondaryCategoryDrpdwnField_ID"))));
        secondaryCategory.selectByVisibleText("Plant And Machinery");
        //Select Primary Category
        Select primaryCategory = new Select(driver.findElement(By.xpath(Utility.fetchLocator("primaryCategoryDrpdwnField_XPATH"))));
        primaryCategory.selectByVisibleText("Assets");
        //Click search button
        WebElement searchBtn = driver.findElement(By.xpath(Utility.fetchLocator("gLSearchBtn_XPATH")));
        searchBtn.click();
        Thread.sleep(2000);
        //Validate the expected result is displayed
        String glNameSearchResult = driver.findElement(By.xpath(Utility.fetchLocator("glNameSearchResult_XPATH"))).getText();
        Assert.assertEquals("Generator", glNameSearchResult);
        System.out.println("Test completed successfully");
        Thread.sleep(2000);
    }
    @Test(priority=4)
    public void  viewGLBalance() throws IOException, InterruptedException {
        //Click Balance button
        WebElement viewBalance = driver.findElement(By.xpath(Utility.fetchLocator("glBalanceBtn_XPATH")));
        viewBalance.click();
        //Print out the balance
        String balance = driver.findElement(By.xpath(Utility.fetchLocator("accountBalanceDigit_XPATH"))).getText();
                System.out.println(balance);
                Thread.sleep(2000);
                WebElement closeBalance = driver.findElement(By.xpath(Utility.fetchLocator("closeglBalanceModalBtn_XPATH")));
                closeBalance.click();
    }
    @Test(priority=5)
    public void editGeneralLedgerAccount(){
        System.out.println("edit");
    }

}
