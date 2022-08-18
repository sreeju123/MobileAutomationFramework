package com.learning.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;

/**
 * @author Sreej
 */
public class ExtentReport {
    public static ExtentReports extent;

    public static void initReports(){
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/index.html");
            spark.config().setTheme(Theme.DARK);
            spark.config().setReportName("Automation Report");
            spark.config().setDocumentTitle("Checking");
            extent.attachReporter(spark);
        }
    }


    public static void tearDownReports(){
        if (Objects.nonNull(extent)){
            extent.flush();
            ExtentManager.unloadExtentTest();
        }
    }

    public static void createTest(String testcaseName){
        ExtentTest tests=extent.createTest(testcaseName);
        ExtentManager.setExtentTest(tests);
    }



}
