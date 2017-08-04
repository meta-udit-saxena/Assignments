/**
 * ActionMenuItem class sets action for particular ActionableMenuItem.
 * 
 * @author Udit Saxena
 * 
 */
public class ActionableMenuItem<T> extends MenuItem implements Action<Object> {
	// Generic class Object
	T action;

	/**
	 * Sets the action to be performed.
	 * 
	 * @param action
	 */
	public ActionableMenuItem(T action) {
		this.action = action;
	}

	/**
	 * Performs the action corresponding to Class object.
	 */
	@Override
	public void performAction() {
		System.out.println(this.action);
	}
}
