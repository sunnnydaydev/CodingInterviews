package others;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by SunnyDay on 2021/06/12 18:36
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int repeatNum = 0;
        for (int num : nums) {
            if (!map.containsKey(num)){
                map.put(num,num);
            }else{
                repeatNum = num;
                break;
            }
        }
        return repeatNum;
    }

}
