package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        People p = new People();
        p.setAge("2");
        p.setName("people");
        p.setPhone(123);
        List<Cat> cats = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Cat cat = new Cat();
            cat.setCatName("cat"+i);
            cat.setCol("red");
            cats.add(cat);
        }
        p.setCats(cats);

    }
}
