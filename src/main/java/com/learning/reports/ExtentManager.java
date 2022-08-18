package com.learning.reports;

import com.aventstack.extentreports.ExtentTest;

/**
 * @author Sreej
 */
public class ExtentManager {

    public static ThreadLocal<ExtentTest> extentTestThreadLocal=new ThreadLocal<>();

    protected static ExtentTest getExtentTest(){
        return extentTestThreadLocal.get();
    }

    public static void setExtentTest(ExtentTest extentTest){
        extentTestThreadLocal.set(extentTest);
    }

    public static void unloadExtentTest(){
        extentTestThreadLocal.remove();
    }

}
