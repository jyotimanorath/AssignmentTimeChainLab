package com.assignment.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.assignment.Pageobject.loginPage;

public class TC_loginPage extends BaseClass {
	@Test(priority = 0)
	public void verifyTitleOfPage() throws InterruptedException {
		driver.get(url);
		log.info("url open");
		Thread.sleep(2000);
		String title=driver.getTitle();
		System.out.println(title);
		Thread.sleep(1000);
		Assert.assertEquals(title, "ERNX - Parents");
		}
	@Test(priority = 2)
	public void verifyLoginValidemail() throws InterruptedException {
		driver.get(url);
		log.info("url open");
		loginPage pg=new loginPage(driver);
		pg.enterEmail("jyotimanoraths@gmail.com");
		Thread.sleep(1000);
		pg.clickSubmit();
		
		Thread.sleep(3000);
		String currenturl=driver.getCurrentUrl();
		Assert.assertEquals(currenturl, "https://ernx-consumer.vercel.app/login/otp");
		log.info("valid emailId submitted successfully");
		driver.quit();
}

@Test(priority = 1)
public void verifyLoginInValidemail() throws InterruptedException {
	driver.get(url);
	log.info("url open");
	loginPage pg=new loginPage(driver);
	pg.enterEmail("jyoti");
	Thread.sleep(1000);
	pg.clickSubmit();
	log.info("login failed with invalid email id");
	Thread.sleep(2000);
	String currenturl=driver.getCurrentUrl();
	Assert.assertNotEquals(currenturl, "https://ernx-consumer.vercel.app/login/otp");
	}

}
