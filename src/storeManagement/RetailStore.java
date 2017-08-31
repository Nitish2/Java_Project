package storeManagement;

/**
 * Creating RetailStore class.
 * RetailStrore class knows about the storeName,customers registered with the store and product details available in the store.
 * Creating RetailStore(String storeName) constructor .This constructor initialize the storeName with the given input value.
 * Creating following methods
    -generateCustomerID():This method generates the customerID.
    -generateProductID():This method generates the productID.
    -addCustomer():This method creates a customer ID , with that it creates a customer object and then it adds to the customerList.
    -addProduct():This method creates a product ID , with that it creates a product object and then it adds to the productList.
    -checkProductAvailability(): This method returns the count of products.
    -bookProduct():This method checks for the availability of the given product in the productList of retail store.
    -calculateNetAmount():This method takes a customer ID and discount percentage as input parameters and calculates and returns the net amount.
 * 
 */

import java.util.ArrayList;

public class RetailStore {

	String storeName; // Declaring variable
	/*
	 * Creating two ArrayList 
	     -custList for Customer list and 
	     -prodList for product list.
	 */
	ArrayList<Customer> custList = new ArrayList<Customer>(); // Creating Customer list object
	ArrayList<Product> prodList = new ArrayList<Product>();  // Creating Product list object 

	public int generateCustomerID() { // Creating method
		// Initializing variables 
		int count = 0;
		int custId = 0;
		// It will initialize customer ID to 1 if the size of the customer list is equals to 0. 
		if (custList.size() == 0) // If statement 
			custId = 1;
		else {
			// It will increment the customer ID by 1 when the size of customer list increases .
			for (Customer cust : custList) { // For loop 
				count++;
				if (count == custList.size()) {
					custId = cust.getCustomerID() + 1;
					break;
				}
			}
		}
		return custId;  // Return Customer ID 
	}

	public int generateProductID() { // Creating method 
		//Initializing the variables 
		int count = 0;
		int prodId = 0;
		
		// It will initialize customer ID to 1 if the size of the product list is equals to 0. 
		if (prodList.size() == 0) // If statement 
			prodId = 1;
		else {
			// It will increment the product ID by 1 when the size of product list increases .
			for (Product prod : prodList) {
				count++;
				if (count == prodList.size()) {
					prodId = prod.getProductID() + 1;
					break;
				}
			}
		}
		return prodId; //Return product id 

	}

	// This method will add new customer into the customer list and initialize a customer ID.
	public void addCustomer(String name, long phoneNo) { //Creating method
		int customId = generateCustomerID();  // Initializing value 
		Customer c = new Customer(customId, name, phoneNo); // Creating object 
		custList.add(c); // Adding new customer into list 

	}

	// This method will add new product into the customer list and initialize a product ID.
	public void addProduct(String name, String status, double price) { //Creating method
        int pid = generateProductID(); // Initializing value 
        Product p = new Product(pid, name, price); // Creating object
		prodList.add(p); // Adding new customer into list 

	}

	// This method will checks the availability of product by ProductName
	public int checkProductAvailability(String ProductName) { // Creating method
		int count = 0;
		for (Product prod : prodList) // For loop 
			try {
				// If getProductName equals to ProductName and status equals to Available..then it will increment the product count. 
				if ((prod.getProductName().equals(ProductName)) && (prod.getProductStatus(null).equals("Available"))) {
					count++;
				}
		// NullPointerException is thrown when the program attempts to use an object reference that has the null value. 		
			} catch (NullPointerException e) { 
				e.printStackTrace();

			}

		return count; // Return product count

	}

	//Using getter and setter functions 
	public String getStoreName() {  // Creating method 
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public RetailStore(String storeName) {
		super();
		this.storeName = storeName;
	}

	public void display() {  // Creating display method 

		for (Customer cust : custList) { // For loop 
			//Prints CustomerName , CustomerNo , CustomerID .
			System.out.println("\nCustomer: " + cust.getCustomerName() + "\nPhone number: " + cust.getCustomerNo()
					+ "\nCustomer_ID: " + cust.getCustomerID());
		}
		for (Product pd : prodList) {
			
			//Prints ProductName , ProductPrice , ProductID , ProductStatus .
			System.out.println("\nProduct: " + pd.getProductName() + "\nPrice: Rs " + pd.getProductPrice()
					+ "\nProduct_ID: " + pd.getProductID() + "\nProduct Status: " + pd.getProductStatus(null));

		}

	}

	//This method will return the total number of products booked.
	public int bookProduct(int customerID, String productName, int numberOfProduct) { // Creating Method 
		// Initializing variables 
		int availProduct = 1;
		int count1 = 0;
		int count2 = 0;
		availProduct = checkProductAvailability(productName);
		int count3 = availProduct;
		int count4 = numberOfProduct;

		/*
		 * If the given product is not available in the product list or no stock available, it will return 0.
		 * If the given customer is not available in the customer list, then the method will return -1.
		 */
		for (Customer cust : custList) {
			count1++;
			if (cust.getCustomerID() == customerID) {
				for (Product prod : prodList) {
					count2++;

					if (prod.getProductName().equals(productName)) { // If getProductName()is equal to productName

						if (availProduct <= numberOfProduct) {
							cust.addBookedProduct(prod);
							count3--;
							if (count3 == 0)
								break;
						}
						if (availProduct > numberOfProduct) // If availProduct is greater than numberOfProduct

						{
							availProduct = numberOfProduct;
							cust.addBookedProduct(prod);
							count4--;
							if (count4 == 0)
								break;
						}

					} else if (count2 == prodList.size()) {
						availProduct = 0;
						break;
					}
				}

			} else if (count1 == custList.size()) {
				availProduct = -1;
				break;
			}
		}
		return availProduct; // Return available product 
	}

	// This method will returns the net amount that the customer need to pay for the entire booking he has made.
	public double calculateAmount(int customerID,int discount) {
		double amount = 0;
		for (Customer cust : custList)
			// The method takes a customer ID as input parameters and calculates the net amount . 
			if (cust.getCustomerID() == customerID) {
				ArrayList<Product> prodList1 = cust.bookedProductList;
				for (Product p : prodList1) {
					// Net amount is calculated by the sum of price of all products that the customer has booked. 
					amount += p.getProductPrice();

				}

				break;
			}
		// Discount is applied on the sum of price of all products.
		amount=amount-((amount*discount)/100);
		
		return amount; // Return amount 
	}

}
