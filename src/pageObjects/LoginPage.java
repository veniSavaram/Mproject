// Login Page Object example
// Login page java file from PageFactory
package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testData.readProperties;

public class LoginPage {
	
	WebDriver driver;
	By username = By.xpath("//input[@id='username']");
	By password = By.xpath("//input[@id='password']");
	By LoginButton = By.xpath("//button[@id='btnsubmit']");
	public static String baseurl; 
	public static String uname; 
	public static String upass; 

	public LoginPage(WebDriver driver) {
	   this.driver=driver;
	}
	
	public static void readConfigProperties() {
		
		readProperties get = new readProperties();
		get.readData();
		baseurl = readProperties.appurl;
		uname = readProperties.username;
		upass = readProperties.pwd;
		
	}
	public void launchERP() {
		LoginPage.readConfigProperties();
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	public void LoginERP() {
		//LoginPage.readConfigProperties();
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(upass);
		driver.findElement(LoginButton).click();
	}
	
	

}