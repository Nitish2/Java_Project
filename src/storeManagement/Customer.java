package storeManagement;

/**
 * Creating class Customer and class knows about his customerID,customerName, customerNumber.
 * Constructor creates Customer object with the given id, name & contact no.
 * Creating method addBookedProduct.
 * addBookedProduct () method will add the product into cart which is booked by the customer to
    his bookedProductList. 
 */

import java.util.ArrayList;

public class Customer { // Creating class customer
	// Declaring variables as mention in the project
	int customerID;
	String customerName;
	long customerNo;
	
	/*
	 * Creating an ArrayList which extends AbstractList and implements the List
	     interface for bookedProductList.
	 */
	ArrayList<Product> bookedProductList = new ArrayList<Product>(); // Creating  an array list object
																		

	public Customer(int customId, String name, long phoneNo) { // Creating method
																
        // Super() is a reference variable which is used to refer immediate  parent class constructor.
		super();
		
		// Giving reference to the objects
		this.customerID = customId;
		this.customerName = name;
		this.customerNo = phoneNo;

		// TODO Auto-generated constructor stub
	}

	public void addBookedProduct(Product abp) { // Creating addBookedProduct()  method as mentioned in the project
												
		abp.setProductStatus("Booked"); // Creating abject
		bookedProductList.add(abp);
	}

	// Constructor creates Customer class objects with the given id, name & customer no.
	//Using getter and setter functions 
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(long customerNo) {
		this.customerNo = customerNo;
	}

}
