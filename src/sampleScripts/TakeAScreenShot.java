package sampleScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import commonUtilities.GetScreenShot;

public class TakeAScreenShot {

    @Test

    public void TakeScreenShot() throws Exception{
    
		WebDriver driver ;
    	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
    	driver = new ChromeDriver();
        try {
           driver.get("http://projects.qedgetech.com/webapp/login.php");
           driver.findElement(By.id("btnsubmit")).click();
           if(driver.findElement(By.id("ewPageCaption1")).isDisplayed()) {
        	  System.out.println("TestCase Passed..");
           }
        }
        //Call take screenshot function
        catch (Exception e) {
    	   System.out.println("TestCase Failed..");
    	   GetScreenShot.getPic(driver, "ScreenShot//test.png");
        }
    }
}

  