package com.qf.test;

import com.qf.pojo.Classes;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ClassTest {
    public static void main(String[] args) throws Exception {
        Class<Classes> classesClass = Classes.class;
        Field[] fields = classesClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field+"=====>"+field.getName());
            field.setAccessible(true);
            Object o = field.get(classesClass.newInstance());
            System.out.println(o);
        }

    }
}
