package Nvidia;

import Arrays.TwoSum;
import com.sun.jdi.ArrayReference;

import java.util.*;

/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0
 */
public class LastStoneWeight {


    //Using Linkedlist
    public int lastStoneWeight(int[] stones) {
        LinkedList<Integer> linkedList= new LinkedList<Integer>();
        Arrays.sort(stones);
        for (int n : stones) {
            linkedList.add(n);
        }
        while(linkedList.size()>=1) {
            if(linkedList.size()==1){
                return linkedList.get(0);
            }
            int last_index = linkedList.size() - 1;
            if (linkedList.get(last_index) > linkedList.get(last_index - 1)) {
                linkedList.set(last_index, linkedList.get(last_index) - linkedList.get(last_index - 1));
                linkedList.remove(last_index - 1);
                Collections.sort(linkedList);
            }else if(linkedList.get(last_index)==linkedList.get(last_index - 1)){
                linkedList.remove(last_index);
                linkedList.remove(last_index - 1);
            }

        }
        return 0;
    }

    //Using PriorityQueue
    public int lastStoneWeightQue(int[] stones) {
       PriorityQueue<Integer> priorityQueue=new PriorityQueue(Comparator.reverseOrder());
       for(int i:stones) {
           priorityQueue.add(i);
       }
       while(priorityQueue.size()>=1){
           if(priorityQueue.size()==1){
               return priorityQueue.poll();
           }
           int y = priorityQueue.poll();
           int x =priorityQueue.poll();
           if (y > x) {
              priorityQueue.add(y-x);
           }else if(y==x){
              continue;
           }

       }
        return 0;

    }

    public static void main(String args[]) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        int nums[] = {2,7,4,1,8,1};
        System.out.print(lastStoneWeight.lastStoneWeightQue(nums));
    }
}
