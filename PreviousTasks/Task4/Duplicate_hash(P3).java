/* Program3:
Write a function to remove duplicates from an array
*/
import java.util.*;
public class Duplicate{
    public static void duplicate(int arr[]){
        HashMap<Integer, Boolean> hash = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            if (hash.get(arr[i]) == null)
            {
                System.out.print(arr[i] + " ");
                hash.put(arr[i], true);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array:");
        int n = sc.nextInt();
        int[] arr=new int[n];
        System.out.println("enter the elements of array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
	System.out.println("Result after removing duplicates:");
        duplicate(arr);
    }
}