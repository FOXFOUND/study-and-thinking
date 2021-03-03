package algorithm.test.array.sort;

import com.alibaba.fastjson.JSON;

public class HeapSortTest {
    /**
     * 堆排序
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 5, 7, 6, 8, 3, 0, 1, 3, 8, 9, 5, 7, 9};
        heapSort(nums);
    }

    public static void heapSort(int[] nums) {
        //1.构架最大堆或最小堆 ,堆利用的树结构
        System.out.println(JSON.toJSONString(nums));

        buildMaxHeap(nums);
        //2.将最后一个元素放到根位置进行比较,堆稳定后,将根元素移到末尾

//        int treeHeight = (int) Math.floor(Math.log(nums.length) / Math.log(2));
//        System.out.println(treeHeight);
//        System.out.println(nums[2]);
//        int leftNode = (int) Math.pow(2, treeHeight) - 1;
//        System.out.println(nums[leftNode]);
//        swap(nums, 2, leftNode);
//        System.out.println(JSON.toJSONString(nums));


        //buildMaxHeap(nums);
        //3.重复上一步,指导比较完成
    }

    private static void buildMaxHeap(int[] nums) {
        int lastRoot = nums.length / 2 == 0 ? nums.length / 2  : nums.length / 2 - 1;
        //构建最大堆
        for (int i = lastRoot; i >= 0; i--) {

            checkTreeNode(nums, i);

        }
        System.out.println(JSON.toJSONString(nums));
    }

    private static void checkTreeNode(int[] nums, int i) {
        int lastRoot = nums.length / 2 == 0 ? nums.length / 2  : nums.length / 2 - 1;
        if (i > lastRoot) {
            return;
        }
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (nums[right] > nums[left]) {
            //左节点大于右节点
            swap(nums, left, right);
        }
        //根节点
        int root = i;
        //左节点大于根节点
        if (nums[left] > nums[root]) {
            //swap(nums, i - 1, root);
            swap(nums, root, left);
            if (nums[right] > nums[left]) {
                //左节点大于右节点
                swap(nums, left, right);
            }
        }
    }

    private static void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
        //System.out.println(JSON.toJSONString(nums));
        // System.out.println(JSON.toJSONString(nums));

    }
}
