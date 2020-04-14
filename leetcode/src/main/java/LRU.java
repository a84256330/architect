import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Classname LRU
 * @Description TODO
 * @Date 2020/3/29 8:32
 * @Created by Ma
 */
public class LRU extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public LRU(int capacity){
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key){
        return super.getOrDefault(key,-1);
    }

    public void put(int k,int v){
        super.put(k,v);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size()>capacity;
    }
}
