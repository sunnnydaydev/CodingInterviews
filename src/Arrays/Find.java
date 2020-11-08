package Arrays;

/**
 * Create by SunnyDay on 2020/11/08 19:57
 * 题目：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
public class Find {
    // 方案2：相对1优化方案。

    // 起始位置，只能为右上角、左下角。
    // （满足给定数组与目标数组的关系：）
    //1、假如从右上角开始：比目标元素大的数组元素都在下侧，比目标元素小的数组元素都在左侧。(方案可行)
    //2、假如从左下角开始：比目标元素大的数组元素都在右侧，比目标元素小的数组元素都在上侧。（方案不可行）
    //3、其他两角判断出现两侧都有状况，无法确定去哪边。
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) col--;
            else if (matrix[row][col] < target) row++;
            else return true;
        }
        return false;
    }
    // 方案1：暴力循环方案
    public static boolean Find(int target, int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.println("数组元素：" + anInt);
                if (anInt == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
