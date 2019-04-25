package selenium.demo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Windows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Script to open Citibank site in one tab and Google site in another tab in Firefox browser

		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.online.citibank.co.in");
		driver.manage().window().maximize();
		
		String parent = driver.getWindowHandle();
		System.out.println("Parent " + parent);  //Printout ID of parent window
		
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div/div[1]/div[1]/p[2]/a[1]/img")).click();  //click Login Now
		
		Set<String> allWindows = driver.getWindowHandles();		//create variable with set of strings to contain all Windows
		System.out.println("All Windows" + allWindows);  //Printout ID of all open windows
		
		for(String child:allWindows)					//run for loop for all open windows
		{
			if(!parent.equalsIgnoreCase(child))			//if 2 windows are open
			{
				driver.switchTo().window(child);		//switch to child window
				driver.get("http://www.google.com");	//navigate to google
				System.out.println(driver.getCurrentUrl());  //print the google URL
				Thread.sleep(3000);						//wait 3 seconds
				driver.close();							//close the tab
			}
		}
	}

}
