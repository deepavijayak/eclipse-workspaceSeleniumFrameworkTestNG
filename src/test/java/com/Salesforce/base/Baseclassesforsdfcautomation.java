package com.Salesforce.base;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Baseclassesforsdfcautomation {
	// getTitle, switchToAlert acceptAlert DismissAlert getTextFromAlert

	protected WebDriver driver = null;
	private WebDriverWait wait=null;

		public void launchBrowser(String browserName) {

			switch (browserName.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println("Chrome browser instance chrome created.");
				driver.manage().window().maximize();
				System.out.println("window is maximized");
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println("Firefox browser instance chrome created.");
				driver.manage().window().maximize();
				break;

			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				System.out.println("Edge browser instance chrome created.");
				driver.manage().window().maximize();
				break;

			case "safari":
				// Safari does not require a separate driver setup, as it is included with macOS
				driver = new SafariDriver();
				break;

			default:
				System.out.println("Unsupported browser: " + browserName);
			}

			// return driver;
		}
		
		public void goToUrl(String url) {
			driver.get(url);
			System.out.println(url + "is entered");
			
		}

		public static void entertext(WebElement ele, String data, String objectName) {
			if(ele.isDisplayed()){
				ele.clear();
				ele.sendKeys(data);
				System.out.println("Userdata" + objectName + "is entered");
			}else {
				System.out.println(objectName + "Userdata is not entered");
				}
		}
		public static void entertextfor2args(WebElement ele, String data) {
			if(ele.isDisplayed()){
				ele.clear();
				ele.sendKeys(data);
				System.out.println("Username" + data + "is entered");
			}else {
				System.out.println("Username is not entered");
				}
		}
		
		
		public void clickElement(WebElement ele, String objectName) {
			if (ele.isEnabled()) {
				ele.click();
				System.out.println(objectName + "button is clicked");
				
			} else {
				System.out.println(objectName+" element is not enabled");
				
			}
		}
		
		public String getTextFromElement(WebElement ele, String objectName) {
			String data=null;
			if(ele.isDisplayed()) {
			data = ele.getText();
			System.out.println("text is extracted from "+objectName);
			}
			else {
				System.out.println(objectName+" not dispalyed");
			}
			return data;
		}
		public void waitForVisibility(WebElement ele,Duration timeInSec,String ObjectName) {
			System.out.println(ObjectName+ "waiting for visibility for maximum of "+timeInSec+ "sec");
			wait=new WebDriverWait(driver,timeInSec);
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
		public void closeBrowser() {
			driver.close();
			System.out.println("browser instance closed");
			//driver=null;
		}
	
	}
	

