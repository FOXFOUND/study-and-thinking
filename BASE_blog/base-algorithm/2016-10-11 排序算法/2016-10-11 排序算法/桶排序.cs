using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2016_10_11_排序算法
{

    /*
     * 桶排序的思想是将数据分散到一个个的桶里，然后将每个桶里的数据
     * 进行先进的排序，因为每一个桶里的数据都是相近的所以可以很好的
     * 使用排序算法
     * 
     * 需要注意的是桶排序如果待排序的数据的hash值较分散，那么就会占用
     * 较大的空间，此外如果采用定值数组，那么数组的大小没法确定，所以
     * 应该采用集合
     * 
     * 桶排序的最好的时间复杂度为 o(n)
     * 这是桶排序就退化为计数排序了
     * 
     * 桶排序的平均时间复杂度为O(N+C)，其中C=N*(logN-logM)
     * 
     * 此外桶排序是稳定的
     */
    class 桶排序
    {

        public static void bucketsort(int [] arr)
        {

            //规定桶的数量
            int bucknum = 10;

            //创建桶，这里采取buckets作为桶的索引
            List<List<int>> buckets = new List<List<int>>();

            //初始化桶
            for (int i = 0; i < bucknum; i++)
            {
                buckets.Add(new List<int>());
            }

            //将待排序的数组的数据划分到对应的桶中
            for (int i = 0; i < arr.Length; i++)
            {
                //这里temp作为索引值
                int temp=(int)(arr[i]/10);
                buckets[temp].Add(arr[i]);
            }

            //使用快速算法对每个桶进行排序
            for (int i = 0; i < bucknum; i++)
            {
                if (buckets[i].Count!=0)
                {
                    buckets[i].Sort();
                }
              
            }

            //将排序后的数据放回到原数组中
            int k = 0;
            foreach (List<int> item in buckets)
            {
                foreach (int num in item)
                {
                    arr[k++] = num;
                }
            }
        }
    }
}
