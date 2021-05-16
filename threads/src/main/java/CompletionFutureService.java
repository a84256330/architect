import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletionFutureService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "HELLO").whenComplete(CompletionFutureService::accept);
//        future.whenCompleteAsync(CompletionFutureService::accept);
        System.out.println(future.get());
        TimeUnit.SECONDS.sleep(5);
        System.out.println("main end");


    }

    private static void accept(String v, Throwable t) {
        System.out.println("start");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("world");
        System.out.println("end");
    }
}
