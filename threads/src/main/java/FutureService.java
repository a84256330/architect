import java.util.concurrent.*;

/**
 * @program: architect
 * @description: Future服务
 * @author: machao42
 * @create: 2021-05-12 16:22
 **/
public class FutureService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Tast tast = new Tast();
        Future submit = executorService.submit(tast);
        executorService.shutdown();
        Thread.sleep(2000);
        System.out.println("main run");
        System.out.println("zi result" + submit.get());
        System.out.println("main end");

        ExecutorService executorService1 = Executors.newFixedThreadPool(1);
        FutureTask futureTask = new FutureTask(()->"123");
        executorService1.submit(futureTask);
        executorService1.shutdown();
        System.out.println("FutureTast:"+futureTask.get());

    }
}
