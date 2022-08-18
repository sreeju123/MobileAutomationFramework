package com.learning.pages;

import com.learning.reports.ExtentLogger;
import org.openqa.selenium.WebElement;

/**
 * @author Sreej
 */
public class WebAppBasePage {

    protected void click(WebElement element, String elementname) {
        element.click();
        ExtentLogger.pass(elementname + " is clicked");
    }
}
