using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2016_10_11_排序算法
{
    /*
     * 选择排序利用的是 整体数据 ，而不是冒泡排序相邻范围内的数据
     * 减少了不必要了交换次数，但是数据的比较次数没有减少
     * 
     * 在排序的 性能方面有一定提升，因为减少了移动次数，这样子就
     * 节省了因为数据频繁移动而需要的时间
     * 
     * 选择排序的时间复杂度为 最好和最坏 o（n^2）
     *  空间复杂度为  o（1）
     * 
     *  因此可以把选择排序看作是对冒泡排序的一次优化
     */
    class 选择排序
    {
        public static void selectsort(int [] arr)
        {
            for (int i = 0; i < arr.Length; i++)  //从左到右的空位
            {
                int temp=arr[i];  // 获取第i个空位的值
                int prt = i;      //一个指针 指向要换到的位置
                for (int j = i; j < arr.Length; j++)  
                {
                    //如果要获取第i个空位只要比较这个位子之后的数据就可以了
                    //因为不用前后比较所以，这次 不用 减1

                    //采取大头在左侧的策略进行排序


                    if (arr[j]>temp)
                    {
                        // 获取最大值，然后指针指向最大值所在的数组位置
                        // 为接下来的数据交换做准备
                        temp = arr[j];
                        prt = j;
                    }
                    // 这里减少了冒泡排序的数据交换操作，但是增加了
                    //赋值操作，我觉得数组交换可能损耗更大一点
                    //因为数组是在堆中而赋值是在栈中
                }

                //将i之后最大的数交换到 i位置来，i交换到最大的数所在的位置
                int numt = arr[i];
                arr[i] = temp;
                arr[prt] = numt;

            }
        }

    }
}
