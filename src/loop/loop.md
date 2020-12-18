###### 1、斐波那契数列

>[题目](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/)
>
> [练习](https://github.com/sunnnydaydev/CodingInterviews/blob/master/src/loop/Fibonacci.java)
>

```java
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
```

###### 2、青蛙跳台

>[题目](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/)
>
> [练习](https://github.com/sunnnydaydev/CodingInterviews/blob/master/src/loop/FrogJumping.java)
>

```java
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
```
