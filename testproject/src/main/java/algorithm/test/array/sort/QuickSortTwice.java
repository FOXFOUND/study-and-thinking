package algorithm.test.array.sort;

import java.util.Arrays;
import java.util.Queue;

public class QuickSortTwice {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 7, 3, 5, 7, 6, 8, 3, 0, 1, 3, 8, 9, 5, 7, 9, 10};
        QuickSortTwice quickSortTwice = new QuickSortTwice();
        quickSortTwice.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {

        QuickSort(arr, 0, arr.length - 1);
    }

    private void QuickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left<right && arr[right]>=temp) right --;
            while (left<right && arr[left] <=temp) left ++;
            swap(arr,left,right);
        }
        arr[start] = arr[left];
        arr[left] = temp;
        QuickSort(arr,start,left-1);
        QuickSort(arr,left+1,end);

    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
