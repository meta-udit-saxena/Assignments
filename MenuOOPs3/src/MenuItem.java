/**
 * MenuItems can be Actionable MenuItems or another subMenu.
 * 
 * @author Udit Saxena
 *
 */
public abstract class MenuItem {
	private String displayName;
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * Set display name of MenuItem
	 * @param displayName
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * Implement performAction method of action class
	 */
	public void performAction() {
		// TODO Auto-generated method stub
		
	}
	

}
