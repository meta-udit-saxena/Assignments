package webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Server side - provide Fahrenheit to celsius conversion service
 * 
 * @author Udit
 *
 */
@WebService
public class FahrenheitToCelsius {

	/**
	 * @param temperature
	 *            - temperature in fahrenheit
	 * @return temperature in celsius
	 */
	@WebMethod
	public double convertFahrenheitToCelsius(double temperature) {
		temperature = ((temperature - 32) * 5) / 9;

		return temperature;
	}
}