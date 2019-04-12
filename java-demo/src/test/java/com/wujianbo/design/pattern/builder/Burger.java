package com.wujianbo.design.pattern.builder;

public abstract class Burger implements Item{

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
