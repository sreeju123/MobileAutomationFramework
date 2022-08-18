package com.learning.pages;

import com.learning.driver.DriverManager;
import com.learning.reports.ExtentLogger;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * @author Sreej
 */
public class NativeBasePage {

    protected String getText(MobileElement element){
        return element.getText();
    }

    private void explicitWait(MobileElement element){
        new WebDriverWait(DriverManager.getDriver(),5)
                .pollingEvery(Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(WebElement element, String elementName) {
        element.click();
        System.out.println(elementName + "is clicked");
    }

    //Android, ios, mobile browser
    protected void click(By by, String elementName) {
        click((MobileElement) DriverManager.getDriver().findElement(by), elementName);
        System.out.println(elementName + "is clicked");
    }

    protected void clickMenuItems(List<MobileElement> list, String menu) {
        MobileElement mobileElement = list.parallelStream().filter(e -> e.getText().contains(menu)).findFirst().get();
        click(mobileElement, menu);
        // or
//        list.parallelStream().filter(e->e.getText().contains(menu)).findFirst().ifPresent(WebElement::click);
    }

    protected void scrollToSpecificElementandClick(By by, AndroidDriver<AndroidElement> driver) {
        while (DriverManager.getDriver().findElements(by).isEmpty()) {
            Dimension dimension = DriverManager.getDriver().manage().window().getSize();
            Double screenHeightStart = dimension.getHeight() * 0.5;
            int scrollStart = screenHeightStart.intValue();
            Double screenHeightEnd = dimension.getHeight() * 0.2;
            int scrollEnd = screenHeightEnd.intValue();
            int center = (int) (dimension.width * 0.5);
            new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver()).press(PointOption.point(center, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(center, scrollEnd)).release().perform();
        }
        if (!DriverManager.getDriver().findElements(by).isEmpty()) {
            DriverManager.getDriver().findElement(by).click();
        }

    }

    protected void Tap(AndroidElement views) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver()).tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();
    }

    protected void dragAndDrop(AndroidElement source, AndroidElement target) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(source))).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();
        ExtentLogger.pass("Drag and Drop is success");
        System.out.println("\n Drag and Drop is success");

    }

}


