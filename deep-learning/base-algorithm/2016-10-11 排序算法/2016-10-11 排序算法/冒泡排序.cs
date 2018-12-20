using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2016_10_11_排序算法
{
    class 冒泡排序
    {
        /*
         *  冒泡排序就是每次比较前后的两个数，将大的数在前，小的数在后
         *  由于之前的数已经有序，所以接下来的比较中就不用比较之前的数了
         *  基于此点，有了优化后的冒泡排序
         *  
         *  此外冒泡排序是时间复杂度 最好 和最坏 都为  O（n^2）
         *   空间复杂度为 o（1）
         */
        public static void bubblesort(int [] arr)
        {
            for (int i = 0; i < arr.Length; i++) //表示这次冒泡的是数组的第几个数
            {
                for (int j = i; j < arr.Length-1; j++) //从这个数开始，与后面的数进行比较
                {
                    // 现在采用 最大的数在右侧 的有序序列

                    if (arr[j+1]<arr[j])
                    {
                        int temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                    }
                    // 因为 j 和 j+1 表示一个数的前后，那么最后一个
                    //数 没有后边的数了，所以应该注意数组的索引范围

                    //进行互换的时候还是可以优化的，参考的就是互换
                    //两杯水的例子，如果被子容量是确定的那么就用
                    //三个杯子。如果杯子容量很大，水很少就用2个杯子

                    if (arr[j+1]<arr[j])
                    {
                        arr[j + 1] = arr[j + 1] + arr[j]; 
                        //将两杯水合到一杯水中
                        arr[j] = arr[j + 1] - arr[j];
                        //从一杯水中剪掉另一杯水
                        arr[j + 1] = arr[j + 1] - arr[j];
                        //得到另一杯水
                    }
                    //实际上 上边的判断有一个漏洞，就是二者之和
                    //不能超出int的最大范围

                    //此外上面的原理还是借助了cpu内部的寄存器，
                    //虽然没有显示的声明变量当作寄存器，但是
                    //却隐士的使用了cpu内的寄存器
                }
            }
        }
    }
}
