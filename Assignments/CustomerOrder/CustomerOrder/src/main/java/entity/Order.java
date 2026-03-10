package entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String orderNumber;
    private String productName;
    private int quantity;
    private double price;
    private LocalDate orderDate;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order() {}
    
	public Order(int id, String orderNumber, String productName, int quantity, double price, LocalDate orderDate,
			Customer customer) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
    
	@Override
	public String toString() {
	    return "Order [id=" + id + ", orderNumber=" + orderNumber + ", productName=" + productName +
	            ", quantity=" + quantity + ", price=" + price + ", orderDate=" + orderDate + "]";
	}
    

}
