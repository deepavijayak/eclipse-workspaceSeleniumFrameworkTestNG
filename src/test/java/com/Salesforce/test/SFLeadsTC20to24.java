package com.Salesforce.test;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Salesforce.base.BaseSFfunctionality;
import com.Salesforce.utilities.Constants;
import com.Salesforce.utilities.PropertiesUtility;
public class SFLeadsTC20to24 extends BaseSFfunctionality {
	Logger mylog = LogManager.getLogger(SfdcAutomation.class);
	private static final Alert EnterText = null;
	@Test
	public void TC20Leadstab() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Leadstab=driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a")); //find and Leads accounts tab
		Leadstab.click();
		System.out.println("Leads tab clicked");
		String leadspagetitle=driver.getTitle();
		System.out.println(leadspagetitle);
	}
	//List should drop down and should show the following contents: 
	//All Open Leads / My Unread Leads / Recently Viewed Leads / Today's Leads.  
	@Test
	public void TC21Leadstab() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Leadstab=driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a")); //find and Leads accounts tab
		Leadstab.click();
		System.out.println("Leads tab clicked");
		String leadspagetitle=driver.getTitle();
		System.out.println(leadspagetitle);
		WebElement ViewLeadele=driver.findElement(By.id("fcf"));
		Select viewdropdown=new Select(ViewLeadele);
		List <WebElement> menuitems=viewdropdown.getOptions();
		for(WebElement menuitemlist: menuitems) {
			System.out.println(menuitemlist.getText());
		}
	}
	@Test
	public void TC22LeadsTodayslead() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Leadstab=driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a")); //find and Leads accounts tab
		Leadstab.click();
		System.out.println("Leads tab clicked");
		String leadspagetitle=driver.getTitle();
		System.out.println(leadspagetitle);
		WebElement Leaddropdown=driver.findElement(By.id("fcf")); 
		Select Leaddropdownvalue=new Select(Leaddropdown);
		Leaddropdownvalue.selectByValue("00Bak00000A5Trm");
		System.out.println("Todays lead selected");
		WebElement usermenudropdown = driver.findElement(By.id("userNavLabel"));//find the xpath of usermenu
		usermenudropdown.click();
		Thread.sleep(5000);
		WebElement logoutoption=driver.findElement(By.xpath("//a[@title='Logout']"));
		logoutoption.click();
		System.out.println("logout clicked");
		Thread.sleep(2000);
		SfcommonUsermenu();
		WebElement Leadstabagain=driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a")); 
		Leadstabagain.click();
		WebElement LeadsGobut=driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		LeadsGobut.click();
	}
	@Test
	public void TC23LeadsTodayslead() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Leadstab=driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a")); //find and Leads accounts tab
		Leadstab.click();
		System.out.println("Leads tab clicked");
		WebElement Leaddropdown=driver.findElement(By.id("fcf")); 
		Select Leaddropdownvalue=new Select(Leaddropdown);
		Leaddropdownvalue.selectByValue("00Bak00000A5Trm");
		System.out.println("Todays lead selected");
	}
	@Test
	public void TC24NewLeads() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Leadstab=driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a")); //find and Leads accounts tab
		Leadstab.click();
		System.out.println("Leads tab clicked");
		WebElement LeadsNewbut=driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		LeadsNewbut.click();
		Thread.sleep(2000);
		WebElement LeadsLastnametextbox=driver.findElement(By.id("name_lastlea2"));// new lead last name
		if(LeadsLastnametextbox.isDisplayed()){
			LeadsLastnametextbox.clear();
			LeadsLastnametextbox.sendKeys("ABCD");
			System.out.println("Last name entered");
		}else {
			System.out.println("Last name not entered");
			}
		WebElement Leadscompanynametextbox=driver.findElement(By.id("lea3"));// new lead Company name
    	if(Leadscompanynametextbox.isDisplayed()){
    		Leadscompanynametextbox.clear();
    		Leadscompanynametextbox.sendKeys("ABCD");
			System.out.println("company name entered");
		}else {
			System.out.println("company name not entered");
			}
    	WebElement LeadsSavebut=driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
    	LeadsSavebut.click();
    	}
	
}
