package algorithm.test.replaceSpaces;

/**
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * 示例 2：
 * <p>
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-url-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String replaceSpaces(String S, int length) {
        String checkS = S.trim();
        StringBuilder stringBuffer = new StringBuilder();
        String replaceStr = "%20";
        if (checkS.length() == 0) {
            for (int i = 0; i < length; i++) {
                stringBuffer.append(replaceStr);
            }
            return stringBuffer.toString();
        }
        if (checkS.length() == length) {
            for (int i = 0; i < length; i++) {
                char c = checkS.charAt(i);
                if (c == ' ') {
                    stringBuffer.append(replaceStr);
                } else {
                    stringBuffer.append(c);
                }
            }
            return stringBuffer.toString();
        }
        int subLength = length - checkS.length();
        if (S.charAt(0) == ' ') {
            for (int i = 0; i < subLength; i++) {
                stringBuffer.append(replaceStr);
            }
            for (int i = 0; i < checkS.length(); i++) {
                char c = checkS.charAt(i);
                if (c == ' ') {
                    stringBuffer.append(replaceStr);
                } else {
                    stringBuffer.append(c);
                }
            }
        }else {

            for (int i = 0; i < checkS.length(); i++) {
                char c = checkS.charAt(i);
                if (c == ' ') {
                    stringBuffer.append(replaceStr);
                } else {
                    stringBuffer.append(c);
                }
            }
            for (int i = 0; i < subLength; i++) {
                stringBuffer.append(replaceStr);
            }
        }


        return stringBuffer.toString();

    }
}
