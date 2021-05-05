package com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class Trivago_pg{
		
		WebDriver driver;
		
		public Trivago_pg(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath ="//input[@id='querytext']")
		WebElement EnterDestination;
		public WebElement getEnterDestination() {
			return EnterDestination;
		}
		
		@FindBy(xpath ="//body/div[@id='page_wrapper']/div[2]/div[4]/div[1]/div[1]/div[2]/form[1]/div[1]/button[2]")
		WebElement SubmitButton;
		public WebElement getSubmitButton() {
			return SubmitButton;
		}
		
		
		@FindBy(xpath ="//header/nav[1]/a[2]")
		WebElement Weekend;
		public WebElement getWeekend() {
			return Weekend;
		}
	
}