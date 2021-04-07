import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

class LRUCache {

    private Set<Integer> cache;
    private int capacity;


    public LRUCache(int capacity) {
        this.cache = new LinkedHashSet<Integer>(capacity);
        this.capacity = capacity;
    }

    public boolean get(int key) {
        if(!cache.contains(key)){
            return false;
        }
        cache.remove(key);
        cache.add(key);
        return true;
    }

    public void refer(int key) {
        if(!get(key)) {
            put(key);
        }
    }

    public void put(int key) {
        if (cache.size() == capacity) {
            int firstKey = cache.iterator().next();
            cache.remove(firstKey);
        }
        cache.add(key);
    }

    public void display() {
        LinkedList<Integer> list = new LinkedList<>(cache);

        Iterator<Integer> iterator = list.descendingIterator();

        while(iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }

    }



}


public class LRU {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.display();

    }


}
