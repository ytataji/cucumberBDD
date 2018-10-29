package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewDetails {

public static WebDriver driver;

public static void setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\tyerubandhi\\Downloads\\chromedriver.exe");	
	driver = new ChromeDriver();
}
public static void tearDown() {
	driver.quit();
}

	@Given("^user is on home page of RLH website$")
	public void user_is_on_home_page_of_RLH_website() throws InterruptedException {
		ViewDetails.setup();
		driver.get("https://prod.redlion.com");
		Thread.sleep(20000);
		driver.manage().window().maximize();
	}
	
	@When("^user clicks on particular location$")
	public void user_clicks_on_particular_location() throws Throwable {
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Red lion hotel port angeles");
		
		Thread.sleep(20000);
		Actions build = new Actions(driver);
    	build.moveToElement(driver.findElement(By.cssSelector("#globalSearchInput"))).moveByOffset(-150, 0).click().build().perform();
    	Actions a = new Actions(driver);
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
	String b[]=s1.split(" ");
	String s2=b[0].replace("Per", "");
	
	
	
	System.out.print(s2+" is the price per night for choosen hotel");
		
		
	
	}

	@Then("^user clicks on view details$")
	public void user_clicks_on_view_details() throws Throwable {
	    driver.findElement(By.xpath("(//button[contains(text(),'View Details')])[1]")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("(//div/child::button[@title='Select This Room'])[4]")).click();
		Thread.sleep(10000);
		 String s1= 	driver.findElement(By.xpath("//div[@class='checkout-itemized-list-items']")).getText();
		 System.out.println("cost distribution before we choose upgrade option:");
		 System.out.println(s1);
		 driver.findElement(By.xpath("(//button[@data-rate-code='RNRA'])[2]")).click();


		 String s2= 	driver.findElement(By.xpath("//div[@class='checkout-itemized-list-items']")).getText();
		 System.out.println("cost distribution after we choose upgrade option:");
		 System.out.println(s2);
		 
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

	@Then("^user captures the amenities$")
	public void user_captures_the_amenities() throws Throwable {
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='field field--name-name field--type-string field--label-hidden field__item']"));
		System.out.println("Below are the amenities found for the selected hotel");
		for(WebElement e:list) {
			System.out.println(e.getText());
		}
	}

	@Then("^user captures the details$")
	public void user_captures_the_details() throws Throwable {
	String s=   driver.findElement(By.xpath("(//div[@class='clearfix text-formatted field field--name-field-feature-description field--type-text-long field--label-hidden field__item'])[1]")).getText();
	   
	System.out.println("Below are the details found for the selectd hotel");
	System.out.println(s);
	
	
	
	
	
	
	
	ViewDetails.tearDown();
	
	}
	



}





