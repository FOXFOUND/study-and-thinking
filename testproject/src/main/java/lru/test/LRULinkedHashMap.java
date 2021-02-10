package lru.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    LRULinkedHashMap(int capacity) {
        // 初始大小，0.75是装载因子，true是表示按照访问时间排序
        super(capacity, 0.75f, true);
        //传入指定的缓存最大容量
        this.capacity = capacity;
    }

    /**
     * 实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRULinkedHashMap lruLinkedHashMap = new LRULinkedHashMap<String,String>(10);
        lruLinkedHashMap.put("admin","admin");
    }
}

