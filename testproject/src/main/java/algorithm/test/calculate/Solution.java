package algorithm.test.calculate;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        char[] cs = s.trim().toCharArray();
        Stack<Integer> st = new Stack();
        int ans = 0, i = 0;
        while (i < cs.length) {
            if (cs[i] == ' ') {
                i++;
                continue;
            }
            //记录操作符
            char tmp = cs[i];
            if (tmp == '*' || tmp == '/' || tmp == '+' || tmp == '-') {
                i++;
                //寻找下一步有效字符,可以是数字也可以是操作符
                while (i < cs.length && cs[i] == ' ') i++;

            }
            //记录数字
            int num = 0;

            //将识别到的字符串转变成数字
            while (i < cs.length && Character.isDigit(cs[i])) {
                num = num * 10 + cs[i] - '0';
                i++;
            }
            //计算逻辑
            switch (tmp) {
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = st.pop() * num;
                    break;
                case '/':
                    num = st.pop() / num;
                    break;
                default:
                    break;
            }
            //结果入栈
            st.push(num);
        }
        //倒序相加
        while (!st.isEmpty()) ans += st.pop();
        return ans;
    }

    public static void main(String[] args) {
        Solution solution  = new Solution();
        int res = solution.calculate("3/2");
        System.out.println(res);
    }

}


