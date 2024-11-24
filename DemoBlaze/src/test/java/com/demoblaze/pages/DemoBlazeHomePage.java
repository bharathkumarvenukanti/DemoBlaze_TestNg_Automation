package com.demoblaze.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.objectrepository.DemoBlazeObjectsRepository;
import com.demoblaze.utilities.TestUtil;

public class DemoBlazeHomePage {
	private WebDriver driver;
	private TestUtil utils;

	@FindBy(xpath = DemoBlazeObjectsRepository.Phones_Xpath)
	WebElement phones;
	@FindBy(xpath = DemoBlazeObjectsRepository.Samsung_Mobile_Xpath)
	WebElement SamsungMob;
	
	@FindBy(xpath = DemoBlazeObjectsRepository.Laptop_Xpath)
	WebElement laptops;
	@FindBy(xpath = DemoBlazeObjectsRepository.Sony_xpath)
	WebElement Sony_Lap;
	
	@FindBy(xpath = DemoBlazeObjectsRepository.Monitors_Xpath)
	WebElement monitors;
	@FindBy(xpath = DemoBlazeObjectsRepository.Asus_Desktop_Xpath)
	WebElement asusDesktop ;
	
	@FindBy(xpath = DemoBlazeObjectsRepository.Logo_Xpath)
	WebElement logo;
	
	@FindBy(xpath = DemoBlazeObjectsRepository.Signup_XPath)
	WebElement signUpLink;
	
	@FindBy(id = DemoBlazeObjectsRepository.Login_ID)
	WebElement loginLink;
	
	public DemoBlazeHomePage()
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		utils=new TestUtil();
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isLogoDisplayed()
	{
		return logo.isDisplayed();
	}
	
	public DemoBlazeProductioninfoPage getPhone()
	{
		TestUtil.clickOn(phones);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView(true);", SamsungMob);
		
		TestUtil.JSClick(SamsungMob);
		
		return new DemoBlazeProductioninfoPage();
	}
	
	public DemoBlazeProductioninfoPage getLappy()
	{
		TestUtil.clickOn(laptops);
		
		TestUtil.clickOn(Sony_Lap);
		
		return new DemoBlazeProductioninfoPage();
	}
	
	
	public DemoBlazeProductioninfoPage getMonitor()
	{
		TestUtil.clickOn(monitors);
		TestUtil.clickOn(asusDesktop);
		
		return new DemoBlazeProductioninfoPage();
	}
	
	public DemoBlazeSignUpPage goToSignUpPage()
	{
		TestUtil.clickOn(signUpLink);	
		
		return new DemoBlazeSignUpPage();
	}
	
	
	public DemoBlazeLoginPage goToLoginPage()
	{
		TestUtil.JSClick(loginLink);	
		
		return new DemoBlazeLoginPage();
	}

}
