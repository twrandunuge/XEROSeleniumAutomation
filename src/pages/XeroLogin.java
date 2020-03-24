
/*
Test 				ID01	A		
Any Web bowser		Firefox 		
URL					https://www.xero.com/us/		
date				6/28/2016		
Test Description	Navigate to XERO		
			
Sl No	Test Step Name			TestStep Description															Test Result Expected
			
1		Launch App				Open firefox window and provide <https://login.xero.com/> url to the browser.	Xero application page is displayed
2		Enter User Name			Enter User Name <User@gmail.com>												User Name is displayed in User name field
3		Enter Password			Enter Password <pwd>															Password is displayed in password field
4		Click on Log in button	Direct to User's Home Page														User's Home Page should be displayed*/


package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class XeroLogin extends BaseClass {

	@Test(description="ID01 - Navigate to XERO")
	public void loginToApplication() throws InterruptedException 
	
	{	
						
		WebElement EmailaddressTextBox = driver.findElement(By.id("email"));
		EnterText(EmailaddressTextBox, "thilanka.randunuge@yahoo.com", "Email address");
		
		WebElement PasswordTextBox = driver.findElement(By.id("email"));
		EnterText(PasswordTextBox, "Lychees@123", "Password");
		
		WebElement loginButton = driver.findElement(By.id("submitButton"));
		Click(loginButton, "Log in Button");
		
		driver.navigate().back();
		
		Thread.sleep(5000);
	}
	

}
