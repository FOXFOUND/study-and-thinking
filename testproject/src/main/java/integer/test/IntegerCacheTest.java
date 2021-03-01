package integer.test;

public class IntegerCacheTest {
    public static void main(String[] args) {
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        Integer i7 = Integer.valueOf(40);
        Integer i8 = Integer.valueOf(40);

        /**
         * i1=i2   true
         * i1=i2+i3   true
         * i1=i4   false
         * i4=i5   false
         * i7=i8   true
         * i4=i5+i6   true
         * 40=i5+i6   true
         */
        System.out.println("i1=i2   " + (i1 == i2));
        System.out.println("i1=i2+i3   " + (i1 == i2 + i3));
        System.out.println("i1=i4   " + (i1 == i4));
        System.out.println("i4=i5   " + (i4 == i5));
        System.out.println("i7=i8   " + (i7 == i8));
        System.out.println("i4=i5+i6   " + (i4 == i5 + i6));
        System.out.println("40=i5+i6   " + (40 == i5 + i6));
    }
}
