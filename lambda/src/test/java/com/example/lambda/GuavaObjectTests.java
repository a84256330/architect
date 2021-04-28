package com.example.lambda;

import com.google.common.base.MoreObjects;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

@SpringBootTest
public class GuavaObjectTests {

    @Test
    void firstNonNullTest() {

        String name = "马超";
        String 架构师 = MoreObjects.firstNonNull(name, "架构师");
        System.out.println(架构师);

        String name2 = null;
        String 架构师1 = MoreObjects.firstNonNull(name2, "架构师");
        System.out.println(架构师1);
    }
}
