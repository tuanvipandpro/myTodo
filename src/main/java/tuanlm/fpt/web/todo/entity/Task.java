/**
 * 
 */
package tuanlm.fpt.web.todo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

/**
 * The Class Task.
 *
 * @author Tuan
 */
@Entity
public class Task implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int id;
	
	/** The username. */
	@Column(name = "username", nullable = false, length = 50)
	private String username;
	
	/** The content. */
	@NotBlank(message = "Content is empty !")
	@Column(name = "content", nullable = false, length = 500)
	private String content;
	
	/** The date. */
	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false)
	private Date date;
	
	/** The status id. */
	@Column(name = "status_id", nullable = false)
	private int statusId;

	/**
	 * 
	 */
	public Task() {}

	/**
	 * @param username
	 * @param content
	 * @param date
	 * @param statusId
	 */
	public Task(String username, String content, Date date, int statusId) {
		this.username = username;
		this.content = content;
		this.date = date;
		this.statusId = statusId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the status_id
	 */
	public int getStatusId() {
		return statusId;
	}

	/**
	 * @param status_id the status_id to set
	 */
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
}
