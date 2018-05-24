package com.wujianbo.lamda;

import com.wujianbo.collections.Person;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Auther: wujianbo
 * @Date: 2018/5/24 11:54
 * @Description:
 */
public class FunctionTest
{
    @Test
    public void testPredicate(){
        Predicate<Integer> boolValue = x -> x > 5;
        Assert.assertTrue(boolValue.test(6));
        Assert.assertFalse(boolValue.test(4));
    }

    @Test
    public void testConsumer(){
        Person person = new Person();
        person.setAge(22).setName("wujianbo");
        Consumer<Person>  personConsumer = Person -> Person.setName("sunwukong");
        personConsumer.accept(person);
        Assert.assertEquals("sunwukong",person.getName());
    }

    /**
     * 测试一个条件然后剔除List中的元素
     */
    @Test
    public void testPredicateAndConsumer(){
        Predicate<Person> personPredicate = x -> x.getAge() > 25 ;
        List<Person> personList = Lists.newArrayList(new Person().setAge(24).setName("wujianboo"),
                new Person().setName("zhangyuan").setAge(28));
        personList = personList.stream().filter(personPredicate).collect(Collectors.toList());
        Assert.assertEquals(1,personList.size());
    }

}
