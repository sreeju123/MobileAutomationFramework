package com.learning.pages;

import com.learning.driver.DriverManager;
import com.learning.reports.ExtentLogger;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * @author Sreej
 */
public class HomePageNative extends NativeBasePage {

    public HomePageNative() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Views')]")
    @iOSXCUITFindBy(accessibility = "Views")
    private AndroidElement views;

    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "Views")
    private List<AndroidElement> menuItems;

    public ViewsLandingPage clickOnViews() {
        views.click();
        System.out.println("\n Clicked Views");
        ExtentLogger.pass("Clicked Views");
        return new ViewsLandingPage();
    }

    public void clickMenuItems(String menu) {
        menuItems.parallelStream().filter(e -> e.getText().contains(menu)).findFirst().ifPresent(WebElement::click);
    }

}
