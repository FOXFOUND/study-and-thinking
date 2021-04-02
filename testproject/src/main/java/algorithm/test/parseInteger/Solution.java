package algorithm.test.parseInteger;

public class Solution {

    //将字符串解析成整数
    public Integer parseInteger(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        if (!Character.isDigit(s.charAt(s.length() - 1))) {
            return null;
        }

        // int res = Integer.valueOf(s.charAt(s.length() - 1) - '0');
        int res = 0;
        long check = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!Character.isDigit(s.charAt(i))) {
                return null;
            }
            int currentNum = (int) Math.pow(10, (s.length() - 1 - i)) * (s.charAt(i) - '0');
            check = currentNum + check;
            if (check > Integer.MAX_VALUE || check < Integer.MIN_VALUE) {
                return null;
            }
            res = (int)check;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int res = solution.parseInteger("1234");
        //int res = solution.parseInteger("12348");
        //Integer res = solution.parseInteger("a1b1");
        Integer res = solution.parseInteger("12147483647");
        //Integer res = solution.parseInteger("2147483648");
       // Integer res = solution.parseInteger("01234");
        System.out.println(res);

//        long a = Integer.MAX_VALUE;
//        int b = (int) a;
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(b);
    }
}
