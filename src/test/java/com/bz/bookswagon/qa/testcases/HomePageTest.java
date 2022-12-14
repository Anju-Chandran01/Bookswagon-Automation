package com.bz.bookswagon.qa.testcases;

import com.bz.bookswagon.qa.base.TestBase;
import com.bz.bookswagon.qa.pages.HomePage;
import com.bz.bookswagon.qa.pages.LoginPage;
import com.bz.bookswagon.qa.pages.SearchBooks;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    SearchBooks searchBooksPage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("mobile"), prop.getProperty("pass"));
    }

    @Test(priority = 1)
    public void homePage_Heading_Test(){
        boolean flag = homePage.validate_HomePage_Heading();
        Assert.assertTrue(flag);
    }

    @Test(priority = 2)
    public void homePage_UrlTest(){
        String url = homePage.validate_HomePage_Url();
        Assert.assertEquals(url,"https://www.bookswagon.com/myaccount.aspx");
    }

    @Test(priority = 3)
    public void searchBoxTest(){
        searchBooksPage = homePage.searchBooksUsingSearchBar("Wings of Fire");
    }

    @Test(priority = 4)
    public void searchBooks_AddToWishList_Test(){
        Boolean flag = homePage.searchBookAndAddToWishList("Chetan Bhagath");
        Assert.assertTrue(flag);
    }

    @Test(priority = 5)
    public void direct_RemoveFrom_Wishlist_Test(){
        homePage.directRemoveFromWishlist();
    }

    @Test(priority = 6)
    public void logout_Test () throws InterruptedException {
        String urlAfterLogout = homePage.logout();
        Assert.assertEquals(urlAfterLogout, "https://www.bookswagon.com/login");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
