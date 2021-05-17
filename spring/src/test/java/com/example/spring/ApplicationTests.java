package com.example.spring;

import com.example.spring.async.AsyncService;
import com.example.spring.async.SynchronousService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootTest
class ApplicationTests {

    @Resource
    private AsyncService asyncService;

    @Resource
    private SynchronousService synService;

    @Test
    void asyn() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        asyncService.execute();
        asyncService.execute2();
        stopWatch.stop();
        System.out.println("同步方法执行时间："+stopWatch.getTotalTimeSeconds());

        StopWatch stopWatch2 = new StopWatch();
        stopWatch2.start();
        synService.execute();
        synService.execute2();
        stopWatch2.stop();
        System.out.println("异步方法执行时间："+stopWatch2.getTotalTimeSeconds());
    }

    @Test
    void asynFuture() throws InterruptedException, ExecutionException {
        StopWatch stopWatch2 = new StopWatch();
        stopWatch2.start();
        Future<Integer> integerFuture = synService.execute3();
        Future<Integer> integerFuture1 = synService.execute4();
        int i = integerFuture.get() + integerFuture1.get();
        stopWatch2.stop();
        System.out.println("异步方法执行时间："+stopWatch2.getTotalTimeSeconds());
        System.out.println("异步方法执行结果："+i);
    }


}
