package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.objectrepository.DemoBlazeObjectsRepository;
import com.demoblaze.utilities.TestUtil;

public class DemoBlazePaymentInfoPage {
	private WebDriver driver;
	private TestUtil utils;
	public DemoBlazePaymentInfoPage()
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		utils=new TestUtil();
	}
	@FindBy(id =DemoBlazeObjectsRepository.Name_ID)
	@CacheLookup
	WebElement name;

	@FindBy(id = DemoBlazeObjectsRepository.Country_ID)
	@CacheLookup
	WebElement country;

	@FindBy(id=DemoBlazeObjectsRepository.City_ID)
	@CacheLookup
	WebElement city;

	@FindBy(id = DemoBlazeObjectsRepository.Card_ID)
	@CacheLookup
	WebElement card;

	@FindBy(id = DemoBlazeObjectsRepository.Month_ID)
	@CacheLookup
	WebElement month;


	@FindBy(id = DemoBlazeObjectsRepository.year_ID)
	@CacheLookup
	WebElement year;

	@FindBy(xpath=DemoBlazeObjectsRepository.Purchase_Button_Xpath)
	@CacheLookup
	WebElement purchaseBtn;
	
	@FindBy(xpath =DemoBlazeObjectsRepository.SuccessMessage_Xpath)
	@CacheLookup
	WebElement successmessage;

	public void sendDetails()
	{
		
		utils.sendKeys(name, "Bharath");
		utils.sendKeys(country, "India");
		utils.sendKeys(city, "Aurangabad");
		utils.sendKeys(card, "123456789012");
		utils.sendKeys(month, "June");
		utils.sendKeys(year, "2022");
		
		
	}
	public void clickPurchaseBtn()
	{
		TestUtil.JSClick(purchaseBtn);
	}

	public String getSuccessMsg()
	{
		String msg = successmessage.getText();

		return msg;

	}


}
