package fr.bufalo.acme.utils.charts;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import fr.bufalo.acme.bo.Customer;
import fr.bufalo.acme.constant.ParameterConstant;

/**
 * This class is in charge of generating a string suitable to be used by Google
 * pie chart
 * 
 * @date Created 05/06/2021
 * @author Frederic Thebault
 * @version 1.0
 */
public class ChartFormatting {

	private static final String NOT_MENTIONED = ParameterConstant.NOT_MENTIONED.getParameterName();

	public static String pieChartFormatting(List<Customer> listCustomers) {
		// first part, extracting data from customer list and gather it in an array
		HashMap<String, Integer> customerNumberPerDept = new HashMap<>();
		for (Customer customer : listCustomers) {
			if (customer.getPostalCode() != null) {
				String deptNumber = customer.getPostalCode().getNumber().substring(0, 2);
				if (customerNumberPerDept.get(deptNumber) == null) {
					customerNumberPerDept.put(deptNumber, 1);
				} else {
					Integer value = customerNumberPerDept.get(deptNumber);
					customerNumberPerDept.put(deptNumber, value + 1);
				}
			} else {
				if (customerNumberPerDept.get(NOT_MENTIONED) == null) {
					customerNumberPerDept.put(NOT_MENTIONED, 1);
				} else {
					Integer value = customerNumberPerDept.get(NOT_MENTIONED);
					customerNumberPerDept.put(NOT_MENTIONED, value + 1);
				}
			}
		}

		// second part, use data gathered to generate a string suitable for the pie
		// chart
		return ChartFormatting.generatePieChartFormat(customerNumberPerDept);
	}

	private static String generatePieChartFormat(HashMap<String, Integer> list) {
		String result = "[ [ \"Numéro du département\", \"Nombre de clients\" ]";
		for (String key : list.keySet()) {
			result += ",[ \"" + key + "\", " + list.get(key) + " ]";
		}
		result += " ]";
		return result;
	}
	
	public static String histogramChartFormatting(List<Customer> listCustomers) {
		// first part, extracting data from customer list and gather it in an array
		HashMap<String, Integer> customerNumberPerAge = new HashMap<>();
		for (Customer customer : listCustomers) {
			if (customer.getBirthdate() != null) {
				int age = LocalDate.now().getYear() - customer.getBirthdate().getYear();
				customerNumberPerAge.put(customer.getReference(),age);
			} else {
				customerNumberPerAge.put(customer.getReference(), -1);
			}
		}
		
		// second part, use data gathered to generate a string suitable for the histogram
		// chart
		return generateHistogramChartFormat(customerNumberPerAge);
	}
	
	private static String generateHistogramChartFormat(HashMap<String, Integer> list) {
		String result = "[ [ \"Référence du client\", \"Age du client\" ]";
		for (String key : list.keySet()) {
			result += ",[ \"" + key + "\", " + list.get(key) + " ]";
		}
		result += " ]";
		return result;
	}
}
