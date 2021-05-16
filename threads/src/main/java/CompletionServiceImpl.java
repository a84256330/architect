import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: architect
 * @description: CompletionService
 * @author: machao42
 * @create: 2021-05-12 19:37
 **/
public class CompletionServiceImpl {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        CompletionService<Integer> completionService = new ExecutorCompletionService(es);
        List<Future> futures = new ArrayList<Future>();
        Tast A  = new Tast();
        Tast B  = new Tast();
        Tast C  = new Tast();
        futures.add(completionService.submit(A));
        futures.add(completionService.submit(B));
        futures.add(completionService.submit(C));

        for (Future future : futures) {
            Integer res = completionService.take().get();
        }
    }
}
