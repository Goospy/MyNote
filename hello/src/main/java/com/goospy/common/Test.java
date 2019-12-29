package com.goospy.common;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Goospy on 2019/10/29 in Hong Xin Jin Fu
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        condition.await();
        condition.wait();

        Arrays.copyOf(new Object[]{}, 1);

        Date d = new Date(1572364800000l);
        System.out.println(d.toString());
//        String goodsPrice = "233200,32323001,10,";
//        System.out.println(getGoodsPrice(goodsPrice));
    }

    public static String getGoodsPrice(String goodsPrice) {
        BigDecimal HUNDRED = new BigDecimal(100);
        String[] strings = goodsPrice.split(",");
        if(strings.length == 1) {
            return new BigDecimal(goodsPrice).divide(HUNDRED).toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new BigDecimal(strings[0]).divide(HUNDRED).toString());
        for(int i = 1; i < strings.length; i++) {
            stringBuilder.append(",");
            stringBuilder.append(new BigDecimal(strings[i]).divide(HUNDRED).toString());
        }
        return stringBuilder.toString();
    }


    public static String test() {
        return "test";
    }
}
