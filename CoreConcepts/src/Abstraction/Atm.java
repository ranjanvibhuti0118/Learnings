package Abstraction;

public class Atm extends Bank{

	//Every constructor has super method call in first line
	Atm(){
		super();

	}

	
	
	//Every constructor has super method call in first line
	//Super() can not be followed by a this or this() can not be followed up by super() call
	public Atm(String bankName, Integer accountNo, Double balance) {
		
		
		//super(bankName, accountNo, balance);
		this();
		System.out.println("This");
	}

	@Override
	Double showBalance(Integer acountNumber) {
		// TODO Auto-generated method stub
		return null;
	}


}
