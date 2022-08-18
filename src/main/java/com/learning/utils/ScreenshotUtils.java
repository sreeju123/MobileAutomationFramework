package com.learning.utils;

import com.learning.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * @author Sreej
 */
public final class ScreenshotUtils {

    private ScreenshotUtils(){

    }

    public static String getBase64Image(){
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }


}
