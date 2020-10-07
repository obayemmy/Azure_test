package com.kuda.testCases;

import java.io.IOException;

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
import com.kuda.utility.Utility;


public class CustomerAccountManagement extends TestBase  {
	public ValidateLogin login;
	@Test(priority=1)
	public void viewCASAccount() throws IOException, InterruptedException {
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
		//click customer Account Management button
		//		WebElement customerAcctMgtBtn = driver.findElement(By.xpath(Utility.fetchLocator("customerAccountMgtBtnXpath")));
		//		customerAcctMgtBtn.click();	

		WebDriverWait customerAcctMgtBtn= new WebDriverWait(driver, 5);
		customerAcctMgtBtn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("customerAccountMgtBtnXpath"))));
		driver.findElement(By.xpath(Utility.fetchLocator("customerAccountMgtBtnXpath"))).click();
		//Click savings button
		WebElement viewSavingsBtn =	driver.findElement(By.xpath(Utility.fetchLocator("viewSavingsAccountBtnXpath")));
		viewSavingsBtn.click();
		Thread.sleep(2000);
	}
	@Test(priority = 2)
	public void searchByAccountName() throws IOException, InterruptedException {
		WebElement searchAccountName = driver.findElement(By.id(Utility.fetchLocator("searchField_ID")));
		searchAccountName.sendKeys(Utility.fetchLocator("searchAccountNameText"));
		//Select AccountName from dropdown
		Select searchdrpDwn = new Select(driver.findElement(By.id(Utility.fetchLocator("searchParameterDrpdwnId"))));
		searchdrpDwn.selectByVisibleText("Account Name");
		//Click quick search button
		WebElement quickSearchBtn = driver.findElement(By.xpath(Utility.fetchLocator("quickSearchBtn_XPATH")));
		quickSearchBtn.click();
		//Assert search result is correct
		String expectedResult= "Shaye Mycon";
		WebElement searchNameResult = driver.findElement(By.xpath(Utility.fetchLocator("AccountNameResult_XPATH")));
		String searchNameDisplayed = searchNameResult.getText();
		Assert.assertEquals(searchNameDisplayed, expectedResult, "Correct Result is not displayed");
		Thread.sleep(2000);

	}
	@Test(priority=3)
	public void searchByAccountNumber() throws IOException, InterruptedException {
		//Enter Account Number
		WebElement searchAccountNumber = driver.findElement(By.id(Utility.fetchLocator("searchField_ID")));
		searchAccountNumber.clear();
		searchAccountNumber.sendKeys(Utility.fetchLocator("searchAccountNumberText"));
		//Select AccountNumber from dropdown
		Select accountNumber = new Select(driver.findElement(By.id(Utility.fetchLocator("searchParameterDrpdwnId"))));
		accountNumber.selectByVisibleText("Account Number");
		//Click quick search button
		WebElement quickSearchBtn = driver.findElement(By.xpath(Utility.fetchLocator("quickSearchBtn_XPATH")));
		quickSearchBtn.click();
		//Assert result is correct
		String expectedAccount = "Jonathan Ojaigho";
		WebElement AccountNumberResult = driver.findElement(By.xpath(Utility.fetchLocator("AccountNumberResult_XPATH")));
		String displayedAccount = AccountNumberResult.getText();
		Assert.assertEquals(displayedAccount, expectedAccount, "Correct Account details is not returned");
		Thread.sleep(2000);
	}
	@Test(priority =4)
	public void searchByAccountEmail() throws IOException, InterruptedException {
		//Enter Account Number
		WebElement searchAccountNumber = driver.findElement(By.id(Utility.fetchLocator("searchField_ID")));
		searchAccountNumber.clear();
		searchAccountNumber.sendKeys(Utility.fetchLocator("searchAccountEmailText"));
		//Select AccountNumber from dropdown
		Select accountEmail = new Select(driver.findElement(By.id(Utility.fetchLocator("searchParameterDrpdwnId"))));
		accountEmail.selectByVisibleText("Account Email");
		//Click quick search button
		WebElement quickSearchBtn = driver.findElement(By.xpath(Utility.fetchLocator("quickSearchBtn_XPATH")));
		quickSearchBtn.click();
		//Assert result is correct
		String expectedDetails = "Emmanuel Oluwafemi Odutola";
		WebElement AccountNumberResult = driver.findElement(By.xpath(Utility.fetchLocator("AccounEmailResult_XPATH")));
		String displayedAccount = AccountNumberResult.getText();
		Assert.assertEquals(displayedAccount, expectedDetails, "Correct Account details is not returned");
		Thread.sleep(2000);
	}
	@Test(priority = 5)
	public void viewAccountBalance() throws IOException, InterruptedException {
		//click view  balance button
		WebElement viewbalanceBtn = driver.findElement(By.xpath(Utility.fetchLocator("viewBalanceBtn_XPATH")));
		viewbalanceBtn.click();
		Thread.sleep(3000);
		//Print out balance
		WebElement availableBalance = driver.findElement(By.xpath(Utility.fetchLocator("availableBalance_XPATH")));
		String balanceText = availableBalance.getText();
		System.out.println("The balance is " + balanceText);
		//Close modal for balance info
		WebElement balanceModal =driver.findElement(By.className(Utility.fetchLocator("closeModalBalance_CLASS")));
		balanceModal.click();
		Thread.sleep(3000);
	}
	@Test(priority =6)
	public void editCustomerAccount() throws IOException, InterruptedException {
		//Click Manage button
		WebElement manageBtn = driver.findElement(By.xpath(Utility.fetchLocator("manageBtn_XPATH")));
		manageBtn.click();
		System.out.println("manage button is clicked");
		//Click edit button
		WebElement editBtn = driver.findElement(By.xpath(Utility.fetchLocator("customerAccountEditBtn_XPATH")));
		editBtn.click();
		System.out.println("Edit button is clicked");
		//Scroll down
		JavascriptExecutor scrollDown= (JavascriptExecutor)driver;
		scrollDown.executeScript("window.scrollBy(0,1000)");
		//Click save button
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("page is scrolled");
		WebElement saveBtn = driver.findElement(By.id(Utility.fetchLocator("updateAccountSaveBtn_ID")));
		saveBtn.click();
		System.out.println("save button is clicked");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Click yes button
		WebElement yesBtn = driver.findElement(By.xpath(Utility.fetchLocator("confirmYes_XPATH")));
		yesBtn.click();
		Thread.sleep(2000);
		//Verify Success Message
		String successText = "Completed Successfully";
		WebElement successMsg = driver.findElement(By.xpath(Utility.fetchLocator("accountUpdateSuccessText_XPATH")));
		String successResponse = successMsg.getText();
		Assert.assertEquals(successResponse, successText, "Customer Account Update Not Successful");
		//Click Ok button
		Thread.sleep(3000);
		WebElement okBtn = driver.findElement(By.xpath(Utility.fetchLocator("OkayBtn_XPATH")));
		okBtn.click();
		Thread.sleep(2000);
	}
	@Test(priority =7)
	public void createCustomerAccount() throws IOException, InterruptedException {
		WebDriverWait customerAcctMgtBtn= new WebDriverWait(driver, 5);
		customerAcctMgtBtn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("customerAccountMgtBtnXpath"))));
		driver.findElement(By.xpath(Utility.fetchLocator("customerAccountMgtBtnXpath"))).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Click create CASA button
		WebElement createCASABtn = driver.findElement(By.id(Utility.fetchLocator("createCASABtn_ID")));
		createCASABtn.click();
		Thread.sleep(2000);
        //Click account name field
		WebElement accountNameField = driver.findElement(By.id(Utility.fetchLocator("accountNameField_ID")));
		accountNameField.click();
		Thread.sleep(2000);
		//Enter search details
		WebElement searchCustomerfield = driver.findElement(By.xpath(Utility.fetchLocator("searchCustomerField_XPATH")));
		searchCustomerfield.clear();
		searchCustomerfield.sendKeys(Utility.fetchLocator("searchCustomerFieldText"));
		//Select customer iD
		Select searchParam = new Select( driver.findElement(By.id(Utility.fetchLocator("searchCustomerModalDrpdwn_ID"))));
		searchParam.selectByVisibleText("Customer Id");
		
		//Click quick Search Button
		WebElement quickSearchBtn = driver.findElement(By.id(Utility.fetchLocator("quickSearchCustomerModalBtn_ID")));
		quickSearchBtn.click();
		Thread.sleep(2000);
		//Click Select Customer Button
		WebElement selectCustomerBtn = driver.findElement(By.xpath(Utility.fetchLocator("selectCustomerBtnModal_XPATH")));
		selectCustomerBtn.click();
		Thread.sleep(2000);
		//Select Account ype dropdown
		Select accountType = new Select( driver.findElement(By.id(Utility.fetchLocator("accountTypeDrpdwnField_ID"))));
		accountType.selectByVisibleText("Personal");
		//Select Account Tier
		Select accountTier = new Select(driver.findElement(By.id(Utility.fetchLocator("accountTierLevelDrpdwnField_ID"))));
		accountTier.selectByVisibleText("Account Tier 3");
		//Select Branch
		Select branch = new Select(driver.findElement(By.id(Utility.fetchLocator("selectBranchDrpdwnField_ID"))));
		branch.selectByVisibleText("Head Office Branch");
		//Select product
		Select productType = new Select(driver.findElement(By.id(Utility.fetchLocator("productType_ID"))));
		productType.selectByVisibleText("Spending Account");
		Thread.sleep(3000);
		//Select Account Officer
	    Select  accountOfficer= new Select(driver.findElement(By.id(Utility.fetchLocator("accountOfficer_ID"))));
	    accountOfficer.selectByVisibleText("Fred Jeremiah");
	    //Enter minimum balance figure
	    WebElement minimuBalance = driver.findElement(By.id(Utility.fetchLocator("minimumBalanceField_ID")));
	    minimuBalance.sendKeys(Utility.fetchLocator("minimumBalanceDigit"));
		//Scroll down
		JavascriptExecutor scollDown= (JavascriptExecutor)driver;
		scollDown.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		//select statement deliverymode radio button
		Actions actions = new Actions(driver);
		WebElement statementDelivery = driver.findElement(By.id(Utility.fetchLocator("emailDeliveryMode_ID")));
		actions.doubleClick(statementDelivery).perform();
		Thread.sleep(2000);

//		WebElement statementDelivery = driver.findElement(By.id(Utility.fetchLocator("emailDeliveryMode_ID")));
//		statementDelivery.click();
		//Select frequency
//		WebElement frequencyRadioBtn = driver.findElement(By.id(Utility.fetchLocator("frequency_ID")));
//		frequencyRadioBtn.click();
		
		Actions clickFrequencyBtn = new Actions(driver);
		WebElement frequencyRadioBt = driver.findElement(By.id(Utility.fetchLocator("frequency_ID")));
		clickFrequencyBtn.doubleClick(frequencyRadioBt).perform();
		Thread.sleep(2000);
		System.out.println("test ran successfully ");

		
	}
	
	

	
}
