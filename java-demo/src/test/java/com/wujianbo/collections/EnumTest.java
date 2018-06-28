package com.wujianbo.collections;

import java.util.Arrays;

/**
 * @auther: wujianbo
 * @Date: 2018/5/25 14:38
 * @Description:
 */
public enum EnumTest {
    ONE(1),
    TOW(2),
    THREE(3);

    private int code;


    EnumTest(int i) {
        this.code = i;
    }

    public int getCode(){
        return this.code;
    }

    /**
     * 每个Enum对象在编译的时候都会产生一个values()对象
     * @param code
     * @return
     */
    public EnumTest from(int code){
        return Arrays.stream(values()).filter(element -> element.getCode() == code).findFirst().orElseThrow(() ->
                new IllegalArgumentException("illegal code, not found SalesReporType")
        );
    }
}
