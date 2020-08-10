package org.example.gof.command;

/**
 * @Classname order
 * @Description TODO
 * @Date 2020/8/10 23:43
 * @Created by Ma
 */
public abstract class order {

    protected Ps4 ps4  = new Ps4();

    protected Ns ns = new Ns();

    protected Xbox xbox = new Xbox();

    public abstract void handle();

}
