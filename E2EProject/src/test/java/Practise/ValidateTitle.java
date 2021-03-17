package Practise;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;

public class ValidateTitle extends Base{
	
	@BeforeTest
	public void initialize() throws FileNotFoundException, IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void navigationBase() throws IOException {
		
		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "Featured Courses 123");
		/*lp.clickLogin().click();
		
		LoginPage login = new LoginPage(driver);
		login.setEmail().sendKeys(email);
		login.setPassword().sendKeys(password);
		System.out.println(text);
		login.clickLogin().click();*/
		
	}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
		driver=null;
	}
	
}
