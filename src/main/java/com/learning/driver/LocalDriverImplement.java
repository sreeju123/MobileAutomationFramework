package com.learning.driver;

import com.learning.contants.FrameworkConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * @author Sreej
 */
public class LocalDriverImplement implements IDriver{

    @Override
    public WebDriver getDriver(Map<String,String> map) throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, FrameworkConstants.getApkFilePath());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel Emulator 3");
        capabilities.setCapability(AndroidMobileCapabilityType.SKIP_UNLOCK,true);
        capabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
        // below one is for running parallel test using same server- we need to mention 8200-8201
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, "8200");
        return new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

}
