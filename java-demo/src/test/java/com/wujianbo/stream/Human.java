package com.wujianbo.stream;

import lombok.Data;

@Data
public class Human {
    private String name;
    private String sex;
    public int age;
    private long id;

    public Human(String name, String sex, int age, long id) {
        super();
        this.name = name;
        this.age = age;
        this.id = id;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Human [name=" + name + ", sex=" + sex + ", age=" + age + ", id=" + id + "]";
    }
}
