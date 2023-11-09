package com.webstaurant.tests_cases;


import com.webstaurant.pages.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.util.List;
import static com.webstaurant.utilities.UI_Actions.*;


public class TestCases {

    private final BasePage basePage = new BasePage();
    private final SearchResultPage searchResultPage = new SearchResultPage();
    private final CartPage cartPage = new CartPage();

    private SoftAssert softAssert = new SoftAssert();


    @BeforeMethod
    public void setUp() {
        navigateTo("https://www.webstaurantstore.com/");
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
        softAssert.assertAll();
    }

    @Test
    public void testCaseTask() {

        String searchItem = "stainless work table";
        basePage.searchItem(searchItem);


        List<String> results = searchResultPage.getAllSearchResultTitles();
        String word = "Table";
        softAssert.assertTrue(searchResultPage.doAllSearchResultsContain(results, word), "Not all search results contain the word " + word);


        searchResultPage.addLastProductToCart();
        searchResultPage.openCart();
        softAssert.assertFalse(cartPage.isCartEmpty(), "No items found in Cart!");


        cartPage.emptyCart();
        softAssert.assertTrue(cartPage.isCartEmptyNotificationDisplayed(), "Card is empty notification not displayed!");
    }

}
