package com.learning.utils;

import com.learning.contants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Sreej
 */
public class PropertyUtils {

    private static final Properties properties = new Properties();
    private static Map<String, String> MAP = new HashMap<>();


    static {
        try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getConfigFilePath())) {

            properties.load(fileInputStream);

            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                String key = String.valueOf(entry.getKey());
                String value = String.valueOf(entry.getValue());
                MAP.put(key, value);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);

        }
    }

    public static String getValue(String key) {
        return MAP.get(key);
    }


}
