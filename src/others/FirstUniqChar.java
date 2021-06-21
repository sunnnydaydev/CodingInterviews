package others;

import java.util.*;

/**
 * Created by zb on 2021/6/16 17:16
 * <p>
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println("test1:" + firstUniqChar("abcdefgg"));
        System.out.println("test2:" + firstUniqChar("leetCode"));
    }


    public static char firstUniqChar(String s) {
        char c = ' ';
        if (s == null) return c;

        Map<Character, Integer> map = new LinkedHashMap<>();  //这里不能使用HashMap，hashMap取元素时无序的。
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (map.containsKey(currentChar)) {

                int count = map.get(currentChar) + 1;
                map.put(currentChar, count);

            } else {
                map.put(currentChar, 1);
            }
        }

        // 取出现1此的元素，放入list。
        List<Character> list = new ArrayList<>();
        for (Character character : map.keySet()) {
            if (map.get(character) == 1) {
                list.add(character);
            }
        }
        return list.size() == 0 ? c : list.get(0);
    }

}
