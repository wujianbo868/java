package com.wujianbo.stream;

import com.wujianbo.collections.Person;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wujianbo on 2018/5/15.
 */
public class StreamTest {

    @Test
    public void testForeach(){
        Person person1 = new Person().setName("wujianbo").setAge(22);
        Person person2 = new Person().setName("zhangyuan").setAge(21);
        Person person3 = new Person().setName("xijinping").setAge(21);
        List<Person> people = Arrays.asList(person1,person2,person3);
        people.forEach(n->System.out.println(n.getName()));
        //map可以对每一个元素进行一次表达式运算
        System.out.println("map可以对每一个元素进行一次表达式运算");
        people.stream().map(n->n.getAge()>21).forEach(n-> System.out.println(n));
        //测试grouping by来进行分组
        Map<Integer,List<Person>> groupby = people.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(groupby);
        //尝试用group by来求平均值,求和,过滤数据,转map等操作
        //测试转map
        System.out.println("--->test_map");
        Map<Integer,Person> personMap = people.stream().collect(Collectors.toMap(Person::getAge,a->a,(k1,k2)->k1));
        System.out.println(personMap);
        //使用filter过滤数据
        List<Person> filterList = people.stream().filter(a->a.getAge()<22).collect(Collectors.toList());
        System.out.println(filterList);
        //用reduce
        Integer totalAge = people.stream().map(Person::getAge).reduce(0,(a,b)-> a = a + b);
        System.out.println(totalAge);
        //尝试一下求平均值
        Double averageAge = people.stream().collect(Collectors.averagingDouble(Person::getAge));
        System.out.println(averageAge);
    }
}
