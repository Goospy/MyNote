package com.goospy.common;

/**
 * Created by Goospy on 2019/11/6 in Hong Xin Jin Fu
 */
public class SubTest extends Test {

    public static void main(String[] args) {
        Test test = new SubTest();
        System.out.println(test.test());
    }


    public static String test() {
        return "subTest";
    }

}
