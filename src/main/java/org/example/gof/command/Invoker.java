package org.example.gof.command;

/**
 * @Classname Invoker
 * @Description TODO
 * @Date 2020/8/10 23:43
 * @Created by Ma
 */
public class Invoker {

    private order orderr;

    public void set(order order){this.orderr = order;}

    public void active(){orderr.handle();}

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.set(new OpenOrder());
        invoker.active();
    }
}
