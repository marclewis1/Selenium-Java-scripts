package selenium.demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WF_dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Script to select Brokerage from the View Your Accounts dropdown
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();			//setting up a WebDriver for Chrome
		driver.get("https://www.wellsfargo.com");	//navigate to webpage
		WebElement dropdown = driver.findElement(By.name("destination"));	//creating a WebElement for Account Summary dropdown menu
		Select select = new Select(dropdown);  		//creating a Select class for the dropdown
		select.selectByValue("Brokerage");				//using the selectByValue method to select Brokerage


	}

}
