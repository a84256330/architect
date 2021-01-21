import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: mc
 * @DateTime: 2021/1/20 20:07
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 */
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n =  nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n-2; i++) {
            if (i==0 || nums[i]!=nums[i-1]){
                List<List<Integer>> nexts = twoSum(nums,i+1,-nums[i]);// 数组里有负数
                for (List<Integer> next : nexts) {
                    next.add(0,nums[i]);
                    ans.add(next);
                }
            }
        }
        return ans;
    }

    private List<List<Integer>> twoSum(int[] nums,int begin , int target){
        int l = begin;
        int r = nums.length-1;
        List<List<Integer>> ans = new ArrayList<>();

        while(l<r){
            if (nums[l]+nums[r]<target) {
                l++;
            }
            else if (nums[l]+nums[r]>target) {
                r--;
            }else{
                if (l==begin || nums[l]!=nums[l-1]){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[l]);
                    res.add(nums[r]);
                    ans.add(res);
                }
                l++;
            }
        }
        return ans;
    }

}
