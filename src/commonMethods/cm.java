package commonMethods;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class cm {
	
	static WebDriver driver;
	static String baseurl = "http://projects.qedgetech.com/webapp/login.php";
	

// Launching Chrome Browser
	public static void launchchrome() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
    	driver = new ChromeDriver();
}

//Closing the Chrome browser
	public static void closeChrome() {
    	driver.close();
}

//Launch ERP Stock Accounting Application
	public static void launchERP() throws InterruptedException {
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	 }
	
//Get Page Title of the focused window
	public static String getPageTitle() {
		String pageTitle = driver.getTitle();
	    return pageTitle;
	 }

//Click on Login button
	public static void LoginERP() {
		WebElement login = driver.findElement(By.xpath("//button[@name=\"btnsubmit\"]"));
	    login.click();
	}
	
//Get Text of the Given Web Element
   public static String checkLogin() {
      WebElement logout = driver.findElement(By.xpath("//a[@id=\"logout\"]"));
      String Text = logout.getText();
      return Text;
}

// Select Stock Items Menu
public static void selectStockItems() throws Throwable {
	
	WebElement stockItems = driver.findElement(By.xpath("//a[contains(text(),\"Stock Items \")]"));
	Actions actions=new Actions(driver);
	actions.moveToElement(stockItems).build().perform();
	stockItems.click();
	String caption = driver.findElement(By.xpath("//*[@id='ewPageCaption']")).getText();
	Assert.assertEquals(caption, "Stock Items");
	
	}

public static void selectStockCategories() throws Throwable {
	
    WebElement stockItems = driver.findElement(By.xpath("//a[contains(text(),\"Stock Items \")]"));
	
	Actions actions=new Actions(driver);
	actions.moveToElement(stockItems).build().perform();
	
	WebElement stockCat = driver.findElement(By.xpath("//li[@id='mmi_a_stock_categories']/following::a[@href='a_stock_categorieslist.php']"));
	actions.moveToElement(stockCat).build().perform();
	stockCat.click();
}

public static void selectUnitOfMeasurement() throws Throwable {
	
    WebElement stockItems = driver.findElement(By.xpath("//a[contains(text(),\"Stock Items \")]"));
	
	Actions actions=new Actions(driver);
	actions.moveToElement(stockItems).build().perform();
	
	WebElement unitMeasurement = driver.findElement(By.xpath("//li[@id='mi_a_unit_of_measurement']"));
	actions.moveToElement(unitMeasurement).build().perform();
	unitMeasurement.click();
}

public static void logout() {
	
	WebElement erpLogout = driver.findElement(By.xpath("//li[@id='mi_logout']"));
	erpLogout.click();
}

public static void logout1() throws Throwable {
	
	
	WebElement erpLogout = driver.findElement(By.xpath("//a[@id='logout']"));
	erpLogout.click();
	String alertWindow = driver.getWindowHandle();	
	driver.switchTo().window(alertWindow);
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	WebElement alertOK = driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
	alertOK.click();
}

public static void addStockItem() throws Throwable {
	
	WebElement addStock = driver.findElement(By.xpath("(//span[@data-caption='Add'])[1]"));
	addStock.click();
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	Select category = new Select(driver.findElement(By.id("x_Category")));
	category.selectByVisibleText("samsung");
	Select supplierNumber = new Select(driver.findElement(By.id("x_Supplier_Number")));
	supplierNumber.selectByVisibleText("HYD");
	WebElement stockName = driver.findElement(By.xpath("//input[@id='x_Stock_Name']"));
	stockName.sendKeys("Samsung Galaxy S21");
	Select uom = new Select(driver.findElement(By.id("x_Unit_Of_Measurement")));
	uom.selectByVisibleText("Units");
	WebElement purchasePrice = driver.findElement(By.xpath("//input[@id='x_Purchasing_Price']"));
	purchasePrice.sendKeys("100000");
	WebElement sellingPrice = driver.findElement(By.xpath("//input[@id='x_Selling_Price']"));
	sellingPrice.sendKeys("125000");
	WebElement notes = driver.findElement(By.xpath("//input[@id='x_Notes']"));
	notes.sendKeys("Samsung Galaxy S21");
	WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
	submit.click();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	String alertWindow = driver.getWindowHandle();	
	driver.switchTo().window(alertWindow);
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	WebElement confirm = driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
	confirm.click();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	cm.selectStockItems();
	
}

