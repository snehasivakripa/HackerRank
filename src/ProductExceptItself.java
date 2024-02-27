//Given an integer array nums, return an array answer such that answer[i] is
// equal to the product of all the elements of nums except nums[i].
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//You must write an algorithm that runs in O(n) time and without using the division operation.
public class ProductExceptItself {

    //this has time COmplexity of O(n)
    //but the space complexity of this is O(n)
    public int[] productExceptSelf(int[] nums) {
        int[] prefixArray=new int[nums.length];
        int[] sufixArray=new int[nums.length];
        int[] outputArray=new int[nums.length];

        for(int i=0; i<=nums.length-1;i++){
           if(i==0){prefixArray[i]=1;}
           else {
               prefixArray[i]=prefixArray[i-1]*nums[i-1];
           }
        }

        for(int i=nums.length-1; i>=0;i--){
            if(i==nums.length-1){sufixArray[i]=1;}
            else {
                sufixArray[i]=sufixArray[i+1]*nums[i+1];
            }
        }
        for(int i=0;i<nums.length-1;i++){
            outputArray[i]=prefixArray[i]*sufixArray[i];
        }
        return outputArray;
    }

    //Better approach with time complexity O(n)
    //and space complexity O(1)
    public int[] productExceptSelfBetter(int[] nums) {

        int[] outputArray=new int[nums.length];

        for(int i=0; i<=nums.length-1;i++){
            if(i==0){outputArray[i]=1;}
            else {
                outputArray[i]=outputArray[i-1]*nums[i-1];
            }
        }

        int suffix=1;
        for(int i=nums.length-1; i>=0;i--){
            if(i==nums.length-1){outputArray[i]=outputArray[i]*suffix;}
            else {
                suffix=suffix*nums[i+1];
                outputArray[i]=suffix*outputArray[i];
            }
        }

        return outputArray;
    }

    public static void main(String args[]) {
        ProductExceptItself s = new ProductExceptItself();
        int num[] = {-1,1,0,-3,3};
        s.productExceptSelfBetter(num);
        for(int n:s.productExceptSelf(num))
        System.out.print(n+ " ");
    }
}
