package algorithm.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    /**
     * 获取集合所有的子集
     * @param args
     */

    /**
     *  解题思路
     *  1.集合中的元素是无序的
     *  2.进行估算子集的时候,通过判断这个元素有没有,实现2^n,通过pop和push模拟元素存在
     *  3.利用LinkedList的结构特性,实现频繁插入和删除操作
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] nums = new int[]{1,2,3};
        List<List<Integer>> intergerList=  solution.subsets(nums);
        System.out.println(JSON.toJSONString(intergerList));
    }

    public  List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> stringLinkedList = new LinkedList<>();
        List<List<Integer>> intergerList = new ArrayList<>();
        seeUnit(0, nums, stringLinkedList, intergerList);
        intergerList.add(new ArrayList<Integer>());
        return intergerList;
    }

    public void seeUnit(int index, int[] arr, LinkedList<Integer> stringLinkedList, List<List<Integer>> intergerList) {
        for (int i = index; i < arr.length; i++) {
            stringLinkedList.push(arr[i]);
           // System.out.println(stringLinkedList.toString());
            LinkedList<Integer> tringLinkedList = new LinkedList<>();
            tringLinkedList.addAll(stringLinkedList);
            intergerList.add(tringLinkedList );
            seeUnit(i + 1, arr, stringLinkedList,intergerList);
            stringLinkedList.pop();
        }
    }
}