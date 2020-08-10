package org.example.gof.command;

/**
 * @Classname CloseOrder
 * @Description TODO
 * @Date 2020/8/10 23:58
 * @Created by Ma
 */
public class CloseOrder extends order{
    @Override
    public void handle() {
        super.ps4.close();
        super.ns.close();
        super.xbox.close();
    }
}
