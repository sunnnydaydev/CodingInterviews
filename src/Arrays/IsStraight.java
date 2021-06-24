package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zb on 2021/6/24 15:29
 * <p>
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * <p>
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，
 * <p>
 * 而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 *  
 * <p>
 * 限制：
 * <p>
 * 数组长度为 5 
 * <p>
 * 数组的数取值为 [0, 13] .
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class IsStraight {
    public static void main(String[] args) {
        int[] arr1 = new int[]{5, 3, 2, 1, 4};
        System.out.println(isStraight(arr1));

        int[] arr2 = new int[]{5, 0, 2, 1, 0};
        System.out.println(isStraight(arr2));

        int[] arr3 = new int[]{5, 0, 2, 12, 0};
        System.out.println(isStraight(arr3));

    }

    /**
     * 获取信息：
     * 1、大小鬼表示为0，但是可为任意牌。
     * <p>
     * 分析题：5张牌构成顺子满足的条件
     * <p>
     * 1、除去大小猫外剩余牌不重复
     * 2、剩余牌中最大值maxValue减去最小值minValue <5.
     * <p>
     * 如何解：
     * 1、不重复可以使用set集合过滤
     * 2、由于大小猫可代替任何牌，所以不同判断大小猫的个数。因为不同个数的大小猫情况下都要满足剩余牌 maxValue-minValue<5
     * 3、集合添加过程中筛选大小最值、大小猫即可。
     *
     * 注意解题思路：
     * 1、最大值最小值的初始值设定（不要影响结果，所以取边界之外的数）
     * 2、大小猫的存在个数不影响算法：maxValue - minValue < 5
     */
    public static boolean isStraight(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num == 0) continue;
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
            if (set.contains(num)) return false;
            set.add(num);
        }
        return maxValue - minValue < 5;
    }
}
