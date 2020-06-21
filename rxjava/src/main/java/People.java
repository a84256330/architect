import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Classname People
 * @Description TODO
 * @Date 2020/5/12 21:17
 * @Created by Ma
 */
@Getter
@Setter
public class People {
    private String name;
    private String age;
    private int phone;
    List<Cat> cats;
}
