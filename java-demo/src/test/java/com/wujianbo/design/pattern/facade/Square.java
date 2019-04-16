package com.wujianbo.design.pattern.facade;

public class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}
