package others;

/**
 * Created by sunnyDay on 2021/4/19 16:30
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * sum(n) = 1+2+3....+n
 */
class Sum {

   static int sum = 0;

    public static void main(String[] args) {
        System.out.println("for 循环解法测试:" + sumForLoop(100));
        System.out.println("for 循环解法测试:" + sumForLoop(-10));
        System.out.println("for 循环解法测试:" + sumForLoop(100000));
        System.out.println("--------------");

        System.out.println("递归解法测试:" + sumRecursion(100));
        System.out.println("递归解法测试:" + sumRecursion(-10));
        System.out.println("递归解法测试:" + sumRecursion(100000));


        System.out.println("--------------");

        System.out.println("构造函数解法测试:" + sumConstructor(6));
        System.out.println("构造函数解法测试:" + sumConstructor(-10));
        System.out.println("构造函数解法测试:" + sumConstructor(100000));


        System.out.println("--------------");

        System.out.println("递归变形解法测试:" + sumRecursionPlus(6));




    }

    /**
     * 方法一：循环求解（不符合题意）
     */
    static int sumForLoop(int n) {
        if (n < 1 || n > 10000) return -1; // 返回值-1 代表输入参数不合法。
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * 方法二：递归求解（不符合题意）
     * 1+2+3+4....+n  // 最终的分解
     * -> sum1+2+3+4...+n
     * -> sum2+3+4...+n
     * -> sum3+4...+n
     * ....
     * ->sum(n-1)+n   //最终的推导，也即可以用递归代码的表示
     */
    static int sumRecursion(int n) {
        if (n < 1 || n > 10000) return -1;
        if (n == 1) return 1;
        return sumRecursion(n - 1) + n;
    }

    /**
     * 方法三：使用构造方法(java中实现不了，java中声明数组不会调用构造 例如 Person ps[] = new Person[10],c++ 中可以 )
     */
    @Deprecated
    static int sumConstructor(int n) {
        return 0;
    }


    /**
     * 方法四：常规递归变形解法（符合题意）
     *
     * 技巧：
     *
     * 1、n==1时终止递归
     *
     * 2、逻辑运算符短路运用
     *
     * 题解来源：https://leetcode-cn.com/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/
     */
    static int sumRecursionPlus(int n) {

        boolean b = n > 1 && sumRecursionPlus(n - 1) > 0; // if(A&&B) 当A false时B短路
        sum+=n;
        return sum;
    }

    /**
     * 方法五：常规解法-数学公式（不符合题意）
     *
     * 符合题意的解法：
     * ->  n*（n+1）<<2 右移2位
     * ->  乘法可以用加法和位运算模拟
     *
     */
    static int sumMath(int n) {
        if (n < 1 || n > 10000) return -1;
        return n * (n + 1) / 2;
    }

}
