using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2016_10_11_排序算法
{
    /*
     * 归并排序的思想是将待排序的数组 逐步二分，直至二分不了，也就是说只剩下
     * 一个元素了，然后由底向上的进行排序 
     * 归并排序的时间复杂度是最好和最坏 o（nlogn）
     *          空间复杂度是 o（n）
     *  因为归并排序是逐步二分，由底向上进行逐步有序的，所以 最好和最坏的
     *  时间复杂度是一样的，又由于采取了二分进而导致局部有序，在进行排序
     *  所以导致  时间复杂度为 o（nlogn）
     *  
     *  相比于快速排序，归并排序是稳定的排序，但是归并排序的空间复杂度
     *  比快速排序的空间复杂度高，快速排序的空间复杂度是o（logn） 而
     *  归并排序的空间复杂度是o（n）
     *  
     *  相比于堆排序 ，堆排序和归并排序的时间复杂度都是 o（nlogn）
     *  而且 二者都是稳定的排序算法，但是堆排序的空间复杂度是o（1）
     *  归并排序的空间复杂度是o（logn），但是堆排序需要构建一个有序的
     *  堆
     */
    class 归并排序
    {
        public static void mergesort(int[] arr)
        {

            //为什么不直接将arr参数呢，反而增加多个参数呢
            // 第一 如果直接将arr传过去，那么mergesort这个方法就
            //没有意义
            // 第二 由于递归方法的需要所以应该增加参数
            msort(arr, 0, arr.Length);
        }//mergersort

        private static void msort(int[] arr, int left, int right)
        {

            //递归终止的条件，表示只有一个元素了不用继续递归了
            if (left >= right)
            {
                return;
            }

            //去中间值，体现了二分的思想
            int middle = (left + right) / 2;

            //递归左侧，直到递归到上一级的给定数组的第一个元素
            msort(arr, left, middle);

            //递归右侧，知道递归到上一级的给定数组的最右侧的 元素
            msort(arr, middle + 1, right);


            //将左右两个有序的数组合并，传middle的理由是middle
            //作为判断左边的数组是否已经都输出的依据
            merge(arr, left, middle, right);

        }//msort

        private static void merge(int[] arr, int left, int middle, int right)
        {
            //temp作为中间数组，数组的长度包括left，所以+1
            int[] temp = new int[right - left + 1];
            int k = 0; //一个指针，通过这个指针的后移来为temp数组赋值

            //作为左边数组的指针
            int l = left;

            //作为右边数组的指针
            int r = middle + 1;

            //表示左右两个数组都没有输出完
            //左边数组的边界是middle ，右边数组的边界是 right
            while (l <= middle && r <= right)
            {
                //采用大头在左边的策略
                if (arr[l] < arr[r])
                {
                    //赋值并且指针后移
                    temp[k++] = arr[r];
                    r++;
                }
                else
                {
                    temp[k++] = arr[l];
                    l++;
                }
            }

            while (l<=middle)
            {
                arr[k++] = arr[l];
                l++;
            }

            while (r<=right)
            {
                arr[k++] = arr[r];
                r++;
            }


            //现在中间数组temp已经有序了，只要将temp数组复制到arr中即可

            for (int i = 0; i < temp.Length; i++)
            {
                arr[left++] = temp[i];
            }

        }//merge


    }
}
