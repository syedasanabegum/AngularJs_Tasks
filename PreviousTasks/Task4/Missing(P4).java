/* Program4:
Find the missing number in a given integer array of 1 to 100
*/
import java.util.*;
public class Main {
public static void Missing(int arr[], int n){
    List<Integer> list=new ArrayList<Integer>();
    List<Integer> res=new ArrayList<Integer>();
    for (int i = 0; i < arr.length; i++)
    {
        list.add(new Integer(arr[i]));
    }
    Collections.sort(list);
    int last = list.get(list.size()-1);
    for(int i=1;i<100;i++){
        if(list.contains(i)==false){
            res.add(i);
        }
    }
    System.out.println(res);
}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n;
	System.out.println("Enter the size of the Array:");
	n=sc.nextInt();
    int[] arr = new int[n];
	System.out.println("Enter the elements of array");
	for(int i=0;i<n;i++) {
		arr[i]=sc.nextInt();
	}
	Missing(arr,n);
	
}
}
