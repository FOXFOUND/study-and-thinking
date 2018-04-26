using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2016_10_11_排序算法
{

    /*
     *  希尔排序也叫做最小增量排序，利用的 但一个数据已经有序时，在添加
     *  新的元素，这样的排序效率会很高
     *  
     */
    class 希尔排序
    {
        public static void shellinsert(int [] arr,int d)
        {
            // 注意 i应该从d开始，这样才能和之前的插入排序
            for (int i = d; i < arr.Length; i++)
            {
                //初始化的时候 j是i前d那个元素
                int j = i - d;

                //将第i个元素保存，然后利用这个保存的数据减少
                //相邻交换
                int temp = arr[i];

                //j=0的原因是 这个数组的第一个元素和与第一个元素距离d的
                //元素进行比较
                while (j>=0&&arr[j]>temp)
                {
                    //如果进到这里来，就证明 前面的元素大于temp
                    //这里采用大头在右边的策略

                    //前面的元素后移，此时 arr[j]和arr[j+d] 当赋值结束
                    //后则存的都是同一个值了，也就是说数值有重复的，可以
                    //直接覆盖
                    arr[j + d] = arr[j];

                    //将指针前移一位，进行比较
                    j = j - d;

                    //如果成立，如此时 i的位置是 arr[i-d]的值
                    //此时arr[i-d-d]和arr[i-d]的位置值是相同的
                    //指针指向 i-d-d-d

                }

                 //此时表示不成立了，要么到头了，要么有比他小的了
                //当有属于移动的时候，因为有数据重复，此时指针j之后的
                //j+d位置处的值是重复的，所以直接进行覆盖，
                if (j!=i-d)
                {
                    arr[j + d] = temp;
                }
            }
        }//shellinsert


        public static void shellsort(int [] arr)
        {
            //设置d的值
            int d = arr.Length / 2;

            //直到整体进行一次插入排序才结束
            while (d>=1)
            {
                shellinsert(arr, d);
            }
        }//shellsort

    }
}
