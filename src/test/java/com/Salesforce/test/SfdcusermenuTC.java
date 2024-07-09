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

//import SeleniumPractice.Baseclassesforsdfcautomation;

import org.testng.annotations.Listeners;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.Salesforce.utilities.TestListenerUtility.class)
public class SfdcusermenuTC extends BaseSFfunctionality {
Logger mylog = LogManager.getLogger(SfdcAutomation.class);
private static final Alert EnterText = null;
	@Test
	public void SfusermenuTC() throws InterruptedException { //TC-id-5-Select user menu for <username> drop down
	//	WebDriver driver=null;
		SfcommonUsermenu();
	    WebElement findmenulist = driver.findElement(By.id("userNav-menuItems"));
        List<WebElement> menuitems = findmenulist.findElements(By.tagName("a"));
	for (WebElement menuitemlist : menuitems)
	{
		System.out.println(menuitemlist.getText());
	}
		
	}
	@Test
	public void SfusermenuMyprofile() throws InterruptedException {//TC-06-Select "My Profile" option from user menu for <username> drop down
		SfcommonUsermenu();
		Thread.sleep(2000);
		try {
				WebElement Myprofileoption=driver.findElement(By.xpath("//a[@title='My Profile']"));
				Myprofileoption.click();
				System.out.println("Myprofile clicked");
				//	Check for the edit button next to contact text on the page and click the button. 
				WebElement Myprofileeditimg=driver.findElement(By.xpath("//img[contains(@alt, 'Edit Profile')]"));
				Myprofileeditimg.click();
				System.out.println("Myprofile image clicked");
				//	Edit profile pop up window is displayed with contact and About tabs to edit. 
				Thread.sleep(2000);
				WebElement editprofileabouttab=driver.findElement(By.xpath("//*[@id=\"contactInfoContentId\"]"));
				driver.switchTo().frame(editprofileabouttab);
				Thread.sleep(2000);
				WebElement abouttabclick=driver.findElement(By.xpath("//*[@id=\'aboutTab\']/a")); 
				Actions ac=new Actions(driver);
      			ac.moveToElement(abouttabclick).click().perform();
      			System.out.println("about tab clicked");
				//Enter username in about tab
      			WebElement aboutlastname=driver.findElement(By.id("lastName"));
				String updatelastname="Vijayakumar";
				if(aboutlastname.isDisplayed()){
					aboutlastname.clear();
					aboutlastname.sendKeys(updatelastname);
					System.out.println("Lastname in About Tab" + aboutlastname + "is entered");
				}else {
					System.out.println("Lastname is not entered");
					}
				//Save all button click
				WebElement aboutsaveallbut=driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]"));
				aboutsaveallbut.click();
				System.out.println("Save All button clicked");
				 String originalWindow = driver.getWindowHandle();
				 driver.switchTo().window(originalWindow);
				Thread.sleep(5000);
				 // Use WebDriverWait to wait for the element to be present
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		         WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='tailNode cxTailNode' and @id='tailBreadcrumbNode']")));
				String actualupdatedlastname=usernameElement.getAttribute("title");
				  System.out.println("Myprofile page username " + actualupdatedlastname + " is updated");
			//	Click on Post link, Enter the <text> to post in the post text area and click on share button
			WebElement postlink=driver.findElement(By.xpath("//*[@id=\"publisherAttachTextPost\"]/span[1]"));
			postlink.click();
			System.out.println("post link clicked");
				
			WebElement enterpost=driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[3]/div[1]/div/div[1]/div/div[2]/ul/li[1]/div/div/div[1]/div[1]/div[1]/div[1]/div/div[2]/div[2]/div/div/iframe")); 
			driver.switchTo().frame(enterpost);
			WebElement enterposttext=driver.findElement(By.xpath("/html/body"));
			enterposttext.sendKeys("I like painting");
			System.out.println("Post text entered");
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			WebElement postsharebut=driver.findElement(By.xpath("//*[@id=\"publishersharebutton\"]"));
			postsharebut.click();
			System.out.println("Share button clicked");
			//verify posted text is showing
			 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	         WebElement postedtextele = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div[2]/table/tbody/tr/td/div/div[3]/div[1]/div/div[1]/div/div[2]/ul/li[1]/div/div/div[2]/div/div[6]/div/div[1]/div[1]/div[2]/div[1]/span/p")));
	         String postedtext=postedtextele.getText();
			 System.out.println("Posted text " + postedtext + " is updated");
			  
