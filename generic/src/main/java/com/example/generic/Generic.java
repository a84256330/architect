package com.example.generic;

/**
 * @Classname Generic
 * @Description TODO
 * @Date 2020/8/9 7:56
 * @Created by Ma
 * 泛型的类型参数只能是类类型，不能是简单类型
 * 不能对确切的泛型类型使用instanceof操作。如下面的操作是非法的，编译时会出错
 */
public class Generic<T> {
    private T t;

    public T get(){
        return t;
    }

    public Generic(T t){
        this.t = t;
    }
}
