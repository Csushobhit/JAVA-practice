package com.app.CustomerOrder;

import dao.CustomerDAO;
import dao.impl.CustomerDAOImpl;
import entity.Customer;
import entity.Order;

import java.time.LocalDate;
import java.util.List;

public class App {

	static CustomerDAO dao = new CustomerDAOImpl();

	public static void main(String[] args) {

//        insertCustomer();
//        fetchCustomer();
//		getCustomerByEmail();
//        updateCustomer();
//		 deleteCustomer();
		fetchAllCustomers();

	}

	static void insertCustomer() {

		Customer customer = new Customer();
		customer.setCustomerName("Rahul");
		customer.setEmail("rahul@gmail.com");
		customer.setGender("Male");
		customer.setPhone(9876543210L);
		customer.setRegistrationDate(LocalDate.now());

		Order order = new Order();
		order.setOrderNumber("ORD101");
		order.setProductName("Laptop");
		order.setQuantity(1);
		order.setPrice(75000);
		order.setOrderDate(LocalDate.now());

		// one-to-one-mapping
		customer.setOrder(order);
		order.setCustomer(customer);

		dao.insertCustomer(customer);

		System.out.println("Customer inserted");
	}

	static void fetchCustomer() {

		Customer c = dao.getCustomerById(1);
		System.out.println(c);
	}

	static void getCustomerByEmail() {
		Customer c = dao.getCustomerByEmail("rahul@gmail.com");
		System.out.println(c);
		System.out.println(c.getOrder());
	}

	static void updateCustomer() {

		Customer c = dao.getCustomerById(1);
		c.setCustomerName("Rahul Sharma");

		dao.updateCustomer(c);

		System.out.println("Customer updated");
	}

	static void deleteCustomer() {

		dao.deleteCustomer(1);

		System.out.println("Customer deleted");
	}

	static void fetchAllCustomers() {

		List<Customer> list = dao.getAllCustomers();

		for (Customer c : list) {
			System.out.println(c);
		}
	}
}