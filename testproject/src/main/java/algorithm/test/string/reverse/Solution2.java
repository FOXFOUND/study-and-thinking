package algorithm.test.string.reverse;

public class Solution2 {
    public static int minCount = 0;
    public boolean validPalindrome(String s) {

        boolean res = validPalindromeSub(s, 0, s.length() - 1, 0);
        return res;

    }

    private boolean validPalindromeSub(String s, int left, int right, int deleteCount) {
//        if (deleteCount > 1 ) {
//            return false;
//        }
        if(deleteCount < minCount){
            minCount = deleteCount;
        }
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            validPalindromeSub(s, left + 1, right, deleteCount + 1);
            validPalindromeSub(s, left, right - 1, deleteCount + 1);


        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.validPalindrome("abbbbca");
        System.out.println(minCount);
    }

}
