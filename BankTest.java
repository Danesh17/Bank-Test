import java.io.*;
import java.util.*;
class Account /// creating Accountclass
{
    double balance,intrest; 

    Account()
    {
        balance=0;
        intrest=0;
    }

    double getBalance()
    {
        
            return this.balance;
    }

    void deposit(double ammount)
    {
        
        if(ammount>0)
        {
            this.balance+=ammount;
            System.out.print("\n amont deposited\n");
        }
        else
            System.out.print("\n you have enter invalid deposit number\n");
    }

    boolean withdraw(double withdrawAmmount)
    {
        
        if(withdrawAmmount>0)
        {
            if(this.balance>withdrawAmmount)
            {

            this.balance-=withdrawAmmount;
            System.out.print("\n your Withdraw is Successfully....!\n");
            return true;
            }
            else
            {
          
            System.out.print("\n  balance is not enough \n");
            return false;

            }
          
        }
        else
        {
            System.out.print("\n you have enter invalid withdraw number\n ");
            return false;
        }
    }


}


public class BankTest
{
    static int customer_Count;

    static void addIntrest(Account obj[])
    {
       

        for(int i=0;i<30;i++)
        {
            double intrestBalance=(obj[i].balance)*3/100.0; /// adding 3 percent interest on the amount
            obj[i].balance+=intrestBalance;
        }
            System.out.println("\n interest added 3%");

    }
public static void main(String[] args)
    {

        Account obj[] =new Account[30];
        for(int i=0;i<30;i++)                    // limiting the bank to 30 users 
            {


                obj[i]=new Account();
            }
      
        Scanner sc=new Scanner(System.in);
        int ch;
        double balance,ammount;
        while(true)
            {
                      
                System.out.println("\n1:Deposite\n2:Withdraw\n3:Check balance\n4:Select Customer\n5:Add 3% intrest\n6:Exit\nWhat you Want=");
                ch=sc.nextInt();
                if(customer_Count==0&&ch!=4)
                    System.out.println("\nplease Select the number of Customer First from number 1 to 30");
                else
                {
                    switch(ch) /// using switch case to get user request and provide output accordingly
                        {
                            case 1:
                                    
                                    
                                    
                                    System.out.println("\nEnter Deposite=");
                                    ammount=sc.nextDouble();
                                    obj[customer_Count].deposit(ammount);   /// will deposite the amount
                                    break;
                            case 2:
                      
                                    
                                    
                                    System.out.println("\nEnter  Withdraw=");
                                    ammount=sc.nextDouble();
                                  
                                    System.out.println("\nWithdraw Ammount Result="+obj[customer_Count].withdraw(ammount));
                                    break;
                            case 3:
                                        
                                    System.out.println("\nCurrent Balance="+obj[customer_Count].getBalance());
                                    break;
                            case 6:
                                    
                                    System.exit(0);
                                    break;
                            case 4:
                                    

                                    System.out.print("\nSelect Customer Number between 1 to 30 for make Transaction=");
                                    int cust=Integer.parseInt(sc.next());
                                    if(cust>0&&cust<=30)
                                        customer_Count=cust;
                                    else
                                        {
                                            System.out.println("\nInvalid Customer Select...!");
                                            customer_Count=0;
                                        }
                                    break;
                            case 5:
                                    
                                    addIntrest(obj);
                                    break;
                            default:
                                    System.out.println("\n Choice is not valid ");
                                    break;
                        }

                }
              

                      
            }

    }

      
}