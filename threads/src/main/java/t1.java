
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class t1 {

    public static void main(String[] args) {

        statck s = new statck();


        new Thread(()->{

            for(int i = 0; i<10; i++){
                s.add(i);
                System.out.println("添加进集合第"+i+"元素");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"t1").start();

        new Thread(()->{
            while (true){
                if(s.size() == 5) {
                    System.out.println("添加进集合第"+5+"元素，线程t2退出");
                    break;
                }
            }
        },"t2").start();

    }
}

class statck{

    volatile List<Integer>  intlist = new ArrayList<>();

    public void add(int a ){
        intlist.add(a);
    }

    public int size(){
        return intlist.size();
    }


}
