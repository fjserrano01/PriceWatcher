import java.util.Scanner;

public class Consoleui {
	private item item;

	public Consoleui(item item) {
		this.item = item;
		
	}

	public void welcomemessage() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Price Watcher\n");
	}

	public void showitem() {
		String nameofitem= item.item_name;
		nameofitem = "Dell laptop";
		//For future program which takes url of item to take information
		//String url;
		System.out.println("Name: " + nameofitem);
		//System.out.println(url);
		
		if (item.item_price == 0) {
			showitemprice();
			System.out.println("Change in price: 0.00%");
		}else {
			System.out.println("Price: " + item.item_price);
		}
	}
	public void showitemprice() {
		PriceFinder price_of_item = new PriceFinder();
		item.item_price = price_of_item.findprice();
		System.out.println("Price of item: " + item.item_price);
	}
	
	public void pricechange() {
		PriceFinder price_of_item = new PriceFinder();
		float new_price = price_of_item.findprice();
		
		float price_diff = item.item_price - new_price;
		price_diff = (price_diff/item.item_price) *100;
		item.item_price = new_price;
		
		System.out.println("Change in price: " + price_diff + "%");
		System.out.println("New price is: " + item.item_price +"\n");
	}

	public int promptuser() {
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter 1 to check price Enter 2 to view page ");
		System.out.print("Enter -1 to quit\n");
		int response = reader.nextInt();
		return response;
		// TODO Auto-generated method stub
		
	}

}
