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
public class SFCreateAccountTC10to14 extends BaseSFfunctionality {
	Logger mylog = LogManager.getLogger(SfdcAutomation.class);
	private static final Alert EnterText = null;
	@Test
	public void TC10Createnewaccount() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Accountstab=driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a")); //find and click accounts tab
		Accountstab.click();
		WebElement Newaccountbut=driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")); 
		Newaccountbut.click();
		WebElement Accountnametext=driver.findElement(By.xpath("//*[@id=\"acc2\"]"));
		if(Accountnametext.isDisplayed()){
			Accountnametext.clear();
			Accountnametext.sendKeys("My Account for test");
			System.out.println("Unique name is entered");
		}else {
			System.out.println("Unique name is not entered");
			}
		 WebElement Typedropdown = driver.findElement(By.xpath("//*[@id=\"acc6\"]"));
		 Select Technologypartner = new Select(Typedropdown);
		 Technologypartner.selectByValue("Technology Partner"); 
		 System.out.println("Technology partner is selected"); ////*[@id="00Nak000002hz3u"]
		 WebElement CustomerPriority = driver.findElement(By.xpath("//*[@id=\"00Nak000002hz3u\"]"));
		 Select PriorityHigh = new Select(CustomerPriority);
		 PriorityHigh.selectByValue("High"); 
		 System.out.println("Technology partner is selected");
		 WebElement Newaccountsavebut=driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]")); 
		 Newaccountsavebut.click();
	}
	@Test
	public void TC11Newviewlink() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Accountstab=driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a")); //find and click accounts tab
		Accountstab.click();
		WebElement verifyusername=driver.findElement(By.xpath("//*[@id=\"mru005ak000004nmrt\"]/a/span"));
		if(verifyusername.isDisplayed()){
		String name = verifyusername.getText();
		System.out.println("Username is showing Accounts tab passed" + name);
		}else {
			System.out.println("Username is not showing");
		}
		Thread.sleep(2000);
		WebElement createnewviewlink=driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		createnewviewlink.click();
		WebElement Enterviewname=driver.findElement(By.xpath("//*[@id=\"fname\"]"));
		entertextfor2args(Enterviewname, "First_accounts");
		WebElement Enterviewuniquename=driver.findElement(By.xpath("//*[@id=\"devname\"]"));
		if(Enterviewuniquename.isDisplayed()){
			Enterviewuniquename.clear();
			Enterviewuniquename.sendKeys("Unique_name");
			System.out.println("Unique name is entered");
		}else {
			System.out.println("Unique name is not entered");
			}
		WebElement createviewsavebut=driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		createviewsavebut.click();
		System.out.println("Save button clicked");
	}
	@Test
	public void TC12Newviewlink() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Accountstab=driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a")); //find and click accounts tab
		Accountstab.click(); 
		WebElement Viewdropdown=driver.findElement(By.xpath("//*[@id=\"fcf\"]")); 
		Select vieweditdropdownvalue=new Select(Viewdropdown);
		vieweditdropdownvalue.selectByValue("00Bak00000A5TsL");
		System.out.println("View dropdown clicked");
		Thread.sleep(2000);
		WebElement ViewdropdownEditlink=driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[1]"));
		ViewdropdownEditlink.click();
		System.out.println("Edit Link clicked");
		WebElement EditViewname=driver.findElement(By.xpath("//*[@id=\"fname\"]"));
		if(EditViewname.isDisplayed()){
			EditViewname.clear();
			EditViewname.sendKeys("Changed_viewname");
			System.out.println("View name edited");
		}else {
			System.out.println("View name not edited");
			}
		WebElement Editviewsavebut=driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		Editviewsavebut.click();
		System.out.println("Save button clicked after editing");
	}
	@Test
	public void TC13Mergeaccounts() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Accountstab=driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a")); //find and click accounts tab
		Accountstab.click(); 
		WebElement Mergeaccountslink=driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a")); 
		Mergeaccountslink.click(); 
		System.out.println("Merge accounts link clicked");
		WebElement AccountnametoMerge=driver.findElement(By.id("srch"));
		if(AccountnametoMerge.isDisplayed()){
			AccountnametoMerge.clear();
			AccountnametoMerge.sendKeys("Merge");
			System.out.println("Account name entered");
		}else {
			System.out.println("Account name not entered");
			}
		WebElement Findaccountsbut=driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]")); 
		Findaccountsbut.click(); 
		System.out.println("Find accounts button clicked");
		
		WebElement Nextbut=driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[1]")); 
		Nextbut.click(); 
		System.out.println("Next accounts button clicked");
		WebElement Mergebutton=driver.findElement(By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[2]")); 
		Mergebutton.click(); 
		System.out.println("Merge accounts button clicked");
		
		Thread.sleep(5000);
		String text = null;
		String expconfirmMsg = "These records will be merged into one record using the selected values. Merging can't be undone. Proceed with the record merge?";
		try {
			Alert alertOb = driver.switchTo().alert();
			text = alertOb.getText();
			System.out.println("text on the alert box=" + text);
			alertOb.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("failed: alert not present");
			e.printStackTrace();
		}
		if (text.equals(expconfirmMsg)) {
			System.out.println("testcase passed");
		} else {
			System.out.println("testcase failed");
		}		
	}
	@Test
	public void TC14Createaccountreport() throws InterruptedException {
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Accountstab=driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a")); //find and click accounts tab
		Accountstab.click();
		WebElement Accountslastactivitylink=driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a")); //find and click accounts tab
		Accountslastactivitylink.click();
		System.out.println("Accounts last activity link clicked");
		WebElement Datefielddropdown=driver.findElement(By.xpath("//*[@id='ext-gen20']")); 
		Datefielddropdown.click();
		System.out.println("Date field dropdown clicked");
		// Wait for the dropdown options to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".x-combo-list-item")));
        // Loop through the options and click the one with the desired text
        for (WebElement option : options) {
            if (option.getText().equals("Created Date")) {
                option.click();
                break;
            }
        }
		//Date picker FROM date 
        WebDriverWait waitforreports1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fromDateField = waitforreports1.until(ExpectedConditions.elementToBeClickable(By.id("ext-gen152")));
    //    WebElement fromDateField = driver.findElement(By.id("ext-gen152")); 
        fromDateField.click();
        // Locate and click the "Today" link in the date picker
        WebElement fromdatetodayLink = driver.findElement(By.id("ext-gen281")); // 
        fromdatetodayLink.click();
        System.out.println("From date selected");
        WebDriverWait waitforreports2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toDateField = waitforreports2.until(ExpectedConditions.elementToBeClickable(By.id("ext-gen154")));
         toDateField.click();
        System.out.println("To image date selected");
         // Locate and click the "Today" link in the date picker
        WebDriverWait waitforreports3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Todatetodaybut = driver.findElement(By.id("ext-gen296"));
        Todatetodaybut.click();
        driver.switchTo().defaultContent();
        System.out.println("To date selected");
        WebElement Savebutele = driver.findElement(By.xpath("//*[@id=\"saveReportBtn\"]/tbody/tr[2]/td[2]/em")); // Adjust the XPath as needed
        Savebutele.click();
        System.out.println("Save button clicked");
        WebElement Reportname_ele=driver.findElement(By.xpath("//*[@id=\"saveReportDlg_reportNameField\"]"));
		String Reportname="Myreport";
		if(Reportname_ele.isDisplayed()){
			Reportname_ele.clear();
			Reportname_ele.sendKeys(Reportname);
			System.out.println("Report name" + Reportname_ele + "is entered");
		}else {
			System.out.println("Report name is not entered");
			}
		WebElement Reportuniquename_ele=driver.findElement(By.xpath("//*[@id=\"saveReportDlg_DeveloperName\"]"));
		String Reportuniquename="July2024";
		if(Reportuniquename_ele.isDisplayed()){
			Reportuniquename_ele.clear();
			Reportuniquename_ele.sendKeys(Reportuniquename);
			System.out.println("Report name" + Reportuniquename_ele + "is entered");
		}else {
			System.out.println("Report name is not entered");
			}
		
		WebElement SaveReportbut=driver.findElement(By.id("ext-gen313"));
		SaveReportbut.click();
		System.out.println("Save report button clicked");
   	}
	
}
