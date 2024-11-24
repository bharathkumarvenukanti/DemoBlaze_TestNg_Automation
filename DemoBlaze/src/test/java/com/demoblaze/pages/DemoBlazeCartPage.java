package com.demoblaze.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.objectrepository.DemoBlazeObjectsRepository;
import com.demoblaze.utilities.TestUtil;

public class DemoBlazeCartPage {
	private WebDriver driver;
	private TestUtil utils;
	public DemoBlazeCartPage()
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		utils=new TestUtil();
	}
	@FindBy(xpath = DemoBlazeObjectsRepository.First_Item_Xpath)
	WebElement FirstItem;

	@FindBy(xpath = DemoBlazeObjectsRepository.Delete_First_Item_Xpath)
	WebElement deleteFirstItem;

	@FindBy(xpath = DemoBlazeObjectsRepository.Place_Order_Xpath)
	WebElement placeOrderBtn;

	@FindBy(id = DemoBlazeObjectsRepository.Total_ID)
	WebElement total;

	@FindBy(xpath = DemoBlazeObjectsRepository.cart_Link_Xpath)
	WebElement cartLink;

	@FindBy(xpath =DemoBlazeObjectsRepository.AllItems_Xpath)
	private List<WebElement> allItemPrice;


	public boolean firstItemDisplayed() throws Exception
	{
		String FirstitemName = FirstItem.getText();
		System.out.println(FirstitemName);
		TestUtil.JSClick(deleteFirstItem);
		String pageSource  = driver.getPageSource();
		return pageSource.contains(FirstitemName);
	}

	public int getTableTotalPrice()
	{
	
		int tableTotal = 0;

		for(WebElement item: allItemPrice)
		{
			tableTotal+=Integer.parseInt(item.getText());
		}

		return tableTotal;

	}

	public int getTotal()
	{

		return Integer.parseInt(total.getText());	
	}


	public void goToCart()
	{
		TestUtil.clickOn(cartLink);
	}


	public DemoBlazePaymentInfoPage goToPaymentPage()
	{

		TestUtil.clickOn(placeOrderBtn);

		return new DemoBlazePaymentInfoPage();
	}

}
