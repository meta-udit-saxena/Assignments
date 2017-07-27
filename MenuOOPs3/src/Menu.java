import java.util.ArrayList;
import java.util.List;

/**
 * Menu class contains a list of menu items and other sub menus.
 * 
 * @author Udit Saxena
 * 
 */

public class Menu extends MenuItem {

	private List<MenuItem> subMenu = new ArrayList<MenuItem>();

	public List<MenuItem> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<MenuItem> list) {
		this.subMenu = list;
	}

	/**
	 * Return MenuItem based on choice.
	 * 
	 * @param choice
	 */
	public MenuItem getSelection(int choice) {
		if (choice >= subMenu.size())
			return null;

		return subMenu.get(choice);
	}

}
