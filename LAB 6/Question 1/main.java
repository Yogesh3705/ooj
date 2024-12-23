import mypack.Balance;

class main{
	public static void main(String args[]){
		Balance current[]  = new Balance[3];
		current[0] = new Balance("A",200.00);
		current[1] = new Balance("B",21200.00);
		current[2] = new Balance("C",-200.00);
		
		for(int i=0;i<3;i++){
			current[i].display_details();
		}
	}
}
