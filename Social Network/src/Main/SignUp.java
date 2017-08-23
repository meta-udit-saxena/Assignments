package Main;

import java.util.Scanner;

import SocialNetwork.Connection;
import SocialNetwork.Entity;
import SocialNetwork.Graph;
import SocialNetwork.Organization;
import SocialNetwork.User;

/**
 * Responsible for signUp operations
 * 
 * @author User27
 *
 */
public class SignUp {
	private static Scanner scan = new Scanner(System.in);;

	/**
	 * Call function according to the type user or organization
	 * 
	 * @param graph
	 *            - Graph class object
	 * @param connection
	 *            - Connection class object
	 */
	protected void signUp(Graph graph, Connection connection) {
		System.out.println("Enter Account Type - User/Organization");
		String type = scan.nextLine();
		switch (type) {
		case "User":
		case "user":
			addUser(type, graph, connection);
			break;
		case "Organization":
		case "organization":
			addOrganization(type, graph, connection);
			break;
		default:
			System.out.println("Enter correct Option");
		}
	}

	/**
	 * Add organization into the graph
	 * 
	 * @param type
	 *            - Organization type
	 * @param graph
	 *            - Graph class object
	 * @param connection
	 *            - Connection class object
	 */
	private void addOrganization(String type, Graph<Organization> graph,
			Connection connection) {
		System.out.println("Enter Organization Id:");
		String id = scan.nextLine();
		while (graph.isValidNodeId(id)) {
			System.out.println("This id is already exist in social network");
			id = scan.nextLine();
		}
		String name, password;
		String address;
		long contact;
		System.out.println("Enter your Name:");
		name = scan.nextLine();
		System.out.println("Password");
		password = scan.nextLine();
		System.out.println("Address");
		address = scan.nextLine();
		contact = getValidContact();
		graph.addNode(id, new Organization(id, name, password, contact,
				address, type));
		System.out.println("\n--------Welcome to the Social Network " + name
				+ "---------\n");
		new SignIn().organizationLogin(graph, connection, id);

	}

	/**
	 * Add user into the graph
	 * 
	 * @param type
	 *            - user type
	 * @param graph
	 *            - Graph class object
	 * @param connection
	 *            - Connection class object
	 */
	protected void addUser(String type, Graph<User> graph, Connection connection) {
		System.out.println("Enter User Id:");
		String id = scan.nextLine();
		// if node already exist in social network
		while (graph.isValidNodeId(id)) {
			System.out.println("This id is already exist in social network");
			id = scan.nextLine();
		}
		String name, password;
		int age;
		long contact;
		System.out.println("Enter your Name:");
		name = scan.nextLine();
		System.out.println("Password");
		password = scan.nextLine();
		age = getValidAge();
		contact = getValidContact();
		graph.addNode(id, new User(id, name, password, contact, age, type));
		System.out.println("\n--------Welcome to the Social Network " + name
				+ "---------\n");
		new SignIn().userLogin(graph, connection, id);
	}

	/**
	 * get age until user enter correct Age
	 * 
	 * @return valid age
	 */
	private int getValidAge() {
		System.out.println("Age");
		int age;
		while (!scan.hasNextInt() || (age = scan.nextInt()) > 150 || age < 1) {
			System.out.println("Enter Correct Age:");
			scan.nextLine();
		}
		return age;
	}

	/**
	 * 
	 * @return valid contact number
	 */
	private long getValidContact() {
		System.out.println("Contact Number");
		long contact;
		while (!scan.hasNextLong()
				|| String.valueOf(contact = scan.nextLong()).length() != 10) {
			System.out.println("Enter 10 digit number:");
			scan.nextLine();
		}
		return contact;
	}
}
