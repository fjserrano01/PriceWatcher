//Fernando Serrano Advanced Object Oriented Programming CS3331
public class item {
	//Keeps track of all the item details
	float item_price;
	String item_name;
	String url_name;
	float price_diff;
	float newprice;
	
	item(){}
	item(float price, String name, String url, float pricedifference, float new_price){
		item_price = price;
		item_name = name;
		price_diff = pricedifference;
		newprice = new_price;
		url_name = url;
		
	}
	

}
