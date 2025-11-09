package com.assignment.TestCases;



import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import com.assignment.Pageobject.loginPage;
import com.assignment.Utility.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
    String url=readconfig.getBaseUrl();
    String browser=readconfig.getBrowser();
    loginPage pg=new loginPage(driver);
    
    public static WebDriver driver;
    public static Logger log;
    
    @BeforeClass
    public void setup() {
    	//String browser="chrome";
    	
    	 switch(browser.toLowerCase()){
		 case "chrome":
			 WebDriverManager.chromedriver().setup();
			   driver=new ChromeDriver();
			   break;
		 case "firefox":
			 WebDriverManager.firefoxdriver().setup();
			  driver=new FirefoxDriver();
			  break;
		 case "msedge":
			 WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			 break;
		 default:
			 driver=null;
			 break;
	 }
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    log = LogManager.getLogger(BaseClass.class);

}
}