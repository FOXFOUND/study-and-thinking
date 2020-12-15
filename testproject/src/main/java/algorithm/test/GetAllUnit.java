package algorithm.test;

import java.util.LinkedList;

public class GetAllUnit {
    /**
     * 获取一个集合的所有子集
     *
     * @param args
     */



    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b", "c","d"};
        LinkedList<String> stringLinkedList = new LinkedList<>();
        seeUnit(0,arr,stringLinkedList);

    }

    public static void seeUnit(int index, String[] arr, LinkedList<String> stringLinkedList) {
        for (int i = index; i < arr.length; i++) {
            stringLinkedList.push(arr[i]);
            System.out.println(stringLinkedList.toString());
            seeUnit(i+1,arr,stringLinkedList);
            stringLinkedList.pop();
        }
    }
}
