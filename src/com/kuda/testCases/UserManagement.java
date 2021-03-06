package com.kuda.testCases;

import com.kuda.base.TestBase;
import com.kuda.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserManagement extends TestBase{
	public ValidateLogin login ;
	@Test(priority=1)
	public void viewUsers() throws IOException, InterruptedException {
		login = new ValidateLogin();
		try {
			login.googleSign();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement userMgtBtn = driver.findElement(By.xpath(Utility.fetchLocator("userManagementBtn_ID")));
		js.executeScript("arguments[0].scrollIntoView();", userMgtBtn);
		String userText =userMgtBtn.getText();
		Assert.assertEquals(userText, "User Management", "The right text is not on the button");
		userMgtBtn.click();
		System.out.println(userText);
		//click view user
		WebElement viewUser = driver.findElement(By.xpath(Utility.fetchLocator("viewUserBtn_XPATH")));
		viewUser.click();
	}
	@Test(priority=2)
	public void searchUsersByUserName() throws IOException, InterruptedException {
		//search text
		WebElement searchField = driver.findElement(By.id(Utility.fetchLocator("userSearchField_ID")));
		searchField.sendKeys(Utility.fetchLocator("usernameSearchText"));
		//search parameter
		Select searchCriteria = new Select(driver.findElement(By.id(Utility.fetchLocator("searchParamsField_ID"))));
		searchCriteria.selectByVisibleText("Username");
		//click search button
		WebElement searchBtn = driver.findElement(By.id(Utility.fetchLocator("userSearchBtn_ID")));
		searchBtn.click();
		Thread.sleep(2000);
	}
	@Test(priority =3)
	public void searchUserByDesignation() throws IOException, InterruptedException {
		WebElement searchField = driver.findElement(By.id(Utility.fetchLocator("userSearchField_ID")));
		searchField.clear();
		searchField.sendKeys(Utility.fetchLocator("userDesignationSearchText"));
		//search parameter
		Select searchCriteria = new Select(driver.findElement(By.id(Utility.fetchLocator("searchParamsField_ID"))));
		searchCriteria.selectByVisibleText("Designation");
		//Click seaarch button
		WebElement searchBtn = driver.findElement(By.id(Utility.fetchLocator("userSearchBtn_ID")));
		searchBtn.click();
		//Verify Search Result
		String searchResult = driver.findElement(By.xpath(Utility.fetchLocator("userDesignationSearchResult_XPATH"))).getText();
		Assert.assertTrue(searchResult.contains("Orok"));
		Thread.sleep(2000);
		}
	@Test(priority = 4)
	public void searchUserByPhoneNumber() throws IOException, InterruptedException {
		//Enter search text
		WebElement searchField = driver.findElement(By.id(Utility.fetchLocator("userSearchField_ID")));
		searchField.clear();
		searchField.sendKeys(Utility.fetchLocator("userPhoneNumberSearchText"));
		//search parameter
		Select searchCriteria = new Select(driver.findElement(By.id(Utility.fetchLocator("searchParamsField_ID"))));
		searchCriteria.selectByVisibleText("Phone Number");
		//Click seaarch button
		WebElement searchBtn = driver.findElement(By.id(Utility.fetchLocator("userSearchBtn_ID")));
		searchBtn.click();
		//Validate Result
		String phoneNumber = driver.findElement(By.xpath(Utility.fetchLocator("userPhoneNumberSearchResult_XPATH"))).getText();
		Assert.assertEquals(phoneNumber, "Gabriel");
		Thread.sleep(2000);
	}
	@Test(priority = 5)
	public void searchUserByEmployeeNumber() throws IOException, InterruptedException {
		WebElement searchField = driver.findElement(By.id(Utility.fetchLocator("userSearchField_ID")));
		searchField.clear();
		searchField.sendKeys(Utility.fetchLocator("userEmployeeNumberSearchText"));
		//search parameter
		Select searchCriteria = new Select(driver.findElement(By.id(Utility.fetchLocator("searchParamsField_ID"))));
		searchCriteria.selectByVisibleText("Employee Number");
		//Click seaarch button
		WebElement searchBtn = driver.findElement(By.id(Utility.fetchLocator("userSearchBtn_ID")));
		searchBtn.click();
		//Validate search result
		String result = driver.findElement(By.xpath(Utility.fetchLocator("userEmployeeNumberSearchResult_XPATH"))).getText();
		Assert.assertTrue(result.contains("Mustapha"));
		Thread.sleep(2000);
	}
	@Test(priority=6)
	public void searchUserByEmail() throws IOException, InterruptedException {
		WebElement searchField = driver.findElement(By.id(Utility.fetchLocator("userSearchField_ID")));
		searchField.clear();
		searchField.sendKeys(Utility.fetchLocator("userEmilSearchText"));
		//search parameter
		Select searchCriteria = new Select(driver.findElement(By.id(Utility.fetchLocator("searchParamsField_ID"))));
		searchCriteria.selectByVisibleText("Email Address");
		//Click seaarch button
		WebElement searchBtn = driver.findElement(By.id(Utility.fetchLocator("userSearchBtn_ID")));
		searchBtn.click();
		//Validate search result
		String result = driver.findElement(By.xpath(Utility.fetchLocator("userEmployeeNumberSearchResult_XPATH"))).getText();
		Assert.assertTrue(result.contains("Mustapha"));
		Thread.sleep(2000);
	}
	@Test(priority=7)
	public void searchUserBylastName(){

	}
	@Test(priority=8)
	public void editUser(){

	}
	@Test(priority=9)
	public void createUser(){

	}

}
