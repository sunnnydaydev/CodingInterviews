package loop;

/**
 * Created by zb on 2020/12/18 13:28
 * <p>
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * <p>
 * 一、1次可跳：
 * 1个
 * 2个
 * 二、N 阶有多少种跳法
 * <p>
 * <p>
 * n时 1,2 多少种组合？？？？
 * 跳的步数、台阶总数、跳的方法数关系？？？
 * <p>
 * 三、思考：
 * n = 0     不需要跳，                              0跳法。     (特殊情况)
 * n=1           1                                   1跳法。    （特殊情况）
 * n =2       11, 2                                  2跳法      （特殊情况）
 * n =3      111，12, 21                             3跳法      （普通情况）
 * n =4  1111,121,112，211,22                        5跳法      （普通情况）
 * n=5   11111,1211,1121，1112,2111，212,221,122     8跳法      （普通情况）
 * 四、问题转化->斐波那契数列->数列变形（从n=3台阶开始符合规律）
 */
public class FrogJumping {
    public static void main(String[] args) {
        System.out.println("台阶跳法：" + jump(0));
        System.out.println("台阶跳法：" + jump(1));
        System.out.println("台阶跳法：" + jump(2));
        System.out.println("台阶跳法：" + jump(3));
        System.out.println("台阶跳法：" + jump(4));
        System.out.println("台阶跳法：" + jump(5));
    }

    // 循环写法 O(n)复杂度
    private static int jump(int n) {
        if (0 == n || 1 == n) return 1;
        int fn = 0;
        int preOne = 1;
        int preTwo = 2;
        for (int i = 2; i <= n; i++) {
            fn = (preOne + preTwo) % 1000000007;
            preOne = preTwo;
            preTwo = fn;
        }
        return fn;
    }
    // 递归写法：复杂度太高。
}
