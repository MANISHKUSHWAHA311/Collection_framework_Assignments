package Collection_Framwork_Assignment;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

class SavingAccount{
	private double acc_balance;
	private int acc_ID;
	private String accountHolderName;
	private boolean isSalaryAccount;
	public SavingAccount(double acc_balance, int acc_ID, String accountHolderName, boolean isSalaryAccount) {
		super();
		this.acc_balance = acc_balance;
		this.acc_ID = acc_ID;
		this.accountHolderName = accountHolderName;
		this.isSalaryAccount = isSalaryAccount;
	}
	public double getAcc_balance() {
		return acc_balance;
	}
	public void setAcc_balance(double acc_balance) {
		this.acc_balance = acc_balance;
	}
	public int getAcc_ID() {
		return acc_ID;
	}
	public void setAcc_ID(int acc_ID) {
		this.acc_ID = acc_ID;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public boolean isSalaryAccount() {
		return isSalaryAccount;
	}
	public void setSalaryAccount(boolean isSalaryAccount) {
		this.isSalaryAccount = isSalaryAccount;
	}
	
	public void withDraw(double amount) {
		if(amount>acc_balance) {
			System.out.println("Insufficient amount in your account");
		}
		else {
			acc_balance-=amount;
			System.out.println(amount + " has been withdraw from your account "+acc_ID +"\n"+"Current balance in your account "+ acc_balance);
		}
	}
	public void deposit(double amount) {
		acc_balance +=amount;
		System.out.println(amount+" has been deposited into your account "+ acc_ID +"\n"+"Current balance in your account "+ acc_balance);
	}
	public boolean add(SavingAccount savingAccounts) {
		// TODO Auto-generated method stub
		return true;
	}

}

class BankAccountListComparators implements Comparator<SavingAccount>{
	
	@Override
	public int compare(SavingAccount object1,SavingAccount object2) {
		return (int) (object1.getAcc_ID()-object2.getAcc_balance());
	}
	
}

class BankAccountList{
	
	private TreeSet<SavingAccount>savingAccounts=new TreeSet<>(new BankAccountListComparators());
	
	public void BankAccountListComparator(TreeSet<SavingAccount>savingAccounts) {
		this.savingAccounts=savingAccounts;
	}
	
	public boolean addSavingAccount(SavingAccount savingAccounts) {
		return savingAccounts.add(savingAccounts);
	}
	public List<Integer>displaySavingAccountID(){
		for(SavingAccount sav :savingAccounts ) {
			System.out.println(sav.getAcc_ID());
		}
		return null;
	}

	
}

public class Assignment3Q9{
	public static void main(String [] args) {
		
		SavingAccount Sa1=new SavingAccount(5000, 101, "chris", true);
		SavingAccount Sa2=new SavingAccount(6000, 102, "Aryan", true);
		SavingAccount Sa3=new SavingAccount(7000, 103, "Sahil", true);
		
		BankAccountList bankList=new BankAccountList();
		
		if(bankList.addSavingAccount(Sa1)) {
			System.out.println("Added your saving account with account_ID = "+Sa1.getAcc_ID());
		}
		else {
			System.out.println("Saving Account are already present in bank");
		}
		
		if(bankList.addSavingAccount(Sa2)) {
			System.out.println("Added your saving account with account_ID = "+Sa2.getAcc_ID());
		}
		else {
			System.out.println("Saving Account are already present in bank");
		}
		
		if(bankList.addSavingAccount(Sa3)) {
			System.out.println("Added your saving account with account_ID = "+Sa3.getAcc_ID()+"\n");
		}
		else {
			System.out.println("Saving Account are already present in bank");
		}
		
		bankList.displaySavingAccountID();
		
		Sa1.deposit(2000);
		
		bankList.displaySavingAccountID();
		
		Sa1.withDraw(1000);
		
		bankList.displaySavingAccountID();
	}
}

