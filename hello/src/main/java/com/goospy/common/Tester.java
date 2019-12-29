package com.goospy.common;

import com.goospy.dp.Singleton;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Tester {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance();
        Singleton singleton = constructor.newInstance();
        Singleton.class.newInstance();
        System.out.println(singleton == Singleton.getInstance());

        String s = ";";
        Thread test = new Thread() {
            @Override
            public void run() {
                synchronized (s) {

                }
            }
        };
    }

}
