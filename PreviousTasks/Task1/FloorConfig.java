/*Task 1
Problem Statement: Elevator Configuration
Every Elevator runs based on certain rules predefined. So, Here we will be doing the same.
There is an 10 Stories Building.
Elevator should be configured based on 2 use cases
1. First come First Server.
2. Nearest Floor Serve First*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class FloorConfig{
    static int size, elevator_floor;
	 //size -> No. of persons in the lift, elevator_floor -> starting floor number at which lift is waiting
    static int myArray[];//floor numbers selection
    static  ArrayList<Integer> array_list =	new ArrayList<Integer>();
    static void closest(int elevator_floor){
        int[] numbers = new int[array_list.size()];
        for (int i = 0; i < array_list.size(); i++)
        {
            numbers[i] = array_list.get(i);
        }
        int myNumber = elevator_floor;
        int distance = Math.abs(numbers[0] - myNumber);
        int idx = 0;
        for(int c = 1; c < numbers.length; c++)
        {
            int cdistance = Math.abs(numbers[c] - myNumber);
            if((cdistance < distance)&&(cdistance!=0))
            {
                    idx = c;
                    distance = cdistance;
            }
        }   
        int theNumber = numbers[idx];
        System.out.print( "->" +" "+ theNumber);
        elevator_floor = theNumber;
        //System.out.print("now elevator_floor:"+ theNumber);
        array_list.remove(array_list.get(idx));
        if(array_list.size()!=0)
	{
        closest(elevator_floor);
	}
    }
    
    public static void main(String[] args)
    {
        int option;
        FloorConfig ob = new FloorConfig();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the floor at which lift is present:");
        elevator_floor = sc.nextInt();
        System.out.println("Enter the number of person :: ");
        size = sc.nextInt();
        //System.out.println("size is :"+ size);
        myArray = new int[size];
        System.out.println("Enter floor numbers of the persons:: ");
        for(int i=0; i<size; i++) 
        {
            myArray[i] = sc.nextInt();
        }
        // ask users to enter operator
        System.out.println("Choose 1.FCFS\t 2.NearestFloor:");
        option = sc.nextInt();
        switch (option) 
        {
          // outside of lift FCFS
             case 1:
                System.out.println("order of lift is:");
                System.out.print(elevator_floor+ " ");
                for(int j=0; j<size ; j++)
                {
                    System.out.printf("->"+" "+myArray[j]+" ");
                }
                break;
    
                // Inside of lift Nearest floor
            case 2:
    		    for (int i = 0; i < myArray.length; i++)
    		    {
    			    array_list.add(new Integer(myArray[i]));
    		    }
    			//System.out.print("list:"+array_list);
    			
    			    System.out.print(elevator_floor);
                    ob.closest(elevator_floor);
                break;
            default:
                System.out.println("Invalid operator!");
                break;
        }

    }
}