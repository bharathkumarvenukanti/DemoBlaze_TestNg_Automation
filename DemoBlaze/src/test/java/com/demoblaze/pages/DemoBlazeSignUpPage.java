package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.objectrepository.DemoBlazeObjectsRepository;
import com.demoblaze.utilities.TestUtil;

public class DemoBlazeSignUpPage {
	private WebDriver driver;
	private TestUtil utils;
	public DemoBlazeSignUpPage()
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		utils=new TestUtil();
	}
	@FindBy(xpath = DemoBlazeObjectsRepository.Signup_XPath)
	@CacheLookup
	WebElement sUsername;
	
	@FindBy(id = DemoBlazeObjectsRepository.Signup_Password_ID)
	@CacheLookup
	WebElement sPassword;
	
	@FindBy(xpath = DemoBlazeObjectsRepository.Signup_Button_Xpath)
	@CacheLookup
	WebElement signUpBtn;
	@FindBy(xpath = DemoBlazeObjectsRepository.Signup_Close_Button_Xpath)
	@CacheLookup
	WebElement CloseBtn;
	public void EntersignupUserName(String userName)
	{
		
		sUsername.sendKeys(userName);
		
	}
	public void EnterPasword(String password)
	{
		
		sPassword.sendKeys(password);
	}
	public void ClickonsignUp()
	{
		signUpBtn.click();
	}
	
	
	
	public void clickOnClose()
	{
		TestUtil.JSClick(CloseBtn);
	}
	

}
