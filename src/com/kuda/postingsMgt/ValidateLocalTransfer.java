package com.kuda.postingsMgt;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kuda.base.TestBase;
import com.kuda.testCases.ValidateLogin;
import com.kuda.utility.Utility;

public class ValidateLocalTransfer extends TestBase{
	public ValidateLogin login;
	@Test(priority =0)
	public void verifyLocalFundTransfer() throws IOException, InterruptedException {
		login = new ValidateLogin();
		login.googleSign();
		//Details of the crediting Account
		//Click postings  management vutton
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("postingsMgtBtnXpath"))));

		driver.findElement(By.xpath(Utility.fetchLocator("postingsMgtBtnXpath"))).click();
		//Click Local Transfer
		driver.findElement(By.id(Utility.fetchLocator("localFundTransferId"))).click();
		//Enter Account nUmber
		driver.findElement(By.name(Utility.fetchLocator("accountSearchFiedName"))).sendKeys(Utility.fetchLocator("AccountNumber1Digit"));
		//Click search criteria dropdown
		Select searchDrpDwn = new Select(driver.findElement(By.xpath(Utility.fetchLocator("searchParamsDropdownXpath"))));
		searchDrpDwn.selectByVisibleText("Account Number");
		//Click Quick search button
		driver.findElement(By.xpath(Utility.fetchLocator("quickSearchBtn_Xpath"))).click();
		//click select Account button
		driver.findElement(By.xpath(Utility.fetchLocator("selectAccountBtn_Xpath"))).click();
		Thread.sleep(2000);
		//Completing Details of the debiting Account
		//Scroll down the page

		JavascriptExecutor scollDown= (JavascriptExecutor)driver;
		scollDown.executeScript("window.scrollBy(0,1000)");
		WebDriverWait sleep = new WebDriverWait(driver, 2);
		WebElement accountSearchField = sleep.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("accountSearchField2_Xpath"))));
		accountSearchField.sendKeys(Utility.fetchLocator("AccountNumber2Digit"));
		//WebElement accountSearchField = driver.findElement(By.xpath(Utility.fetchLocator("accountSearchField2_Xpath")));
		//	accountSearchField.sendKeys(Utility.fetchLocator("AccountNumber2Digit"));
		//		//select search parameters from dropDown
		Select searchDrpdwn2 = new Select(driver.findElement(By.xpath(Utility.fetchLocator("searchParamsDropdown2_XPath"))));
		searchDrpdwn2.selectByVisibleText("Account Number");
		//Click search button
		WebElement quickSearchBtn = driver.findElement(By.xpath(Utility.fetchLocator("quickSearchBtn2_xpath")));
		quickSearchBtn.click();
		Thread.sleep(2000);
		scollDown.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		//		//click select account button
		driver.findElement(By.xpath(Utility.fetchLocator("selectAccountBtn2_Xpath"))).click();
		//	scroll down	
		scollDown.executeScript("window.scrollBy(0,1000)");
		//		Enter amount
		WebElement amountField = driver.findElement(By.id(Utility.fetchLocator("localAmountField_ID")));
		amountField.clear();
		amountField.sendKeys(Utility.fetchLocator("amountDigit"));
		//Enter instrument number
		WebElement instrumentNumber = driver.findElement(By.id(Utility.fetchLocator("instrumentBumberField_ID")));
		instrumentNumber.clear();
		//Generte random uuid for instrument number
		UUID id=UUID.randomUUID(); //Generates random UUID  
		instrumentNumber.sendKeys(id.toString());

		//Enter depositor text
		WebElement depositorsField = driver.findElement(By.id(Utility.fetchLocator("depositorField_ID")));
		depositorsField.clear();
		depositorsField.sendKeys(Utility.fetchLocator("depositorText"));
		//Enter narration text
		WebElement  narration = driver.findElement(By.id(Utility.fetchLocator("narrationField_ID")));
		narration.clear();
		narration.sendKeys(Utility.fetchLocator("narrationText"));
		//scroll 
		scollDown.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		//Click post transaction button
		WebElement postTransactionBtn = driver.findElement(By.xpath(Utility.fetchLocator("postTransactionBtn_XPATH")));
		Actions actions = new Actions(driver);
		actions.moveToElement(postTransactionBtn).click().perform();
		Thread.sleep(2000);
		click("yesPostTransactionBtn_ID");
		String postingsResponse = 	getText("postingSuccessMsg_XPATH");
		String ExpectedResult ="Transaction successful";
		//The need to validate the success message  
		assertTrue(postingsResponse.contains(ExpectedResult));
		System.out.println(postingsResponse);



	}


}
