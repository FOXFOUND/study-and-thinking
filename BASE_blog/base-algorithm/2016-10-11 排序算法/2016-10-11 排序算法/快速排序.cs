using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2016_10_11_排序算法
{
    //快速排序 利用的是分治，二分，递归的思想
    //一次都是将待排序的数组一分为二，然后小的在一边，大的在一边
    //依次递归直到只有一个元素了，也就是说没法排序的，那么这个数组
    //就排序完了

    // 快速排序的 最好 时间复杂度 为o（nlgn） 最坏的时间复杂度为 o(n^2)
    // 空间复杂度为 o（1）
    //但是快速排序需要递归 也就是 需要栈空间 这个栈空间是 O(lg n)
    // 综上所属快速排序的空间复杂度是o(lg n)


    // 为什么有最好和最坏之分呢 ，因为由于判断大小的那么标定值的选取和数组
    //的有序程度有关。如果每次移动由于标定值的选取不当，而且数组基本有序
    // 那么就会造成数据来回移动，就像冒泡排序一样，所以快速排序就退化成了
    // 冒泡排序了， 快速排序是不稳定的排序，因为他的时间复杂度和给定的数组
    //有关
    class 快速排序
    {
        public static int partion(int [] arr,int left,int right)
        {
            int prikey = arr[left];  //将数组中最左边的元素作为标定值
            while (left<right)   
            {
                //当左右指针没有相遇的时候，将小的数换到左边，大的数换到右边
                //因为第一个位置已经保留，所以可以直接覆盖移动，之后覆盖移动
                //也是这个原因
                while (left < right && arr[right] > prikey)
                {
                    right--;
                }
                arr[left] = arr[right];
                while (left < right && arr[left] <= prikey)
                {
                    left++;
                }
                arr[right] = arr[left];
            }
               //当两个指针相遇了就停止移动，因为已经遍历了整个数组了
               
                //因为最后是左指针移动到有指针的空位，所以左指针的位置
               //的数据是重复了，所以最后将标志数据移动到左指针处
            arr[left] = prikey;
            return left;
        }


        public static void quicksort(int [] arr,int left,int right)
        {
            //递归终止条件 表示数组只剩下一个元素了
            if (left>=right)
            {
                return;
            }

            //进行递归排序
            int middle = partion(arr, left, right);

            //先是左递归，然后有递归，总的来看相当于后序遍历
            //当左递归的时候 middle-1 替换right指针，保证了
            //数组向左边依次二分递归
            //middle+1替换了left指针，保证了数组向右边依次二分

            //因为中间的位置已经确定那么就没有参加排序的必要了
            //所以从middle 的-1 和+1 位置开始排序的
            quicksort(arr, left, middle - 1);
            quicksort(arr, middle + 1, right);
        }

        public  static void sort(int [] arr)
        {
            //数组的合法性判断
            if (arr == null || arr.Length == 0)
                return;

            //整体上调用，确定数组，left指针和right指针
            //这样每次递归，二分的时候才有了边界条件，因为数组的
            //类型是引用类型，所以保证每次修改都是在原数组上的修改
            quicksort(arr, 0, arr.Length - 1);
        }

    }
}
