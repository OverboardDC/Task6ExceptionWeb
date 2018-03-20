package com.training.homework.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalUtil {

    private final ResourceBundle bundle = ResourceBundle.getBundle(GlobalConstants.BUNDLE_NAME,
            new Locale(GlobalConstants.LANGUAGE_NAME));

    private static LocalUtil instance;

    public static LocalUtil getInstance() {
        if (instance == null) {
            instance = new LocalUtil();
        }
        return instance;
    }

    public String getMessage(String key) {
        return bundle.getString(key);
    }
}
