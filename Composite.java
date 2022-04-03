package practice.lld.machine.structural;

import java.util.ArrayList;
import java.util.List;

/**
 * wherever we need to add/composite individual leaf
 * Component : Account class, which contains common method
 * leaf : Saving Account  and Deposit Account
 * composite : CompositeAccount
 * @author Yash
 *
 */
abstract class Account{
	public abstract float getBalance();
}
class SavingAccount extends Account{
    
	private String Account_no;
	private float balance;
	
	public SavingAccount(String Account_no,float balance){
		super();
		this.Account_no = Account_no;
		this.balance = balance;
	}
	@Override
	public float getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}
	
}
class DepositAccount extends Account{
    
	private String Account_no;
	private float balance;
	
	public DepositAccount(String Account_no,float balance){
		super();
		this.Account_no = Account_no;
		this.balance = balance;
	}
	
	@Override
	public float getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}
	
}
// composite class
class CompositeAccount extends Account{
    
	private float totalBalance;
	private List<Account> AccountList = new ArrayList<>();
	@Override
	public float getBalance() {
		// TODO Auto-generated method stub
		totalBalance = 0;
		for(Account account : AccountList){
			totalBalance += account.getBalance();
		}
		return totalBalance;
	}
	
	public void addAccount(Account account){
		AccountList.add(account);
	}
	
	public void removeAccount(Account account){
		AccountList.remove(account);
	}
}
public class Composite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		CompositeAccount component = new CompositeAccount();
		// 2 deposit Account 
		component.addAccount(new DepositAccount("121",100));
		component.addAccount(new DepositAccount("151",250));
		
		// 1 saving Account
		component.addAccount(new SavingAccount("191",200));
		
		// total balance of all the accounts
		System.out.println("total balance: " + component.getBalance());
		
	}

}
