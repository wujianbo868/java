package com.wujianbo.stream;

import com.wujianbo.collections.Person;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wujianbo on 2018/5/15.
 */
public class StreamTest {

    @Test
    public void testForeach() {
        Person person1 = new Person().setName("wujianbo").setAge(22);
        Person person2 = new Person().setName("zhangyuan").setAge(21);
        Person person3 = new Person().setName("xijinping").setAge(21);
        List<Person> people = Arrays.asList(person1, person2, person3);
        people.forEach(n -> System.out.println(n.getName()));
        //map可以对每一个元素进行一次表达式运算
        System.out.println("map可以对每一个元素进行一次表达式运算");
        people.stream().map(n -> n.getAge() > 21).forEach(n -> System.out.println(n));
        //测试grouping by来进行分组
        Map<Integer, List<Person>> groupby = people.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(groupby);
        //尝试用group by来求平均值,求和,过滤数据,转map等操作
        //测试转map
        System.out.println("--->test_map");
        Map<Integer, Person> personMap = people.stream().collect(Collectors.toMap(Person::getAge, a -> a, (k1, k2) -> k1));
        System.out.println(personMap);
        //使用filter过滤数据
        List<Person> filterList = people.stream().filter(a -> a.getAge() < 22).collect(Collectors.toList());
        System.out.println(filterList);
        //用reduce
        Integer totalAge = people.stream().map(Person::getAge).reduce(0, (a, b) -> a = a + b);
        System.out.println(totalAge);
        //尝试一下求平均值
        Double averageAge = people.stream().collect(Collectors.averagingDouble(Person::getAge));
        System.out.println(averageAge);
        //查找元素
        Person person = people.stream().filter(a -> a.getAge() == 21).findFirst().orElseThrow(() -> new IllegalArgumentException());
        Assert.assertEquals("zhangyuan", person.getName());
        //skip
        List<Person> skipList = people.stream().skip(1).collect(Collectors.toList());
        Assert.assertEquals(2, skipList.size());
        //limit
        List<Person> limitList = people.stream().limit(2).collect(Collectors.toList());
        Assert.assertEquals(2, limitList.size());
        //flatMap 将元素降级,获取单词，并且去重
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world", "hello world welcome");
        //map和flatmap的区别
        list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("---------- ");
        list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList())
                .forEach(System.out::println);
        //也可以这样
        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct()
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}
