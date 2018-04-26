using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2016_10_11_排序算法
{
    /*
     *  堆排序就是 利用堆的性质 最大堆和最小堆 ，最大堆是根节点是最大的
     *  元素，最小堆是根节点是最小的元素，此外因为堆是由完全二叉树组成的
     *  而完全二叉树又是可以采取链式存储的，也就是数组的组成形式，所以
     *  采用堆排序可以对数组进行排序，当一个堆形成后，只要每次将最小的值放到
     *  根节点然后动态调整，那么每次根节点的值都是这个当前数组的最大值
     *  这样只要依次交换，那么就可以得到有序的数组
     *  
     * 堆排序的最好和最坏的时间复杂度  为 O(nlgn) 
     *             空间复杂度是  o（1）
     *  
     *  任意
     *  
     */
    class 堆排序
    {

        public static void  maxmodify(int [] arr,int index,int heapsize)
        {
            int imax = index;  //相当于根节点
            int ileft = 2 * index + 1;  //相当于子节点的左节点
            int iright = 2 * index + 2;  //相当于子节点的右节点

            //获取3个节点中的最大节点的值的位置  imax相当于一个指针
            if (ileft<heapsize&&arr[imax]<arr[ileft])
            {
                imax = ileft;
            }
            if (iright<heapsize&&arr[imax]<arr[iright])
            {
                imax = iright;
            }

            //最大堆的性质，将最大值调整到父节点上 ，然后递归调整，
            //递归的终止条件 是 ileft<heapsize  和 imax!=index
            //当 当前的节点满足这个最大堆的性质的时候，那么就需要
            //递归调整了，因为递归调整的堆是一个已经构建好的最大堆
            if (imax!=index)
            {
                int temp = arr[index];
                arr[index] = arr[imax];
                arr[imax] = temp;
                maxmodify(arr, imax, heapsize);
            }
        }//maxmodify

        public static void  buildmaxheap(int [] arr,int heapsize)
        {
            //double temp=((heapsize ) / 2)
            //heapsize -1 代表的是这个堆最后一个元素的索引长度，
            //值得说明的是 无论这个元素队列的长度是奇数还是偶数，除以二
            //取floor 奇数的小数点后的数就会自动抹去，
            double temp = ((heapsize - 1) / 2);
            int iparent = (int)Math.Floor(temp);

            //利用堆的性质构建一个最大堆，如果当前元素需要被调整，那么就会
            //递归调整 直到所有元素都满足最大堆的性质位置
            for (int i = iparent; i>=0; i--)
            {
                maxmodify(arr, i, arr.Length);
            }


        }//buildmaxheap


        public static void heapsort(int [] arr,int heapsize)
        {
            //构建一个最大堆
            buildmaxheap(arr, heapsize);


            
            for (int i = heapsize - 1; i >0; i--)
            {
                //将当前最大的值换到i位置
                int temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;

                //因为交换之后，最大堆的性质不在满足，所以递归调整
                //使得根节点永远是最大值
                maxmodify(arr, 0, i);


                //新的最大堆形成 ，i--了，继续换位，继续调整，依次类推
            }
        }//heapsort

    }
}
