package storeManagement;
/**
 * Create class Product and class knows about productID,productName,productStatus and productPrice.
 * Constructor initializes the value of productID, name & price with the given values.
 *.Initially the status of the product is set to “Available”.
 */


class Product { // Creating class
	// Declaring variables as mention in the project
	public int productID;
	String productName;
	double productPrice;
	String productStatus="Available";
	
	public Product(int pid, String name, double price) {
		// TODO Auto-generated constructor stub
		 // Super() is a reference variable which is used to refer immediate  parent class constructor..
		super();
		
		// Giving reference to the objects
		this.productID = pid;
		this.productName = name;
		this.productPrice = price;
	}
	
	
	// Constructor creates Product class objects with the given id, name & contact no.
	//Using getter and setter functions 
	public  String getProductStatus(String status) {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
}