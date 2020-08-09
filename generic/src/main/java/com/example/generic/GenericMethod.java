package com.example.generic;

/**
 * @Classname GenericMethod
 * @Description TODO
 * @Date 2020/8/9 8:36
 * @Created by Ma
 *  *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
 *  *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
 *  *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
 *  *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
 */
public class GenericMethod {

    public <T> void a(){}

    /**
     * 泛型方法与可变参数
     * @param args
     * @param <T>
     */
    public <T> void printMsg( T... args){
        for(T t : args){
        }
    }

    /**
     * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
     * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
     * 如：public static void show(T t){..},此时编译器会提示错误信息：
     "StaticGenerator cannot be refrenced from static context"
     */
    public static <T> void show(T t){

    }

}
