package com.wujianbo.base;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * @author: wujianbo
 * @Date: 2018/6/21 12:01
 * @Description:
 */
public class BaseTest {

    @Test
    public void testDecimal(){
        double money = 399.74099999999993;
        DecimalFormat df=new DecimalFormat("0.00");
        System.out.println(df.format(money));

        System.out.println(df.format((float)0));

        Integer a = 20;
        Integer b = 5;

        String foo = df.format((float)a/b);
        System.out.println(foo);
    }
}
