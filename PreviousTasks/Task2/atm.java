/*Task2
Problem Statement: ATM
Consider an ATM with which we withdraw our cash. Now inside the atm, bank guys keep the notes like 2000*5,500*10,200*20,100*50. Write a program using recursion which takes the amount input from the user and gives the output in the format.
Example: User enters the amount as 300, Output will be “Amount Debited: 200 – 1, 100 -1 “
And also it should give no of notes in the atm ex: “After transaction 2000 notes – 100, 500 notes – 50 , 200 notes – 4 , 100 notes – 2 “.

Input 1: Enter Denomination of notes , Ex1: No. of 2000 notes = 100,Ex2: No. of 500 notes =50 etc.. , same for all other denominations 
Input 2: Amount a user wants to debit
Output:   Denomination and No. of notes received by user after transaction,*/

import java.io.*;
import java.util.*;
import java.lang.*;
public class Main {
    static int amt,total=0,c,n=0,half,rem,one;
    static int notes[] ={2000, 500, 200, 100};
    static int number[]=new int[4];
    public static int total(int n){
        total=0;
        for(int i=n+1;i<4;i++){
           
            total=total+(notes[i]*number[i]);
        }
        return total;
    }
    public static void decide(int amt){
        if(amt>=2000){n=0; denomination(amt,n);}
        else if(amt>=500){n=1; denomination(amt,n);}
        else if(amt>=200){n=2; denomination(amt,n);}
        else if(amt>=100){n=3; denomination(amt,n);}
        else if(amt==0){display();}
       


    }
    public static void display(){
        System.out.println("----- cash left-----");
        for(int k=0;k<notes.length;k++){
            System.out.println(notes[k]+" notes left = "+number[k]);
        }
    }
    public static void denomination(int amt, int n){
        int t = amt;
        if((amt>=2000)&&(n==0)){
            c = t / 2000;
            if(c==number[0]&&number[0]>1){
              half=c/2;
              rem=c%2;
              total=total(0);
                if(total!=0){
                    if(((half*2000)+(rem*2000))<=total){
                        System.out.println("number of 2000 notes we get="+ c/2);
                        number[0]=number[0]-(c/2);
                        amt=amt-(2000*(c/2));
                        denomination(amt,1);
                    }
                    else{           
                    one=number[n]-1;
                    System.out.println("number of 2000 notes we get = "+one);
                    number[0]=1;
                    amt=amt-(2000*(one));
                    denomination(amt,1);
                    }//yaha se likho
                }
                else{
                    System.out.println("number of 2000 notes we get = "+ c);
                    number[0]=0;
                    amt=amt-(notes[0]*number[0]);
                    denomination(amt,1);
                }
            }
            else if((c != 0)&&(c<=number[0])){
                System.out.println("number of "+2000+ " notes we get =" + c);
                number[n]=number[n]-c;  
                t=t%2000; n=1; 
                amt=t;
                decide(amt);
                       
            }
            else if((number[0]!=0)&&(c>number[0])){
                half=number[0]/2;
                total=total(0);
                    if((half*2000)<=total){
                        one = half+1;
                        System.out.println("number of 2000 notes we get = "+one);
                        amt=amt-(2000*one);
                        number[n]=number[n]-one;
                        denomination(amt,1);
                    }
                    else{
                        System.out.println("number of "+2000+" notes we get = "+number[n]);
                        amt=amt-(2000*number[n]);
                        number[n]=0;
                        denomination(amt,1);
                    }
            }
                
            
           
        }
        else if((amt>=500)&&(n==1)){
            c=t/500;
            if(c==number[1]&&number[1]>1){
              half=c/2;
              rem=c%2;
              total=total(1);
                if(total!=0){
                    if(((half*500)+(rem*500))<=total){
                        System.out.println("number of 500 notes we get="+ c/2);
                        number[1]=number[1]-(c/2);
                        amt=amt-(500*(c/2));
                        denomination(amt,2);
                    }
                    else{           
            	       one=number[n]-1;
                       System.out.println("number of 500 notes we get = "+one);
                       number[1]=1;
                       amt=amt-(500*(one));
                       
                       denomination(amt,2);
                    }//yaha se likho
                }
                else{
                    System.out.println("number of 500 notes we get = "+ c);
                    number[1]=0;
                    amt=amt-(notes[1]*number[1]);
                    denomination(amt,2);
                }
            }
            else if ((c != 0)&&(c<=number[n])){
               System.out.println("number of "+500+ " notes we get =" + c);
                number[n]=number[n]-c; 
                t=t%500; n=2;  
                amt=t;
                decide(amt);
                          
            }
            else if((number[1]!=0)&&(c>number[n])){
            	    total=total(1);
            	    half=number[1]/2;
            	    if(total>=(half*500)){
                        one=half+1;
                        System.out.println("number of 500 notes we get = "+one);
                        amt=amt-(500*one);
                        number[n]=number[n]-one;
                        denomination(amt,2);
            	    }
                    else{
                        System.out.println("number of "+500+" notes we get = "+number[n]);
                        amt=amt-(500*number[n]);
                        number[n]=0;
                        denomination(amt,2);
                    }
            }
            
            
            
        }
        else if((amt>=200)&&(n==2)){
            c=t/200;
            if(c==number[2]&&number[2]>1){
              half=c/2;
              rem=c%2;
              total=total(2);
                if(total!=0){
                    if(((half*200)+(rem*200))<=total){
                        System.out.println("number of 200 notes we get="+ c/2);
                        number[2]=number[2]-(c/2);
                        amt=amt-(200*(c/2));
                        denomination(amt,3);
                    }
                    else{           
                        one=number[n]-1;
                        System.out.println("number of 200 notes we get = "+one);
                        number[2]=1;
                        amt=amt-(200*(one));
                        System.out.println("amt:"+amt);
                        denomination(amt,3);
                    }//yaha se likho
                }
                else{
                    System.out.println("number of 200 notes we get = "+ c);
                    number[2]=0;
                    amt=amt-(notes[2]*number[2]);
                    denomination(amt,3);
                }
              
            }
            else if ((c != 0)&&(c<=number[n])){
                System.out.println("number of "+200+ " notes we get =" + c);
                number[n]=number[n]-c;
                t=t%200;n=3; 
                amt=t;
                decide(amt);
                    
            }
            else if((c>number[n])&&(number[2]!=0)){
                half=number[2]/2;
                rem=number[2]%2;
                total=total(2);
                    if(((half*200)+(rem*200))<=total){
                        System.out.println("half:"+half);
                        one = half +1;
                        System.out.println("number of 200 notes we get = "+one);
                        amt=amt-(200*one);
                        System.out.println("amt:"+amt);
                        number[n]=number[n]-one;
                        denomination(amt,3);
                    }
                    else{
                        System.out.println("number of "+200+" notes we get = "+number[n]);
                        amt=amt-(200*number[n]);
                        number[n]=0;
                        denomination(amt,3);
                    }
            }
            
            
            
        }
        else if((amt>=100)&&(n==3)){
            c=t/100;
            if ((c != 0)&&(c<=number[n])){
                System.out.println("number of "+100+ " notes we get =" + c); 
                number[n]=number[n]-c;
                t=t%100; 
                amt=t;
                System.out.println("amt at last:"+amt);
                display();
                
                              
            }
            else if((c>number[n])&&(number[0]!=0)){
                System.out.println("number of "+100+" notes we get = "+number[n]);
                amt=amt-(100*number[n]);
                number[n]=0;
                amt=t;
                System.out.println("amt at last:"+amt);
                display();
                
            }
            else{System.exit(0);}
            
            
        }
        else{
            System.out.println("------cash left-------");
            display();
            System.exit(0);
        }
        
    }
    public static void main(String arg[]){
        Scanner in= new Scanner(System.in);
        for(int i=0;i<notes.length;i++){
            System.out.println("Enter number of "+notes[i]+" notes:");
            number[i]=in.nextInt();
        }
        System.out.print("Enter the amount: ");
        amt = in.nextInt();
        if(amt>=2000&&number[0]!=0){n=0;}
        else if(amt>=500&&number[1]!=0){n=1;}
        else if(amt>=200&&number[2]!=0){n=2;}
        else{n=3;}
        for(int i=0;i<notes.length;i++){
            total=total+(notes[i]*number[i]);
        }
        if (amt > total) {
            System.out.println("ATM Cash Exceeded");
            return;
        }
        System.out.print("[");
        for(int i=0;i<notes.length;i++){
            System.out.print(number[i]+" ");
        }
        System.out.print("]"+"\n");
        denomination(amt,n);
        
    }
}
