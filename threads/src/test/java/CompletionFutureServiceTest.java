import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class CompletionFutureServiceTest {


    @Test
    public void thenApply() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()-> "123").thenApply(String::length);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(()-> "123").thenApply(t->2);
        System.out.println("future:"+future.get());
        System.out.println("future2:"+future2.get());
    }

    @Test
    public void handle() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()-> "123").handle((s,t)->s.length());

        System.out.println("future:"+future.get());
    }

    @Test
    public void acceptEither() throws ExecutionException, InterruptedException {
        acceptEitherHandle();
        Thread.currentThread().join();

    }

    private void acceptEitherHandle() {
        CompletableFuture.supplyAsync(()->{
            System.out.println("t1 start");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 end");
            return "t1 good";})
                .acceptEither(CompletableFuture.supplyAsync(()->{
            System.out.println("t2 start");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 end");
            return "t2 good";}),System.out::println);
    }


    @Test
    public void acceptBoth() throws ExecutionException, InterruptedException {
        acceptBothHandle();
        Thread.currentThread().join();

    }

    private void acceptBothHandle() {
        CompletableFuture.supplyAsync(()->{
            System.out.println("t1 start");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 end");
            return "t1 good";})
        .thenAcceptBoth(CompletableFuture.supplyAsync(()->{
            System.out.println("t2 start");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 end");
            return "t2 good";
        }),(s,v)-> System.out.println(s+"_"+v));
    }


}
