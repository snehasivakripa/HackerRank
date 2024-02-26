/*  Given an integer array nums,return true if any value appears at
least twice in the array, and return false if every element is distinct.
Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 */

import java.util.HashMap;

public class Contains_Duplicate {

    // the below method uses hash map and has time complexity of O(n)
    public boolean containsDuplicate(int[] nums) {

        HashMap<Integer,Integer> map=new HashMap();
        for(int n:nums){
            if(map.containsKey(n)){
                return true;
            }else {
                map.put(n, n);
            }

        }
        return false;
    }

    public static void main(String args[]) {
        Contains_Duplicate s = new Contains_Duplicate();
        int num[] = {1,1,1,3,3,4,3,2,4,2};
        System.out.print(s.containsDuplicate(num));
    }
}
