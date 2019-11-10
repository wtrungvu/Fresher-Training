package com.tvu56;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		final String PATH_CUSTOMER = "D:/Learn Java/DXC Fresher Trainning/Java Core/Customer.txt";
		final String PATH_ORDER = "D:/Learn Java/DXC Fresher Trainning/Java Core/Order.txt";
		
		List<Customer> customers = new ArrayList<Customer>();
		List<Order> orders = new ArrayList<Order>();
		List<Customer> customersNew = new ArrayList<Customer>();
		List<Order> reports = new ArrayList<Order>();
	
		readFileCustomer(PATH_CUSTOMER, customers);
		readFileOrder(PATH_ORDER, orders);

		for (Customer customer : customers) {
			System.out.println(customer);
		}
		
		for (Order order: orders) {
			System.out.println(order);
		}
		
		System.out.println();
		
		// Sort by name & Export Output File.
		customersNew = customers;
		Collections.sort(customersNew, Customer.COMPARE_BY_NAME);
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(new File("D:/Learn Java/DXC Fresher Trainning/Java Core/CustomerNew.txt")));
			for (Customer customer : customersNew) {
				bw.write(customer.toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Sort by total number & Export Output File.
		reports = orders;
		Collections.sort(reports, Order.COMPARE_BY_TOTAL);
		BufferedWriter bwReport;
		try {
			bwReport = new BufferedWriter(
					new FileWriter(new File("D:/Learn Java/DXC Fresher Trainning/Java Core/Report.txt")));
			
			for (int i = 0; i < 3; i++) {
				Order order = orders.get(i);
				bwReport.write(order.toString());
				bwReport.newLine();
			}
			bwReport.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void readFileCustomer(String PATH_CUSTOMER, List<Customer> customers) {
		
		String[] information;
		try (BufferedReader br = new BufferedReader(new FileReader(PATH_CUSTOMER))) {

			String strCurrentLine;
			
			while ((strCurrentLine = br.readLine()) != null) {
				information = strCurrentLine.split(",");
				addIntoCollectionCustomer(customers, information);	
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void readFileOrder(String PATH_ORDER, List<Order> orders) {
		
		String[] information;
		try (BufferedReader br = new BufferedReader(new FileReader(PATH_ORDER))) {

			String strCurrentLine;
			
			while ((strCurrentLine = br.readLine()) != null) {
				information = strCurrentLine.split(",");
				addIntoCollectionOrder(orders, information);	
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void addIntoCollectionCustomer(List<Customer> customers, String[] information) {
		if (information[0].equals("id")) {
			return;
		} else if (information[1].equals("name")){
			return;
		} else if (information[2].equals("sex")){
			return;
		} else if (information[3].equals("dob")){
			return;
		} else {
			int id = Integer.parseInt(information[0]);
			String name = information[1];
			char sex = information[2].charAt(0);
			String dob = information[3];
			
			customers.add(new Customer(id, name, sex, dob));
		}
	}

	private static void addIntoCollectionOrder(List<Order> orders, String[] information) {
		if (information[0].equals("id")) {
			return;
		} else if (information[1].equals("custId")){
			return;
		} else if (information[2].equals("description")){
			return;
		} else if (information[3].equals("total")){
			return;
		} else if (information[4].equals("orderDate")){
			return;
		} else {
			int id = Integer.parseInt(information[0]);
			int custId = Integer.parseInt(information[1]);
			String description = information[2];
			long total = Long.parseLong(information[3]);
			String orderDate = information[4];
			
			orders.add(new Order(id, custId, description, total, orderDate));
		}
	}
}