package com.kuda.testCases;

import com.kuda.base.TestBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class GeneralLedgerManagement extends TestBase {
    public ValidateLogin login;
    @Test
    public void viewGLAccounts() throws IOException, InterruptedException {
        login = new ValidateLogin();
        login.googleSign();

    }
    @Test
    public void searchGLAccountByCode(){
    }

    @Test
    public void searchGLByNane(){

    }

}
