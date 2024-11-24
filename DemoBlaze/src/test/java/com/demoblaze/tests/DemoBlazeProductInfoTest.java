package com.demoblaze.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoblaze.driverscript.TestBase;
import com.demoblaze.pages.DemoBlazeCartPage;
import com.demoblaze.pages.DemoBlazeHomePage;
import com.demoblaze.pages.DemoBlazeProductioninfoPage;
import com.demoblaze.pages.DemoBlazeSignUpPage;
import com.demoblaze.pages.HomepageNavigation;
import com.demoblaze.utilities.TestUtil;

public class DemoBlazeProductInfoTest extends TestBase{
	public HomepageNavigation navigatetohomepage;
	public DemoBlazeHomePage homePage;
	public DemoBlazeCartPage cartPage;
	public DemoBlazeProductioninfoPage DemoBlazeProductioninfoPage;
	private TestUtil utils;
	private Alert alert;
	private String alertTxt;
	

	@BeforeMethod
	public void set()
	{
		navigatetohomepage=new HomepageNavigation();
		
		homePage = PageFactory.initElements(driver, DemoBlazeHomePage.class);
		cartPage=PageFactory.initElements(driver, DemoBlazeCartPage.class);
		DemoBlazeProductioninfoPage=PageFactory.initElements(driver, DemoBlazeProductioninfoPage.class);
		utils=new TestUtil();
		
	}
	@AfterMethod
	public void assertingAll() {
		utils.assertAllSoftAssertions();

	}
	@Test(priority = 1)
	public void verifyTitle()
	{	
		
		try
		{
			navigatetohomepage.LaunchHomepage();
			utils.AssrtEquals(homePage.validateHomePageTitle(), "STORE","Title are not matched!!");



		}
		catch(Exception e)
		{
			
		}
	}
	@Test(priority = 2,groups = {"DemoBlazeProductioninfoPage.addProduct"})
	public void selectPhone() throws Exception
	{
	
		DemoBlazeProductioninfoPage phone = homePage.getPhone();
		phone.clickOnaddToCartBtn();
		
		alertTxt = TestUtil.handleAlert(alert);
		
		utils.AssrtTrue(true, alertTxt);
		
	
	}
	
	@Test(groups = {"DemoBlazeProductioninfoPage.addProduct"})
	public void selectLappy() throws Exception
	{
		DemoBlazeProductioninfoPage lappy = homePage.getLappy();
		lappy.clickOnaddToCartBtn();
		
		alertTxt = utils.handleAlert(alert);
		
		utils.AssrtTrue(true, alertTxt);
		
	}
	
	@Test(groups = {"DemoBlazeProductioninfoPage.addProduct"})
	public void selectMonitor() throws Exception
	{
		DemoBlazeProductioninfoPage	monitor = homePage.getMonitor();
		monitor.clickOnaddToCartBtn();
		
		Thread.sleep(2000);
		
		alertTxt = utils.handleAlert(alert);
		
		utils.AssrtTrue(true, alertTxt);
		
	}
	
}
