package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticeAutomation {
	
	WebDriver driver;
	
	@BeforeMethod
	public void SetUp()
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}
	@Test(priority=0)
	public void SignUp()
	{
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email_create")).sendKeys("arkamandal1202@gmail.com");
		driver.findElement(By.xpath("//form[@id='create-account_form']//span[1]")).click();
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Arka");
		driver.findElement(By.id("customer_lastname")).sendKeys("Mandal");
		driver.findElement(By.id("passwd")).sendKeys("Ab@#$&");
		WebElement daylistbox = driver.findElement(By.id("days"));
		Select s=new Select(daylistbox);
		s.selectByValue("12");
		WebElement monthlistbox = driver.findElement(By.id("months"));
		Select s1=new Select(monthlistbox);
		s1.selectByValue("2");
		WebElement yearlistbox = driver.findElement(By.id("years"));
		Select s2=new Select(yearlistbox);
		s2.selectByValue("1995");
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("company")).sendKeys("Tech Exactly");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Kestopur,ghoshpara");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Kolkata");
		WebElement state = driver.findElement(By.xpath("//select[@id='id_state']"));
		Select s3=new Select(state);
		s3.selectByValue("9");
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("12345");
		WebElement country = driver.findElement(By.xpath("//select[@id='id_country']"));
		Select s4= new Select(country);
		s4.selectByValue("21");
		driver.findElement(By.id("phone_mobile")).sendKeys("7980619225");
		driver.findElement(By.xpath("//input[@id='alias']")).clear();
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("Dumdum");
		driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
		
		
	}
	
	@Test(priority=1)
	public void Signout()
	{
		driver.findElement(By.className("login")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("arkamandal1202@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Ab@#$&");
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		driver.findElement(By.xpath("//a[@class='logout']")).click();
		
	}
	
	
	@Test(priority=2)
	public void LoginTest()
	{
		driver.findElement(By.className("login")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("arkamandal1202@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Ab@#$&");
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
	}
	
	@Test(priority=3)
	public void AddToCartTest()
	{
		WebElement ele = driver.findElement(By.xpath("(//img[@title='Faded Short Sleeve T-shirts'])[1]"));
		Actions action =new Actions(driver);
		action.moveToElement(ele);
		driver.findElement(By.xpath("(//span[text()='Add to cart'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='cross']")).click();
		WebElement ele1 = driver.findElement(By.xpath("(//img[@title='Blouse'])[2]"));
		Actions action1 =new Actions(driver);
		action1.moveToElement(ele1);
		driver.findElement(By.xpath("(//span[text()='Add to cart'])[2]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
		driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("arkamandal1202@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Ab@#$&");
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Please do not ring the bell multiple times");
		driver.findElement(By.xpath("//button[@name='processAddress']")).click();
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
		driver.findElement(By.className("bankwire")).click();
		driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
		driver.findElement(By.linkText("Back to orders")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
	}
	
	@Test(priority=4)
	public void EditPersonalInformationTest()
	{
		driver.findElement(By.className("login")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("arkamandal1202@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Ab@#$&");
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		driver.findElement(By.xpath("//a[@class='account']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'My personal information')]")).click();
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Arkas");
		driver.findElement(By.id("old_passwd")).sendKeys("Ab@#$&");
		driver.findElement(By.id("passwd")).sendKeys("12345678");
		driver.findElement(By.id("confirmation")).sendKeys("12345678");
		driver.findElement(By.xpath("//span[contains(text(),'Save')]//i[@class='icon-chevron-right right']")).click();
		
	}
	
	@Test(priority=5)
	public void EditAddressTest()
	{
		driver.findElement(By.className("login")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("arkamandal202@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("12345678");
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'My addresses')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Update')]")).click();
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567898");
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("Lixas");
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
		
	}
	
	@Test(priority=6)
	public void SearchResultTest()
	{
		driver.findElement(By.id("search_query_top")).sendKeys("Blouse");
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
	}
	
	@Test(priority=7)
	public void WishlistTest() throws InterruptedException
	{
		
			driver.findElement(By.className("login")).click();
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("arkamandal1202@gmail.com");
			driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("12345678");
			driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();

			WebElement quickview = driver.findElement(By.xpath("(//span[text()='Quick view']/ancestor::div[@class='product-image-container'])[1]"));
			int a = quickview.getLocation().getX();
			int b = quickview.getLocation().getY();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(" + a + ", " + b + ")");
			Thread.sleep(3000);
			Actions act= new Actions(driver);
			act.moveToElement(quickview).click().perform();
			WebElement wishlist = driver.findElement(By.xpath("//a[@id='wishlist_button']"));
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(wishlist));
			wishlist.click();
			String WishlistText = driver.findElement(By.xpath("//p[text()='Added to your wishlist.']")).getText();
			System.out.println(WishlistText);
		    Assert.assertEquals(WishlistText, "Added to your wishlist." ,"The element has been added");
	}
	
	
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}

}
