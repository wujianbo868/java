package com.wujianbo.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wujianbo on 2018/4/29.
 */
public class SortTest {

    @Test
    public void testSort(){
        Person person1 = new Person().setName("wujianbo").setAge(22).setRealAge(1);
        Person person2 = new Person().setName("zhangyuan").setAge(21).setRealAge(20);
        List<Person> people = Arrays.asList(person1,person2);
        //这个是降序的，升序去掉reversed
        people.sort(Comparator.comparing(Person::getAge).reversed());
        people.forEach(n->System.out.print(n.getName()));
        Assert.assertTrue(people.get(0).getName().equals("wujianbo"));
        Assert.assertTrue(person1.compareTo(person2) > 0);
        Collections.sort(people);
        Assert.assertEquals("zhangyuan",people.get(0).getName());
    }

    @Test
    public void testArraysSort(){
        int[] arrays = {4,2,3,1};
        Arrays.sort(arrays);
        Assert.assertEquals(1,arrays[0]);
    }

}
