package com.metacube.get.layarch.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class Factory.
 */
public class Factory {

	/** The application context. */
	static ApplicationContext applicationContext;

	static {
		applicationContext = new ClassPathXmlApplicationContext(
				"ApplicationContext.xml");
	}

	/**
	 * Gets the application context.
	 *
	 * @return the application context
	 */
	static public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
}