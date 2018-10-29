package stepDefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

import MyRunner.TestRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookaHotelRLH{

Actions a;
public static WebDriver driver;
public static boolean flag1=false;
public static boolean flag2=false;
public static ArrayList<String> al=new ArrayList<String>();

public static void setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\tyerubandhi\\Downloads\\chromedriver.exe");	
	driver = new ChromeDriver();
}

public static void selectDateByJs(WebElement element,String DateValue){
	
	 JavascriptExecutor js=((JavascriptExecutor)driver);
	 js.executeScript("arguments[0].setAttribute('value','"+DateValue+"');",element);
}

public static void TearDown() {
	driver.quit();
}

	@Given("^user is on RLH website$")
	public void user_is_on_RLH_website() throws InterruptedException{
		/* System.setProperty("webdriver.chrome.driver", "C:\\Users\\tyerubandhi\\Downloads\\chromedriver.exe");	
			driver = new ChromeDriver(); */
		BookaHotelRLH.setup();
			driver.get("https://prod.redlion.com");
			Thread.sleep(20000);
			driver.manage().window().maximize();
	}

	@When("^user enters \"([^\"]*)\"$")
	public void user_enters(String location) throws Throwable {
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(location);
	}

	@Then("^choose hotel in entered location$")
	public void choose_hotel_in_entered_location() throws InterruptedException {
		Thread.sleep(20000);
		// Actions build = new Actions(driver);
	    //	build.moveToElement(driver.findElement(By.cssSelector("#globalSearchInput"))).moveByOffset(-150, 0).click().build().perform();
	    	
	}

	@Then("^select hotel from different options$")
	public void select_hotel_from_different_options() throws Throwable {
		 Actions build = new Actions(driver);
	    	build.moveToElement(driver.findElement(By.cssSelector("#globalSearchInput"))).moveByOffset(-150, 0).click().build().perform();
	    	
		Thread.sleep(5000);
		a =new Actions(driver);
    	a.moveToElement(driver.findElement(By.xpath("(//li/child::a/child::strong)[1]"))).click().build().perform();
    	Thread.sleep(10000);
    	
    	WebElement e1=driver.findElement(By.xpath("//input[@id='searchStartDate']"));
    	System.out.println(e1.isDisplayed());
    	WebElement e2=driver.findElement(By.xpath("//input[@id='searchEndDate']"));
    	System.out.println(e2.isDisplayed());
    	e1.clear();
    	e1.sendKeys("Jan 03,2019");
    	e2.clear();
    	e2.sendKeys("Jan 04,2019");
    	//BookaHotelRLH.selectDateByJs(e1, "Jan 03, 2019");	
    	Thread.sleep(3000);
    	//BookaHotelRLH.selectDateByJs(e2, "Jan 04, 2019");
    	
    	a.moveToElement(driver.findElement(By.xpath("//div/child::a/child::span"))).click().build().perform();
    	
    //	a.moveToElement(driver.findElement(By.xpath("//li/child::a[@title='Government']"))).click().build().perform();
    	driver.findElement(By.xpath("//button[contains(text(),'Check Availability')]")).click();
    	Thread.sleep(10000);
    	/*Select s=new Select(driver.findElement(By.xpath("//select[@title='Select a Room Type']")));
    	
    	s.selectByIndex(1);*/
     	a.moveToElement(driver.findElement(By.xpath("//select[@title='Select a Room Type']"))).click().build().perform();
    	Thread.sleep(5000);
    	a.moveToElement(driver.findElement(By.xpath("(//span[@class='text'])[2]"))).doubleClick().build().perform();
    	Thread.sleep(10000);
    	String s1=driver.findElement(By.xpath("(//div[@class='right-container js-temp-right-container text-right price-container'])[1]")).getText();
    	String a[]=s1.split(" ");
    	String s2=a[0].replace("Per", "");
    	
    	
    	
    	System.out.print(s2+" is the price per night for choosen hotel");
    	driver.findElement(By.xpath("(//div/child::button[contains(text(),'Quick Book')])[1]")).click();
    	Thread.sleep(10000);
	}
	
	

	@Then("^Fill the form to book a hotel$")
	public void fill_the_form_to_book_a_hotel() throws Throwable {
		driver.findElement(By.xpath("//button[@title='Edit']")).click();
		driver.findElement(By.xpath("//input[@id='to-edit']")).clear();
		driver.findElement(By.xpath("//input[@id='to-edit']")).sendKeys("Jan 05,2019");
		Thread.sleep(3000);
		Robot robot = new Robot();

	    // Simulate a key press
	  
	    robot.keyPress(KeyEvent.VK_TAB);
	    Thread.sleep(3000);	
	    robot.keyRelease(KeyEvent.VK_TAB);
	    
	Thread.sleep(2000);
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//button[@id='btnUpdateReservation']"))).doubleClick().build().perform();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//button[@id='btnUpdateReservation']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Tataji");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Yerubandhi");
		
		driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("ytataji555@gmail.com");
		driver.findElement(By.xpath("(//input[@type='tel'])[1]")).sendKeys("9505367379");
		driver.findElement(By.xpath("(//input[@type='tel'])[2]")).sendKeys("531126");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='checkoutScreen']")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='cardNumber']")).sendKeys("4012000033330026");
		driver.findElement(By.xpath("//input[@id='fullYear']")).sendKeys("12/18");
		driver.findElement(By.xpath("//input[@id='cvc']")).sendKeys("012");
		driver.findElement(By.xpath("//input[@id='postalCode']")).sendKeys("1223");
		driver.switchTo().defaultContent();
	}
	
	@And("^Get the price details$")
	public void get_the_price_details() throws InterruptedException {
		Thread.sleep(10000);
		
		 String s1= 	driver.findElement(By.xpath("//div[@class='checkout-itemized-list-items']")).getText();
		 System.out.println("cost distribution before we check extra options:");
		 System.out.println(s1);
		try {
	if(	driver.findElement(By.xpath("(//header/child::h4)[3]")).isDisplayed())
	{
		try {
		a.moveToElement(driver.findElement(By.xpath("//label[@for='Late Check']"))).click().build().perform();;
		flag1=true;
		}
		catch(Exception e) {
			System.out.println("Late Checkout option is not found");
		}
		try {
			a.moveToElement(driver.findElement(By.xpath("//label[@for='RNR']"))).click().build().perform();;
			flag1=true;
			}
			catch(Exception e) {
				System.out.println("Pay at Hotel option is not found");
			}
		try {
			driver.findElement(By.xpath("//div/child::input[@id='Early Check']")).click();
			flag2=true;
			}
			catch(Exception e) {
				System.out.println("Early Checkout option is not found");
			}
			
		
	}
    /*	
    	a.moveToElement(driver.findElement(By.xpath("//div/child::input[@id='Early Check']"))).click().build().perform();
    	Thread.sleep(5000);
    	a.moveToElement(driver.findElement(By.xpath("//div/child::input[@id='Late Check']"))).click().build().perform();
    	Thread.sleep(5000);*/
	}
		catch(Exception e) {
			System.out.println("Options are not found");
		}
		Thread.sleep(5000);
   String s2= 	driver.findElement(By.xpath("//div[@class='checkout-itemized-list-items']")).getText();
   Thread.sleep(5000);
   
		// String s3= 	driver.findElement(By.xpath("//div[@class='room-rate d-flex justify-content-between padding-top-bottom-5']")).getText();
		// String s4=driver.findElement(By.xpath("//div[@class='//div[@class='discount d-flex justify-content-between padding-top-bottom-5']")).getText();
		 
   System.out.println("cost disribution after we check extra options:");
   System.out.println(s2);
   
   String line = "#food was testy. #drink lots of. #night was fab. #three #four";

   Pattern pattern = Pattern.compile("$\\w+");

   Matcher matcher = pattern.matcher(s2);
   while (matcher.find())
   {
       System.out.println(matcher.group());
   }
   
	 /*System.out.println(s2);
	String [] b=s2.split(" ");
	for(String s:b) {
		String x=s.replace("$", "");
		al.add(x);
		
	String [] t=	x.split(" ");
	for(String s6:t) {
		System.out.println(t[1]+",");}
	}
	

	 
  // BookaHotelRLH.TearDown();
*/
	
	
	
	
}}
