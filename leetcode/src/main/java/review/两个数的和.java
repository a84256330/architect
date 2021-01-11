package review;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: mc
 * @DateTime: 2021/1/4 20:42
 * @Description: TODO
 */
public class 两个数的和 {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target-nums[i])) {
                return new int[]{hash.get(target-nums[i]),i};
            }
            hash.put(nums[i],i);
        }

        return new int[]{-1,-1};

    }

}
