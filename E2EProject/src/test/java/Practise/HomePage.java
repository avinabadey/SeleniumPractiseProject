package Practise;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;

public class HomePage extends Base{
	
	@BeforeTest
	public void initialize() throws FileNotFoundException, IOException {
		
		driver = initializeDriver();
		
	}
	
	@Test(dataProvider = "getData")
	public void navigationBase(String email, String password, String text) throws FileNotFoundException, IOException {
		
		driver.get(prop.getProperty("url"));
		
		LandingPage lp = new LandingPage(driver);
		lp.clickLogin().click();
		
		LoginPage login = new LoginPage(driver);
		login.setEmail().sendKeys(email);
		login.setPassword().sendKeys(password);
		System.out.println(text);
		login.clickLogin().click();
		
	}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[2][3];
		
		data[0][0] = "user1@gmail.com";
		data[0][1] = "pwd1";
		data[0][2] = "admin user";
		
		data[1][0] = "user2@gmail.com";
		data[1][1] = "pwd2";
		data[1][2] = "support user";
		
		return data;
	}
	
}
