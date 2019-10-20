import java.util.Scanner;
import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
//Fernando Serrano Advanced Object Oriented Programming CS3331
public class Consoleui {
	private item item;

	public Consoleui(item item) {
		this.item = item;
		
	}

	public void welcomemessage() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Price Watcher\n");
	}
	//Keeps track of the url of the item and displays the browser when called
	public void url() {
		item.url_name = "https://www.bestbuy.com/site/dell/dell-laptops/pcmcat140500050011.c?id=pcmcat140500050011";
		if(Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.browse(new URI(item.url_name));
				
			}catch(IOException|URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void showitem() {
		String nameofitem= item.item_name;
		nameofitem = "Dell laptop";
		//For future program which takes url of item to take information
		//String url;
		item.item_name = nameofitem;
		System.out.println("Name: " + nameofitem);
		//System.out.println(url);
		
		if (item.item_price == 0) {
			showitemprice();
			url();
			System.out.println("url: " + (String)item.url_name);
			System.out.println("Change in price: 0.00%");
		}else {
			System.out.println("Price: " + item.item_price);
			System.out.println("url: "+item.url_name);
			System.out.println("Change in price: " + item.price_diff + "%");
			item.item_price = item.newprice;
			System.out.println("New price is: " + item.item_price);
		}
	}
	public void showitemprice() {
		PriceFinder price_of_item = new PriceFinder();
		item.item_price = price_of_item.findprice();
		System.out.println("Price of item: " + item.item_price);
	}
	/*Gets a new random price and calculates the difference between current
	 *and new price.
	*/
	public void pricechange() {
		PriceFinder price_of_item = new PriceFinder();
		float new_price = price_of_item.findprice();
		
		float price_diff = item.item_price - new_price;
		price_diff = (price_diff/item.item_price) *100;
		item.price_diff = price_diff;
		item.newprice = new_price;
	}
	//Menu that displays selection for user
	public int promptuser() {
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter 1 to check price Enter 2 to view page ");
		System.out.println("Enter -1 to quit");
		System.out.println("*If option does not appear press enter again*");
		int response = reader.nextInt();
		return response;
		
	}

}
