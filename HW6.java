import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class HW6 
{

    public  static ArrayList<CheckClass> listOfChecks = new ArrayList<CheckClass>();
    //code by Sebastian Rodriguez
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        
        HW6.createNewCheck();//check 1
        HW6.createNewCheck();//check 2
        HW6.createNewCheck();//check 3 
        HW6.createNewCheck();//check 4 
        HW6.createNewCheck();//check 5
         
        /* 
        CheckClass a = HW6.createNewCheck();
        HW6.issueCheck(a);
        */
        
        boolean hasWork = true;

        while(hasWork == true)
        {
            System.out.println("Enter R for check register or N for a specific check number or S to stop: ");
            String input = scanner.nextLine().toUpperCase();

            if(input.equals("R"))
            {
                HW6.printRegister();
            }

            else if(input.equals("N"))
            {
                HW6.getCheckDetails();
            }

            else if(input.equals("S"))
            {
                hasWork = false;
                break;
            }

            else
            {
                System.out.println("Invalid Input, try again"); // this will not stop the loop since there is no break statement 
                
            }
        }


        
        

    }

    public static CheckClass createNewCheck()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, we will need some information to create a check for you dear customer");
        CheckClass check = null;
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

                check = new CheckClass(checkNumber, todayDate, payee, amount, reason);

                System.out.println("Thanks a lot! your check was created");

                listOfChecks.add(check);

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

            for(CheckClass check: listOfChecks)
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
        for(CheckClass check:listOfChecks)
        {
            System.out.println(check.GetCheckNumber());
            tempVal++;
        }

        if(tempVal == 0) System.out.println("there is no checks here");
    }
        

    public static void issueCheck(CheckClass a){
        a.printCheck();
    }
    
}
