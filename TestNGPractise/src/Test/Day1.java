package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day1 {
	@Test(priority = 0)
	public void Demo(){
		System.out.println("Hello World!");
		Assert.assertTrue(false);
	}
	
	@Test(priority = 1)
	public void Check(){
		System.out.println("Check test");
	}

}
