package com.example.lambda;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ImmutableTests {

    @Test
    void finalTest(){

        List<String> stringList = new ArrayList<>(16);
        stringList.add("aa");
        stringList.add("bb");
        stringList.add("cc");

        final List<String> stringList2 = new ArrayList<>(16);
        stringList2.add("aa");
        stringList2.add("bb");

        System.out.println(stringList);
        System.out.println(stringList2);
    }

    @Test
    void ImmutableListTest(){

        List<String> stringList = new ArrayList<>(16);
        stringList.add("aa");
        stringList.add("bb");
        stringList.add("cc");

        ImmutableList immutableList = ImmutableList.copyOf(stringList);

        System.out.println(immutableList);

        immutableList.add("dd");

        System.out.println(immutableList);
    }

}
