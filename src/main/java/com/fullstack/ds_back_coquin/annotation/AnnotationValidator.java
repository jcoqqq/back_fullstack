package com.fullstack.ds_back_coquin.annotation;

import java.lang.reflect.Field;

public class AnnotationValidator {

    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Verify.class)) {
                field.setAccessible(true);

                int value = field.getInt(obj);

                Verify checkValueAnnotation = field.getAnnotation(Verify.class);

                boolean isValid = false;
                for (int allowedValue : checkValueAnnotation.allowedValues()) {
                    if (value == allowedValue) {
                        isValid = true;
                        break;
                    }
                }

                if (!isValid) {
                    throw new IllegalArgumentException("La valeur du champ " + field.getName() + " n'est pas autorisée.");
                }
            }
        }
    }
}
