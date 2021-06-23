package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zb on 2021/6/23 13:29
 * <p>
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * <p>
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 */
class FindContinuousSequence {

    public static void main(String[] args) {
        int[][] arr = findContinuousSequence(9);


        for (int[] ints : arr) {
            System.out.println("-----");
            for (int anInt : ints) {
                System.out.print(" value:"+anInt);
            }
            System.out.println("-----");
        }
    }

    /**
     * 题意获取信息：
     * 1、符合元素为[1,target/2) 直接
     * 2、元素为递增连续。
     * <p>
     * 一、题解：
     * 方案1、暴力循环
     * 方案2、滑动窗口思想（这里使用此方案）
     * 二、滑动窗口定义参考：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
     */
    public static int[][] findContinuousSequence(int target) {
        // 初始化窗口[1,1) 代表窗口元素个数为0

        int winStart = 1; //窗口左边界
        int winEnd = 1; // 窗口右边界

        int winSum = 0;// 滑动窗口内所有元素和。

        List<int[]> list = new ArrayList<>();


        while (winStart <= target / 2) {
            if (winSum < target) {
                winSum += winEnd; //计算当前窗口内的值。（先计算，后位移一位）
                winEnd++; // 右窗口右移一位。增加一个数，用于下次累加。

            } else if (winSum > target) {
                winSum -= winStart; // 计算当前窗口值（先计算，后位移一位）
                winStart++; // 左窗口向右位移一位，减少一个数。用于下次累加时减去这个数。
            } else {//winSum>target
                // 找到合适数，把这些数添加到数组。
                int[] arr = new int[winEnd - winStart];
                for (int k = winStart; k < winEnd; k++) {
                    arr[k - winStart] = k;
                }
                list.add(arr);

                //移动做窗口，开始新一轮寻找。
                winSum -= winStart;
                winStart++;
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
