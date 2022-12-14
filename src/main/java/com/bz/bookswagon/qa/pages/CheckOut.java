package com.bz.bookswagon.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {

    @FindBy(id="ctl00_cpBody_ShoppingCart_lvCart_txtGiftMessage")
    WebElement giftMessage;

    @FindBy(id="ctl00_cpBody_ShoppingCart_lvCart_txtInstruction")
    WebElement specialInstruction;

    @FindBy(id="ctl00_cpBody_ShoppingCart_lvCart_savecontinue")
    WebElement saveAndContinueButtton;

    public CheckOut(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkOutFromCart(){
        giftMessage.sendKeys("Happy Birthday Appu");
        specialInstruction.sendKeys("Please wrap the book with red paper and also include some chocolates inside ");
        saveAndContinueButtton.click();
    }
}
