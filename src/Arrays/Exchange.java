package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zb on 2021/6/9 15:35
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Exchange {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);


        System.out.println("结果：" + exchange(list1));

    }

    /**
     * 给定数组，变换数组的位置，奇数在前、偶数在后。
     * <p>
     * 常规思路：
     * 1、申请两个数组arr1，arr2，大小与arr相同。分别代表奇数数组，偶数数组。
     * 2、遍历数组arr，把奇数、偶数copy一份放入对应数组
     * 3、arr数组数据替换。
     *
     * 未提交！
     */
    static public List<Integer> exchange(List<Integer> list) {

        if (list == null) return null;
        List<Integer> list1 = new ArrayList<>();//偶数集合
        List<Integer> list2 = new ArrayList<>();//奇数集合

        for (int num : list) {
            if (num % 2 == 0) {
                list1.add(num);
            } else {
                list2.add(num);
            }
        }
        // 元素remove，重新追加
        list2.addAll(list1);
        return list2;
    }

    /**
     * 优化写法：双指针。
     *
     * 提交成功！！！
     */
    static public int[] exchangePlus(int[] nums) {
        if (null == nums) return null;

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if ((nums[start] & 1) == 1) { // 为奇数，直接索引+1，跳过继续循环寻找偶数。
                start++;
                continue;
            }
            if ((nums[end] & 1) == 0){// 为偶数，直接索引+1，跳过
                end--;
                continue;
            }

            //这里必定start指向偶数，end指向奇数。 change size
            int temp = nums[end] ;
            nums[end--] = nums[start];
            nums[start++] = temp;

            //优化
//            end--;
//            start++;
        }

        return nums;
    }




}
