package com.learning.driver;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Map;

/**
 * @author Sreej
 */
public interface IDriver {

    public WebDriver getDriver(Map<String, String> map) throws IOException;
}
