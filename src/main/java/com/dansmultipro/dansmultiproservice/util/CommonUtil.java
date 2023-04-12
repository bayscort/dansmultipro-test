package com.dansmultipro.dansmultiproservice.util;

import org.springframework.util.ClassUtils;

import java.util.Collection;

public class CommonUtil {
    public static boolean isArrayOrCollection(Object obj) {
        if (null != obj) {
            if (obj.getClass().isArray()) {
                return true;
            } else {
                return ClassUtils.isAssignable(obj.getClass(), Collection.class);
            }
        }
        return false;
    }
}
