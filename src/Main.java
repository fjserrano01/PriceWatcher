import java.util.Scanner;
public class Main {
	
	public void run() {
		int response;
		item Item = new item();
		Consoleui ui = new Consoleui(Item);
		ui.welcomemessage();
		/*
		 * repeat until user wants to quit
		 * 		print the item
		 * 		prompt the user
		 * 		process
		 */
		do {
			ui.showitem();
			response = ui.promptuser();
			switch(response) {
			case 1:
				ui.pricechange();
				break;
			case 2:
				break;
			}
		}while(response != -1);
	}
	
	public static void main(String[] args) {
		new Main().run();

	}

}