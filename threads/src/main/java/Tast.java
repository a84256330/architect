import java.util.concurrent.Callable;

/**
 * @program: architect
 * @description: 标签
 * @author: machao42
 * @create: 2021-05-12 16:10
 **/
public class Tast implements Callable {
    @Override
    public Integer call() throws Exception {

        System.out.println(">>>开始异步计算<<<");
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            Thread.sleep(1000);
            sum += sum;
            sum++;
        }
        return sum;
    }
}