//Select Stock Items Menu
public static void selectCustomer() throws Throwable {
	WebElement customer = driver.findElement(By.xpath("//li[@id='mi_a_customers']"));
	customer.click();
	}

public static void addCustomer() throws Throwable {
	
	WebElement addCustomer = driver.findElement(By.xpath("(//span[@data-caption='Add'])[1]"));
	addCustomer.click();
	WebElement cname = driver.findElement(By.xpath("//input[@id='x_Customer_Name']"));
	cname.sendKeys("Medha Enterprises");
	WebElement caddress = driver.findElement(By.xpath("//textarea[@id='x_Address']"));
	caddress.sendKeys("Door No: 786 - Ameerpet - Hyderabad");
	WebElement city = driver.findElement(By.xpath("//input[@id='x_City']"));
	city.sendKeys("Bangalore");
	WebElement country = driver.findElement(By.xpath("//input[@id='x_Country']"));
	country.sendKeys("India");
	WebElement contact = driver.findElement(By.xpath("//input[@id='x_Contact_Person']"));
	contact.sendKeys("Hari Kumar");
	WebElement phone = driver.findElement(By.xpath("//input[@id='x_Phone_Number']"));
	phone.sendKeys("9999188881");
	WebElement email = driver.findElement(By.xpath("//input[@id='x__Email']"));
	email.sendKeys("harik@medhaxl.com");
	WebElement mobile = driver.findElement(By.xpath("//input[@id='x_Mobile_Number']"));
	mobile.sendKeys("9999188881");
	WebElement notes = driver.findElement(By.xpath("//input[@id='x_Notes']"));
	notes.sendKeys("New Customer Addition");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement addButton = driver.findElement(By.xpath("//button[@type='submit']"));
	js.executeScript("arguments[0].scrollIntoView();", addButton);
	addButton.click();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	String alertWindow = driver.getWindowHandle();	
	driver.switchTo().window(alertWindow);
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	WebElement confirm = driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
	confirm.click();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    cm.selectStockItems();
	cm.selectCustomer();
}

public static void selectExport() {
	
	WebElement exportButton = driver.findElement(By.xpath("//span[@data-phrase='ButtonExport']"));
	exportButton.click();
		
}

public static void selectPrinterFriendly(String pageTitle) {
	
	WebElement selectPrinter = driver.findElement(By.xpath("//a[@data-caption='Printer Friendly']"));
	selectPrinter.click();
	Assert.assertEquals(driver.getTitle(), pageTitle);
		
}

public static void selectExcel(String pageTitle) {
	
	WebElement selectExcel = driver.findElement(By.xpath("//a[@data-caption='Excel']"));
	selectExcel.click();
	Assert.assertEquals(driver.getTitle(), pageTitle);
			
}

public static void selectXML(String pageTitle) {
	
	WebElement selectXML = driver.findElement(By.xpath("//a[@data-caption='XML']"));
	selectXML.click();
	String actualText = driver.findElement(By.xpath("//*[contains(text(),'XML')]")).getText();
	Assert.assertTrue(actualText.contains(pageTitle));
		
}

public static void selectWord(String pageTitle) {
	
	WebElement selectWord = driver.findElement(By.xpath("//a[@data-caption='Word']"));
	selectWord.click();
	Assert.assertEquals(driver.getTitle(), pageTitle);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
}

