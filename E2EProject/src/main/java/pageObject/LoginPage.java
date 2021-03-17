package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By emailAddress = By.xpath("//input[@id='user_email']");	
	By password = By.xpath("//input[@id='user_password']");
	By login = By.xpath("//input[@value='Log In']");
	
	public WebElement setEmail() {
		return driver.findElement(emailAddress);
	}
	
	public WebElement setPassword() {
		return driver .findElement(password);
	}
	
	public WebElement clickLogin() {
		return driver.findElement(login);
	}
}