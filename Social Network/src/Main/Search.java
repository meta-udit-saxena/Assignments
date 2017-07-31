package Main;

import java.util.Scanner;
import java.util.Set;

import SocialNetwork.Entity;
import SocialNetwork.Graph;

/**
 * Search entity from the social network
 * 
 * @author Udit Saxena
 *
 */
public class Search {
	private static Scanner scan;

	/**
	 * Search entity by using name
	 * 
	 * @param graph
	 *            - Graph class object
	 * @param userId
	 *            - entity ID
	 */
	public void search(Graph<Entity> graph, String userId) {
		scan = new Scanner(System.in);
		boolean searchresult = false;
		System.out.println("Enter name : ");
		String name = scan.nextLine();
		Set<String> entityIds = graph.getNodesId();
		for (String id : entityIds) {
			// condition to skip current user name and check the input name
			// contains in any Node
			if (!graph.getNodeById(id).equals(graph.getNodeById(userId))
					&& graph.getNodeById(id).getName().contains(name)) {
				System.out.println("User id - " + id + " \t Name : "
						+ graph.getNodeById(id).getName());
				searchresult = true;
			}
		}
		if (!searchresult) {
			System.out.println("No result found..!!!");
		}
	}
}
