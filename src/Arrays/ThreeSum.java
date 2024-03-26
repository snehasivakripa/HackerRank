package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets
*/
public class ThreeSum {

    //with duplicates
    public List<List<Integer>> threeSums(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        List<List<Integer>> output= new ArrayList<>();

        for(int i=0; i<nums.length;i++){
            numMap.put(nums[i],i);
        }
        for(int i=0; i<nums.length;i++){
            int j=i+1;
            while(j<nums.length) {
                int firstSum=-1*(nums[j]+nums[i]);
                if (numMap.containsKey(firstSum) && numMap.get(firstSum) !=i && numMap.get(firstSum) !=j) {
                    output.add(Arrays.asList(firstSum, nums[i],nums[j]));
                }
                j++;
            }
        }

        return output;
    }

    // removing duplicates
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Sorted Array
        List<List<Integer>> answer = new ArrayList<>();
        //if array contains less than triplet
        if (nums.length < 3) {
            return answer;
        }
        //after sorting if the array first element greater than 0
        if (nums[0] > 0) {
            return answer;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            int j = i + 1;
            while(j<nums.length) {
                int required = -1 * (nums[i] + nums[j]);
                if (hashMap.containsKey(required) && hashMap.get(required) > j) {
                    answer.add(Arrays.asList(nums[i], nums[j], required));
                }
                j = hashMap.get(nums[j]);
                j++;
            }

            i = hashMap.get(nums[i]);
        }

        return answer;
    }

    public static void main(String args[]) {
        ThreeSum s = new ThreeSum();
        int nums[] = {-1,0,1,2,-1,-4};
        List<List<Integer>> output= s.threeSum(nums);
        System.out.println(Arrays.toString(output.toArray()));
    }
}
