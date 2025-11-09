package com.assignment.Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	//create webdriver object   local driver
		WebDriver ldriver;
		
		//create constructor and pass remote driver
		 public loginPage(WebDriver rdriver) {
			 this.ldriver=rdriver;
			 PageFactory.initElements(rdriver, this);
		 }

		 @FindBy(name = "email")
		 WebElement emailTextBox;
		 
		 @FindBy(tagName = "button")
		 WebElement nextButton;
		 
		 public void enterEmail(String email) {
			 emailTextBox.sendKeys(email);
			
		}
		 
		 public void clickSubmit() {
			 nextButton.click();
			 emailTextBox.clear();
			
		}
}
