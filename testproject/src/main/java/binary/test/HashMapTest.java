package binary.test;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 *
 * 每一步，你可以从下标 i 跳到下标：
 *
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 *
 * 注意：任何时候你都不能跳到数组外面。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HashMapTest {
    public static void main(String[] args) {
        int[] arr = new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        System.out.println(minJumps(arr));

    }

    public static int minJumps(int[] arr) {
        int l = arr.length;
        if (l == 1) {
            return 0;
        }
        //  将可以进行跳转的数据进行整理
        HashMap<Integer, Set<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            System.out.println(hashMap.computeIfAbsent(arr[i], k -> new HashSet<>()));
            hashMap.get(arr[i]).add(i);
        }
        System.out.println(hashMap.toString());

        // 每种走法的消耗的步数, 数组输索引表示走法,值表示消耗的步数
        int[] res = new int[l];

        // 走法的队列
        Deque<Integer> deque = new LinkedList<>();

        //开始的位置,默认从数组头开始
        deque.addLast(0);

        //表示还有可以尝试的走法
        while (!deque.isEmpty()) {
            System.out.println("开始新的走法");
            //g 当前的位置
            int g = deque.removeFirst();

            // g == l -1 表示已经走到了数组尾部
            if (g == l - 1) {
                System.out.println("g == l-1 :" + JSON.toJSONString(res));
                return res[l - 1];
            }

            System.out.println("left g:"+g);
            //向左走一个
            addQueue(g - 1, g, res, deque);
            System.out.println("right g:"+g);
            //向右走一个
            addQueue(g + 1, g, res, deque);

            //表示如果可以跳转
            if (hashMap.get(arr[g]) != null) {
                System.out.println("arr:"+JSON.toJSONString(arr));
                //将每个跳转都加入到尝试队列中
                System.out.println("hashmap:"+hashMap.get(arr[g]));
                for (int e : hashMap.get(arr[g])) {
                    System.out.println("jump g:"+g+"\te:"+e);
                    addQueue(e, g, res, deque);
                }
                //已经到尝试队列中,移除可以跳转,防止死循环
                hashMap.remove(arr[g]);
            }
        }
        System.out.println("finished while:" + JSON.toJSONString(res));
        return res[l - 1];
    }

    /**
     * @param i     跳转后的位置
     * @param g     当前位置
     * @param res   耗费的步数
     * @param deque 尝试队列
     */
    private static void addQueue(int i, int g, int[] res, Deque<Integer> deque) {
        // i < = 0 表示向左走已经超出数组索引了
        if(i<=0){
            return;
        }

        System.out.println("before:" + JSON.toJSONString(res) + "\ti:" + i + "\tg:" + g + "\tqueue:" + JSON.toJSONString(deque));
        // res[i] !=0 表示之前已经尝试过了,隐含了一个问题,当前res[i]不是最小的走法
//        if (res[i] != 0) {
//            return;
//        }
        // res[i] == 0 表示当前位置从未走过,可以直接初始化对应的值
        if(res[i] != 0 && res[i]<=res[g] + 1){
            return;
        }
        //尝试队列中包含跳转后的位置
        deque.addLast(i);
        //从res[g]的走法中加1步
        res[i] = res[g] + 1;
        System.out.println("after:" + JSON.toJSONString(res) + "\tdeque:" + JSON.toJSONString(deque));
    }
}
