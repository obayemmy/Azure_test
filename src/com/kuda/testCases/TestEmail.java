package com.kuda.testCases;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.kuda.base.TestBase;
import com.kuda.utility.Utility;

public class TestEmail extends TestBase{
	ValidateLogin login;
	@Test
	public void search() throws InterruptedException, IOException {
		login = new ValidateLogin();
		login.googleSign();
		WebDriverWait customerAcctMgtBtn = new WebDriverWait(driver, 5);
		customerAcctMgtBtn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("customerAccountMgtBtnXpath"))));
		driver.findElement(By.xpath(Utility.fetchLocator("customerAccountMgtBtnXpath"))).click();
		//Click savings button
		WebElement viewSavingsBtn = driver.findElement(By.xpath(Utility.fetchLocator("viewSavingsAccountBtnXpath")));
		viewSavingsBtn.click();
		Thread.sleep(2000);

		WebElement searchAccountName = driver.findElement(By.id(Utility.fetchLocator("searchField_ID")));
		// random email Generate 
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(100000);  
		searchAccountName.sendKeys("username"+ randomInt +"@gmail.com"); 
		Thread.sleep(20000);  
		searchAccountName.clear();
		UUID id=UUID.randomUUID(); //Generates random UUID  
		searchAccountName.sendKeys(id.toString());
		//   searchAccountName.sendKeys("12" + UUID.randomUUID().toString());
		//	        UUID id=UUID.randomUUID(); //Generates random UUID  
		//	        int id = ;
		//	        searchAccountName.sendKeys(uuid);

		Thread.sleep(20000);

	}



}
