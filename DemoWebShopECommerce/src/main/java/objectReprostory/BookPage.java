package objectReprostory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage {

	public BookPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='page-title']//h1")
	private WebElement booksPageHeading;
	
	@FindBy(id="products-orderby")
	private WebElement sortByDropdown;
	
	@FindBy(id="products-pagesize")
	private WebElement pageSizeDropdown;
	
	public WebElement getBooksPageHeading() {
		return booksPageHeading;
	}

	public WebElement getSortByDropdown() {
		return sortByDropdown;
	}

	public WebElement getPageSizeDropdown() {
		return pageSizeDropdown;
	}

	public WebElement getViewAsDropdown() {
		return viewAsDropdown;
	}

	@FindBy(id="products-viewmode")
	private WebElement viewAsDropdown;
	
	
}
