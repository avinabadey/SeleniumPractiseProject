import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","D:\\Testing\\Selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.spicejet.com");
		
		//clicking on radio button
		//driver.findElement(By.xpath("//input[@value='RoundTrip']")).click();
		
		//finding number of radio buttons by group/name which is common for multiple radio buttons
		int rcount=driver.findElements(By.xpath("//input[@name='ctl00$mainContent$rbtnl_Trip']")).size();
		
		//clicking on radio button by index using get() dynamically
		for(int i=0;i<rcount;i++) {
			//driver.findElements(By.xpath("//input[@name='ctl00$mainContent$rbtnl_Trip']")).get(i).click();
			String rvalue = driver.findElements(By.xpath("//input[@name='ctl00$mainContent$rbtnl_Trip']")).get(i).getAttribute("value");
			
			if(rvalue.equals("RoundTrip")){
				driver.findElements(By.xpath("//input[@name='ctl00$mainContent$rbtnl_Trip']")).get(i).click();
			}
			
		}
		
	}

}
