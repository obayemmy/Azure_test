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
	//WebDriverWait wait;
	
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
	public void searchUsersByUserName() throws IOException {
		//search text
		WebElement searchField = driver.findElement(By.id(Utility.fetchLocator("userSearchField_ID")));
		searchField.sendKeys(Utility.fetchLocator("usernameSearchText"));
		//search parameter
		Select searchCriteria = new Select(driver.findElement(By.id(Utility.fetchLocator("searchParamsField_ID"))));
		searchCriteria.selectByVisibleText("Username");
		//click search button
		WebElement searchBtn = driver.findElement(By.id(Utility.fetchLocator("userSearchBtn_ID")));
		searchBtn.click();
	}
	@Test(priority =3)
	public void searchUserByDesignation() throws IOException {
		WebElement searchField = driver.findElement(By.id(Utility.fetchLocator("userSearchField_ID")));
		searchField.clear();
		searchField.sendKeys(Utility.fetchLocator("userDesignationSearchText"));
		//search parameter
		Select searchCriteria = new Select(driver.findElement(By.id(Utility.fetchLocator("searchParamsField_ID"))));
		searchCriteria.selectByVisibleText("Designation");
		//Click seaarch button
		WebElement searchBtn = driver.findElement(By.id(Utility.fetchLocator("userSearchBtn_ID")));
		searchBtn.click();
		}
	@Test(priority = 3)
	public void searchUserByPhoneNumber() {
		//driver.navigate().back();
	}
	@Test(priority = 4)
	public void searchUserByEmployeeNumber(){

	}
	@Test(priority=5)
	public void searchUserByEmail(){

	}
	@Test(priority=6)
	public void searchUserBylastName(){

	}

}
