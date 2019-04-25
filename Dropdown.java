package selenium.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;



public class Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();						//setting up a WebDriver for Chrome
		driver.get("http://way2automation.com/way2auto_jquery/");	//navigate to webpage
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);  //implicit wait of 12 seconds
		driver.manage().window().maximize();						//maximize the webpage
		driver.findElement(By.name("country")).click();				//click on the 'Country' dropdown
		String CurrentURL = driver.getCurrentUrl();			// get the URL of the current webpage and save to variable
		System.out.println(CurrentURL);						// print the URL of the current webpage
		
		WebElement dropdown = driver.findElement(By.name("country"));	//creating a WebElement for a dropdown menu
		Select select = new Select(dropdown);  //creating a Select class as mentioned in Section 9, Lecture 77
		select.selectByValue("Angola");						//using the selectByValue method to select Angola
		List<WebElement> dropDownValues = select.getOptions();		//creating a List WebElement to retrieve all of the values in the dropdown menu
		System.out.println(dropDownValues.size());				//printing out the # of values in the dropdown
		System.out.println(dropDownValues.get(15).getText());	//printing out the 16th value in the dropdown
	

		
		String actualTitle = driver.getTitle();		//get title of webpage
		System.out.println(actualTitle);				//print title of webpage
		String expectedTitle = "Welcome to the Test Site";  //create of variable containing Expected title of webpage
		Assert.assertEquals(expectedTitle, actualTitle);  // assert that the title of the webpage is correct
		int temp = 2;	
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));	//create list of Web Elements to find links with Tagname a
		for (WebElement link : allLinks) {
			
		System.out.println(link.getText());		//print out the links present on the webpage
		if(link.getText().equals("Interaction")){
			temp = 1;
		
		}
		else {
			temp = 0;
		}
		
		if(temp==1)
		{
			System.out.println("Interaction link is available");
			break;
		}	
		else
			System.out.println("Interaction link is not available");
		}

		
	}

}
