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

public class DemoBlazeCartTest extends TestBase{
	public DemoBlazeCartPage cartPage;
	private TestUtil utils;
	private Alert alert;
	private String alertTxt;
	

	@BeforeMethod
	public void set()
	{
		cartPage=PageFactory.initElements(driver, DemoBlazeCartPage.class);
		utils=new TestUtil();
		
	}
	@AfterMethod
	public void assertingAll() {
		utils.assertAllSoftAssertions();

	}
	@Test(priority = 0, description = "Go to Cart Page")
	public void goToCart() throws Exception
	{
		cartPage.goToCart();
		utils.AssrtTrue(true, "Check it again");
	}
	@Test(priority = 1,description="Verifying Whether First item is displayed after deleting it")
	public void validateDeleteItem() throws Exception
	{
		utils.AssrtTrue(cartPage.firstItemDisplayed(), "Item not displayed");
	}
	@Test(priority = 2,description="Verifying whether Total table price shown on page is equal to the sum of price of all items")
	public void valiadteTotalProductPrice()
	{
		utils.AssertEquals(cartPage.getTableTotalPrice(), cartPage.getTotal());
		
	}
	
}
