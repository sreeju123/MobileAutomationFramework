package com.learning.pages;

import com.learning.driver.DriverManager;
import com.learning.reports.ExtentLogger;
import com.learning.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

/**
 * @author Sreej
 */
public class ViewsLandingPage {

    private String dragAndDrop = "//android.widget.TextView[contains(@text,'%s')]";

    public void clickMenuItem(String menuName) {
        String newXpath = DynamicXpathUtils.getXpath(dragAndDrop, menuName);
        DriverManager.getDriver().findElement(By.xpath(newXpath)).click();
        ExtentLogger.pass("Clicked "+menuName);
    }

}
