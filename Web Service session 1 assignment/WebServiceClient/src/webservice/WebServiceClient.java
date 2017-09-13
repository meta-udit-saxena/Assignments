package webservice;
import java.util.Scanner;
/**
 * Client Side - request for service from server
 * @author Udit Saxena
 *
 */
public class WebServiceClient {
	
	/**
	 * @param temperature
	 *            - temperature in fahrenheit
	 * @return temperature in celsius
	 */
	public double convertor(double temperature) {
		FahrenheitToCelsiusServiceLocator locatorObject = new FahrenheitToCelsiusServiceLocator();
		double result = 0d;
		locatorObject
				.setFahrenheitToCelsiusEndpointAddress("http://localhost:8080/Web_Service_Assignment_1/services/FahrenheitToCelsius");
		try {
			FahrenheitToCelsius obj = locatorObject.getFahrenheitToCelsius();
			result = obj.convertFahrenheitToCelsius(temperature);
		} catch (Exception e) {

		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		WebServiceClient webServiceClient = new WebServiceClient();
		System.out.println("Enter temperature in fahrenheit");
		double temperature;
		while (!scan.hasNextDouble()) {
			System.out.println("Enter temperature in fahrenheit");
			scan.next();
		}
		temperature = scan.nextDouble();
		System.out.println(webServiceClient.convertor(temperature));
	}
}