public static void selectHTML(String pageTitle) {
	
	WebElement selectHTML = driver.findElement(By.xpath("//a[@data-caption='HTML']"));
	selectHTML.click();
	Assert.assertEquals(driver.getTitle(), pageTitle);
		
}

public static void selectCSV(String pageTitle) {
	
	WebElement selectCSV = driver.findElement(By.xpath("//a[@data-caption='CSV']"));
	selectCSV.click();
	System.out.println(driver.getTitle());
	Assert.assertEquals(driver.getTitle(), pageTitle);
		
}

public static void gotoActions() {
	
	WebElement gotoActions = driver.findElement(By.xpath("(//span[@data-phrase='ButtonActions'])[1]"));
	gotoActions.click();
		
}

public static void selectThefirstRecord() {
	
	WebElement selectRecord = driver.findElement(By.xpath("//span[@id='el1_a_stock_items_checkbox']"));
	selectRecord.click();
		
}

public static void selectTheCustomerRecord2() {
	
	WebElement selectRecord = driver.findElement(By.xpath("//span[@id='el2_a_customers_checkbox']"));
	selectRecord.click();
		
}

public static void selectTheCustomerRecord1() {
	
	WebElement selectRecord = driver.findElement(By.xpath("//span[@id='el1_a_customers_checkbox']"));
	selectRecord.click();
		
}

public static void selectTheSecondRecord() {
	
	WebElement selectRecord = driver.findElement(By.xpath("//span[@id='el2_a_stock_items_checkbox']"));
	selectRecord.click();
		
}

public static void deleteSelectedStockItem() throws Throwable {
	
	WebElement delSelectRecords = driver.findElement(By.xpath("(//a[@data-caption='Delete Selected Records'])[1]"));
	delSelectRecords.click();
	String alertWindow = driver.getWindowHandle();	
	driver.switchTo().window(alertWindow);
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	WebElement alertOK = driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
	alertOK.click();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	alertWindow = driver.getWindowHandle();	
	driver.switchTo().window(alertWindow);
	alertOK = driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
	alertOK.click();
	//cm.selectStockItems();
}

public static void deleteSelectedRecords() throws Throwable {
	
	WebElement delSelectRecords = driver.findElement(By.xpath("(//a[@data-caption='Delete Selected Records'])[1]"));
	delSelectRecords.click();
	String alertWindow = driver.getWindowHandle();	
	driver.switchTo().window(alertWindow);
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	WebElement alertOK = driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
	alertOK.click();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);	
	cm.selectCustomer();
}

public static void updateSelectedStockItem() throws Throwable {
	
	WebElement updateSelectedRecords = driver.findElement(By.xpath("(//a[@data-caption='Update Selected Records'])[1]"));
	updateSelectedRecords.click();
	
	WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox' and @id='u_Stock_Name']"));
	checkBox.click();
	
	WebElement input = driver.findElement((By.xpath("//input[@id='x_Stock_Name']")));
	input.clear();
	input.sendKeys("Samsung Galaxy S21 v1");
	
	WebElement submit = driver.findElement((By.xpath("//button[@id='btnAction']")));
	submit.click();
	
	String alertWindow = driver.getWindowHandle();	
	driver.switchTo().window(alertWindow);
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	WebElement alertOK = driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
	alertOK.click();
	cm.selectStockItems();
}

public static void updateSelectedCustomer() throws Throwable {
	
	WebElement updateSelectedRecords = driver.findElement(By.xpath("(//a[@data-caption='Update Selected Records'])[1]"));
	updateSelectedRecords.click();
	
	WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox' and @id='u_Customer_Name']"));
	checkBox.click();
	
	WebElement input = driver.findElement((By.xpath("//input[@id='x_Customer_Name']")));
	input.clear();
	input.sendKeys("Medha Private Ltd.");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement submit = driver.findElement((By.xpath("//button[@id='btnAction']")));
	js.executeScript("arguments[0].scrollIntoView();", submit);
	submit.click();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	String alertWindow = driver.getWindowHandle();	
	driver.switchTo().window(alertWindow);
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	WebElement alertOK = driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
	alertOK.click();
	cm.selectStockItems();
	cm.selectCustomer();
}

