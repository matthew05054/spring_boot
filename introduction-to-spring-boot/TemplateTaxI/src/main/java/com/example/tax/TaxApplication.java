package com.example.tax;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TaxApplication {

	public static void main(String[] args) {
		// Take ClassPathXmlApplicationContext from applicationContext.xml file

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Tax incomeTax = (Tax) context.getBean("incomeTax");
		incomeTax.setTaxableAmount(10000);
		incomeTax.calculateTaxAmount();

		
        System.out.println("Tax Type : " + incomeTax.getTaxType());
        System.out.println("Tax Amount : " + incomeTax.getTaxAmount());

        incomeTax.payTax();

        Tax propertyTax = (Tax) context.getBean("propertyTax");

        propertyTax.setTaxableAmount(1000000);
        propertyTax.calculateTaxAmount();

        System.out.println("Tax Type : " + propertyTax.getTaxType());
        System.out.println("Tax Amount : " + propertyTax.getTaxAmount());

        propertyTax.payTax();


	}

}
