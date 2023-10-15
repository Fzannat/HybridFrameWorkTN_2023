package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage {
    public WebDriver driver;

    @FindBy(linkText = "HP LP3065")
    private WebElement HP_LP3065;

    @FindBy(xpath = "//p[text() = 'There is no product that matches the search criteria.']")
    private WebElement invalidSearchErrorMessage;


    public SearchProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isHP_LP3065Displayed(){
        boolean isDisplayed = HP_LP3065.isDisplayed();
        return isDisplayed;
    }
    public boolean isInvalidSearchErrorMessageDisplayed(){
        boolean isMessageDisplayed = invalidSearchErrorMessage.isDisplayed();
        return isMessageDisplayed;
    }
}
