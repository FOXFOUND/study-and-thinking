package algorithm.test.array.sort;

import com.alibaba.fastjson.JSON;

public class ArrayNew {

    public void sortArr(int[] arr) {

        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }
        int temp = arr[start];
        int left = start;
        int right = end;

        while (left < right) {

            //找到右边的节点小于temp的位置
            while (arr[right] >= temp && left < right) right--;

            //找到左边节点大于temp的位置
            while (arr[left] <= temp && left < right) left++;

            swap(arr, left, right);
        }
        arr[start] = arr[left];
        arr[left] = temp;
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{5, 2, 4, 5};
       int[] arr = new int[]{6,9,8,7,6,6};
        ArrayNew arrayNew = new ArrayNew();
        arrayNew.sortArr(arr);
        System.out.println(JSON.toJSONString(arr));
    }

}
