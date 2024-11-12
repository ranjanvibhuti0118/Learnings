package Abstraction;


// a class with one or more abstract method has to declared as abstract
//A class for which obj can not be created and  provides a common functionality to sub classes
// A class can not be final abstract, as it contradicts
 public abstract class Bank {

	private String bankName;
	private Integer accountNo;
	private Double balance;
	static String  brnachCount;

	Bank(){
		System.out.println("Super method called from child class ATM");
	}

	// Abstract class constructor is called from child class constructor
	public Bank(String bankName, Integer accountNo, Double balance) {
		super();
		this.bankName = bankName;
		this.accountNo = accountNo;
		this.balance = balance;

	System.out.println("Paratemtrized constructor Super method called from child class ATM");

	}

	// An abstract class can have 0 or more abstract methods
	abstract Double showBalance(Integer acountNumber);


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public Integer getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}



}
