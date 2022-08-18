package com.learning.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * @author Sreej
 */
public class BrowserStackImplement implements IDriver {

    @Override
    public WebDriver getDriver(Map<String, String> map) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("device", "Xiaomi Redmi Note 9");
//        capabilities.setCapability("os_version", "10.0");

         // it reads all the key value from map and store in capabilities
        capabilities.setCapability("browserstack.user", "sreejithr_tbQOle");
        capabilities.setCapability("browserstack.key", "bzmC1Qq9N6swwMSHZzgw");
        map.forEach(capabilities::setCapability);

        // Which app to open
        capabilities.setCapability(MobileCapabilityType.APP, "bs://169f5286301b935352fb4ca4c1a8de65e85ae162");
        capabilities.setCapability("project", "First Java Project");
        capabilities.setCapability("build", "Java Android");
        capabilities.setCapability("name", "Browserstack Test");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.asMap().forEach((k,v)-> System.out.println(k+":"+v));
        return new AndroidDriver<AndroidElement>(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
    }

}