public static void selectSearch() {
	
	WebElement searchBtn = driver.findElement(By.xpath("//span[@data-phrase='SearchBtn']"));
	searchBtn.click();
		
}

public static void searchStockItem(String searchItem) {
	
	WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
	input.sendKeys(searchItem);
	WebElement search = driver.findElement(By.xpath("//button[@name='btnsubmit']")); 
	search.click();
	String stockName = driver.findElement(By.xpath("//span[@id='el1_a_stock_items_Stock_Name']")).getText();
	Assert.assertEquals(stockName, searchItem);
	
}

public static void searchCustomer(String searchItem) {
	
	WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
	input.sendKeys(searchItem);
	WebElement search = driver.findElement(By.xpath("//button[@name='btnsubmit']")); 
	search.click();
	String cName = driver.findElement(By.xpath("//span[@id='el1_a_customers_Customer_Name']")).getText();
	Assert.assertEquals(cName, searchItem);
	
}

public static void saveFilter(String filterName) throws Throwable {
	
	WebElement filterDropdown = driver.findElement(By.xpath("//button[@data-original-title='Filters']"));
	filterDropdown.click();
	WebElement selectSaveFilter = driver.findElement(By.xpath("//a[@class='ewSaveFilter']")); 
	selectSaveFilter.click();
	String alertWindow = driver.getWindowHandle();	
	driver.switchTo().window(alertWindow);
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	WebElement input = driver.findElement(By.xpath("(//input[@class='form-control' and @type='text'])[2]")); 
	input.sendKeys(filterName);
	WebElement alertOK = driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
	alertOK.click();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);	
	filterDropdown.click();
	WebElement savedFilter = driver.findElement(By.xpath("//a[@class='ewFilterList']")); 
	String ActualFilterName = savedFilter.getText();
	Assert.assertEquals(ActualFilterName, filterName);
	
}

public static void deleteFilter(String filterName) throws Throwable {
	
	WebElement filterDropdown = driver.findElement(By.xpath("//button[@data-original-title='Filters']"));
	filterDropdown.click();
    WebElement deleteFilter = driver.findElement(By.xpath("//a[@class='ewDeleteFilter']"));
	
	Actions actions=new Actions(driver);
	actions.moveToElement(deleteFilter).build().perform();
	
	WebElement filter = driver.findElement(By.xpath("(//a[@data-index='0'])[2]"));
	String fname = filter.getText();
	actions.moveToElement(filter).build().perform();
	filter.click();
	String alertWindow = driver.getWindowHandle();	
	driver.switchTo().window(alertWindow);
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	WebElement alertOK = driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
	alertOK.click();
	Assert.assertEquals(fname, filterName);
	
}

public static void searchUOM(String searchItem) {
	
	WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
	input.sendKeys(searchItem);
	WebElement search = driver.findElement(By.xpath("//button[@name='btnsubmit']")); 
	search.click();
	String uom = driver.findElement(By.xpath("//span[@id='el1_a_unit_of_measurement_UOM_Description']")).getText();
	Assert.assertEquals(uom, searchItem);
	
}

public static void navigateBack() {
	
	driver.navigate().back();
		
}

public static void navigateRefresh() {
	
	driver.navigate().refresh();
		
}

public static boolean isFileDownloaded(String downloadPath, String fileName) {
	  File dir = new File(downloadPath);
	  File[] dirContents = dir.listFiles();
	  //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  for (int i = 0; i < dirContents.length; i++) {
	      if (dirContents[i].getName().equals(fileName)) {
	          // File has been found, it can now be deleted:
	          dirContents[i].delete();
	          return true;
	      }
	          }
	      return false;
	  }


///////////////////////////////////////////////////////////////////////////////////////	
}  // End of Common Method Class
