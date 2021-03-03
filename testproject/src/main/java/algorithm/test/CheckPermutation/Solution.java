package algorithm.test.CheckPermutation;

import java.util.Arrays;

public class Solution {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        String s12 = new String(s1Array);
        String s22 = new String(s2Array);
        return s12.equals(s22);

    }

    public static void main(String[] args) {


        String s1 = "abc";
        String s2 = "bca";
        Solution solution = new Solution();
        boolean res =  solution.CheckPermutation(s1,s2);
        System.out.println(res);
    }
}
