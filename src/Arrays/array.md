###### 1、二维数组的查找
>[题目](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/)
>
>[练习](https://github.com/sunnnydaydev/CodingInterviews/blob/master/src/Arrays/Find.java)

```java
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;//（row，col）代表右上角元素
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) col--;//往左边列寻找
            else if (matrix[row][col] < target) row++;//往下面行寻找
            else return true;
        }
        return false;
    }

```