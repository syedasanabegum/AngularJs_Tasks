/*Program:
Given an integer n, break into  the sum of k positive integers, and return the maximum product of those integers.
Input:
	Integer n
	Desired Output:
	Maximum product of numbers whose sum is n.
*/
import java.util.*;
public class Main
{
static int max(int n)
{
	
	
	if (n == 2 || n == 3) 
	    return (n - 1);

	
	int result = 1;
	while (n > 4)
	{
	n -= 3;
	result *= 3; 
	}
	return (n * result); 
}


public static void main(String[] args) {
    int num;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Number:");
    num = sc.nextInt();
	System.out.println("Maximum Product is " + max(num));
}
}



