package Arrays;

import java.util.Scanner;

//Program with sum of two integers without '+' or '-'
public class SumOfTwoNumbers {


    public int sum(int a, int b){
        if(a==0) return b;
        else { return sum(--a,++b);
        }

    }
    public static void main(String args[]){
        SumOfTwoNumbers sumOfTwoNumbers=new SumOfTwoNumbers();
        Scanner sc=new Scanner(System.in);
        int a =sc.nextInt();
        //Read two numbers
        System.out.print("Enter first Number:"+ a+"\n");
        int b=sc.nextInt();
        System.out.print("Enter second Number:"+ b+"\n");
        System.out.print("Sum: "+sumOfTwoNumbers.sum(a,b));
    }
}
