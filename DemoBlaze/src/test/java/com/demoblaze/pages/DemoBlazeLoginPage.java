package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.objectrepository.DemoBlazeObjectsRepository;
import com.demoblaze.utilities.TestUtil;

public class DemoBlazeLoginPage {
	private WebDriver driver;
	private TestUtil utils;
	public DemoBlazeLoginPage()
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		utils=new TestUtil();
	}
	@FindBy(id=DemoBlazeObjectsRepository.UserName_ID)
	@CacheLookup
	WebElement loginUserName;

	@FindBy(id=DemoBlazeObjectsRepository.Password_ID)
	@CacheLookup
	WebElement loginPassword;

	@FindBy(xpath = DemoBlazeObjectsRepository.Login_Button_Xpath)
	@CacheLookup
	WebElement loginButton;

	@FindBy(xpath = DemoBlazeObjectsRepository.Close_Button_Xpath)
	@CacheLookup
	WebElement closeButton;
	
	@FindBy(id = DemoBlazeObjectsRepository.User_LogOut_ID)
	@CacheLookup
	WebElement LogOutLink;

	public void enterUserName(String username) throws Exception
	{

		TestUtil.sendKeys(loginUserName, username);

	}
	public void enterPassword(String password) throws Exception
	{

		TestUtil.sendKeys(loginPassword, password);
	}
	public void clickonLogin() throws Exception
	{	
		TestUtil.JSClick(loginButton);
	}	

	public void clickOnClose()
	{
		TestUtil.JSClick(closeButton);
	}
	
	public void clickOnlogout()
	{
		TestUtil.JSClick(LogOutLink);
	}
}
