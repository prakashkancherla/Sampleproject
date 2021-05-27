package poms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Framework.PFramework;
	public class Amazon {
		WebDriver driver;
		PFramework pFW;
		  public Amazon(PFramework _pFW) 
		  { 
			  pFW = _pFW;
			  driver = pFW.driver;
			  PageFactory.initElements(driver, this);
		  }
		 
		@FindBy(how =How.ID, using = "twotabsearchtextbox")
		WebElement txtAmazonSearch;
		@FindBy(how =How.ID, using = "nav-search-submit-button")
		WebElement btnSearch;
		@FindBy(how =How.XPATH, using = "//div[@id='brandsRefinements']//li/span")
		List<WebElement> lstMobileBrands;
		@FindBy(how =How.XPATH, using = "(//img[@class='s-image'])[1]")
		WebElement imgMobile;
		@FindBy(how =How.ID, using = "productTitle")
		WebElement txtMobile;
		@FindBy(how =How.ID, using = "add-to-cart-button")
		WebElement btnAddtoCart;
		@FindBy(how =How.ID, using = "hlb-view-cart")
		WebElement btnViewCart;
		@FindBy(how =How.XPATH, using = "//span[@class[contains(.,'sc-product-title')]]")
		WebElement txtCartMobile;

		public void searchMobilefromAmazon(String Mobile)
		{
			pFW.fOperationsWebedit(txtAmazonSearch, Mobile);
		}
		public void clickSearchButton()
		{
			pFW.fOperationsWebclick(btnSearch);
		}
		public void selectMobileBrand(String Brand)
		{
			List<WebElement> ele=lstMobileBrands;
			int size=ele.size();
			System.out.println(size);
			for( WebElement product : ele){
				System.out.println(product.getText());
				if(product.getText().equals(Brand))
				{
					pFW.fOperationsWebclick(product);
					break;
				}
			}
		}
		public void clickonMobile()
		{
			pFW.fOperationsWebclick(imgMobile);
		}
		public String getTextfromMobile()
		{
			String text=pFW.getTextFromWebElement(txtMobile);
			return text;
		}
		public void addtoCart()
		{
			pFW.fOperationsWebclick(btnAddtoCart);
		}
		public void viewCart()
		{
			pFW.fOperationsWebclick(btnViewCart);
		}
		public String getTextfromAddedCartMobile()
		{
			String textcart=pFW.getTextFromWebElement(txtCartMobile);
			return textcart;
		}
}
