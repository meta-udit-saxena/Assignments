package SocialNetwork;

/**
 * Record class holds all the post of entity
 * 
 * @author Udit Saxena
 *
 */
public class Record {
	private String title;
	private String content;

	public Record(String title, String content) {
		this.title = title;
		this.content = content;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
