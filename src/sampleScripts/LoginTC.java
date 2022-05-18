package sampleScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.LoginPage;

public class LoginTC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Hello this is sample line
		// This line from cloud
		
		System.setProperty("webdriver.chrome.driver", "Tools//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		LoginPage base = new LoginPage(driver);
		
		base.launchERP();
		base.LoginERP();
		System.out.println("Hello this is for test");
		System.out.println("This change done from the GITHUB Server");

	}

}
