package com.wujianbo.base;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author wujianbo
 */
public class StringTest {

    @Test
    public void testString(){
        String format = String.format("[%s]:%s","key","value");
        System.out.println(format);
        List<String> strings = Arrays.asList("haha","lolo");
        String listFormat = String.join("\n",strings);
        System.out.println(listFormat);
        String foo = "wujianbo";
        System.out.println(foo.hashCode());
    }
}
