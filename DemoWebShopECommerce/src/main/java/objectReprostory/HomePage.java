package objectReprostory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Register")
	private WebElement registerLink;
	
	public WebElement getRegisterLink() {
		return registerLink;
	}


	public WebElement getLoginLink() {
		return loginLink;
	}


	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}


	public WebElement getWishlistLink() {
		return wishlistLink;
	}


	public WebElement getSearchTextField() {
		return searchTextField;
	}


	public WebElement getSearchButton() {
		return searchButton;
	}
	
	@FindBy(partialLinkText ="Log in")
	private WebElement loginLink;
	
	@FindBy(linkText = "Shopping")
	private WebElement shoppingCartLink;
	
	@FindBy(partialLinkText = "Wishlist")
	private WebElement wishlistLink;
	
	@FindBy(id  = "small-searchtxerms")
	private WebElement searchTextField;
	
	@FindBy(css = "[value='Search']")
	private WebElement searchButton;
	
	@FindBy(partialLinkText ="BOOKS")
	private WebElement booksLink ;
	
	@FindBy(partialLinkText = "Jewelry")
	private WebElement jewlryLink;
	
	public WebElement getJewlryLink() {
		return jewlryLink;
	}

    @FindBy(partialLinkText = "Log out")
    private WebElement logOutLink;
    
	public WebElement getLogOutLink() {
		return logOutLink;
	}


	public WebElement getBooksLink() {
		return booksLink;
	}
	

}
