package SocialNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Holds the connection map between entities
 * 
 * @author Udit saxena
 *
 */
public class Connection {
	private List<String> detailsFromFile;
	private List<String> connectionList;
	private HashMap<String, List<String>> connectionMap = new HashMap<String, List<String>>();

	public Connection() {
		initConnectionList();
	}

	/**
	 * initiate the connectionMap
	 */
	private void initConnectionList() {
		detailsFromFile = new FileHandling()
				.read(Constants.CONNECTION_LIST_PATH);
		for (String str : detailsFromFile) {
			connectionList = new ArrayList<String>();
			String[] details = str.split(",");
			if (details.length > 1) {
				String[] connectionIds = details[1].split(";");
				for (int index = 0; index < connectionIds.length; index++) {
					connectionList.add(connectionIds[index]);
				}
				connectionMap.put(details[0], connectionList);
			}
		}
	}

	/**
	 * 
	 * @param Id
	 *            - enity Id holding connection list
	 * @param connectionId
	 *            - Connection Id present in connection List
	 */
	public void removeConnection(String Id, String connectionId) {
		connectionMap.get(Id).remove(connectionId);
	}

	/**
	 * 
	 * @param Id
	 *            - entity Id holding connection list
	 * @param connectionId
	 *            - Connection Id present in connection List
	 * @return String message according to the condition
	 */
	public void addConnection(String entityId, String connectionId) {
		if (!connectionMap.containsKey(entityId)) {
			connectionList = new ArrayList<String>();
			connectionList.add(connectionId);
			connectionMap.put(entityId, connectionList);
		} else {
			connectionList = getConnectionList(entityId);
			connectionList.add(connectionId);
			connectionMap.put(entityId, connectionList);
		}
	}

	/**
	 * 
	 * @param entityId
	 *            - Unique Id of entity
	 * @return connection list of that entityId
	 */
	public List<String> getConnectionList(String entityId) {
		return connectionMap.get(entityId);
	}

	public boolean isEntityIdIsPresentInList(String userId,
			String entityId) {
		if (getConnectionList(userId).contains(entityId)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return the whole connection Map
	 */
	public Set<String> getConnectionIdSet() {
		return connectionMap.keySet();
	}
}
