package com.qa.tutorialsninja.TestCases;

import com.qa.tutorialsninja.Pages.LandingPage;
import com.qa.tutorialsninja.TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductTest  extends TestBase {
    public WebDriver driver;
    public LandingPage landingPage;
    public SearchProductPage searchProductPage;


    public SearchProductTest() throws Exception {
        super();
    }
    @BeforeMethod
    public void searchSetUp(){
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
        landingPage = new LandingPage(driver);

    }

    @Test(priority=1)
    public void verifySearchWithValidProduct() {
        searchProductPage = landingPage.searchProduct(dataprop.getProperty("validProduct"));
        Assert.assertTrue(searchProductPage.isHP_LP3065Displayed());

    }
    @Test(priority=2)
    public void verifySearchWithInvalidProduct() {
        searchProductPage = landingPage.searchProduct(dataprop.getProperty("invalidProduct"));
        Assert.assertTrue(searchProductPage.isInvalidSearchErrorMessageDisplayed());

    }

    @Test(priority=3)
    public void verifySearchWithNoProduct() {
        searchProductPage = landingPage.clickOnSearchButton();
        Assert.assertTrue(searchProductPage.isInvalidSearchErrorMessageDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
