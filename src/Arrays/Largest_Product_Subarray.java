package Arrays;

//Given an integer array nums, find a subarray that has the largest product, and return the product.
public class Largest_Product_Subarray {

    public int maxProdArray(int[] nums) {

        int max_product=0;
        int current_product=1;
        int[] prod_array=new int[5];
        int j=0;
        for(int i=0;i<nums.length;i++){
            current_product=current_product*nums[i];
            if(current_product>max_product){
                max_product=current_product;
                prod_array[j]=nums[i];
                j++;
            }
        }

        for(int n:prod_array)
        System.out.print(n);
        System.out.println();

        return max_product;
    }
    public static void main(String args[]) {
        Largest_Product_Subarray s = new Largest_Product_Subarray();
        int num[] = {2,3,-2,4};
        System.out.print(s.maxProdArray(num));
    }
}
