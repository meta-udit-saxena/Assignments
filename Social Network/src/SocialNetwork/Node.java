package SocialNetwork;

import java.util.HashMap;
import java.util.Set;

/**
 * @author goku
 **/
public interface Node<E> {
	/**
	 * Add Node into hashMap
	 * @param id - node Id
	 * @param obj
	 */
	public void addNode(String id, E obj);

	/**
	 * remove node from hashMap
	 * @param id nodeId
	 */
	public void removeNodeById(String id);

	/**
	 * get Node by using Id
	 * @param id - node id
	 * @return node
	 */
	public E getNodeById(String id);

	/**
	 * 
	 * @return whole hashMap of nodes
	 */
	public HashMap<String, E> getNodeHashMap();

	/**
	 * Check node is valid or not
	 * @param id -node Id
	 * @return if id is valid then return true else false
	 */
	public boolean isValidNodeId(String id);

	/**
	 * 
	 * @return set of nodes Id
	 */
	public Set<String> getNodesId();
}
