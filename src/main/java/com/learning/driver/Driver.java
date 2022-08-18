package com.learning.driver;

import com.learning.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * @author Sreej
 */
public class Driver {

    private Driver() {
    }

    public static void initDriver(Map<String,String> map) throws IOException {
        if (isNull(DriverManager.getDriver())) {
            String modeValue = PropertyUtils.getValue("mode");
            WebDriver driver = DriverFactory.get(Modes.valueOf(modeValue.toUpperCase()),map); //Local
            DriverManager.setDriver(driver);
        }
    }

    public static void quitDriver() {
        if (nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
