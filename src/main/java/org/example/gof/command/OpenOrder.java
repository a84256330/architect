package org.example.gof.command;

/**
 * @Classname OpenOrder
 * @Description TODO
 * @Date 2020/8/10 23:44
 * @Created by Ma
 */
public class OpenOrder extends order{


    @Override
    public void handle() {
        super.ps4.open();
        super.ns.open();
        super.xbox.open();
    }
}
