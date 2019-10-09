package com.goospy.jvm;

/**
 * Created by Goospy on 2019/10/3 in Hong Xin Jin Fu
 */
public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception {

        MyClassLoader.class.getClassLoader().loadClass("com.goospy.jvm.MyClassLoader");
        System.out.println(MyClassLoader.class.getClassLoader().toString());
    }

    public void test() {
        getClass().getClassLoader();
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
