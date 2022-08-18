package com.learning.contants;

/**
 * @author Sreej
 */
public class FrameworkConstants {

    private FrameworkConstants(){}

    private static final String apkFilePath=System.getProperty("user.dir") + "/src/test/resources/apkFiles/ApiDemos-debug.apk";

    private static final String configFilePath=System.getProperty("user.dir") + "/src/test/resources/config/config.properties";

    public static String getApkFilePath() {
        return apkFilePath;
    }

    public static String getConfigFilePath() {
        return configFilePath;
    }

}
