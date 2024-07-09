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

public class SFOpportunityTC15to19 extends BaseSFfunctionality {
	Logger mylog = LogManager.getLogger(SfdcAutomation.class);
	private static final Alert EnterText = null;
	@Test
	public void TC15Opportunitydropdown() throws InterruptedException { //opportunities drop down
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Opportunitytab=driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a")); //find and opportunity accounts tab
		Opportunitytab.click();
		WebElement ViewlistdropdownEle=driver.findElement(By.id("fcf")); 
		Select dropdownoption=new Select(ViewlistdropdownEle);
		List<WebElement> menuitems = dropdownoption.getOptions();
			for (WebElement menuitemlist : menuitems)
			{
				
				System.out.println(menuitemlist.getText());
			}
	  	}
	//Create a new Opty
	@Test
	public void TC16newOpportunity() throws InterruptedException { //opportunities drop down
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Opportunitytab=driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a")); //find and opportunity accounts tab
		Opportunitytab.click();
		Thread.sleep(2000);
		WebElement opnewbut=driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		opnewbut.click();
		System.out.println("New button clicked");
		//Enter Opportunity Name,Account Name,Close Date,Stage,Probability,Lead Source , Primary Campaign Source and click on save button.
		WebElement Opnametextbox=driver.findElement(By.xpath("//*[@id=\"opp3\"]"));
		if(Opnametextbox.isDisplayed()){
			Opnametextbox.clear();
			Opnametextbox.sendKeys("United Oil Office Portable Generators");
			System.out.println("oppotunity name entered");
		}else {
			System.out.println("opportunity name not entered");
			}
		WebElement OpAcnametextbox=driver.findElement(By.xpath("//*[@id=\"opp4\"]"));//Account name
		if(OpAcnametextbox.isDisplayed()){
			OpAcnametextbox.clear();
			OpAcnametextbox.sendKeys("United Oil & Gas Corp.");
			System.out.println("oppotunity account name entered");
		}else {
			System.out.println("opportunity account name not entered");
			}
		WebElement Opleaddropdown=driver.findElement(By.id("opp6")); //Lead dropdown
		Select Opleaddropdownnvalue=new Select(Opleaddropdown);
		Opleaddropdownnvalue.selectByValue("Web");
		System.out.println("stage dropdown clicked");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dateLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("6/21/2024")));
        dateLink.click();
		WebElement Opstagedropdown=driver.findElement(By.xpath("//*[@id=\"opp11\"]")); //stage
		Select Opstagedropdownvalue=new Select(Opstagedropdown);
		Opstagedropdownvalue.selectByValue("Prospecting");
		System.out.println("stage dropdown value selected");
		Thread.sleep(2000);
		WebElement Opprobablitytextbox=driver.findElement(By.id("opp12"));// probablity percentage
		if(Opprobablitytextbox.isDisplayed()){
			Opprobablitytextbox.clear();
			Opprobablitytextbox.sendKeys("50");
			System.out.println("probablity percentage entered");
		}else {
			System.out.println("probablity name not entered");
			}
		
		WebElement OpPrimarycampaigntextbox=driver.findElement(By.id("opp17"));//Primary campaign
		if(OpPrimarycampaigntextbox.isDisplayed()){
			OpPrimarycampaigntextbox.clear();
			OpPrimarycampaigntextbox.sendKeys("");
			System.out.println("OpPrimarycampaign entered");
		}else {
			System.out.println("OpPrimarycampaign not entered");
			}
		WebElement Opsavebut=driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		Opsavebut.click();
		System.out.println("save button clicked");
	}
	//Test Opportunity Pipeline Report
	@Test
	public void TC17OpportunityReport() throws InterruptedException { 
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Opportunitytab=driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a")); //find and opportunity accounts tab
		Opportunitytab.click();
		WebElement Opportunitypipelinelink=driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a")); 
		Opportunitypipelinelink.click();
		System.out.println("Pipeline link clicked");
		closeBrowser();
	}	
	//Test Stuck Opportunities Report
	public void TC18StuckOpportunitiesReport() throws InterruptedException { 
		SfcommonUsermenu();
		Thread.sleep(2000);
		WebElement Opportunitytab=driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a")); //find and opportunity accounts tab
		Opportunitytab.click();
		WebElement Opportunitypipelinelink=driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a")); 
		Opportunitypipelinelink.click();
		System.out.println("Stuck Opportunities link clicked");
	}
	//Test Quarterly Summary Report
	@Test
	public void TC19QuaterlySummaryReport() throws InterruptedException { 
		SfcommonLogin();
		Thread.sleep(2000);
		WebElement Opportunitytab=driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]/a")); //find and opportunity accounts tab
		Opportunitytab.click();
		WebElement QuaterlyIntervaldropdown=driver.findElement(By.xpath("//*[@id=\"quarter_q\"]")); 
		Select QuaterlyIntervaldropdownnvalue=new Select(QuaterlyIntervaldropdown);
		QuaterlyIntervaldropdownnvalue.selectByValue("current");
		System.out.println("Interval dropdown selected");
		WebElement QuaterlyIncludedropdown=driver.findElement(By.xpath("//*[@id=\"open\"]")); 
		Select QuaterlyIncludedropdownnvalue=new Select(QuaterlyIncludedropdown);
		QuaterlyIncludedropdownnvalue.selectByValue("all");
		System.out.println("Include dropdown selected");
		WebElement Runreportbut=driver.findElement(By.xpath("//*[@id=\"lead_summary\"]/table/tbody/tr[3]/td/input"));
		Runreportbut.click();
		System.out.println("Report button clicked");
		String ReportpageTitle = driver.getTitle();// Verifying report page title
		System.out.println(ReportpageTitle);
		}
	
	}
