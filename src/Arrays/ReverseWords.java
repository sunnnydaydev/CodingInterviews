package Arrays;

import java.util.List;
import java.util.Stack;

/**
 * Created by zb on 2021/6/23 15:35
 * <p>
 * 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
class ReverseWords {

    public static void main(String[] args) {

        //
        System.out.println("翻转单词:" + reverseWords("the sky is blue"));
        System.out.println("翻转单词:" + reverseWords("  hello world!  "));
        System.out.println("翻转单词:" + reverseWords("a good   example"));

    }

    /**
     * 一、需求：翻转单词.
     * <p>
     * 二、根据题意获取信息：
     * <p>
     * 1、标点符号与单词在一起时当做单词一部分。
     * 2、翻转单词后 多余的空格去除（包括首尾去除、单词间只留一个空格）
     * <p>
     * 三、思路：
     * 1、string 去空格，然后根据空格分隔String。[注意：假如存在n个空格，去空格后剩下n-1个]
     * 2、倒叙遍历 分隔得到的数值，碰到空格直接跳过。
     */
    public static String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if(strs[i].equals("")) continue; // 遇到空单词则跳过
            sb.append(strs[i]).append(" "); // 将单词拼接至 StringBuilder
        }
        return sb.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }
}

