/*Program 5:
Move all zeros in a number to the end using a linked list(Ex: 1034035 ---> 1343500)*/
import java.io.*;
import java.util.*;
public class LinkedList {
	Node head;
	static int count=0,n,key;
	static class Node {
		int data;
		Node next;
		// Constructor
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
    // Method to delete a node in the LinkedList by KEY=0
    public static LinkedList deleteByKey(LinkedList list, int key)
    {
        // Store head node
        Node currNode = list.head, prev = null;
  
        // CASE 1:
        // If head node itself holds the key to be deleted
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Changed head
            count=count+1;
            return list;
        }

        // CASE 2:
        // If the key is somewhere other than at head
        // Search for the key to be deleted,
        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }
        // If the key was present, it should be at currNode
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;
            count=count+1;
            
        }
        return list;
    }
	// Method to insert a new node and 0 at end
	public static LinkedList insert(LinkedList list, int data)
	{
		// Create a new node with given data
		Node new_node = new Node(data);
		
	
		// If the Linked List is empty,insert data at head node
		if (list.head == null) {
			list.head = new_node;
		}
		else {
			// Else traverse till the last node and insert at last
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			// Insert the new_node at last node
			last.next = new_node;
		}
		return list;
	}
	
	// Method to print the LinkedList.
	public static void printList(LinkedList list)
	{
		Node currNode = list.head;
	
		System.out.print("LinkedList: ");
	
		// Traversing
		while (currNode != null) {
			System.out.print(currNode.data);
			currNode = currNode.next;
		}
	}
	
	public static void main(String[] args)
	{
		/* Start with the empty list. */
		LinkedList list = new LinkedList();
	    Scanner sc= new Scanner(System.in);
		System.out.println("Enter the size of the list:");
		n=sc.nextInt();
		System.out.println("Enter the elements of the list:");
		while(n!=0){
		    key = sc.nextInt();
		    list = insert(list,key);
		    n--;
		}
		printList(list);
		System.out.println("\n");
		for(int i=0;i<8;i++){
		deleteByKey(list,0);}
		for(int i=0;i<count;i++){
		    insert(list,0);
		}
	
		System.out.println("****Result****");
		printList(list);
	}
}
