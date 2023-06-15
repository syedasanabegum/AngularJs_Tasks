/* Program1:
Write a function that merges two unsorted lists into a new sorted list*/
import java.util.*;
public class MergeSortedList{
    static int n,m;
    public static void Merge(int First[],int Second[]){
        List<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < First.length; i++){
            list.add(new Integer(First[i]));}
        for (int i = 0; i < Second.length; i++){
            list.add(new Integer(Second[i]));}
        System.out.print("Original unsorted list:"+list+"\n");
        Collections.sort(list);
        System.out.print("Sorted list:"+list);

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of first list:");
        n=sc.nextInt();
        int First[]=new int[n];
        System.out.println("Enter the elements of first list:");
        for(int i=0;i<n;i++){
            First[i]=sc.nextInt();
        }
        System.out.println("Enter the size of Second list:");
         m=sc.nextInt();
        int Second[]=new int[m];
        System.out.println("Enter the elements of Second list:");
        for(int i=0;i<m;i++){
            Second[i]=sc.nextInt();
        }
        Merge(First,Second);
    }
}