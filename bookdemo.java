import java.util.Scanner;

class book{
	String name;
	String auther;
	double price;
	int num_pages;
	
	void book(String name,String auther,double price,int num_pages){
		this.name = name;
		this.auther = auther;
		this.price = price;
		this.num_pages = num_pages;
	}
	
	void setname(String name){
		this.name = name;
	}
	void setauther(String auther){
		this.auther = auther;
	}
	void setprice(double price){
		this.price = price;
	}
	void setnum_pages(int num_pages){
		this.num_pages = num_pages;
	}
	
	void toDisplay(){
		System.out.println("the name of the book "+name);
		System.out.println("the auther of the book "+auther);
		System.out.println("the price of the book "+price);
		System.out.println("the number of pages in the book "+num_pages);	
	}
	
	public String toString(){
		return "name : "+name+"\nAuther : "+auther+"\nprice : "+price+"\nnumber of pages : "+num_pages;
	}
}


class bookdemo{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of books");
		int n = sc.nextInt();

		book[] b = new book[n];
		for(int i=0;i<n;i++){
			b[i] = new book();
			String k = sc.nextLine();
			System.out.println("Enter the name of the book ");
			String name = sc.nextLine();
			System.out.println("Enter the name of the auther of the book ");
			String auther = sc.nextLine();
			System.out.println("Enter the price of the book ");
			double price = sc.nextDouble();
			System.out.println("Enter the number of pages of the book ");
			int num_pages = sc.nextInt();
			b[i].book(name,auther,price,num_pages);
			System.out.println(b[i]+"\n");
		}

	}
}