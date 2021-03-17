package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By loginLink = By.xpath("//a[@href='http://qaclickacademy.usefedora.com/sign_in']");
	By title = By.cssSelector("div[class='text-center']>h2");
	
	public WebElement clickLogin() {
		return driver.findElement(loginLink);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
}
