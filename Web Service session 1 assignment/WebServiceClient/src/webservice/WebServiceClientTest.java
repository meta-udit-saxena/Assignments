package webservice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WebServiceClientTest {

	WebServiceClient obj;
	@Before
	public void setUp() {
		obj = new WebServiceClient();
	}

	@Test
	public void GivenFahrenheitIs50_WhenConvertor_Then10() {
		double actual = obj.convertor(50);
		double expected = 10.0;
		assertEquals(expected, actual,2);
	}
	
	@Test
	public void GivenFahrenheitIs76_WhenConvertor_Then24() {
		double actual = obj.convertor(76);
		double expected = 24.4;
		assertEquals(expected, actual,0.1);
	}
}
