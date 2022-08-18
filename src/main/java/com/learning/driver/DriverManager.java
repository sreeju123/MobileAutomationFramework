package com.learning.driver;

import org.openqa.selenium.WebDriver;

/**
 * @author Sreej
 */
public class DriverManager {

    private DriverManager() {
    }

    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();


    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static void setDriver(WebDriver driverRef) {
        threadLocalDriver.set(driverRef);
    }

    public static void unload() {
        threadLocalDriver.remove();
    }

}
