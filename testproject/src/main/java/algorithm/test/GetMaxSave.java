package algorithm.test;

/**
 * 一名窃贼半夜潜入某珠宝店,珠宝店从编号1,编号2,编号3,....,编号n排列着一共n个珠宝柜,每个珠宝柜均放有名贵珠宝
 * 并标有该珠宝的价值,窃贼可拿取任以珠宝柜的珠宝;但是现场有智能监控系统:
 * 只要2个连续编号的珠宝柜没有珠宝,监控系统即刻自动拉响警报
 *
 * 要求: 如何在不拉响警报的情况下,窃贼得到最大的珠宝收益
 *
 *
 *  这个编程题不严谨:
 * 1.只能取不能放-->两个数比大小
 * 2.能取也能放--> 中位数之前求和 (利用交换将中位数隔位排列)
 *
 */
public class GetMaxSave {

    /**
     *
     */
    private  static  int[] arr = new int[]{1,10,9,4,6,6};   //max  2(10) 4(4) 6(6) =  20



    public static void main(String[] args) {


    }

}
