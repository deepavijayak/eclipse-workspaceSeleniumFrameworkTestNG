package com.Salesforce.test;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class SFTC33to37RandomScenarios  extends BaseSFfunctionality {
	Logger mylog = LogManager.getLogger(SfdcAutomation.class);
	private static final Alert EnterText = null;
	@Test
	public void TC33Verifyfnlnlogin() throws InterruptedException{
	// entering login details 
		WebElement username_ele=driver.findElement(By.id("username"));
		entertextfor2args(username_ele, "raghunathan@cognizant.com"); //calling the reusable entertext method
		WebElement password_ele=driver.findElement(By.id("password"));
		entertextfor2args(password_ele, "Lavansri1516"); //calling the reusable entertext method
		WebElement login_but=driver.findElement(By.id("Login"));
		if(login_but.isDisplayed()) {
			login_but.click();
			System.out.println("Login Button clicked for positive test case passed");
		}else {
			System.out.println("Login button not clicked");
		}
	//	WebElement homepage_title=driver.findElement(By.tagName(""));
		Thread.sleep(2000);
		String HomepageTitle = driver.getTitle();// Verifying home page title
		System.out.println(HomepageTitle);
		//*[@id="home_Tab"]/a
		WebElement Hometab_ele=driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
		clickElement(Hometab_ele, "Home Tab");
		WebElement Userfnln_ele=driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
		clickElement(Userfnln_ele, "User firstname Lastname");
	}
	@Test
	public void TC34Verifyeditedlastname() throws InterruptedException{
		TC33Verifyfnlnlogin();
		Thread.sleep(2000);
		WebElement Myprofileeditimage=driver.findElement(By.xpath("//img[contains(@alt, 'Edit Profile')]"));
		Myprofileeditimage.click();
		System.out.println("Myprofile image clicked");
		WebElement editprofileabouttab=driver.findElement(By.xpath("//*[@id=\"contactInfoContentId\"]"));
		driver.switchTo().frame(editprofileabouttab);
		Thread.sleep(2000);
		WebElement abouttabclick=driver.findElement(By.xpath("//*[@id=\'aboutTab\']/a")); 
		Actions ac=new Actions(driver);
		ac.moveToElement(abouttabclick).click().perform();
		System.out.println("about tab clicked");
		WebElement aboutlastname=driver.findElement(By.id("lastName"));
		String updatelastname="ABCD";
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
        WebElement usernameElement = driver.findElement(By.xpath("//*[@id=\"tailBreadcrumbNode\"]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
   //     WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tailBreadcrumbNode")));
        String actualupdatedlastname = usernameElement.getText();
        System.out.println("Updated actualupdatedlastname value: " + actualupdatedlastname);
	}
	@Test
	public void TC35Verifyplustabbut() throws InterruptedException{
		TC33Verifyfnlnlogin();
		Thread.sleep(2000);
		WebElement plusimg = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		plusimg.click();
		System.out.println("Add tab image clicked");
	    WebElement Customizemytab = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/table/tbody/tr/td[2]/input"));
	    Customizemytab.click();
		System.out.println("Customize tab button clicked");
	    WebElement selectedtab = driver.findElement(By.id("duel_select_1"));//select from available tabs
		 Select contactsoption = new Select(selectedtab);
		 contactsoption.selectByValue("Contact"); 
		 System.out.println("Contact is selected");
		 WebElement Contactremovebutton = driver.findElement(By.xpath("//*[@id=\"duel_select_0_left\"]/img"));//select from available tabs
		 Contactremovebutton.click();
		 System.out.println("Remove button clicked");
		 Thread.sleep(2000);
		 WebElement savebut=driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		 savebut.click();
		 WebElement usermenudropdown = driver.findElement(By.id("userNavLabel"));
	     usermenudropdown.click();
	 	System.out.println("usermenu dropdown clicked");
		Thread.sleep(5000);
		WebElement logoutoption=driver.findElement(By.xpath("//a[@title='Logout']"));
		logoutoption.click();
		System.out.println("logout clicked");
	}
	@Test
	public void TC36BlockEventinCalendar() throws InterruptedException{
		TC33Verifyfnlnlogin();
		Thread.sleep(2000);
		WebElement Hometab = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
		Hometab.click();
		WebElement Datelink = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		Datelink.click();
		System.out.println("Date clicked");
		WebElement timelink = driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:4:j_id64\"]/a"));
		timelink.click();
		System.out.println("Time link clicked");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
        WebElement subjectIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Subject Combo (New Window)']"))); 
        subjectIcon.click();
        System.out.println("Subject icon clicked");
        // Handle window switching
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        WebElement popupotherElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Other']"))); // Replace with actual ID or locator
        popupotherElement.click();
        driver.switchTo().window(originalWindow);
//        WebElement Endtimedropdown = driver.findElement(By.id("//*[@id=\"EndDateTime_time\"]"));
//        Endtimedropdown.click();
//	 	System.out.println("Endtime dropdown clicked");
//		Thread.sleep(5000);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement endDateTimeInput = wait1.until(ExpectedConditions.elementToBeClickable(By.id("EndDateTime_time")));
        // Click on the EndDateTime input field
        endDateTimeInput.click();
        // Set the value to "9:00 PM"
        endDateTimeInput.clear();
        endDateTimeInput.sendKeys("9:00 PM");
        WebElement Savebut = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
        Savebut.click(); 
        System.out.println("Save button clicked");
        
	}
	@Test
	public void TC37BlockEventrecurrence() throws InterruptedException{
		TC33Verifyfnlnlogin();
		Thread.sleep(2000);
		WebElement Hometab = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a"));
		Hometab.click();
		WebElement Datelink = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		Datelink.click();
		System.out.println("Date clicked");
		WebElement timelink = driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:20:j_id64\"]/a"));
		timelink.click();
		System.out.println("Time link clicked");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
        WebElement subjectIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Subject Combo (New Window)']"))); 
        subjectIcon.click();
        System.out.println("Subject icon clicked");
        // Handle window switching
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        WebElement popupotherElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Other']"))); // Replace with actual ID or locator
        popupotherElement.click();
        driver.switchTo().window(originalWindow);
