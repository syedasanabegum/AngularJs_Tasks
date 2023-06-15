/*Task5
Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
design an algorithm to find the maximum profit.
Note that you cannot sell a stock before you buy one.
Example 1:
	Input: [7,1,5,3,6,4]
	Output: 5
	Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
	Not 7-1 = 6, as selling price needs to be larger than buying price.
*/
import java.util.*;
public class Main {
	static int min,max,profit=0,temp;
	static int price(int[] a, int n) {
		List<Integer> list1=new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++){
            list1.add(new Integer(a[i]));}
        for(int i=0;i<n;i++){
            min = list1.get(i);
            max=0;
            for(int j=i+1;j<n;j++){
               if(list1.get(j)>max){
                   max=list1.get(j);
               }
            }
            temp = max - min;
            if(temp>profit){
                profit = temp;

            }
        }
        return profit;
        
	}
	public static void main(String[] args) {
	Scanner sc=new Scanner (System.in);
	int n;
	System.out.println("Enter the size of the Array:");
	n=sc.nextInt();
    int[] a = new int[n];
	System.out.println("Enter the elements of array");
	for(int i=0;i<n;i++) {
		a[i]=sc.nextInt();
	}
	 System.out.println("profit: "+price(a,n));
	 
	
	}
}