			Thread.sleep(2000);
			//Click on the  file link and click on "upload a file from computer" button.**************
			WebElement filelink=driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[3]/div[1]/div/div[1]/div/div[2]/ul/li[1]/div/div/div[1]/ul/li[2]/a/span[1]"));
			filelink.click();
			System.out.println("file link clicked");
			//click on upload a file from computer option
			WebElement fileuploadlink=driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[3]/div[1]/div/div[1]/div/div[2]/ul/li[1]/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div/table/tbody/tr/td[2]/a"));
			fileuploadlink.click();
			System.out.println("file upload from computer option clicked");
			//Click on choose file button and select a file to be uploaded and click open button.
	        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement fileInput = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='chatterFile']")));
	        System.out.println("choose file button clicked");
           	// Specify the path to the file to be uploaded
			fileInput.sendKeys("C:\\Users\\deepa\\OneDrive\\Desktop\\Docs\\Java selenium\\uploadtestselenium.txt");
		    System.out.println("file uploaded");
              //share button
            Thread.sleep(2000);
			WebElement postsharebut1=driver.findElement(By.xpath("//*[@id=\"publishersharebutton\"]"));
			postsharebut1.click();
			System.out.println("file uploaded and share button clicked");
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
				}
		}
		@Test
	   //Click on personal link and select Login History link. Click on Download login  history link.
		public void Mysettingspersonallink() throws InterruptedException {//TC-07
		SfcommonUsermenu();
		Thread.sleep(2000);
		WebElement Myprofileoption=driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
		Myprofileoption.click();
		WebElement personallinkclick=driver.findElement(By.xpath("//*[@id='PersonalInfo_font']"));
		personallinkclick.click();
		System.out.println("Personal link clicked");
		WebElement loginhistorylink=driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[2]/div/div[8]/a"));
		loginhistorylink.click();
		System.out.println("Login history link clicked");
		//to verify and set the download file in .csv format
		/* String downloadFilePath = "C:\\Users\\deepa\\OneDrive\\Desktop\\Docs\\Java selenium";
		 ChromeOptions options = new ChromeOptions();
		 Map<String, Object> prefs = new HashMap<String, Object>();
	     prefs.put("download.default_directory", downloadFilePath);
	     options.setExperimentalOption("prefs", prefs);
	    // WebElement downloadloginhist=driver.findElement(By.xpath("//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a"));*/
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     WebElement downloadloginhist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(., 'Download login history for last six months')]")));
	     downloadloginhist.click();
	     /*File downloadedFile = waitForDownloadToComplete("C:\\Users\\deepa\\Downloads", "myloginhistoryfile.csv", 30);
	     if (downloadedFile != null && downloadedFile.exists()) {
	         System.out.println("File downloaded successfully: " + downloadedFile.getName());
	     } else {
	         System.out.println("File download failed.");
	     }*/
	    
		}
		@Test
		public void DevloperConsole() throws InterruptedException {
			   // String mainWindowHandle = driver.getWindowHandle();
				SfcommonUsermenu();
				Thread.sleep(2000);
				WebElement Devloperconsoleoption=driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[3]"));
				Devloperconsoleoption.click(); //perform the action
				System.out.println("Developer console link clicked");
				Thread.sleep(2000);
				//check if window handle is present
				String currentHandle=driver.getWindowHandle(); //store the current window handle that opens a new window
				System.out.println("current window handle="+currentHandle);
				Set<String> allHandles = driver.getWindowHandles();//after new window is opened, retrieve the window handles by getWindowHandles()
				//display the number of currently open browser windows or tabs, you can use the size() method
				System.out.println("after window button clicked number of window handles="+allHandles.size());
				//Iterate through window handles, Loop through the Set<String> to find the new window handle and switch to it. 
					for(String handle:allHandles) {
						if(!handle.equals(currentHandle)) {
							driver.switchTo().window(handle);
							System.out.println("New window title " + driver.getTitle());
							break;
						}
						driver.close();
					}
					 String originalWindow1 = driver.getWindowHandle();
					 driver.switchTo().window(originalWindow1);	
				}
		@Test
			public void usermenulogoutTc09() throws InterruptedException {
				SfcommonUsermenu();
				Thread.sleep(2000);
				WebElement Logoutoption=driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
				Logoutoption.click();
				System.out.println("Logout option link clicked");
				Thread.sleep(2000);
				String loginpageTitle = driver.getTitle();// Verifying login page title
				System.out.println(loginpageTitle);
			}
}
