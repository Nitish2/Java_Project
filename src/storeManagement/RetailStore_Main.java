package storeManagement;
/**
 * The retail store wants to automate the following processes:
    -Booking a product by customer
      -Bill generation for customer
        -Inventory status check 
 * Creating MENU driven for good user interface by using Switch case .
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RetailStore_Main { // Creating main class 

	public static void main(String[] args) throws IOException { // Main Method
		// TODO Auto-generated method stub

		// BufferedReader class is used to read the text from a character-based input stream.
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); // Creating Buffer reader object
																						

		// Creating RetailStore class object
		RetailStore retailStore = new RetailStore("Vijay Sales");

		// adding products into product list
		retailStore.addProduct("LG T101", "Available", 35600);
		retailStore.addProduct("LG T101", "Available", 35600);
		retailStore.addProduct("LG T101", "Available", 35600);
		retailStore.addProduct("LG T101", "Available", 35600);
		retailStore.addProduct("LG R601", "Available", 20000);
		retailStore.addProduct("LG R601", "Available", 20000);
		retailStore.addProduct("LG R601", "Available", 20000);
		retailStore.addProduct("Sony24", "Available", 40000);
		retailStore.addProduct("Sony24", "Available", 40000);
		retailStore.addProduct("Sony24", "Available", 40000);
		retailStore.addProduct("Sony24", "Available", 40000);
		retailStore.addProduct("Sony24", "Available", 40000);
		retailStore.addProduct("Sony24", "Available", 40000);

		//Initializing variables 
		String choice;
		String name = "";
		String status = "Available";
		
		int id = 0;
		long num;
		int noProducts = 1;
		int discount = 10;
		double amount;

		
		System.out.println("\t VIJAY SALES");
		do { // Do statement 
            
			// Creating menu 
			System.out.println("\nPress # for\n\t:New product" + "\n\nPress ^ for\n\t:Customer/Product List"
					+ "\n\nPress * for\n\t:New customer" + "\n\nPress @ for\n\t:Availability of product"
					+ "\n\nPress + for\n\t:Add to Kart" + "\n\nPress $ for\n\t:Total bill");
			choice = buffer.readLine(); //readLine() method is used to read data line by line.

			switch (choice) { // Creating switch case to execute one statement from multiple conditions.
			
			case "#": // Condition 1 to add new product in product the list 
				System.out.println("\t\t\tNew Product");
				System.out.println("Enter product name:");
				name = buffer.readLine();
				System.out.println("Enter the price of product:");
				double price = Double.parseDouble(buffer.readLine());
				retailStore.addProduct(name, status, price);
				break;

			case "^": // Condition 2 to display lists 
				System.out.println("\t\t\tCustomer/Product List");
				retailStore.display();
				break;

			case "*": // Condition 3 to add new customer in customer the list 
				System.out.println("\t\t\tNew Customer");
				System.out.println("Enter customer name:");
				name = buffer.readLine();
				System.out.println("Enter contact number:");
				num = Integer.parseInt(buffer.readLine());
				retailStore.addCustomer(name, num);
				break;

			case "@": // Condition 4 to check the availability of product
				System.out.println("\t\t\tAvailability of product");
				System.out.println("Enter product:");
				name = buffer.readLine();
				int number1 = retailStore.checkProductAvailability(name);
				System.out.println("Number of product:" + number1);
				break;

			case "+": // Condition 5 to book a product 
				System.out.println("\t\t\t Add to Kart");
				System.out.println("Enter the customer id:");
				id = Integer.parseInt(buffer.readLine());
				System.out.println("Enter Product:");
				name = buffer.readLine();
				System.out.println("Enter the number of products:");
				noProducts = Integer.parseInt(buffer.readLine());
				retailStore.bookProduct(id, name, noProducts);
				System.out.println("Item is added into Kart");
				break;

			case "$": // Condition 6 to calculate the bill 
				System.out.println("\t\t\tTotal bill");
				System.out.println("Enter the customer id:");
				id = Integer.parseInt(buffer.readLine());
				amount = retailStore.calculateAmount(id, discount);
				System.out.println("Discount: " + discount + ("%"));
				System.out.println("Total cost=" + amount * noProducts);
				System.out.println("-x-x- Vijay Sales -x-x-");
				break;

			default: // Default condition if the user selects an invalid option  
				System.out.println("Pressed invalid button");

			}

		} while (choice != "="); // While loop will execute till "=" condition .
	}
}