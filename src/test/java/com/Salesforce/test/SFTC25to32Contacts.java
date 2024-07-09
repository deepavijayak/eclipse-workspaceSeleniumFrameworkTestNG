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

public class SFTC25to32Contacts  extends BaseSFfunctionality {
	Logger mylog = LogManager.getLogger(SfdcAutomation.class);
	private static final Alert EnterText = null;
	@Test
	public void TC25NewContacts() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Contactstab=driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a")); //find and click Contacts tab
		Contactstab.click();
		System.out.println("Contacts tab clicked");
		WebElement ContactsNewbut=driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		ContactsNewbut.click();
		Thread.sleep(2000);
		WebElement ContactsLastnametextbox=driver.findElement(By.id("name_lastcon2"));// new lead last name
		if(ContactsLastnametextbox.isDisplayed()){
			ContactsLastnametextbox.clear();
			ContactsLastnametextbox.sendKeys("ASDF");
			System.out.println("Last name entered");
		}else {
			System.out.println("Last name not entered");
			}
		WebElement ContactsAccountnametextbox=driver.findElement(By.id("con4"));// new lead Company name
    	if(ContactsAccountnametextbox.isDisplayed()){
    		ContactsAccountnametextbox.clear();
    		ContactsAccountnametextbox.sendKeys("Dickenson plc");
			System.out.println("Account name entered");
		}else {
			System.out.println("Account name not entered");
			}	
    	WebElement ContactsSavewbut=driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
    	ContactsSavewbut.click();
    	System.out.println("Save button clicked");
    	
	}
	@Test
	public void TC26CreatenewView() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Contactstab=driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a")); //find and click Contacts tab
		Contactstab.click();
		System.out.println("Contacts tab clicked");
		WebElement Createnewviewlink=driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		Createnewviewlink.click();
		System.out.println("Create new view clicked");
		WebElement Viewnametextbox=driver.findElement(By.id("fname")); 
    	if(Viewnametextbox.isDisplayed()){
    		Viewnametextbox.clear();
    		Viewnametextbox.sendKeys("My_new View");
			System.out.println("View nametextbox name entered");
		}else {
			System.out.println("View nametextbox name not entered");
			}
    	WebElement ViewUniquenametextbox=driver.findElement(By.id("devname")); 
    	if(ViewUniquenametextbox.isDisplayed()){
    		ViewUniquenametextbox.clear();
    		ViewUniquenametextbox.sendKeys("Unique_newview_name");
			System.out.println("View nametextbox name entered");
		}else {
			System.out.println("View nametextbox name not entered");
			}
    	WebElement Viewpagesavebut=driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
    	Viewpagesavebut.click();
    	System.out.println("Save button clicked");
    	
	}
	@Test
	public void TC27RecentlyCreatedView() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Contactstab=driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a")); 
		Contactstab.click();
		System.out.println("Contacts tab clicked");
		WebElement Contactselectiondropdown=driver.findElement(By.id("hotlist_mode")); 
		Select Contactselectiondropdownval=new Select(Contactselectiondropdown);
		Contactselectiondropdownval.selectByValue("1");
		System.out.println("Recently created selected");
	
	}
	@Test
	public void TC28MyContactsView() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Contactstab=driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a")); 
		Contactstab.click();
		System.out.println("Contacts tab clicked");
		WebElement Viewdropdown=driver.findElement(By.id("fcf")); 
		Select viewdropdownval=new Select(Viewdropdown);
		viewdropdownval.selectByValue("00Bak00000A5TsT");
		System.out.println("MyContacts selected");
		WebElement ViewGobut=driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		ViewGobut.click();
	
	}
	@Test
	public void TC29Viewcontacts() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Contactstab=driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a")); 
		Contactstab.click();
		System.out.println("Contacts tab clicked");
		WebElement Mycontactname=driver.findElement(By.xpath("//table[@class='list']//tr[contains(@class, 'dataRow')][1]//th/a")); 
		Mycontactname.click();
    	System.out.println("Name link clicked");
    	
	}
	@Test
	public void TC30CreatenewViewErrormsg() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Contactstab=driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a")); //find and click Contacts tab
		Contactstab.click();
		System.out.println("Contacts tab clicked");
		WebElement Createnewviewlink=driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		Createnewviewlink.click();
		System.out.println("Create new view clicked");
		WebElement Viewnametextbox=driver.findElement(By.id("fname"));
		WebElement ViewUniquenametextbox=driver.findElement(By.id("devname")); 
    	if(ViewUniquenametextbox.isDisplayed()){
    		ViewUniquenametextbox.clear();
    		ViewUniquenametextbox.sendKeys("EFGH");
			System.out.println("View nametextbox name entered");
		}else {
			System.out.println("View nametextbox name not entered");
			}
    	WebElement Viewpagesavebut=driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
    	Viewpagesavebut.click();
    	System.out.println("Save button clicked");
    	WebElement actualMsg = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/div[2]"));
    	String actualErrorMessage = actualMsg.getText();
    	System.out.println(actualErrorMessage);
		String expmsg="Error: You must enter a value";
		if (actualMsg.equals(expmsg)) {
		    System.out.println("The view name error text passed");
		} else {
		    System.out.println("The view name error text not passed");
		}
		
	}
	@Test
	public void TC31CreateViewCancel() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Contactstab=driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a")); //find and click Contacts tab
		Contactstab.click();
		System.out.println("Contacts tab clicked");
		WebElement Createnewviewlink1=driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		Createnewviewlink1.click();
		System.out.println("Create new view clicked");
		WebElement Viewnametextbox1=driver.findElement(By.id("fname")); 
    	if(Viewnametextbox1.isDisplayed()){
    		Viewnametextbox1.clear();
    		Viewnametextbox1.sendKeys("ABCD");
			System.out.println("View nametextbox name entered");
		}else {
			System.out.println("View nametextbox name not entered");
			}
    	WebElement ViewUniquenametextbox1=driver.findElement(By.id("devname")); 
    	if(ViewUniquenametextbox1.isDisplayed()){
    		ViewUniquenametextbox1.clear();
    		ViewUniquenametextbox1.sendKeys("EFGH");
			System.out.println("View nametextbox name entered");
		}else {
			System.out.println("View nametextbox name not entered");
			}
    	WebElement Viewpagecancelbut=driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[2]"));
    	Viewpagecancelbut.click();
    	System.out.println("Cancel button clicked");
    	
	}
	@Test
	public void TC32NewContactsaveandnew() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Contactstab1=driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]/a")); //find and click Contacts tab
		Contactstab1.click();
		System.out.println("Contacts tab clicked");
		WebElement ContactsNewbut1=driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		ContactsNewbut1.click();
		Thread.sleep(2000);
		WebElement ContactsLastnametextbox1=driver.findElement(By.id("name_lastcon2"));// new contact last name
		if(ContactsLastnametextbox1.isDisplayed()){
			ContactsLastnametextbox1.clear();
			ContactsLastnametextbox1.sendKeys("Indian");
			System.out.println("Last name entered");
		}else {
			System.out.println("Last name not entered");
			}
		WebElement ContactsAccountnametextbox1=driver.findElement(By.id("con4"));// new contact account name
    	if(ContactsAccountnametextbox1.isDisplayed()){
    		ContactsAccountnametextbox1.clear();
    		ContactsAccountnametextbox1.sendKeys("United Oil & Gas Corp.");
			System.out.println("Account name entered");
		}else {
			System.out.println("Account name not entered");
			}	
    	WebElement ContactsSaveandnewbut=driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[2]"));
    	ContactsSaveandnewbut.click();
    	System.out.println("Save&New button clicked");
    
	}
		
}
