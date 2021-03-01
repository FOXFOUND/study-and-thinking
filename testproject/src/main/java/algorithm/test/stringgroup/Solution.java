package algorithm.test.stringgroup;

/**
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 示例1:
 *
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 * 提示:
 *
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-i-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
class Solution {
    int I=0;//返回数组的索引
    public String[] permutation(String S) {
        int N=getlen(S.length());
        char[] c=S.toCharArray();
        String[] res=new String[N];
        backtrack(0,c,res);
        return res;
    }
    int getlen(int n){//n:1-9
        if(n==1) return 1;
        return n*getlen(n-1);
    }
    void backtrack(int index,char[] c,String[] res){
        if(index==c.length-1){
            res[I++]=String.valueOf(c);
            return;
        }
        for(int i=index;i<c.length;i++){//选择路径列表
            swap(index,i,c);//做出选择
            backtrack(index+1,c,res);//继续DFS决策树
            swap(index,i,c);//撤销选择
        }
    }
    void swap(int i,int j,char[] c){
        char t=c[i];
        c[i]=c[j];
        c[j]=t;
    }
}
