package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zb on 2021/6/15 16:56
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class GetLeastNum {
    public static void main(String[] args) {

        System.out.println("测试1:" + getLeastNumbers(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));
    }

    /**
     * 解题思路：
     * 1、排序
     * 2、取数
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k]; // 新数组
        Arrays.sort(arr); // 老数组
        for (int i = 0; i < k; ++i) { // 遍历老数组取前n个数
            vec[i] = arr[i];
        }
        return vec;
    }
}
