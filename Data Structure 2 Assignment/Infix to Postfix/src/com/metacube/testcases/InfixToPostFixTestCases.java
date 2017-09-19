package com.metacube.testcases;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import com.metacube.infixtopostfixnotaion.InfixToPostFix;

@RunWith(Parameterized.class)
public class InfixToPostFixTestCases {

	InfixToPostFix obj;

	@Before
	public void setUpObject() {
		obj = new InfixToPostFix();
	}

	@Parameters
	public static Collection<Object[]> insert() {
		return Arrays.asList(new Object[][] {
				{ "(((54+46)+(45+46)+(465+45))-44*55/5+89)",
						"5446+4546++46545++4455*5/-89+" },
				{ "54+46+45+46+465+45-44*55/5+89",
						"5446+45+46+465+45+4455*5/-89+" },
				{ "((A*B)+(C/D))", "AB*CD/+" },
				{ "( (A * B) + (C / D) )", "AB*CD/+" }, { "(()())", "" },
				{ null, null }

		});
	}

	@Parameter(0)
	public String infixString;
	@Parameter(1)
	public String expectedPostFix;

	@Test
	public void infixToPostFixConversionTest() {
		String actual = obj.covertInfixToPostFix(infixString);
		assertEquals(expectedPostFix, actual);
	}
}
