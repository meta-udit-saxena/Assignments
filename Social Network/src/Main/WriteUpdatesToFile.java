package Main;

import java.util.List;
import java.util.Set;

import SocialNetwork.Connection;
import SocialNetwork.Constants;
import SocialNetwork.Entity;
import SocialNetwork.FileHandling;
import SocialNetwork.Graph;
import SocialNetwork.Organization;
import SocialNetwork.User;

/**
 * Responsible for write the updates in user and connection file
 * 
 * @author Udit Saxena
 *
 */
public class WriteUpdatesToFile {
	/**
	 * writes the update into user file
	 * 
	 * @param graph
	 *            - Graph class object
	 * @param connection
	 *            - Connection class object
	 */
	public void writeEntityDetailsToFile(Graph<Entity> graph,
			Connection connection) {
		String userDetails = "";
		Set<String> entityId = graph.getNodesId();
		for (String id : entityId) {
			if ("user".equalsIgnoreCase(graph.getNodeById(id).getType())) {
				User user1 = (User) graph.getNodeById(id);
				userDetails += user1.getId() + "," + user1.getName() + ","
						+ user1.getPassword() + "," + user1.getContact() + ","
						+ user1.getAge() + "," + user1.getType() + "\n";
			} else {
				Organization organisation = (Organization) graph
						.getNodeById(id);
				userDetails += organisation.getId() + ","
						+ organisation.getName() + ","
						+ organisation.getPassword() + ","
						+ organisation.getContact() + ","
						+ organisation.getAddress() + ","
						+ organisation.getType() + "\n";

			}
		}
		new FileHandling().write(userDetails, Constants.USER_LIST_PATH);
	}

	/**
	 * writes the update into Connection file
	 * 
	 * @param graph
	 *            - Graph class object
	 * @param connection
	 *            - Connection class object
	 */
	public void writeConnectionDetailsToFile(Graph<Entity> graph,
			Connection connection) {
		String connectionDetails = "";
		Set<String> entityId = connection.getConnectionIdSet();
		for (String id : entityId) {
			List<String> connectionIdList = connection.getConnectionList(id);
			connectionDetails += id + ",";
			for (String connectionId : connectionIdList) {
				connectionDetails += connectionId + ";";
			}
			connectionDetails += "\n";
		}
		new FileHandling().write(connectionDetails,
				Constants.CONNECTION_LIST_PATH);
	}
}
