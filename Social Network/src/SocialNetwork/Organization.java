package SocialNetwork;

/**
 * Organization class have all the details related to organization
 * 
 * @author Udit Saxena
 *
 */
public class Organization extends Entity {
	private String address;

	/**
	 * @param id
	 *            -Organization id
	 * @param name
	 *            -Organization name
	 * @param type
	 *            -Type of entity
	 * @param contact
	 *            - Contact number
	 * @param password
	 *            - password
	 */
	public Organization(String id, String name, String password, long contact,
			String address, String type) {
		super(id, name, password, contact, type);
		this.address = address;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}
