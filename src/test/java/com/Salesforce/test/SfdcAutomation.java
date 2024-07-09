package com.Salesforce.test;
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
import org.openqa.selenium.support.ui.Select;

import com.Salesforce.base.BaseSFfunctionality;
import com.Salesforce.utilities.Constants;
import com.Salesforce.utilities.PropertiesUtility;
import org.testng.annotations.Listeners;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.Salesforce.utilities.TestListenerUtility.class)
public class SfdcAutomation extends BaseSFfunctionality{
	Logger mylog = LogManager.getLogger(SfdcAutomation.class);
	@Test
	public void Sdfcloginpositive() throws InterruptedException{ //TC-1
			SfcommonLogin();
	}
	@Test
	public void Sfdcinvalidlogin() throws InterruptedException {//TC-2
		String usernamedata=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		WebElement username_ele=driver.findElement(By.id("username"));
		entertext(username_ele, usernamedata, "username"); //calling the reusable entertext method
		WebElement password_ele=driver.findElement(By.id("password"));
		String pwddata=" ";
		if(password_ele.isDisplayed()){
			password_ele.clear();
			password_ele.sendKeys(" ");
			System.out.println("Userdatas" +pwddata+ "entered");
		}else {
			System.out.println(pwddata + "Userdata is not entered");
			}
		WebElement login_but=driver.findElement(By.id("Login")); //login button functionality
		if(login_but.isDisplayed()) {
			login_but.click();
			System.out.println("Login Button clicked");
		}else {
			System.out.println("Login button not clicked");
		}
		Thread.sleep(2000);
		String actualMsg = driver.findElement(By.id("error")).getAttribute("innerHTML");
		System.out.println(actualMsg);
		String experror="Please enter your password.";
		Assert.assertEquals(actualMsg, experror);
		System.out.println("Error message verified");
	}
	@Test
	public void Sfdcrememberme() throws InterruptedException {//TC-3
		String usernamedata=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passworddata=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		WebElement username_ele=driver.findElement(By.id("username"));
		entertext(username_ele, usernamedata, "username"); 
		WebElement password_ele=driver.findElement(By.id("password"));
		entertext(password_ele, passworddata, "password");
		//to check the rememberme checkbox
		WebElement remembercheckbox = driver.findElement(By.id("rememberUn"));
		if (!remembercheckbox.isSelected()) {
			remembercheckbox.click();
		    System.out.println("Checkbox is now selected.");
		} 
		WebElement login_but=driver.findElement(By.id("Login")); //login button functionality
		if(login_but.isDisplayed()) {
			login_but.click();
			System.out.println("Login Button clicked");
		}else {
			System.out.println("Login button not clicked");
		}
		Thread.sleep(5000);
		String HomepageTitle = driver.getTitle();// Verifying home page title
		System.out.println(HomepageTitle);
		//to click on the user menu dropdown from home page to logout
		WebElement usermenudropdown = driver.findElement(By.id("userNavLabel"));//find the xpath of usermenu
		usermenudropdown.click();
		Thread.sleep(5000);
		
		WebElement logoutoption=driver.findElement(By.xpath("//a[@title='Logout']"));
		logoutoption.click();
		System.out.println("logout clicked");
		Thread.sleep(2000);
		//Verify Loginpage title
		String loginpageTitle = driver.getTitle();// Verifying login page title
		System.out.println(loginpageTitle);
		//verify the username is displayed after logout
		WebElement rememberusername=driver.findElement(By.id("idcard-identity"));
				if(rememberusername.isDisplayed()){
			System.out.println("Username is showing for remember me testcase passed");
		}else {
			System.out.println("Username is not showing");
			}
		//		driver.close();
	}
	@Test
	public void Sfdcforgotpwd() throws InterruptedException {//TC-4
		WebElement forgotpwdlink = driver.findElement(By.id("forgot_password_link")); //give correct link text
		forgotpwdlink.click();
		//verify forgot password page is opened
		String forgotpwdpageTitle=driver.getTitle();
		System.out.println(forgotpwdpageTitle);
		//Provide <username> in salesforce forgot password page
		WebElement usernametext=driver.findElement(By.xpath("//input[@name='un']"));
		usernametext.sendKeys("raghunathan@cognizant.com");
		//continue button click
		WebElement continue_but=driver.findElement(By.id("continue")); //login button functionality
		if(continue_but.isDisplayed()) {
			continue_but.click();
			System.out.println("Continue Button clicked");
		}else {
			System.out.println("Contiue button not clicked");
		}
		//Password reset message page is displayed. 
		String resetpwdemailtitle = driver.getTitle();
		System.out.println(resetpwdemailtitle);
		//verify the message An email associated with the <username> account is sent.
		String actualMsg = driver.findElement(By.xpath("//*[@id=\"forgotPassForm\"]/div/p[1]")).getAttribute("innerHTML");
		String expmsg="We’ve sent you an email with a link to finish resetting your password.";
		if (actualMsg.equals(expmsg)) {
		    System.out.println("The forgot password text verified");
		} else {
		    System.out.println("The forgot password text not verified");
		}
	    Thread.sleep(5000);
		WebElement returntologin_but=driver.findElement(By.xpath("//*[@id=\"forgotPassForm\"]/a")); //login button functionality
		if(returntologin_but.isDisplayed()) {
			returntologin_but.click();
			System.out.println("Return to Login Button clicked for forgot password is passed");
		}else {
			System.out.println("Return to Login button not clicked");
		}
	}
	@Test
	public void SfdcInvalidUsernamePwd() {
		String Username="123";
		String Password="22131";
		WebElement username_ele=driver.findElement(By.id("username"));
		if(username_ele.isDisplayed()){
			username_ele.clear();
			username_ele.sendKeys(Username);
			System.out.println("Username is entered");
		}else {
			System.out.println("Username is not entered");
			}
		WebElement password_ele=driver.findElement(By.id("password"));
		if(password_ele.isDisplayed()) {
			password_ele.clear();
			password_ele.sendKeys(Password);
			System.out.println("Password entered");
		}else {
			System.out.println("Password not entered");
		}
		WebElement login_but=driver.findElement(By.id("Login"));
		if(login_but.isDisplayed()) {
			login_but.click();
			System.out.println("Login Button clicked");
		}else {
			System.out.println("Login button not clicked");
		}
		String actualMsg = driver.findElement(By.id("error")).getAttribute("innerHTML");//will get the input value with getattribute
		String experror="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		if (actualMsg.equals(experror)) {
		    System.out.println("Error message for invalid username& password Test Case Passed");
		} else {
		    System.out.println("Test Case Failed");
		}
	}

}
