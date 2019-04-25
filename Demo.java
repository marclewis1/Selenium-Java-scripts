package selenium.demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// Script to launch the MSU webpage and verify the title of the page is correct 
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.msstate.edu");
		driver.manage().window().maximize();

		
		String at = driver.getTitle();
		String et = "Mississippi State University";
		driver.close();
		if(at.equalsIgnoreCase(et))
		{
			System.out.println("Title of page loaded Successfully");
		}
		else
		{
			System.out.println("Title of page was incorrect");
		}
	

	}

}
