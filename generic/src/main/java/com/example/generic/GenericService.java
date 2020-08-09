package com.example.generic;

/**
 * @Classname GenericService
 * @Description TODO
 * @Date 2020/8/9 8:11
 * @Created by Ma
 * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 */
public interface GenericService<T> {
    public T next();
}
