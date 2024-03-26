package Arrays;

import java.util.HashMap;

/* Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution,
and you may not use the same element twice.
*/
public class TwoSum {

    //two pass hash map
    public int[] twoSum(int[] nums, int target) {
        int[] n=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0; i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0; i<nums.length;i++){
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!=nums[i]){
                n[0]=i;
                n[1]=map.get(target-nums[i]);
            }
        }
        return n;
    }

    //one pass hash map
    public int[] twoSums(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
            System.out.print(numMap.keySet()+"\n");
        }

        return new int[]{};
    }


    public static void main(String args[]) {
        TwoSum s = new TwoSum();
        int nums[] = {2,7,11,15};
        int[] num=s.twoSums(nums, 26);
        for(int n:num){
            System.out.print(n+" ");
        }
    }
}
