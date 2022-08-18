package com.learning.driver;

import com.learning.exceptions.FrameworkException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Map;

/**
 * @author Sreej
 */
public class DriverFactory {

    public DriverFactory() {
    }


    public static WebDriver get(Modes mode, Map<String,String> map) throws IOException {

        WebDriver driver = null;

        if (mode.equals(Modes.LOCAL)) {
            driver = new LocalDriverImplement().getDriver(map);
        } else if (mode.equals(Modes.BS)) {
            driver = new BrowserStackImplement().getDriver(map);
        } else {
            throw new FrameworkException("Mode value not matching");
        }
        return driver;
    }
}
