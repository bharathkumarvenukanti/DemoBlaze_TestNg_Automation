package com.demoblaze.objectrepository;

public class DemoBlazeObjectsRepository {
	// Logo Element
	public static final String Logo_Xpath="//a[@id='nava']//img[@src='bm.png']";

	// Home Page Elements
	public static final String Phones_Xpath="//a[text()='Phones']";
	public static final String Samsung_Mobile_Xpath="//a[text()='Samsung galaxy s6']";
	public static final String Laptop_Xpath="//a[text()='Laptops']";
	public static final String Sony_xpath="//a[text()='Sony vaio i5']";
	public static final String Monitors_Xpath="//a[text()='Monitors']";
	public static final String Asus_Desktop_Xpath="//a[text()='ASUS Full HD']";
	public static final String Signup_XPath="//a[text()='Sign up']";
	public static final String Login_ID="login2";
	
	//Signup Web Elements
	public static final String Signup_UserName_ID="sign-username";
	public static final String Signup_Password_ID="sign-password";
	public static final String Signup_Button_Xpath="//button[text()='Sign up']";
	public static final String Signup_Close_Button_Xpath="//button[text()='Log in']//preceding-sibling::button";
	//Login Page Elements
	public static final String UserName_ID="loginusername";
	public static final String Password_ID="loginpassword";
	public static final String Login_Button_Xpath="//button[text()='Log in']";
	public static final String Close_Button_Xpath="//button[text()='Log in']//preceding-sibling::button";
	public static final String User_LogOut_ID="logout2";
	//Production page elements
	public static final String Add_To_Cart_Xpath="//a[text()='Add to cart']";
	//Cart Page Elements
	public static final String First_Item_Xpath="(//td[2])[1]";
	public static final String Delete_First_Item_Xpath="(//a[text()='Delete'])[1]";
	public static final String Place_Order_Xpath="//button[text()='Place Order']";
	public static final String Total_ID="totalp";
	public static final String cart_Link_Xpath="//a[text()='Cart']";
	public static final String AllItems_Xpath="//td[3]";
	
	//Payment info name
	public static final String Name_ID="name";
	public static final String Country_ID="country";
	public static final String City_ID="city";
	public static final String Card_ID="card";
	public static final String Month_ID="month";
	public static final String year_ID="year";
	public static final String Purchase_Button_Xpath="//button[text()='Purchase']";
	public static final String SuccessMessage_Xpath="//h2[text()='Thank you for your purchase!']";
	
	
}
