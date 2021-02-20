package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: mc
 * @DateTime: 2021/1/21 19:39
 * @Description: TODO
 */
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if(i==0 || nums[i]!=nums[i-1]){
                List<List<Integer>> rns = twoSum(nums,i+1,-nums[i]);
                for (List<Integer> rn : rns) {
                    rn.add(0,nums[i]);
                    ans.add(rn);
                }
            }
        }
        return ans;
    }

    private List<List<Integer>> twoSum(int[] nums,int begin, int target){
        int l = begin;
        int r = nums.length-1;
        List<List<Integer>> ans = new ArrayList<>();
        while(l<r){
            if (nums[l] + nums[r] > target) {
                r--;
            }else if (nums[l] + nums[r] < target){
                l++;
            }else {
                if(l==begin || nums[l]!=nums[l-1]){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[r]);
                    res.add(nums[l]);
                    ans.add(res);
                }
                l++;
            }
        }
        return ans;
    }
}
