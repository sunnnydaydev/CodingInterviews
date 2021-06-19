package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by zb on 2021/6/15 14:28
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 *  
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MajorityElement {

    public static void main(String[] args) {
        System.out.println("test1："+ majorityElement1(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2})); //2
        System.out.println("test2："+ majorityElement1(new int[]{1, 3, 3, 2, 3, 22, 3, 4, 3}));//3
        System.out.println("test3："+ majorityElement1(new int[]{1, 1, 31, 1, 222, 1, 5, 4, 1}));//1
        System.out.println("test4："+ majorityElement1(new int[]{1, 5, 5, 7, 5, 2, 5, 5, 5}));//5
        System.out.println("test5："+ majorityElement1(new int[]{1, 4, 3, 4, 4, 2, 5, 4, 4}));//4
    }


    /**
     * 基本思路：Hash统计。时间空间复杂度o(n)
     * <p>
     * 1、使用map数据结构。 key记录元素，value记录出现次数。
     * <p>
     * 2、遍历map 寻找key最大元素。
     * <p>
     * 3、最大元素>数组长度一半时输出
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        //1、存元素
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                Integer curCount = map.get(num);
                map.put(num, ++curCount);
            }
        }
        //2、寻找value 最大值
        Set<Integer> keys = map.keySet();

        int maxValue = 0;
        for (Integer key : keys) {
            if (map.get(key) > maxValue) {
                maxValue = map.get(key);
            }
        }

        int maxKey = 0;
        for (Integer key : keys) {
            if (map.get(key) == maxValue) {
                maxKey = key;
            }
        }

        if (maxValue > nums.length / 2) return maxKey;

        return 0;

    }

    // todo leetCode 解决方案2 ：排序法。由于“你可以假设数组是非空的，并且给定的数组总是存在多数元素”  所以存在时 存在的元素>数组总数一半。
    // 中间的元素一定为 满足条件的。 统计中间元素出现的次数即可。

    //todo leetCode 解决方案3：摩尔投票
    /**
     * 题目要求：
     *
     * 存在元素占数组长度的一半。
     *
     * 摩尔投票算法：
     *
     * 1、不同候选人选票可以相互抵消。
     *
     * 2、暂定出当前胜利者，其他候选人可与他抵消一张票。
     *
     * 3、若当前双方候选人票数相互抵消，下次抽出候选人，作为暂时候选人。
     *
     * */
    public static int  majorityElement1(int[] nums) {

        //众数 x,   票数统计 votes = 0
        int x = 0, votes = 0;

        for(int num : nums){   //遍历数组 nums 中的每个数字 num ；

            if(votes == 0){ //1、当 票数 votes 等于 0 ，则假设当前数字 num 是众数；
                x = num;
            }

            //2、当 num = x 时，票数 votes 自增 1 ；当 num != x 时，票数 votes 自减 1 ；
            if (num==x){
                num = 1;
            }else{
                num = -1;
            }
            //3、vote 累加，为0 则在上述1中重新选候选人。
            votes += num;
        }

        //  votes += num == x ? 1 : -1;      //2、3步骤优化写法、当 num = x 时，票数 votes 自增 1 ；当 num != x 时，票数 votes 自减 1 ；
        return x;

    }



}
