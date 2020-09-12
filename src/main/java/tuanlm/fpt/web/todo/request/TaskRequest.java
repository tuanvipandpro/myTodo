/**
 * 
 */
package tuanlm.fpt.web.todo.request;

import javax.validation.constraints.NotBlank;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskRequest.
 *
 * @author Tuan
 */
public class TaskRequest {
	/** The content. */
	@NotBlank(message = "Content is blank")
	private String content;
	
	/** The date. */
	private String date;

	/**
	 * Instantiates a new task request.
	 */
	public TaskRequest() {

	}

	/**
	 * @param content
	 * @param date
	 */
	public TaskRequest(@NotBlank(message = "Content is blank") String content, String date) {
		this.content = content;
		this.date = date;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}
}
