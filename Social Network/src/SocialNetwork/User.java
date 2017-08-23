package SocialNetwork;
/**
 * user class have all the details 
 * @author Udit Saxena
 *
 */
public class User extends Entity {
	private int age;

	/**
	 * @param id
	 * @param name
	 * @param type
	 * @param contact
	 * @param password
	 */
	public User(String id, String name, String password, long contact,
			int age,String type) {
		super(id, name,password, contact, type);
		this.age=age;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
