package homework.test;

import com.alibaba.fastjson.JSON;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 7, 3, 5, 7, 6, 8, 3, 0, 1, 3, 8, 9, 5, 7, 9, 10};

        sort(arr);

        System.out.println(JSON.toJSONString(arr));
    }

    private static void sort(int[] arr) {
        //1.构建最大堆

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapReBuild(arr, i, arr.length);
        }
        System.out.println(JSON.toJSONString(arr));
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapReBuild(arr, 0, i-1);
        }
    }

    private static void heapReBuild(int[] arr, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int temp = arr[i];
        int index = left;
        for (int j = left; j < length; j = 2 * j + 1) {
            if (right < length && arr[right] > arr[left]) {
                index =right;
            }
            if (arr[index] > arr[i]) {
                swap(arr, i, index);
                heapReBuild(arr, index, length);
            }
//            if (arr[j] > arr[i]) {
//                arr[i] = arr[j];
//                i = j;
//            } else {
//                break;
//            }
        }
        //arr[i] = temp;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
