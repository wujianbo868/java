package com.wujianbo.collections;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by wujianbo on 2018/4/29.
 */
@Data
@Accessors(chain = true)
public class Person {
    private String name;
    private Integer age;
}
