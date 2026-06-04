package com.example.tax;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import java.util.Scanner;

@SpringBootApplication
public class TaxApplication {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Tax Payment Application");
		while (true) {
			System.out.println("Please select which tax you want to pay: \n1. Income \n2. Property\n3. Exit");
			int userChoice = scanner.nextInt();
			String taxChoice = "";
			switch (userChoice) {
				case 1 -> taxChoice = "incomeTax";
				case 2 -> taxChoice = "propertyTax";
				case 3 -> {
					System.out.println("Exiting...");
					return;
				}
				default -> {
					System.out.println("Invalid choice");
					return;
				}
			}
			Tax tax = (Tax) context.getBean(taxChoice);


		
		if(tax.isTaxPayed()){

		System.out.println("You have already paid" + tax.getTaxType() + "tax.");
		}
		else{
			System.out.println("Enter " + tax.getTaxType() + "amount");
			Scanner sc = new Scanner(System.in);
			double amount = sc.nextDouble();

			tax.setTaxableAmount(amount);
			tax.calculateTaxAmount();

			System.out.println("The tax amount to be paid is "+ tax.getTaxAmount());

			System.out.println("Do you want to pay the tax?");
			String choice = sc.next();

			if(choice.equalsIgnoreCase("yes")){
				tax.payTax();
			}
		}	

		}
	}

}
