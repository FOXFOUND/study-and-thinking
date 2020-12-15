package hashmap.test;

public class NumberOfLeadingZerosTest {
    public static void main(String[] args) {
        int i = 8;
        //00000000 0000000 00000000  00001000 = 28
        //输出第一个不是0的位前面0的个数
        System.out.println(Integer.numberOfLeadingZeros(8));
    }
}
