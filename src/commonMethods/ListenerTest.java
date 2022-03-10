package commonMethods;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import commonUtilities.GetScreenShot;

public class ListenerTest implements ITestListener{
	
	WebDriver driver;

	@Override
	public void onTestStart(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------------------------------------");
		System.out.println("The ["+Result.getName()+ "] Test Case execution is started...");	
	}

	@Override
	public void onTestSuccess(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("----------------------------------------------------------");
		System.out.println("The ["+Result.getName()+ "] Test Case is Passed...");	

	}

	@Override
	public void onTestFailure(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("----------------------------------------------------------");
		System.out.println("The ["+Result.getName()+ "] Test Case is Failed...");	
		try {
			GetScreenShot.getPic(driver, "ScreenShot//test.png");
			File destFile = new File("ScreenShot//test.png");
			Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("----------------------------------------------------------");
		System.out.println("The ["+Result.getName()+ "] Test Case execution skipped...");	
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext Result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext Result) {
		// TODO Auto-generated method stub
		System.out.println("----------------------------------------------------------");
		
	}

	

}
