package com.learning.contants;

import lombok.Getter;

/**
 * @author Sreej
 */
public class FrameworkConstantsWithLombak {

    private FrameworkConstantsWithLombak(){}

    private static @Getter final String apkFilePath=System.getProperty("user.dir") + "/src/test/resources/apkFiles/ApiDemos-debug.apk";

    private static @Getter final String configFilePath=System.getProperty("user.dir") + "/src/test/resources/config/config.properties";


}
