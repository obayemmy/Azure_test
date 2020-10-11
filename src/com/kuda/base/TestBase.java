package com.kuda.base;

import com.kuda.utility.Log;
import com.kuda.utility.Utility;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void setUp() throws IOException {
        if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("chrome")) {
            //set property and create instance of chrome browser
            //System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver.exe");
            //using webdriver manager
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
            //System.out.println(browserName + " browser running");
//			ChromeDriverManager.getInstance().setup();
//			ChromeOptions chromeOptions = new ChromeOptions();
//
//			chromeOptions.addArguments("--headless");
//			driver = new ChromeDriver(chromeOptions);

        }

        else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("firefox")) {
            //set property and create instance of chrome firefox
            //System.setProperty("webdriver.gecko.driver", projectPath+"\\Drivers\\geckodriver.exe");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            //	System.out.println(browserName + " browser running");
        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("edge")) {
            //set property and create instance of chrome firefox
            //	System.setProperty("webdriver.edge.driver", projectPath+"\\Drivers\\msedgedriver.exe");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            //	System.out.println(browserName + " browser running");
        } else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("ie")) {
            //set property and create instance of chrome ie
            //	System.setProperty("webdriver.ie.driver", projectPath+"\\Drivers\\IEDriverServer.exe");
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else {
            //	System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver.exe");
            //	WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.get(Utility.fetchProperty("applicationUrl").toString());

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Log.startLog("Test started");
        //	driver.manage().timeouts().implicitlyWait(Integer.parseInt((String) Utility.fetchProperty("implicit.wait")), TimeUnit.SECONDS);
    }


    @AfterClass
    public void tearDown() {
        Log.endLog("Test ended");
        driver.close();

    }

}
