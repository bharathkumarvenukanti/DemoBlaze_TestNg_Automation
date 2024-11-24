package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.objectrepository.DemoBlazeObjectsRepository;
import com.demoblaze.utilities.TestUtil;

public class DemoBlazeProductioninfoPage {
	private WebDriver driver;
	private TestUtil utils;
	public DemoBlazeProductioninfoPage()
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		utils=new TestUtil();
	}

	@FindBy(xpath = DemoBlazeObjectsRepository.Add_To_Cart_Xpath)
	@CacheLookup
	private WebElement addToCartBtn;
	
	
	public void clickOnaddToCartBtn()
	{
		TestUtil.JSClick(addToCartBtn);
		
	}
}