//        WebElement Endtimedropdown = driver.findElement(By.id("//*[@id=\"EndDateTime_time\"]"));
//        Endtimedropdown.click();
//	 	System.out.println("Endtime dropdown clicked");
//		Thread.sleep(5000);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement endDateTimeInput = wait1.until(ExpectedConditions.elementToBeClickable(By.id("EndDateTime_time")));
        // Click on the EndDateTime input field
        endDateTimeInput.click();
        // Set the value to "9:00 PM"
        endDateTimeInput.clear();
        endDateTimeInput.sendKeys("7:00 PM");
        System.out.println("End time entered");
        WebElement Recurrencecheckbox = driver.findElement(By.id("IsRecurrence"));
		if (!Recurrencecheckbox.isSelected()) {
			Recurrencecheckbox.click();
		    System.out.println("Recurrence checkbox is now selected.");
		} 
		WebElement recurrenceRadiobutton = driver.findElement(By.xpath("//*[@id=\"rectypeftw\"]"));
		if(recurrenceRadiobutton.isSelected())
		{
 			System.out.println("the value is already selected");
		}
		else 
		{
			recurrenceRadiobutton.click();
			System.out.println("the radiobutton value will be selected now");
		}
		 WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement datePickerField = wait.until(ExpectedConditions.elementToBeClickable(By.id("RecurrenceEndDateOnly")));
        		datePickerField.click();

        // Calculate the date two weeks from the current date
        LocalDate currentDate = LocalDate.now();
        LocalDate targetDate = currentDate.plusWeeks(2);
        String targetDateStr = targetDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        datePickerField.clear();
        datePickerField.sendKeys(targetDateStr);
        datePickerField.sendKeys(Keys.TAB);
        String selectedDate = datePickerField.getAttribute("value");
        System.out.println("Date selected 2 weeks from current date: " + selectedDate);
        WebElement Savebut = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
        Savebut.click(); 
        System.out.println("Save button clicked");
       
	}
	
}
