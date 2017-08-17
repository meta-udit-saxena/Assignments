package webservice;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FahrenheitToCelsiusTest {
	FahrenheitToCelsius obj;

	@Before
	public void setUpObject() {
		obj = new FahrenheitToCelsius();
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 33.0, 0.55 }, { 32.0, 0.00 },
				{ 45, 7.22 }, { 76, 24.45 }, { 4, -15.56 } });
	}

	@Parameter(0)
	public double fInput;
	
	@Parameter(1)
	public double fExpected;

	@Test
	public void test() {
		double actual = obj.convertFahrenheitToCelsius(fInput);
		assertEquals(fExpected, actual, 0.1);
	}

}