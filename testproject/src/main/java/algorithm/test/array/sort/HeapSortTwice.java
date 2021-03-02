package algorithm.test.array.sort;

import java.util.Arrays;

public class HeapSortTwice {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 7, 3, 5, 7, 6, 8, 3, 0, 1, 3, 8, 9, 5, 7, 9, 10};
        HeapSortTwice heapSortTwice = new HeapSortTwice();
        heapSortTwice.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void sort(int[] arr) {

        for (int i = arr.length / 2  ; i >= 0; i--) {
            adjustHeap(arr, i, arr.length );
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    private void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    private void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            if (j + 1 < length && arr[j + 1] > arr[j]) {
                j++;
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }

        }
        arr[i] = temp;
    }
}
