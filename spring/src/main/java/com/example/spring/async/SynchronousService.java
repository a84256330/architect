package com.example.spring.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Future;

@Service
public class SynchronousService {
    @Resource
    private AsyncService asyncService;

    @Async
    public void execute() throws InterruptedException{
        System.out.println(">>>start SynchronousService#execute<<<");
        asyncService.execute();
        System.out.println(">>>end SynchronousService#execute<<<");
    }
    @Async
    public void execute2() throws InterruptedException{
        System.out.println(">>>start SynchronousService#execute2<<<");
        asyncService.execute2();
        System.out.println(">>>end SynchronousService#execute2<<<");
    }

    @Async
    public Future<Integer> execute3() throws InterruptedException {
        Thread.sleep(1000);
        return AsyncResult.forValue(1);
    }
    @Async
    public Future<Integer> execute4() throws InterruptedException {
        Thread.sleep(5000);
        return AsyncResult.forValue(2);
    }
}
