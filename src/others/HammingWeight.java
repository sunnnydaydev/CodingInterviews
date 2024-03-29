package others;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by SunnyDay on 2021/06/12 18:29
 */
public class HammingWeight {

    public static void main(String[] args) {

        //1、hammingWeight test

        System.out.println(hammingWeight(0));
        System.out.println(hammingWeight(1));
        System.out.println(hammingWeight(2));
        System.out.println(hammingWeight(3));

    }

    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * <p>
     * 示例 1:
     * <p>
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     *  
     * <p>
     * 说明：
     * <p>
     * 用返回一个整数列表来代替打印
     * n 为正整数
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int[] hammingWeight(int n) {
        int maxValue = (int) (Math.pow(10, n) - 1);
        int[] list = new int[maxValue];
        for (int i = 1; i <= maxValue; i++) {
            list[i-1] = i;
        }
        return list;
    }

}
