package com.wujianbo.collections;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @auther: wujianbo
 * @Date: 2018/6/1 17:25
 * @Description:
 */
public class CollectionTest {

    @Test
    public void testList(){
        List<String> elem = Lists.newArrayList();
        elem.add("lol");
        System.out.println(elem);
        List<List<String>> foo = Arrays.asList(elem,elem);
        System.out.println(foo.stream().map(e -> e.add("mom")).collect(Collectors.toList()));
        foo = foo.stream().map(e -> {
            e.add("haha");
            return e;
        }).collect(Collectors.toList());
        foo.stream().forEach(e->System.out.println(e));
    }

    //两个List，根据对应规则生成一个新的List
    @Test
    public void testCombine(){
        Person person1 = new Person().setName("wujianbo").setAge(22);
        Person person2 = new Person().setName("zhangyuan").setAge(21);
        List<Person> personList1 = Arrays.asList(person1,person2);
        List<Person> personList2 = Arrays.asList(person1,person2);
        personList1.stream().map(e -> {
            Person foo = personList2.stream().filter(ele -> ele.getName().equals(e.getName())).findFirst().get();
            e.setAge(foo.getAge()+e.getAge());
            return e;
        }).forEach(n -> System.out.println(n));
    }

    @Test
    public void TestFunction(){
        Person person1 = new Person().setName("wujianbo").setAge(22);
        Person person2 = new Person().setName("zhangyuan").setAge(21);
        List<Person> personList1 = Arrays.asList(person1,person2);
        List<Person> personList2 = Arrays.asList(person1,person2);
        functionParam(personList1,personList2,Person::getName);
    }

    public void functionParam(List<Person> personList1, List<Person> personList2,
                              Function<? super Person, ? extends String> nameGetter){
        personList1.stream().map(e -> {
            Person foo = personList2.stream().filter(ele -> nameGetter.apply(ele).equals(nameGetter.apply(e))).findFirst().get();
            e.setAge(foo.getAge()+e.getAge());
            return e;
        }).forEach(n -> System.out.println(n));
    }
}
