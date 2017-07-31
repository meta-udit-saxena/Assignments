package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import SocialNetwork.Entity;
import SocialNetwork.Graph;
import SocialNetwork.Record;

/**
 * have all the function relation to the Post
 * 
 * @author Udit Saxena
 *
 */
public class Posts {
	private Scanner scan;

	/**
	 * Display all the option related to Post and call their function
	 * 
	 * @param graph
	 *            - Graph class object
	 * @param userId
	 *            - entity ID
	 */
	protected void posts(Graph<Entity> graph, String userId) {
		scan = new Scanner(System.in);
		boolean back = false;
		do {
			System.out
					.println("1.Display Post\n2.Add Post\n3.Remove Post\n4.Back");
			while (!scan.hasNextInt()) {
				System.out.println("Enter Integer Value:");
				scan.nextLine();
			}
			int choice = scan.nextInt();
			scan.nextLine();
			switch (choice) {
			case 1:
				displayPost(graph, userId);
				break;
			case 2:
				addPost(graph, userId);
				break;
			case 3:
				removePost(graph, userId);
				break;
			case 4:
				back = true;
				break;
			default:
				System.out.println("Enter correct choice\n");
			}
		} while (!back);
	}

	/**
	 * Remove post by using title of post
	 * 
	 * @param graph
	 *            - Graph class object
	 * @param userId
	 *            - entity ID
	 */
	private void removePost(Graph<Entity> graph, String userId) {
		System.out.println("Enter Post title");
		String title = scan.nextLine();
		boolean flag = false;
		for (Record record : graph.getNodeById(userId).getPosts()) {
			if (record.getTitle().equalsIgnoreCase(title)) {
				graph.getNodeById(userId).getPosts().remove(record);
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println(title + " Deleted ");
		} else {
			System.out.println("No such post exit ");
		}
	}

	/**
	 * Add post to record List
	 * 
	 * @param graph
	 *            - Graph class object
	 * @param userId
	 *            - entity ID
	 */
	private void addPost(Graph<Entity> graph, String userId) {
		System.out.println("post Title :");
		String title = scan.nextLine();
		System.out.println("write EOF in the last line of Content: ");
		String content = "\n";
		String checkEnd;
		while (!(checkEnd = scan.nextLine()).equalsIgnoreCase("EOF")) {
			content += checkEnd + "\n";
		}
		if (graph.getNodeById(userId).getPosts() == null) {
			List<Record> post = new ArrayList<Record>();
			graph.getNodeById(userId).setPosts(post);
		}
		graph.getNodeById(userId).getPosts().add(new Record(title, content));
	}

	/**
	 * Display all the post from cuurent user
	 * 
	 * @param graph
	 *            - Graph class object
	 * @param userId
	 *            - entity ID
	 */
	private void displayPost(Graph<Entity> graph, String userId) {
		if (graph.getNodeById(userId).getPosts() == null
				|| graph.getNodeById(userId).getPosts().size() == 0) {
			System.out.println("\n--------You have no Post-------\n");
		} else {
			for (Record post : graph.getNodeById(userId).getPosts()) {
				System.out.println("\nTitle of Post -> " + post.getTitle());
				System.out.println("Content -> " + post.getContent());
			}
		}
	}
}
