using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2016_10_11_排序算法
{
    /*
     *   插入排序 利用的思想是 在一个有序的数组中插入一个新的元素，
     *   然后对新的元素进行冒泡，从而重新构建有序序列
     *   
     *   插入排序的时间复杂度 最好和最坏 o(n^2)
     *    空间复杂度  o（1）
     *    
     *   插入排序，选择排序，冒泡排序成为简单排序
     */
    class 插入排序
    {
        public static void insertsort(int [] arr)
        {
            for (int i = 1; i < arr.Length; i++)  //表示第i个数和之前进行排序构建有序序列
            {
                //因为一个元素不用排序，现在从数组的第二个元素开始，
                //构建新的有序序列

                int j = i;  //
                while (j-1>=0&&arr[j-1]>arr[j])
                {
                    // 这个局部有序序列采用 大头在右边的策略


                    // 大的数在前面 ，
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;

                    //继续和这个数组中第二大的数比较
                    j--;

                    //直到找到比他小的数，或者已经比较完整个
                    //局部有序数组了，找不到比他更小的数，也就是说
                    //他是最小的数了，也就是说，也是数组的开头了

                    //那么此时跳出循环，进行下一个数的判断
                }
                
            }
        }
    }
}
