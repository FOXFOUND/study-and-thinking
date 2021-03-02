package algorithm.test.array.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 7, 3, 5, 7, 6, 8, 3, 0, 1, 3, 8, 9, 5, 7, 9, 10};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {

        //构建大顶堆
        for (int i = arr.length / 2  ; i >= 0; i--) {
            adjustHeap(arr, i, arr.length );
        }
        //调整堆顶
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i);
            adjustHeap(arr, 0, i);
        }

    }

    private void swap(int[] arr, int i) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
    }

    private void adjustHeap(int[] arr, int i, int length) {

        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[j] > temp) { //需要比较的元素
                arr[i] = arr[j];
                i = j;  //移动指针
            } else {
                break;
            }

        }
        arr[i] = temp;
    }

//    public static void adjustHeap(int[] arr, int i, int length) {
//        int temp = arr[i];//先取出当前元素i
//        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
//            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
//                k++;
//            }
//            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
//                arr[i] = arr[k];
//                i = k;
//            } else {
//                break;
//            }
//        }
//        arr[i] = temp;//将temp值放到最终的位置
//        //System.out.println(Arrays.toString(arr));
//    }
}
