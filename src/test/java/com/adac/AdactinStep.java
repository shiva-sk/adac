package com.adac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdactinStep {
	WebDriver driver;
	@Given("Launch into https:\\/\\/adactin.com\\/HotelApp\\/")
	public void launch_into_https_adactin_com_HotelApp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SHIVA\\eclipse\\AdactinCucuPom\\driver\\chromedriver.exe");
		driver = new ChromeDriver();  
		driver.get("http://www.adactin.com/HotelApp/index.php");

	}

	@When("Provide The Required {string},{string} in Login Page")
	public void provide_The_Required_in_Login_Page(String user, String pas) {
		WebElement us = driver.findElement(By.id("username"));
		us.sendKeys(user);
		WebElement pa= driver.findElement(By.id("password"));
		pa.sendKeys(pas);
		WebElement click = driver.findElement(By.id("login"));
		click.click();
	}

	@When("Provide {string},{string},{string},{string} and click search")
	public void provide_and_click_search(String Location, String Hotels, String Type, String Children) {
	   
		WebElement l = driver.findElement(By.name("location"));
		Select s = new Select(l);
		s.selectByVisibleText(Location);
		WebElement hotel = driver.findElement(By.xpath("(//select[@class='search_combobox'])[2]"));
		Select h = new Select(hotel);
		h.selectByVisibleText(Hotels);
		WebElement typ = driver.findElement(By.id("room_type"));
		Select t = new Select(typ);
		t.selectByVisibleText(Type);
		WebElement chi = driver.findElement(By.id("child_room"));
		Select c = new Select(chi);
		c.selectByVisibleText(Children);
		WebElement sub = driver.findElement(By.id("Submit"));
		sub.click();

	}

	@When("Click RadioButton and Submit")
	public void click_RadioButton_and_Submit() {
		WebElement btn = driver.findElement(By.id("radiobutton_0"));
		btn.click();
		WebElement con = driver.findElement(By.id("continue"));
		con.click();	    

	}

	@When("Provide {string},{string},{string},{string},{string} and click Booknow")
	public void provide_and_click_Booknow(String FirstName, String LastName, String BillingAddress, String CType, String Month) {
		WebElement fname = driver.findElement(By.id("first_name"));
		fname.sendKeys(FirstName);
		WebElement lasname = driver.findElement(By.id("last_name"));
		lasname.sendKeys(LastName);
		WebElement add = driver.findElement(By.id("address"));
		add.sendKeys(BillingAddress);
		WebElement cc = driver.findElement(By.id("cc_num"));
		cc.sendKeys("9234567891547896");
		WebElement cctype = driver.findElement(By.id("cc_type"));
		Select s1 = new Select(cctype);
		s1.selectByVisibleText(CType);
		WebElement s2 = driver.findElement(By.id("cc_exp_month"));
		Select mon = new Select(s2);
		mon.selectByVisibleText(Month);
		WebElement ye = driver.findElement(By.id("cc_exp_year"));
		Select s3 = new Select(ye);
		s3.selectByValue("2020");
		WebElement t1 = driver.findElement(By.id("cc_cvv"));
		t1.sendKeys("567");
		WebElement t2 = driver.findElement(By.id("book_now"));
		t2.click();

	}

	@Then("Print the OrderNo")
	public void print_the_OrderNo() throws InterruptedException {
		Thread.sleep(9000);
		WebElement id = driver.findElement(By.id("order_no"));
		String book = id.getAttribute("value");
		System.out.println(book);

	}

	@Then("Exit the browser")
	public void exit_the_browser() {
	   
	}

}
