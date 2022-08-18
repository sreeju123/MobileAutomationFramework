package com.learning.listeners;

import com.learning.reports.ExtentLogger;
import com.learning.reports.ExtentReport;
import org.testng.*;

/**
 * @author Sreej
 */
public class ListenersClass implements ITestListener, ISuiteListener {

    //BeforeSuite
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    //AfterSuite
    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.tearDownReports();
    }

    //BeforeMethod
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName() + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getName() + " is failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getName() + " is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
