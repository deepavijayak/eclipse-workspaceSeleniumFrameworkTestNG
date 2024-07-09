package com.Salesforce.base;
import java.time.Duration;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Salesforce.utilities.Constants;
import com.Salesforce.utilities.PropertiesUtility;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.Salesforce.utilities.TestListenerUtility.class)
public class BaseSFfunctionality extends Baseclassesforsdfcautomation {
	Logger mylog = LogManager.getLogger(BaseSFfunctionality.class);
	
	@BeforeMethod
	@Parameters("browserName")

	public void setUpBeforeMethod(@Optional("chrome") String BrowserName1) throws InterruptedException {
//		mylog.info("*********************setUpBeforeMethod**************************");
		mylog.info("****************setUpBeforeMethod*******************");
		launchBrowser(BrowserName1);
		String url=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "url");
		goToUrl(url);
	}
	
	@AfterMethod
	public void tearDownAfterTestMethod() {
		closeBrowser();
		mylog.info("****************tearDownAfterTestMethod*******************");
	}
	@Test
	public void SfcommonUsermenu() throws InterruptedException {
			// initalizing the chrome browser interface
		
		//launchBrowser("chrome"); // calling the launchbrowser reusable class
		String usernamedata=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passworddata=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		String url=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "url");
	//	goToUrl(url);
		WebElement username_ele=driver.findElement(By.id("username"));
		entertext(username_ele, usernamedata, "username"); 
		WebElement password_ele=driver.findElement(By.id("password"));
		entertext(password_ele, passworddata, "password");
		WebElement login_butele	=driver.findElement(By.id("Login")); //login button functionality
		clickElement(login_butele, "loginButton");
		Thread.sleep(5000);
		String HomepageTitle = driver.getTitle();// Verifying home page title
		mylog.info(HomepageTitle);
			//to verify the username
			WebElement verifyusername=driver.findElement(By.id("userNavLabel"));
			if(verifyusername.isDisplayed()){
				verifyusername.click();
				System.out.println("Username is showing" + verifyusername);
			}else {
				System.out.println("Username is not showing");
				}
	//		closeBrowser();
			//to click on the user menu dropdown from home page
			//		System.out.println("usermenu clicked");
							Thread.sleep(5000);
			/*	    WebElement findmenulist = driver.findElement(By.id("userNav-menuItems"));
					            List<WebElement> menuitems = findmenulist.findElements(By.tagName("a"));
							for (WebElement menuitemlist : menuitems)
							{
								// boolean isDisplayed = menuitemlist.isDisplayed();
					            //    String menuItemText = menuitemlist.getText();
								//System.out.println("The user menu list" + menuItemText);
								System.out.println(menuitemlist.getText());
							}*/
						//	driver.close();
							
		}
	@Test
	public void SfcommonLogin() throws InterruptedException {

		String usernamedata=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	String passworddata=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	String url=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "url");
//	goToUrl(url);
	WebElement username_ele=driver.findElement(By.id("username"));
	entertext(username_ele, usernamedata, "username"); 
	WebElement password_ele=driver.findElement(By.id("password"));
	entertext(password_ele, passworddata, "password");
	WebElement login_butele	=driver.findElement(By.id("Login")); //login button functionality
	clickElement(login_butele, "loginButton");
	Thread.sleep(5000);
	String HomepageTitle = driver.getTitle();// Verifying home page title
	mylog.info(HomepageTitle);
	}

	
}
