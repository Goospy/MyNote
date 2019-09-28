package com.goospy.util;

import java.util.List;

public class ListUtil {

    public static void showList(List list) {
        if(null == list || list.isEmpty()) {
            return;
        }
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

}
