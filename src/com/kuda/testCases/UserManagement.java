package com.kuda.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kuda.base.TestBase;
import com.kuda.utility.Utility;

public class UserManagement extends TestBase{
	public ValidateLogin login ;
	WebDriverWait wait;
	
	@Test(priority=0)
	public void sign() throws IOException, InterruptedException {
		login = new ValidateLogin();
		login.googleSign();
	
		try {
			login.googleSign();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		WebElement signInBtn = 	driver.findElement(By.xpath(Utility.fetchLocator("googleSignBtn")));
//		signInBtn.click();
//		
//		String mainWindowHandle = driver.getWindowHandle();
//		for (String childWindowHandle : driver.getWindowHandles()) {
//			//If window handle is not main window handle then close it 
//			if(!childWindowHandle.equals(mainWindowHandle)){
//				driver.switchTo().window(childWindowHandle);
//				// Close child windows
//			}
//		} 
//		System.out.println(driver.getCurrentUrl());
//		System.out.println(driver.getTitle());
//		//Enter Email Address
//		driver.findElement(By.id(Utility.fetchLocator("googleEmailField"))).sendKeys(Utility.fetchLocator("emailAddressText"));
//		//Click Next Button
//		driver.findElement(By.xpath(Utility.fetchLocator("nextButton"))).click();
//		//Enter Password
//		WebElement passField=driver.findElement(By.xpath(Utility.fetchLocator("passwordField")));
//		passField.sendKeys(Utility.fetchLocator("passwordText"));
//		passField.sendKeys(Keys.ENTER);
//		Thread.sleep(9000);
//		//switch to Main Window
//		driver.switchTo().window(mainWindowHandle);
//		Thread.sleep(2000);
//		System.out.println(driver.getTitle());		
	}
	@Test(priority=1)
	public void viewUsers() throws InterruptedException, IOException {
//		login = new ValidateLogin();
//		login.googleSign();
		//	wait = new WebDriverWait(driver, 15);
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("userManagementBtn"))));
		WebElement userMgtBtn = driver.findElement(By.xpath(Utility.fetchLocator("userManagementBtn")));
		String userText =userMgtBtn.getText();
		Assert.assertEquals(userText, "User Management");
		userMgtBtn.click();
		System.out.println(userText);

		Thread.sleep(4000);
	}

	@Test(priority=2)
	public void searchUsers() throws IOException {
		//Click view Users
		driver.findElement(By.xpath(Utility.fetchLocator("viewUserBtn"))).click();
		WebElement searchText = driver.findElement(By.xpath(Utility.fetchLocator("searchTextResult")));
		String userVerifiy = searchText.getText();
		System.out.println(userVerifiy);
		Assert.assertEquals(userVerifiy, "Testuser");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Utility.fetchLocator("searchField"))));
		WebElement search =	driver.findElement(By.id(Utility.fetchLocator("searchField")));
		search.sendKeys(Utility.fetchLocator("searchText"));
		Select params = new Select(driver.findElement(By.xpath(Utility.fetchLocator("searchParamsField"))));
		params.selectByVisibleText("Username");
		WebElement searchBtn =driver.findElement(By.id(Utility.fetchLocator("searchBtn")));
		searchBtn.click();
		//Assert search result
		WebDriverWait chill = new WebDriverWait(driver, 15);
		chill.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("verifyingResult"))));
		WebElement checkResult = driver.findElement(By.xpath(Utility.fetchLocator("verifyingResult")));
		String resultz = checkResult.getText();
		//boolean result = checkResult.isDisplayed();

		if(resultz.contains("Walex")) {
			System.out.println("Result is valid");
		}else {
			System.out.println("Result not valid");
		}
	}

	@Test
	public void createUser() {
		driver.navigate().back();
	}

}
