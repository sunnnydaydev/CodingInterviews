package Arrays;

/**
 * Create by SunnyDay on 2020/12/15 20:45
 * 题目：斐波那契数列
 * 介绍：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class Fibonacci {
    // 0,1,1,2,3,5,8,,,,
    public static void main(String[] args) {
         System.out.println("fib->Loop:"+fib(0));
         System.out.println("fib->Loop:"+fib(1));
         System.out.println("fib->Loop:"+fib(2));
         System.out.println("fib->Loop:"+fib(3));
         System.out.println("fib->Loop:"+fib(4));
         System.out.println("fib->Loop:"+fib(5));
         System.out.println("fib->Loop:"+fib(6));
    }

    // 循环写法
    public static int fib(int n) {
        if (0 == n) return 0;
        if (1 == n) return 1;

        int preOne = 0;
        int preTwo = 1;
        int fn = 0;

        for (int i = 2; i <= n; i++) {//从第三个数开始遍历计算fn的值。
            fn = (preOne + preTwo) % 1000000007; // 计算fn的值
            preOne = preTwo;
            preTwo = fn;
        }
        return fn;
    }
}
