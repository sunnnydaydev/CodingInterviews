package Arrays;

/**
 * Created by zb on 2021/6/22 14:08
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MissingNumber {

    public static void main(String[] args) {
        int arr1[] = new int[]{0,1,3};
        int arr2[] = new int[]{0,1,2,3,4,5,6,7,9};
        System.out.println("缺失元素1："+missingNumber(arr1));
        System.out.println("缺失元素2："+missingNumber(arr2));
    }

    /**
     * 得知：
     * 1、数组[0,n-1]
     * 2、数组数字连续
     * 3、数组仅缺失一个元素
     * 4、缺失元素所在索引之前的  索引 = 元素值。
     *
     *
     * 一、规律：每个元素都对应索引，则缺失元素索引为为i，则有:
     * <p>
     * 1、缺失元素左侧的元素nums[i] = i;
     * 2、缺失元素右面的元素nums[i]!=i。从缺失那位开始。
     * <p>
     * 二、缺失的元素就是右子元素的首位。
     *
     * 三、其实就是查找 缺失元素对应索引。
     */
    public static int missingNumber(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int middle;

        while (start <= end) { // 这里为啥要有等于的情况，因为避免 【0,1】这种情况下 （0+1）/2  = 0, 但是目标元素是2 少走一步判断情况。

            middle = start + ((end - start) >> 1);

            if (nums[middle] == middle) { // 1、这里只存在等于不等一两种情况。
                start = middle + 1;
            }else{
                end = middle-1;
            }
        }
        return start; // 这里如果返回 end时要记得+1。
    }
}
