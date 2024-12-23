package mypack;

public class Balance{
	String name;
	double balance;
	public Balance(String s,double d){
		name = s;
		balance = d;
	}

	public void display_details(){
		if(balance<0){
			System.out.println("NO balance");
		}
		else{
			System.out.println("NAME = "+name);
			System.out.println("BALNCE = "+balance);
		}
	}
}

