package com.kuda.postingsMgt;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.kuda.base.TestBase;
import com.kuda.testCases.ValidateLogin;
import com.kuda.utility.Utility;

public class ValidateSingleJournalTransfer extends TestBase{
	public ValidateLogin login;
	@Test(priority =0)
	public void glToglTransfer() throws InterruptedException, IOException {
		login = new ValidateLogin();
		login.googleSign();
		WebDriverWait wait = new WebDriverWait(driver, 6);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("postingsMgtBtnXpath"))));
		driver.findElement(By.xpath(Utility.fetchLocator("postingsMgtBtnXpath"))).click();
		//Click single journal posting 
		WebElement singleJournalPostingBtn = driver.findElement(By.id(Utility.fetchLocator("singleJournalPostingBtn_ID")));
		singleJournalPostingBtn.click();
		//Complete Debiting Account details
		//Enter search GL text
		WebElement searchGL = driver.findElement(By.name(Utility.fetchLocator("GlSearchField_NAME")));
		searchGL.sendKeys(Utility.fetchLocator("GlSearchText"));
		//select primary category dropdown
		Select primaryCategory = new Select(driver.findElement(By.id(Utility.fetchLocator("primaryCategoryDrpdwn_ID"))));
		primaryCategory.selectByVisibleText("Expense");
		//Select Secondary Category
		Select secondaryCategory = new Select(driver.findElement(By.id(Utility.fetchLocator("secondCategoryDrpdwn_ID"))));
		secondaryCategory.selectByVisibleText("Overheads");
		//Click quick search button
		WebElement quickSearchBtn =driver.findElement(By.xpath(Utility.fetchLocator("quickSearchBtn_XPATH")));
		quickSearchBtn.click();
		// Click debit button
		WebElement selectDebitBtn = driver.findElement(By.linkText(Utility.fetchLocator("selectDebitBtn_LINKTEXT")));
		selectDebitBtn .click();
		Thread.sleep(2000);
		//Click Okay button
		WebElement oKBtn = driver.findElement(By.xpath(Utility.fetchLocator("OKBtn_XPATH")));
		oKBtn.click();
		Thread.sleep(3000);
		JavascriptExecutor scollDown= (JavascriptExecutor)driver;
		scollDown.executeScript("window.scrollBy(0,500)");
		
		//Completing crediting GL details
		//search gL code
		WebElement glSearchField = driver.findElement(By.id(Utility.fetchLocator("gLCodeSearchField_ID")));
		glSearchField.sendKeys(Utility.fetchLocator("glSearchCodeText"));
		//select branch
		Select selectBranch = new Select(driver.findElement(By.id(Utility.fetchLocator("selectBranchDrpdwn_ID"))));
		selectBranch.selectByVisibleText("Head Office Branch");
		//Enter Amount
		WebElement amount = driver.findElement(By.id(Utility.fetchLocator("amountField_ID")));
		amount.clear();
		amount.sendKeys(Utility.fetchLocator("amountText"));
		//Enter instrument number
		WebElement instrumentNumber = driver.findElement(By.id(Utility.fetchLocator("instrumentNumberField_ID")));
		instrumentNumber.sendKeys(Utility.fetchLocator("instrumentNumberText"));
		//Enter narration
		WebElement narration = driver.findElement(By.name(Utility.fetchLocator("narrationField_NAME")));
		narration.sendKeys(Utility.fetchLocator("narrationText"));
		//Enter instrumenr number
	    Select entryCode = new Select(driver.findElement(By.id(Utility.fetchLocator("entryCodeDrpdwn_ID"))));
	    entryCode.selectByVisibleText("Journal Posting btw GLs - C318");
	    
	    //Final Completion of Debiting GL
	    Select debitBranch =  new Select(driver.findElement(By.id(Utility.fetchLocator("brandcDrpdwn2_ID"))));
	    debitBranch.selectByVisibleText("Head Office Branch");
	    //Enter debit amount
	    WebElement debitAmount = driver.findElement(By.id(Utility.fetchLocator("debitAmountField_ID")));
	    debitAmount.clear();
	    debitAmount.sendKeys(Utility.fetchLocator("debitAmountText"));
	  //  Select debit entry code
	    Select debitEntryCode =new Select(driver.findElement(By.id(Utility.fetchLocator("debitEntryCodeDrpdwn_ID"))));
	    debitEntryCode.selectByVisibleText("Journal Posting btw GLs - D318");
	       
		JavascriptExecutor scroll= (JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0,500)");
		 Thread.sleep(3000);
	    //Click post transaction button
	    WebElement postTransactionBtn = driver.findElement(By.id(Utility.fetchLocator("postTransactionBtn_ID")));
	    postTransactionBtn.click();
		 Thread.sleep(3000);
	    //Need to click yess and verify the success message
	  
		
	}

}
