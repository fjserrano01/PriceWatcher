import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
//Fernando Serrano Advanced Object Oriented Programming CS3331
public class Main {
	
	public void run() {
		try {
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
		}catch(InputMismatchException e) {
			System.out.println("Please insert Valid selection\n");
			run();
		}
	}
	
	public static void main(String[] args) {
		new Main().run();

	}

}