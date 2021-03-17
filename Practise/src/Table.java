import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Table {

	public static void main(String[] args) {
		
		GetDriver get = new GetDriver();
		WebDriver driver = get.loadChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");
		
		WebElement table = driver.findElement(By.xpath("//div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));		
		//WebElement table = maintable.findElement(By.xpath("//span[text()='Sri Lanka Innings']/parent::div/following-sibling::div/div[text()='Batsman']/parent::div/parent::div"));
		int count = table.findElements(By.xpath("//span[text()='Sri Lanka Innings']/parent::div/following-sibling::div/div[text()='Batsman']/parent::div/following-sibling::div")).size();
		
		System.out.println("row count: " + count);
		
		int sum = 0;
		
		for(int i=0; i<count-2; i++) {
			String r = table.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-scrd-itms']/div[3]")).get(i).getText();
			int run = Integer.parseInt(r);
			System.out.println("Run: " + run);
			sum = sum + run;
		}
		
		System.out.println("Total Run without extras: " + sum);
		
		String rext = table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div[1]")).getText();
		int runExtra = Integer.parseInt(rext);
		sum = sum + runExtra;
		System.out.println("Total run with extras: " + sum);
		
		String rtot = table.findElement(By.xpath("//div[text()='Total']/following-sibling::div[1]")).getText();
		int runTotal = Integer.parseInt(rtot);
		System.out.println("Printed Total run: " + runTotal);
		
		if(sum==runTotal){
			System.out.println("Calculated and Printed total Run is a match. Code Successfull!!!");
		} else {
			System.out.println("Calculated and Printed total Run is NOT a match. Code FAILED!!!");
		}
		
	}

}
