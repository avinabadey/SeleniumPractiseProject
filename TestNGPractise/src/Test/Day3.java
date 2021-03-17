package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {
	
	@Parameters ("URL")
	@Test(enabled=true)
	void webLoginPersonalLoan(String url) {
		System.out.println("Web Login of Personal Loan");
		System.out.println(url);
	}
	
	@Test(groups= {"Smoke"})
	void mobileLoginPersonalLoan() {
		System.out.println("Mobile Login of Personal Loan");
	}
	
	@Test(timeOut=4000)
	void mobileLogoutPersonalLoan() {
		System.out.println("Mobile Logout of Personal Loan");
	}
	
	@Test(dependsOnMethods= {"mobileLogoutPersonalLoan"})
	void apiLoginPersonalLoan() {
		System.out.println("API Login of Personal Loan");
	}
	
	@BeforeMethod
	void beforeMethod() {
		System.out.println("Before all methods in day 3.");
	}
	
	@AfterMethod
	void afterMethod() {
		System.out.println("After all methods in day3.");
	}
	
	@BeforeSuite
	void beforeSuite() {
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	void afterSuite() {
		System.out.println("After Suite");
	}
	
	@Test(dataProvider = "getData")
	void loginPage(String username, String password) {
		System.out.println("Please enter login credentials.");
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "User1";
		data[0][1] = "Pwd1";
		
		data[1][0] = "User2";
		data[1][1] = "Pwd2";
		
		data[2][0] = "User3";
		data[2][1] = "Pwd3";
		
		return data;
	}
}
