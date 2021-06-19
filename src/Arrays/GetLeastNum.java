package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zb on 2021/6/15 16:56
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class GetLeastNum {
    public static void main(String[] args) {

        System.out.println("测试1:"+getLeastNumbers(new int[]{4,5,1,6,2,7,3,8},4));
    }

    /**
     * 解题思路：
     * 1、排序
     * 2、取数
     *
     * */
    public static List<Integer>getLeastNumbers(int[] arr,int k){
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);//1、排序

        for (int i : arr) {// 2、加入集合
            list.add(i);
        }

        for (int i = list.size()-1; i >= k; i--) { // 3、删除多余元素（考虑到数组的特性，采用尾删除法，避免重排）
            list.remove(i);
        }
       return list;
    }
}
