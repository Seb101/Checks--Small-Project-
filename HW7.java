import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class HW7 
{

    public  static ArrayList<Transaction> checksAndTransactions = new ArrayList<Transaction>();
    //code by Sebastian Rodriguez
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        
        //HW6.createNewCheck();//check 1

        /* 
        HW6.createNewCheck();//check 2
        HW6.createNewCheck();//check 3 
        HW6.createNewCheck();//check 4 
        HW6.createNewCheck();//check 5
        */

        
        boolean hasWork = true;

        while(hasWork == true)
        {
            System.out.println("\n" +"CHECK to create a check" + "\n" +"REGISTER for check register" + "\n" + "PRINT for a specific check number" + "\n" + "DEPOSIT for a deposit" +"\n"  + "SAVE to save checks" + "\n" + "LOAD to load checks" + "\n" +"STOP to stop: ");
            String input = scanner.nextLine().toUpperCase();

            if(input.equals("REGISTER"))
            {
                HW7.printRegister();
            }
            else if(input.equals("CHECK"))
            {
                Transaction currentCheck = createNewCheck();
            }

            else if(input.equals("PRINT"))
            {
                HW7.getCheckDetails();
            }

            else if(input.equals("STOP"))
            {
                hasWork = false;
                break;
            }

            else if(input.equals("DEPOSIT"))
            {
                Transaction currentDeposit =  createNewCheck();
                currentDeposit.SetIsCheck(false);
            }
            else if(input.equals("LOAD"))
            {
                try{
                    FileInputStream f = new FileInputStream(new File("objects.txt"));
                    ObjectInputStream o = new ObjectInputStream(f);
            
                    Object obj = null;
                    while ((obj = o.readObject()) != null) {
                        if (obj instanceof Transaction) {
                            checksAndTransactions.add((Transaction) obj);
                        }
                    }
            
                    System.out.println("Your Transactions and checks were loaded successfully!!");
                    Thread.sleep(2000); 
            
                    o.close();
                    f.close();
                }
                catch (EOFException e)
                {
                    System.out.println("you have reached the end of your file");
                }
                catch(FileNotFoundException e){
                    System.out.println("File not found, please try again.");
                }
                catch(Exception e){
                    System.out.println("There was an error, try again");
                    e.printStackTrace();

                }
                
            

            }
            
            else if(input.equals("SAVE"))
            {
                try{
                    FileOutputStream f = new FileOutputStream(new File("objects.txt")); //will create file if it doesnt exist
                    ObjectOutputStream o = new ObjectOutputStream(f);

                    for(Transaction currentObject: checksAndTransactions)
                    {
                        o.writeObject(currentObject);
                    }

                    f.close();
                    o.close();

                    System.out.println("Your Transactions and checks were saved succesfully!!");
                    Thread.sleep(2000); 


                }
                catch(Exception e)
                {
                    System.out.println("There was an error, try again");
                }

               
            }

            else
            {
                System.out.println("Invalid Input, try again"); // this will not stop the loop since there is no break statement 
                
            }
        }


        
        

    }

    public static Transaction createNewCheck()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, we will need some information to create a check for you dear customer");
        Transaction check = null;
        boolean checkCreated = false;
        while(checkCreated == false)
        {
            try{
                System.out.print("Enter the checkNumber: ");
                int checkNumber = sc.nextInt();
                System.out.print("Enter the amount of dollars you wish to pay: ");
                double amount = sc.nextDouble();
                String xx = sc.nextLine();
                System.out.print("Enter the name of the person you are giving the check: ");
                String payee = sc.nextLine();
                System.out.print("Enter provide us with the reason for this check: ");
                String reason = sc.nextLine();
                System.out.print("Please enter Todays date: ");
                String todayDate = sc.nextLine();

                check = new Transaction(checkNumber, todayDate, payee, amount, reason);

                System.out.println("Thanks a lot! your check was created");

                checksAndTransactions.add(check);

                checkCreated = true;
                
            }

            catch (InputMismatchException e){
                System.out.println("There was an invalid Input, Please try again: ");
                sc.nextLine();

                continue;

            }
            
        } 

        return check; 
             
    } 
    

    public static void getCheckDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please provide us with your check number: ");
        try{
            int checkNumber = sc.nextInt();
        
        
            boolean found = false;

            for(Transaction check: checksAndTransactions)
            {
                if(check.GetCheckNumber() == checkNumber)
                {
                    found = true;
                    System.out.println("");
                    System.out.println(check.toString());
                    break;
                }


            }

            if(found == false)
            {
                System.out.println("check not found");
            }
        }

        catch(InputMismatchException e)
        {
            System.out.println("there was an invalid input");
        }
    }


    public static void printRegister()
    {
        int tempVal = 0;
        for(Transaction check:checksAndTransactions)
        {
            System.out.println(check.GetCheckNumber());
            tempVal++;
        }

        if(tempVal == 0) System.out.println("there is no checks here");
    }
        

    public static void issueCheck(Transaction a){
        a.printCheck();
    }
    
}
