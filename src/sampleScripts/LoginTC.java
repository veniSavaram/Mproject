package sampleScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.LoginPage;

public class LoginTC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "Tools//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		LoginPage base = new LoginPage(driver);
		
		base.launchERP();
		base.LoginERP();

	}

}
