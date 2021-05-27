package Framework;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class PFramework {
	public WebDriver driver;
	public WebDriver openBrowser(String browserName,String url)
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prakash\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.out.println("Browser not available");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	public void closeBrowser()
	{
		driver.quit();
	}
	public void fOperationsWebedit(WebElement wbeElement,String input) {
		try {
			wbeElement.sendKeys(input);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void fOperationsWebedit(List<WebElement> wbeElement,String input,int index) {
		try {
			wbeElement.get(index).sendKeys(input);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void fOperationsWebclick(WebElement wbeElement) {
		try {
			wbeElement.click();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public String getTextFromWebElement(WebElement wbeElement)
	{
		String text="";
		try {
			text=wbeElement.getText();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return text;
	}

}
