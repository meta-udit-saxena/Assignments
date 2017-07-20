/**
 * determine which button is pressed and set size of each button
 * @author Udit Saxena
 *
 */
class Button1 extends Layout {

	protected int height, width, fontSize;

	public Button1() {
		// default size of the buttons
	}

	/**
	 * create buttons of variable height and width as required by user
	 * 
	 * @param height
	 * @param width
	 * 
	 */
	public void setButtonSize(int height, int width, int fontSize) {
		height = this.height;
		width = this.width;
		fontSize = this.fontSize;
	}

	/**
	 * return numbers and operators whatever user has added add these inputs to
	 * queue for further processing
	 * 
	 * @return string value that user pressed
	 */
	public String onClick() {
		return "";
	}
}
