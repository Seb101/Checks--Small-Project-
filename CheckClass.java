public class CheckClass
{
  //code by Sebastian Rodriguez
  private int checkNumber; // completed
  private double amount; // completed
  private String payee; //completed
  private String reason; //completed
  private String todayDate; //completed
  final String name = "Sebastian Rodriguez";

  public CheckClass(int checkNumber) //constructor 1 
  {
    this.checkNumber = checkNumber;
  }

  public CheckClass(int checkNumber, String todayDate, String payee, double amount, String reason) //constructor 2 
  {
    this.checkNumber = checkNumber;
    this.todayDate = todayDate;
    this.payee = payee;
    this.amount = amount;
    this.reason = reason; 
  }


  //the following will be the setters and getters 

  public void SetCheckNumber(int checkNumber)
  {
    this.checkNumber = checkNumber;
  }

  public int GetCheckNumber()
  {
    return checkNumber;
  }

  public void SetAmount(double amount)
  {
    this.amount = amount;
  }

  public double GetAmount()
  {
    return amount;
  }

  public void SetPayee(String payee)
  {
    this.payee = payee;
  }

  public String GetPayee()
  {
    return payee;
  }

  public void SetReason(String reason)
  {
    this.reason = reason;
  }

  public String GetReason()
  {
    return reason;
  }

  public void setDate(String todayDate)
  {
    this.todayDate = todayDate;
  }

  public String getDate(){

    return todayDate;
  }

  //end of setters and getters

  public String toString()
  {
    return "CheckNumber: " + checkNumber + "\n" + "Amount: " + amount + "\n" + "Payee: " + payee + "\n" + "Reason: " + reason + "\n" + "today's Date: " + todayDate + "\n";

  }

  public void printCheck()
  {
    System.out.println(name + "               " + checkNumber);
    System.out.println("                             " + todayDate);
    System.out.println("Pay to the order of: " + payee + "       " + "$" + amount + "\n" +  "For: " + reason);

  }
  







}