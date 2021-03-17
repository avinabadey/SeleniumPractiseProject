package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {
	
	@Parameters ("URL")
	@Test(enabled=true)
	void webLoginCarLoan(String url) {
		System.out.println("Web Login of Car Loan");
		System.out.println(url);
	}
	
	@AfterClass
	void afterClass() {
		System.out.println("After class 4");
	}
	
	@Test(groups= "Smoke")
	void mobileLoginCarLoan() {
		System.out.println("Mobile Login of Car Loan");
	}
	
	@BeforeClass
	void beforeClass() {
		System.out.println("Before class 4");
	}
	
	@Test(enabled=false)
	void apiLoginCarLoan() {
		System.out.println("API Login of Car Loan");
	}
	
}
