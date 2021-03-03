package algorithm.test.array.sort;

public class FastSort {
    //private static int[] arr = new int[]{1, 10, 9, 4, 6, 6};  9
    //private static int[] arr = new int[]{10,9,8,7,6,5};  11
    private static int[] arr = new int[]{6,9,8,7,6,6};  //11
    //private static int[] arr = new int[]{10,10,10,10,10,10};  11
    private static  int  count = 0;

    public static void main(String[] args) {

        quickSort(arr, 0, arr.length - 1);
        extracted();
        System.out.println(count);
    }

    private static void extracted() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void quickSort(int[] arr, int left, int right) {
        count++;
        System.out.println(left + " _" + right);
        if(left >= right) {
            return;
        }
        int preLeft = left;
        int preRight = right;
        int point = arr[left];
        while (left < right) {

            while (arr[right] >= point && right >left) {
                right--;
            }
            System.out.println("right =" + right);

            while (arr[left] <= point && right > left) {
                left++;
            }
            System.out.println("left =" + left);
            extracted(arr, left, right);
            extracted();
        }
        arr[preLeft] = arr[left];
        arr[left] = point;
        extracted();
        quickSort(arr, preLeft, left - 1);
        quickSort(arr, left + 1, preRight);

    }

    private static void extracted(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
