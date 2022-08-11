package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class LoginTC111 {
  @Test
  public void login1() {
	  
	  System.setProperty("webdriver.chrome.driver", "Tools//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		LoginPage base = new LoginPage(driver);
		
		base.launchERP();
		base.LoginERP();
		
		System.out.println("This TC is related to Login Test Case..");
	        System.out.println("This line is added from GITHUB Server..");
  }
}
