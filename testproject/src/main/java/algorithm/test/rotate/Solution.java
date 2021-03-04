package algorithm.test.rotate;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * 示例 3：
 * <p>
 * 输入：matrix = [[1]]
 * 输出：[[1]]
 * 示例 4：
 * <p>
 * 输入：matrix = [[1,2],[3,4]]
 * 输出：[[3,1],[4,2]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        //水平翻转
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - i][j];
                matrix[length - 1 - i][j] = temp;

            }
        }
        //对角线翻转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }

        }


    }
}
