import java.util.*;

public class Lift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the current floor (1-10): ");
        int currentFloor = scanner.nextInt();

        System.out.print("Enter the number of persons in the lift: ");
        int numOfPersons = scanner.nextInt();

        int[] floors = new int[numOfPersons];

        for (int i = 0; i < numOfPersons; i++) {
            System.out.print("Enter the floor number for person " + (i+1) + " (1-10): ");
            floors[i] = scanner.nextInt();
        }
        
        int option;
        System.out.println("Choose 1.FCFS\t 2.NearestFloor:");
        option = scanner.nextInt();
        switch (option) 
        {
            
          // outside of lift FCFS
             case 1:
                for(int i=0;i<numOfPersons;i++){
                    if(floors[i]>0&& floors[i]<=10)
                        System.out.print(floors[i]+" ");
                } 
                break;
                
            case 2:
                Arrays.sort(floors);

                List<Integer> upFloors = new ArrayList<>();
                List<Integer> downFloors = new ArrayList<>();
        
                for (int i = 0; i < numOfPersons; i++) {
                    if (floors[i] > currentFloor && floors[i] <= 10) {
                        upFloors.add(floors[i]);
                    } else if (floors[i] < currentFloor && floors[i] >= 1) {
                        downFloors.add(floors[i]);
                    }
                    
                }

                Collections.reverse(downFloors);
                List<Integer> orderedFloors = new ArrayList<>(upFloors);
                orderedFloors.addAll(downFloors);
        
                System.out.println("The nearest floors in order are:");
                for (int floor : orderedFloors) {
                    if(floor>0&&floor<=10)
                        System.out.print(floor + " ");
                }
                break;
        }

        
    }
}
