package cn.edu.cqvie.leetcode;

import java.util.Stack;

public class Solution85 {


//    85. 最大矩形
//    给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//    示例 1：
//    输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//    输出：6
//    解释：最大矩形如上图所示。
//    示例 2：
//
//    输入：matrix = []
//    输出：0
//    示例 3：
//
//    输入：matrix = [["0"]]
//    输出：0
//    示例 4：
//
//    输入：matrix = [["1"]]
//    输出：1
//    示例 5：
//
//    输入：matrix = [["0","0"]]
//    输出：0
//
//    提示：
//    rows == matrix.length
//    cols == matrix[0].length
//    0 <= row, cols <= 200
//    matrix[i][j] 为 '0' 或 '1'

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int res = 0;
        int[][] dp = new int[rows + 2][cols];
        for (int i = 1; i < rows + 1; i++) {
            int count = 0;
            for (int j = 0; j < cols; j++) {
                if (matrix[i - 1][j] == '0') {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = count;
            }
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < cols; i++) {
            stack.push(0);
            for (int j = 1; j < rows + 2; j++) {
                while (dp[stack.peek()][i] > dp[j][i]) {
                    int height = dp[stack.pop()][i];
                    int maxWidth = j - stack.peek() - 1;
                    res = Math.max(res, height * maxWidth);
                }
                stack.push(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution85 solution85 = new Solution85();
        char[][] matrix = new char[][]
                {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int rectangle = solution85.maximalRectangle(matrix);
        System.out.println(rectangle);
    }
}
