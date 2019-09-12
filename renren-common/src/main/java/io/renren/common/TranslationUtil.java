package io.renren.common;

import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TranslationUtil {

    private static Map<String, String> transMap;

    static {
        transMap = new HashMap<>();
        Properties properties = new Properties();
        try {
            InputStreamReader in = new InputStreamReader(TranslationUtil.class.getResourceAsStream("/translation.properties"), "GBK");
            properties.load(in);
            Enumeration en = properties.propertyNames();
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                String property = properties.getProperty(key);
                transMap.put(key, property);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String translateKeyWord(String keyword) {
        String str = transMap.get(keyword);
        if (str != null) {
            return str;
        } else {
            return keyword;
        }
    }
}

