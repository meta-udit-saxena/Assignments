package Main;

import java.util.Scanner;

import SocialNetwork.Graph;
import SocialNetwork.Organization;
import SocialNetwork.User;
/**
 * Responsible of profile editing of user and organization both
 * @author Udit Saxena
 *
 */
public class EditProfile {
	private static int choice;
	private static Scanner scan = new Scanner(System.in);

	/**
	 * Edit user Profile or Delete Profile
	 * 
	 * @param graph
	 *            -Graph class object
	 * @param userId
	 *            -user id
	 * @return true if user delete profile else false
	 */
	protected boolean editUserProfile(Graph<User> graph, String userId) {
		boolean back = false;
		do {
			System.out
					.println("1.Edit Name\n2.Edit Contact\n3.Edit Age\n4.Change Password\n5.Display Profile\n6.Delete Profile\n7.Back ");
			while (!scan.hasNextInt()) {
				System.out.println("Enter Integer value:");
				scan.nextLine();
			}
			choice = scan.nextInt();
			scan.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter New Name");
				graph.getNodeById(userId).setName(scan.nextLine());
				break;
			case 2:
				long contact = getValidContact();
				graph.getNodeById(userId).setContact(contact);
				break;
			case 3:
				int age = getValidAge();
				graph.getNodeById(userId).setAge(age);
				break;
			case 4:
				System.out.println("Enter your Current password");
				if (graph.getNodeById(userId).getPassword()
						.equals(scan.nextLine())) {
					System.out.println("Enter new Password :");
					graph.getNodeById(userId).setPassword(scan.nextLine());
				} else {
					System.out.println("Wrong password");
				}
				break;
			case 5:
				User user = graph.getNodeById(userId);
				System.out.println("Name - " + user.getName()
						+ "\t Contact Number - " + user.getContact()
						+ "\t Age - " + user.getAge());
				break;
			case 6:
				if (deleteProfile()) {
					graph.removeNodeById(userId);
					System.out.println("Removed");
					return true;
				}
				break;
			case 7:
				back = true;
				break;
			default:
				System.out.println("Enter correct choice\n");
			}

		} while (!back);
		return false;
	}

	/**
	 * Edit Organization Profile or Delete Profile
	 * 
	 * @param graph
	 *            -Graph class object
	 * @param userId
	 *            -user id
	 * @return true if organization delete his profile else false
	 */
	public boolean editOrganizationProfile(Graph<Organization> graph,
			String userId) {
		boolean back = false;
		do {
			System.out
					.println("1.Edit Name\n2.Edit Contact\n3.Edit Address\n4.Change Password\n5.Display Profile\n6.Delete Profile\n7.Back ");
			while (!scan.hasNextInt()) {
				System.out.println("Enter Integer value:");
				scan.nextLine();
			}
			choice = scan.nextInt();
			scan.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter New Name");
				graph.getNodeById(userId).setName(scan.nextLine());
				break;
			case 2:
				long contact = getValidContact();
				graph.getNodeById(userId).setContact(contact);
				break;
			case 3:
				System.out.println("Enter New Address");
				graph.getNodeById(userId).setAddress(scan.nextLine());
				break;
			case 4:
				System.out.println("Enter your Current password");
				if (graph.getNodeById(userId).getPassword()
						.equals(scan.nextLine())) {
					System.out.println("Enter new Password :");
					graph.getNodeById(userId).setPassword(scan.nextLine());
				} else {
					System.out.println("Wrong password");
				}
				break;
			case 5:
				Organization organization = graph.getNodeById(userId);
				System.out.println("\nName - " + organization.getName()
						+ "\t Contact Number - " + organization.getContact()
						+ "\t Address - " + organization.getAddress()+"\n");
				break;
			case 6:
				if(deleteProfile()){
				graph.removeNodeById(userId);
				back = true;
				return true;
				}
				break;
			case 7:
				back = true;
				break;
			default:
				System.out.println("Enter correct choice\n");
			}
		} while (!back);
		return false;
	}

	/**
	 * get age until user enter correct Age
	 * 
	 * @return valid age
	 */
	private int getValidAge() {
		System.out.println("Enter age");
		int age;
		while (!scan.hasNextInt() || (age = scan.nextInt()) > 150
				|| age  < 1) {
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
		System.out.println("Enter new Contact Number");
		long contact;
		while (!scan.hasNextLong()
				|| String.valueOf(contact = scan.nextLong()).length() != 10) {
			System.out.println("Enter 10 digit number:");
			scan.nextLine();
		}
		return contact;
	}

	/**
	 * 
	 * @return true if user want to remove account else false
	 */
	private boolean deleteProfile() {
		System.out.println("Are you sure .?? Y/N");
		String ans = scan.next();
		if (ans.equalsIgnoreCase("Y")) {
			System.out.println("Really..??  Y/N");
			ans = scan.next();
		}
		if ("Y".equalsIgnoreCase(ans)) {
			System.out.println("Removed");
			return true;
		}else{
			return false;
		}
	}
}
