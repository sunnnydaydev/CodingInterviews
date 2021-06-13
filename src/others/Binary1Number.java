package others;

/**
 * Create by SunnyDay on 2021/06/13 09:27
 *
 * 二进制1的个数
 */
public class Binary1Number {


    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n-1)&n; //循环消去最右边的 1
        }
        return count;
    }


    public  int test(int n){
        String binaryNumber = Integer.toBinaryString(n); //输出的为反码
        int count = 0;
        for (int i = 0; i < binaryNumber.length(); i++) {
            char c = binaryNumber.charAt(i);
            if ('1' == c) {
                count++;
            }
        }
        System.out.println("转为二进制：" + binaryNumber + " 含有1的个数：" + count);
        return count;

    }
}
