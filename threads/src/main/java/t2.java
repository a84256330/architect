import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class t2 {

    public static void main(String[] args) {
        statck2 s = new statck2();
        final Object object = new Object();

        new Thread(()->{
            System.out.println("开始线程2");
            synchronized (object){
                if(s.size()!=5){
                    try {
                        System.out.println("阻塞线程2");
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notify();
            }
            System.out.println("添加第5数据,t2退出");
        },"t2").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            synchronized (object){
                for (int i = 0; i < 10; i++) {
                    s.add(i);
                    System.out.println("添加第"+i+"数据");
                    if(s.size() == 5){
                        System.out.println("唤醒线程2");
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        },"t1").start();

    }

}

class statck2{

    volatile List<Integer> intlist = new ArrayList<>();

    public void add(int a ){
        intlist.add(a);
    }

    public int size(){
        return intlist.size();
    }

}