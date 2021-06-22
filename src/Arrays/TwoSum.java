package Arrays;

/**
 * Created by zb on 2021/6/22 16:39
 * <p>
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class TwoSum {
    public static void main(String[] args) {
        int[] arr = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i : arr) {
            System.out.println("arr:"+i);
        }
    }


    /**
     * 解题思路：
     * <p>
     * 1、两层循环，O（n^2） 时间复杂度
     * <p>
     * 2、双指针 (排序数组)
     */
    public static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int sum;
        while (start <= end) {
            sum = nums[start] + nums[end]; //取首尾值
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                return new int[]{nums[start], nums[end]};
            }
        }
        return new int[0];
    }
}
