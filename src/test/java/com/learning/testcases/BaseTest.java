package com.learning.testcases;

import com.learning.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Map;

/**
 * @author Sreej
 */
public class BaseTest {

    @BeforeMethod
    public void setUp(Object[] data) throws IOException {
        Map<String,String> map= (Map<String, String>) data[0];
        Driver.initDriver(map);
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }


}
