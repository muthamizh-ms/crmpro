package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.AssertionFailedError;


public class LoginStepDefinition {
	
	WebDriver driver;
	@Given("^User is already on Login Page$")
	public void  User_already_loginpage()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\Testing Automation\\CucumberFramework\\src\\main\\java\\browserDriver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://classic.crmpro.com");		
	}
	
	@When("^title of the login page is CRM$")
	public void  title_page_login()
	{
		String Title = driver.getTitle();
		System.out.println(Title);
		Assert.assertEquals("CRMPRO  - CRM software for customer relationship management, sales, and support.", Title);		
		}
	
	@Then("^User enter username and password$")
	public void user_enter_username_and_password()  {
	  
	    driver.findElement(By.name("username")).sendKeys("batchautomation");
	    driver.findElement(By.name("password")).sendKeys("Test@12345");
	   
	}
	
	
	@Then("^user click on Login Button$")
	public void user_click_on_Login_Button() throws Throwable {
	//	 driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")).click();
		 
		 WebElement loginButton=driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input"));
		 JavascriptExecutor js = (JavascriptExecutor) driver;  
		 js.executeScript("arguments[0].click()",loginButton);
		 
		 
	}
	
	@SuppressWarnings("deprecation")
	@Then("^user is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String Title = driver.getTitle();
		System.out.println("Home PAge tielteis " + Title);
		//Assert.assertEquals("CRMPRO", Title);	
		
		Assert.assertEquals("CRMPRO", Title, "*");
	}

	
}
