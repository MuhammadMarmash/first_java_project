import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount{
	double bal;
	ArrayList<Double> prevTrans = new ArrayList<>();
	String customerName;
	String customerId;

	BankAccount(String customerName,String customerId){
		this.customerName=customerName;
		this.customerId=customerId;
	}


	void deposit(double amount){
		if(amount!=0){
			bal+=amount;
			prevTrans.add(amount);
		}
	}

	void withdraw(double amt){
		if(amt!=0 && bal>=amt){
			bal-=amt;
			prevTrans.add(-amt);
		}
		else if(bal<amt){
			System.out.println("Bank balance insufficient");
		}
	}

	String printPreviousTrans(double tran) {
		if(tran>0){
			return "Deposited: "+tran;
		}
		return "Withdrawn: "+Math.abs(tran);
	}
	void getPreviousTrans(boolean all){
		if (prevTrans.size()>0) {
			if (all) {
				for (double tran:prevTrans) {
					System.out.println(printPreviousTrans(tran));
				}
			}else {
				double lastTrans = prevTrans.get(prevTrans.size() - 1);
				System.out.println(printPreviousTrans(lastTrans));
			}
		}else {
			System.out.println("No transaction occured");
		}
	}

	void menu(){
		char option;
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome "+customerName);
		System.out.println("Your ID:"+customerId);
		System.out.println("\n");
		System.out.println("a) Check Balance");
		System.out.println("b) Deposit Amount");
		System.out.println("c) Withdraw Amount");
		System.out.println("d) Previous Transaction");
		System.out.println("f) all Previous Transactions");
		System.out.println("e) Exit");

		do{
			System.out.println("********************************************");
			System.out.println("Choose an option");
			option=sc.next().charAt(0);
			System.out.println("\n");

			switch (option){
			case 'a':
				System.out.println("......................");
				System.out.println("Balance ="+bal);
				System.out.println("......................");
				System.out.println("\n");
				break;
			case 'b':
				System.out.println("......................");
				System.out.println("Enter a amount to deposit :");
				System.out.println("......................");
				double amt=sc.nextDouble();
				deposit(amt);
				System.out.println("\n");
				break;
			case 'c':
				System.out.println("......................");
				System.out.println("Enter a amount to Withdraw :");
				System.out.println("......................");
				double amtW=sc.nextDouble();
				withdraw(amtW);
				System.out.println("\n");
				break;
			case 'd':
				System.out.println("......................");
				System.out.println("Previous Transaction:");
				getPreviousTrans(false);
				System.out.println("......................");
				System.out.println("\n");
				break;
			case 'f':
				System.out.println("......................");
				System.out.println("all Previous Transactions:");
				getPreviousTrans(true);
				System.out.println("......................");
				System.out.println("\n");
			case 'e':
				System.out.println("......................");
				break;
			default:
				System.out.println("Choose a correct option to proceed");
				break;
			}

		}while(option!='e');

		System.out.println("Thank you for using our banking services");
	}

}