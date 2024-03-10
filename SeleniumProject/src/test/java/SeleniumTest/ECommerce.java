package SeleniumTest;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ECommerce {

	WebDriver driver;

	@Test
	public void SeleniumProject() {
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Janet\\eclipse-workspace//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void Register() {
		driver.findElement(By.xpath("//a[contains(@href,'/register?returnUrl=%2F')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'gender-female')]")).click();
		driver.findElement(By.id("FirstName")).sendKeys("John");
		driver.findElement(By.id("LastName")).sendKeys("Smith");
		driver.findElement(By.id("Email")).sendKeys("hi090016@mail.com");
		driver.findElement(By.id("Company")).sendKeys("ABC Corp");
		WebElement notification = driver.findElement(By.id("Newsletter"));
		notification.click();
		driver.findElement(By.id("Password")).sendKeys("test123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("test123");
		driver.findElement(By.xpath("//button[contains(@id, 'register-button')]")).click();
		driver.findElement(By.xpath("//a[contains(@href, '/cart')]")).click();
	}

	@Test(priority = 2)
	public void Producttest() {
		driver.findElement(By.id("small-searchterms")).sendKeys("Apple MacBook Pro 13-inch");
		driver.findElement(By.xpath("//button[contains(@class, 'button-1 search-box-button')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'/apple-macbook-pro-13-inch')]")).click();
		driver.findElement(By.xpath("//button[contains(@id, 'add-to-cart-button-4')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'cart-label')]")).click();
		WebElement terms = driver.findElement(By.id("termsofservice"));
		terms.click();
		driver.findElement(By.xpath("//button[contains(@id, 'checkout')]")).click();
	}

	@Test(priority = 3)
	public void SignIn() {
		driver.findElement(By.id("Email")).sendKeys("hi090016@mail.com");
		driver.findElement(By.id("Password")).sendKeys("test123");
		driver.findElement(By.xpath("//button[contains(@class, 'button-1 login-button')]")).click();
	}

	@Test(priority = 4)
	public void Checkout() {
		WebElement terms = driver.findElement(By.id("termsofservice"));
		terms.click();
		driver.findElement(By.xpath("//button[contains(@id, 'checkout')]")).click();
	}

	@Test(priority = 5)
	public void PaymentPortal() {
		WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
		Select option = new Select(country);
		option.selectByVisibleText("United States");
		WebElement state = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
		Select options = new Select(state);
		options.selectByVisibleText("New York");
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("New York");
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("1234 Street");
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("100000");
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[contains(@class, 'button-1 new-address-next-step-button')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'shippingoption_1')]")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'button-1 shipping-method-next-step-button')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'paymentmethod_0')]")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'button-1 payment-method-next-step-button')]")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'button-1 payment-info-next-step-button')]")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'button-1 confirm-order-next-step-button')]")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'button-1 order-completed-continue-button')]")).click();
	}

	@AfterClass
	public void afterClass() {
    driver.close();
	}

}
