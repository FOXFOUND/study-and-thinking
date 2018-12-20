using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2016_10_11_排序算法
{
    /*
     *  基数排序利用的是每一位的先后顺序进行排序，而不是通过比较进行排序的
     *  可以从小到大，也可以从大到小
     *  
     * 基数排序的 最好和最坏的时间复杂度是 o(d(n+rd))
     *             空间复杂度是o(rd)
     *  时间效率[1]  ：设待排序列为n个记录，d个关键码，关键码的取值范围为radix，则进行链式基数排序的时间复杂度为O(d(n+radix))，
     *  其中，一趟分配时间复杂度为O(n)，一趟收集时间复杂度为O(radix)
     *  ，共进行d趟分配和收集。 空间效率：需要2*radix个指向队列的辅助空间
     *  ，以及用于静态链表的n个指针。
     */
    class 基数排序
    {

        public static void radixSort(int[] arr)
        {
            //如果数组不满足条件则返回
            if (arr == null && arr.Length == 0)
                return;

            //获取数组中最大位数
            int maxBit = getMaxBit(arr);

            //i应该从1开始，因为数组的最高位是0索引处，最低位是 arr.length-1
            //索引处，如果i从0开始会导致数组超出索引异常
            for (int i = 1; i <= maxBit; i++)
            {
                //按照个位，十位。。。。的顺序进行排序的
                //也就是说两个位数相同的数，经过一系列排序就可以分出大小
                //最后的数组是 大头在右边的顺序
                List<List<int>> buf = distribute(arr, i); //分配
                collecte(arr, buf); //收集

                //为什么每次分配和收集之后 就可以确定大小顺序呢
                //因为排序是从个位开始的，当每一次排序完成后，收集也是从
                //个位开始的，那么就保证位数相同的个位数小的排在了前面
                //下一次分配正是借助了这次排序的状态，然后排10位，假设
                //位数相同的两个数 十位数相同 那么由于之间按照个位已经
                //排序好了，那么个位数小的自然在这个桶的低索引处，而个位数
                //大的自然是在这个桶的高索引处，因为数组是从左到右依次
                //入桶的
                //如果位数相同的两个数 10位数不同，那么10位数大的那个数
                //自然在后边
                //百位，千位亦是如此

                //基数排序利用的就是上一次已经排序好的序列，这个排序
                //若干次数组就变得有序了

                //此外需要说明的是，桶的大小不确定，但是桶的数目是可以确定的
                //0-9

                //如果这些数据的某一位是相同的，那么基数排序就退化为快速排序
                //了，因为每一个桶内的排序都是快速排序实现的

                //如果相同的位在高位，那么快速排序的效率会很高，因为之前
                //已经进行过一定的排序了

                //但是如果相同的位数在低位 个位等，那么快速排序的效率可能
                //会很慢，有可能退化成冒泡排序

                //所以，基数排序不是稳定的排序算法
            }
        }
        /**
* 分配
* @param arr 待分配数组
* @param iBit 要分配第几位
* @return
*/
        public static List<List<int>> distribute(int[] arr, int iBit)
        {
            List<List<int>> buf = new List<List<int>>();
            for (int j = 0; j < 10; j++)
            {
                buf.Add(new List<int>());
            }
            for (int i = 0; i < arr.Length; i++)
            {
                buf[getNBit(arr[i], iBit)].Add(arr[i]);
            }
            return buf;
        }

        /**
         * 收集
         * @param arr 把分配的数据收集到arr中
         * @param buf 
         */
        public static void collecte(int[] arr, List<List<int>> buf)
        {
            int k = 0;
            //for(List<int> bucket : buf) {
            //    for(int ele : bucket) {
            //        arr[k++] = ele;
            //    }
            //}
            foreach (var item in buf)
            {
                foreach (int i in item)
                {
                    arr[k++] = i;
                }
            }

        }

        /**
         * 获取最大位数
         * @param x
         * @return
         */
        public static int getMaxBit(int[] arr)
        {

            //选择排序的思想，获取最大值
            int max = int.MaxValue;
            foreach (var ele in arr)
            {
                int len = (ele + "").Length;
                if (len > max)
                    max = len;
            }


            return max;
        }

        /**
         * 获取x的第n位，如果没有则为0.
         * @param x
         * @param n
         * @return
         */
        public static int getNBit(int x, int n)
        {

            String sx = x + "";
            if (sx.Length < n)
                return 0;
            else
                //sx是字符串，所以，索引是从左向右的，也就是说
                //最高位是 0 索引处，最低位是数组的最右侧，也就是
                //说 最低位所在的数组的最右侧是个位，

                //利用asc码的性质将字符转换成对应的int类型整数返回
                // 避免了int.Parse() 的转换
                return sx[(sx.Length - n)] - '0';
        }

    }
}

   