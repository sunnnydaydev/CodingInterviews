package Arrays;

/**
 * Created by zb on 2021/6/24 14:48
 * <p>
 * 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 * <p>
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= k < s.length <= 10000
 */
class ReverseLeftWords {

    public static void main(String[] args) {
        reverseLeftWords("abcdefg", 2);
        reverseLeftWords("lrloseumgh", 6);


    }


    /**
     * 题解:string 的截取、拼接。
     *
     * 执行用时：
     * 20 ms
     * , 在所有 Java 提交中击败了
     * 8.12%
     * 的用户
     * 内存消耗：
     * 38.6 MB
     * , 在所有 Java 提交中击败了
     * 7.82%
     * 的用户
     * */
    public static String reverseLeftWords(String s, int n) {
        if (s == null) return null;
        System.out.println("原来string：" + s + "截取前" + n + "位，放末尾");
        String preN = s.substring(0, n);
        String nextN = s.substring(n);
        System.out.println("截取preN：" + preN);
        System.out.println("截取nextN：" + nextN);
        s = nextN + preN;
        System.out.println("翻转：" + s);
        return s;
    }

    /**
     * 字符串遍历拼接（限制string的api时可用这种方案）
     * */
    public String reverseLeftWords1(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for(int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();

    }


    /**
     * 字符串遍历拼接（取余代码优化）
     *
     * 执行用时：
     * 7 ms
     * , 在所有 Java 提交中击败了
     * 15.32%
     * 的用户
     * 内存消耗：
     * 38 MB
     * , 在所有 Java 提交中击败了
     * 84.53%
     * 的用户
     * */
    public String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length())); // 当 i< s.length 时，i % s.length()  = i
                                                  // 当 i>= s.length时，i % s.length() = 前面跳过的n个数
        return res.toString();
    }



}

