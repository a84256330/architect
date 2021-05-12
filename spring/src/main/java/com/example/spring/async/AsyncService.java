package com.example.spring.async;

import org.springframework.stereotype.Service;

@Service
public class AsyncService {


    /**
     * @return
     */
    public void execute() throws InterruptedException{
        System.out.println(">>>开始执行方法AsyncService#execute<<<");
        // TODO
        Thread.sleep(3000);
        System.out.println(">>>结束执行方法AsyncService#execute<<<");
    }

    public void execute2() throws InterruptedException{
        System.out.println(">>>开始执行方法AsyncService#execute2<<<");
        // TODO
        Thread.sleep(2000);
        System.out.println(">>>结束执行方法AsyncService#execute2<<<");
    }

}
