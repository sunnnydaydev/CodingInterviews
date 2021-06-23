package Arrays;

/**
 * Created by zb on 2021/6/21 17:29
 * <p>
 *
 *剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Search {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        int[] arr1 = new int[]{5, 7, 7, 8, 8, 10};

        int[] arr3 = new int[]{1};
        int[] arr4 = new int[]{2,2};

        System.out.println("searchInLoop:" + searchInLoop(arr, 8));
        System.out.println("searchInLoop:" + searchInLoop(arr1, 6));

        System.out.println("searchInLoopPlus:" + searchInLoopPlus(arr, 8));
        System.out.println("searchInLoopPlus:" + searchInLoopPlus(arr1, 6));

        System.out.println("searchInLoopPlus:" + searchInLoopPlus(arr3, 1));
        System.out.println("searchInLoopPlus:" + searchInLoopPlus(arr3, 2));

        System.out.println("searchInLoopPlus:" + searchInLoopPlus(arr4, 2));
    }


    /**
     * 非最优解，暴力循环。
     * 时间复杂度O(n)
     */
    private static int searchInLoop(int nums[], int target) {
        int count = 0;
        if (nums == null || nums.length == 0) return count;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * 针对searchInLoop 简单优化。
     * <p>
     * 1、首先采取二分定位
     * 2、找到目标元素后，循环查找左右区间的元素。
     */
    private static int searchInLoopPlus(int nums[], int target) {
        int count = 0;
        if (nums == null || nums.length == 0) return count;

        int start = 0, end = nums.length - 1;
        int middle = 0;

        boolean isExit = false; // 二分查找元素是否存在。
        // 1、二分查找中间节点。
        while (start <= end) {
            middle = start + ((end - start) >> 1); // 平均值优化写法，位运算+ 一定范围上防止int溢出
            if (nums[middle] > target) {
                end = middle - 1;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {// num[middle] = target
                isExit = true;
                break; // 中间节点索引为middle.
            }
        }

        if (!isExit) { // 不存在直接退出，下面不用进行。
            return 0;
        }
        // 2、统计总数
        int rightCount = 0;  // 右边区间总数
        int leftCount = 0;// 左边区间总数

        int rightIndex = middle + 1; // 右区间索引
        int leftIndex = middle  -1; // 左区间索引

        while (rightIndex < nums.length - 1 && nums[rightIndex] == target) { //rightIndex < nums.length - 1 注意边界，不能包括
            rightIndex++;
            rightCount++;
        }

        while (leftIndex > 0 && nums[leftIndex] == target) { // 注意边界，不能包括
            leftIndex--;
            leftCount++;
        }

        return rightCount + leftCount + 1; // 目标左区间挨着的元素数+目标元素（1个）+目标右区间元素个数
    }
}
