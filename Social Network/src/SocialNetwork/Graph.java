package SocialNetwork;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Graph implements the node interface and hold the nodesHashMap
 * 
 * @author Udit Saxena
 *
 * @param <T>
 *            generic type
 */
public class Graph<T> implements Node<T> {
	private List<String> entityList;
	private HashMap<String, T> nodesHashMap = new HashMap<String, T>();

	public Graph() {
		initEntity();
	}

	/**
	 * Initializing the nodehashMap from the file
	 */
	private void initEntity() {
		entityList = new FileHandling().read(Constants.USER_LIST_PATH);
		for (String str : entityList) {
			String details[] = str.split(",");
			if ("Organization".equalsIgnoreCase(details[5])) {
				nodesHashMap.put(details[0], (T) new Organization(details[0],
						details[1], details[2], Long.parseLong(details[3]),
						details[4], details[5]));
			} else {
				nodesHashMap.put(details[0], (T) new User(details[0],
						details[1], details[2], Long.parseLong(details[3]),
						Integer.parseInt(details[4]), details[5]));
			}
		}
	}

	/**
	 * Add node to Node hashMap
	 * 
	 * @param id
	 *            - Id of user/organization
	 * @param obj
	 *            -Entity class object;
	 */

	public void addNode(String id, T obj) {
		nodesHashMap.put(id, (T) obj);
	}

	/**
	 * @param id
	 * @return the object
	 */
	public T getNodeById(String id) {
		return nodesHashMap.get(id);
	}

	/**
	 * 
	 * @return complete nodes hashMap
	 */
	public HashMap<String, T> getNodeHashMap() {
		return nodesHashMap;
	}

	/**
	 * Check node id is valid or not
	 * 
	 * @param id
	 *            - node Id
	 * @return if id is valid then return true else false
	 */
	public boolean isValidNodeId(String id) {
		return nodesHashMap.containsKey(id);
	}

	/**
	 * Remove the node from node hashMap having this id
	 * 
	 * @param id
	 *            - id of node
	 */
	public void removeNodeById(String id) {
		nodesHashMap.remove(id);
	}

	/**
	 * 
	 * @return set of nodes
	 */
	public Set<String> getNodesId() {
		return nodesHashMap.keySet();
	}
}
