package com.webstaurant.pages;
import org.openqa.selenium.By;

import static com.webstaurant.utilities.UI_Actions.clickElement;
import static com.webstaurant.utilities.UI_Actions.sendKeys;

public class BasePage extends Page{
    private final static By SEARCH_BOX = By.id("searchval");
    private final static By SEARCH_BUTTON = By.cssSelector("button[value='Search']");

    public void searchItem(String searchItem) {
        sendKeys(SEARCH_BOX, searchItem);
        clickElement(SEARCH_BUTTON);
    }
}
