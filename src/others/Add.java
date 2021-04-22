package others;

/**
 * Created by zb on 2021/4/21 9:31
 */
class Add {
    public static void main(String[] args) {
        System.out.println("test:"+add(5,17));
        System.out.println("test:"+add(3,2));
        System.out.println("test:"+add(50,50));
        System.out.println("test:"+add(-1,0));
        System.out.println("test:"+add(-1,5));

    }


    /**
     * step1:各位相加 不进位（规律：两数相加不进位，得到的结果与异或运算得到的结果一致）
     * step2：记录进位的二进制数（规律：两数&运算，左移1位 得到的就是进位数）
     *
     * step3：step1+step2（循环重复step1、step2即可。当step左移到0时代表都无进位了。此时step1（a）的结果就是最终结果）
     * */
    static int add(int a, int b) {
        int step1;
        int step2;

        while (b != 0) {
            step1 = a ^ b;// step1
            step2 = (a & b) << 1; // step2 (一直左移数最终会变为0)

            // step2
            a =step1;
            b = step2;
        }
        return a; //注意这里返回a不能是step1（否则-1+0 这种情况直接返回0而不是-1）
    }

}
