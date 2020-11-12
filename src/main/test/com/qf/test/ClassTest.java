package com.qf.test;

import com.qf.pojo.Classes;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ClassTest {
    public static void main(String[] args) throws Exception {
        Class<Classes> aClass = (Class<Classes>) Class.forName("com.qf.pojo.Classes");
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Field id = aClass.getDeclaredField("id");
        Field classesName = aClass.getDeclaredField("classesName");
        System.out.println(id);
        System.out.println("===============");
        Constructor<Classes> constructor = aClass.getConstructor();
        Classes classes = constructor.newInstance();
        System.out.println(classes);
        classesName.setAccessible(true);
        classesName.set(classes,"ymta");
        Object o = classesName.get(classes);
        System.out.println(o);
//        id.setAccessible(true);
//        id.set(classes,1);
//        Object o = id.get(classes);
//        System.out.println(o);
        Method method1 = aClass.getMethod("method1",ArrayList.class);
        ArrayList<String> strings = new ArrayList<>();
       method1.invoke(classes, strings);
        System.out.println("=================");
    }
}
