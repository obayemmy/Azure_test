/**
 * 
 */
package com.kuda.testCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kuda.base.TestBase;
import com.kuda.utility.Utility;

public class CustomerInfoManagement  extends TestBase{
	public ValidateLogin login;
	@Test(priority=1)
	public void viewCustomers() throws IOException, InterruptedException {
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
		driver.findElement(By.xpath(Utility.fetchLocator("customerInfoMgtBtnXpath"))).click();
		driver.findElement(By.xpath(Utility.fetchLocator("viewCustomerXpath"))).click();
		Thread.sleep(2000);
		//driver.findElement(By.id(Utility.fetchLocator("quickSearchBtnId"))).click();
		Thread.sleep(3000);
	}

	@Test(priority =2)
	public void searchCustomerByName() throws IOException, InterruptedException {
		WebElement searchField=	driver.findElement(By.id(Utility.fetchLocator("searchFieldId")));
		searchField.sendKeys(Utility.fetchLocator("searchCustomerText"));
		Select searchParams = new Select(driver.findElement(By.id(Utility.fetchLocator("searchParameterDrpDwnId"))));
		searchParams.selectByVisibleText("Last Name");
		driver.findElement(By.id(Utility.fetchLocator("quickSearchBtnId"))).click();
		String result = "OLUGBENGA GABRIEL";
		driver.getPageSource().contains(result);
		Assert.assertEquals(result, "OLUGBENGA GABRIEL");
		Thread.sleep(3000);
	}
	@Test(priority=3)
	public void searchByCustomerEmail() throws IOException, InterruptedException {
		WebElement searchFieldEmail=driver.findElement(By.id(Utility.fetchLocator("searchFieldId")));
		searchFieldEmail.clear();
		searchFieldEmail.sendKeys(Utility.fetchLocator("searchByEmailText"));
	
		Select searchParamsEmail = new Select(driver.findElement(By.id(Utility.fetchLocator("searchParameterDrpDwnId"))));
		searchParamsEmail.selectByVisibleText("Email Address");
		driver.findElement(By.id(Utility.fetchLocator("quickSearchBtnId"))).click();
		Thread.sleep(3000);
		
		
	}
	@Test(priority=4)
	public void searchCustomerById() throws IOException, InterruptedException {
		WebElement searchFieldID=driver.findElement(By.id(Utility.fetchLocator("searchFieldId")));
		searchFieldID.clear();
		searchFieldID.sendKeys(Utility.fetchLocator("searchByIDText"));
	
		Select searchParamsID = new Select(driver.findElement(By.id(Utility.fetchLocator("searchParameterDrpDwnId"))));
		searchParamsID.selectByVisibleText("Customer Id");
		driver.findElement(By.id(Utility.fetchLocator("quickSearchBtnId"))).click();
		Thread.sleep(3000);

	}
	@Test(priority=5)
	public void createCustomer() throws IOException, InterruptedException {
		driver.findElement(By.xpath(Utility.fetchLocator("createCustomerBtnXpath"))).click();
		//Thread.sleep(2000);
		//Click title button
		Select titleDrpdwn = new Select(driver.findElement(By.id(Utility.fetchLocator("titleField_ID"))));
		titleDrpdwn.selectByVisibleText("Prof.");
		//Enter Lastname 
		WebElement lastNameField = driver.findElement(By.id(Utility.fetchLocator("lastName_ID")));
		lastNameField.sendKeys(Utility.fetchLocator("lastNameText"));
		//Enter Other Name
		WebElement otherNameField = driver.findElement(By.id(Utility.fetchLocator("otherNameField_ID")));
		otherNameField.sendKeys(Utility.fetchLocator("otherNameText"));
		//Thread.sleep(2000);
		//Enter House Address
		WebElement houseAddField = driver.findElement(By.id(Utility.fetchLocator("houseAdress_ID")));
		houseAddField.sendKeys(Utility.fetchLocator("houseAddressText"));
		//select gender
		Select genderDrpdwn = new Select(driver.findElement(By.name(Utility.fetchLocator("genderDropdown_Name"))));
		genderDrpdwn.selectByVisibleText("Male");
		//Thread.sleep(2000);
		//marital status dropdown
		Select maritalStatus = new Select(driver.findElement(By.id(Utility.fetchLocator("maritalStatusDropdown_ID"))));
		maritalStatus.selectByVisibleText("Single");
		//Enter maiden name
		WebElement maidenName= driver.findElement(By.id(Utility.fetchLocator("maidenMame_ID")));
		maidenName.sendKeys(Utility.fetchLocator("maidenNameText"));
		//Select religion
		Select religionDrpdwn= new Select(driver.findElement(By.id(Utility.fetchLocator("religionDrpdwn_ID"))));
		religionDrpdwn.selectByVisibleText("Islam");
		//upload passport
		WebElement passportUpload = driver.findElement(By.id(Utility.fetchLocator("passportField_ID")));
		passportUpload.sendKeys("C:\\Nerve_Automation\\image");
		//Click false button for politically exposed
		WebElement politicallyEposedBtn  =driver.findElement(By.xpath(Utility.fetchLocator("politicallyExposeCheck_XPATH")));
		politicallyEposedBtn.click();
		//Enter phoneNumber
		WebElement phoneNumberField = driver.findElement(By.id(Utility.fetchLocator("phoneNumberField_ID")));
		phoneNumberField.sendKeys(Utility.fetchLocator("phoneNumberText"));
		//Enter email
		WebElement email = driver.findElement(By.id(Utility.fetchLocator("emailFiedl_ID")));
		email.sendKeys(Utility.fetchLocator("emailText"));
		//Enter BVN
		WebElement bvnField = driver.findElement(By.id(Utility.fetchLocator("bvn_ID")));
		bvnField.sendKeys(Utility.fetchLocator("bvnText"));
		//Enter DOB
		WebElement dob = driver.findElement(By.id(Utility.fetchLocator("dobField_ID")));
		dob.sendKeys(Utility.fetchLocator("dobnText"));
		//Select country
		Select country = new Select(driver.findElement(By.id(Utility.fetchLocator("nationalityDrpdwn_ID"))));
		country.selectByVisibleText("Nigeria");
		//Thread.sleep(3000);
		System.out.println("Naija selected successfully");
		JavascriptExecutor scollDown= (JavascriptExecutor)driver;
		scollDown.executeScript("window.scrollBy(0,1000)");
		//select state
		Select state = new Select(driver.findElement(By.id(Utility.fetchLocator("stateDrpdwn_ID"))));
		state.selectByVisibleText("Lagos State");
	//	Thread.sleep(2000);
		//select localGovt
		Select localGovt = new Select(driver.findElement(By.id(Utility.fetchLocator("localGovtField_ID"))));
		localGovt.selectByVisibleText("Mushin");
		//select means of identification
		Select moi = new Select(driver.findElement(By.id(Utility.fetchLocator("meansOfIdDrpdwn_ID"))));
		moi.selectByVisibleText("Passport");
		//Enter ID Number
		WebElement idNumber = driver.findElement(By.id(Utility.fetchLocator("iDNumberField_ID")));
		idNumber.sendKeys(Utility.fetchLocator("iDNumberText"));
		JavascriptExecutor scollToNext= (JavascriptExecutor)driver;
		scollToNext.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		//Click Next Button
		WebElement nextBtn = driver.findElement(By.xpath(Utility.fetchLocator("NextBtn_XPATH")));
		nextBtn.click();
		Thread.sleep(2000);
		//Click another next Button
		WebElement nextBtn2= driver.findElement(By.xpath(Utility.fetchLocator("nextBtn2_XPATH")));
		nextBtn2.click();
		Thread.sleep(2000);
		//Click Save button
		WebElement saveBtn= driver.findElement(By.id(Utility.fetchLocator("saveBtn_ID")));
		saveBtn.click();
		Thread.sleep(2000);
	}
}
