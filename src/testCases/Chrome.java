package testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import Framework.PFramework;
import poms.Amazon;

public class Chrome {
	PFramework pFW=new PFramework();
	@Test
	public void addProductAmazon()
	{
		pFW.openBrowser("Chrome","https://amazon.com");
		Amazon az=new Amazon(pFW);
		az.searchMobilefromAmazon("Mobile Phone");
		az.clickSearchButton();
		az.selectMobileBrand("SAMSUNG");
		az.clickonMobile();
		String[] text=az.getTextfromMobile().split("|");
		az.addtoCart();
		az.viewCart();
		String[] getaddedcart=az.getTextfromAddedCartMobile().split("|");
		Assert.assertEquals(text[0], getaddedcart[0]);
		pFW.closeBrowser();
	}
	
}
