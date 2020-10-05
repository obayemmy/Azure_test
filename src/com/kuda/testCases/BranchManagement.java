package com.kuda.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.kuda.base.TestBase;
import com.kuda.utility.Utility;

public class BranchManagement extends TestBase{
	public ValidateLogin signIn ;
	@Test(priority =1)
	public void viewBranches() throws IOException, InterruptedException {
		signIn = new ValidateLogin();

		try {
			signIn.googleSign();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(Utility.fetchLocator("branchMgtBtn"))).click();
		driver.findElement(By.xpath(Utility.fetchLocator("viewBranchesBtn"))).click();
		WebElement branchStatus=driver.findElement(By.xpath(Utility.fetchLocator("branchStatus_XPATH")));
		Thread.sleep(3000);
		String status = branchStatus.getText();
		if(status.contains("Active")) {
			System.out.println("branch is Active");
		}else if(status.contains("Inactive")) {
			System.out.println("branch is inactive");
			return;
		}
	}
	@Test(priority =2)
	public WebElement createBranch() throws IOException {
		WebElement createBranchBtn = driver.findElement(By.id(Utility.fetchLocator("createBranchBtn_ID")));
		createBranchBtn.click();
		return createBranchBtn;
	}

}
