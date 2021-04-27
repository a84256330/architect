package com.example.lambda;

import com.example.lambda.bo.Apple;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@SpringBootTest
class LambdaApplicationTests {

    @Test
    void contextLoads() {
        String[] players = {"zhansgan", "lisi", "wangwu", "zhaoliu",  "wangmazi"};

        // 1.1 使用匿名内部类根据 surname 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });

        // 1.2 使用 lambda 排序,根据 surname
        Arrays.sort(players, (String s1, String s2) ->  s1.compareTo(s2));
    }

    @Test
    void methods(){
        Apple apple1 = new Apple("红富士", "Red", 280);
        Apple apple2 = new Apple("冯心", "Yello", 470);
        Apple apple3 = new Apple("大牛", "Red", 320);
        Apple apple4 = new Apple("小小", "Green", 300);

        List<Apple> appleList = Arrays.asList(apple1, apple2, apple3, apple4);
        // 打印
        appleList.forEach(System.out::println);
        // 静态方法引用
        appleList.sort(Apple::compareByWeight);

        System.out.println(apple4.getString(String :: new));
    }

}
