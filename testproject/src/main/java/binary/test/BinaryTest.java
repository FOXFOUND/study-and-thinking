package binary.test;

public class BinaryTest {
    public static void main(String[] args) {
        int i =3;
        String s= Integer.toBinaryString(i);
        System.out.println(s);
        int n = Integer.parseInt(s,2);
        System.out.println(n);
        int m =5 ;
        int q = 7;
        System.out.println(rangeBitwiseAnd(m,q));
    }
    public static int  rangeBitwiseAnd(int m, int n) {
        int temp = m ;
        for(int i =m+1 ;i<=n;i++){
            temp = temp & i;
        }
        return temp;
    }
}
