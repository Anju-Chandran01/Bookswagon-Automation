package com.bz.bookswagon.qa.pages;

import com.bz.bookswagon.qa.base.TestBase;
import com.bz.bookswagon.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBooksPage extends TestBase {

    TestUtil testUtil;

    @FindBy(xpath="//input[@value='Buy Now']")
    WebElement buyNowButton;

    @FindBy(id = "BookCart_lvCart_imgPayment")
    WebElement placeOrderButton;

    // initialising page objects
    public SearchBooksPage() {
        PageFactory.initElements(driver, this);
    }

    public String verify_SearchBooks_url(){
        return driver.getCurrentUrl();
    }

    // After search add book to cart
    public void searchBookAndAddToCart() {
        WebElement check = driver.findElement(By.xpath("//a[normalize-space()='Rich Dad Poor Dad']"));
        if (check.isDisplayed()) {
            check.click();
            buyNowButton.click();
        }
    }

    // After search, add book to cart and place an order
    public boolean searchBookAndPlaceOrder(String bookName) {
        WebElement check = driver.findElement(By.xpath("//a[normalize-space()='Rich Dad Poor Dad']"));
        if (check.isDisplayed()) {
            check.click();
            buyNowButton.click();
            driver.switchTo().frame("//iframe[@name='cbox1663604928421' and @class='cboxIframe']");
//           testUtil.switchToFrame();
            /* <iframe frameborder="0" name="cbox1663604928421"
        src="https://www.bookswagon.com/shoppingcart.aspx?&amp;pid=21258388&amp;vid=111&amp;ptype=1"
        scrolling="no" class="cboxIframe" xpath="1"></iframe>*/
            placeOrderButton.click();
            return true;
        }else{
            return false;
        }
    }
}
