/**
 * 
 */
package tuanlm.fpt.web.todo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


// TODO: Auto-generated Javadoc
/**
 * The Class Account.
 *
 * @author Tuan
 */

@Entity
public class Account implements Serializable {
	
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The username. */
	@Id
	@Column(name = "Username", nullable = false, length = 50)
	@NotBlank(message = "Username is empty !")
	private String username;
	
	/** The password. */
	@Column(name = "Password", nullable = false, length = 100)
	@NotBlank(message = "Password is empty !")
	private String password;
	
	/** The fullname. */
	@Column(name = "Fullname", nullable = false, length = 50)
	@NotBlank(message = "Fullname is empty !")
	private String fullname;
	
	/** The status id. */
	@Column(name = "Status_Id", nullable = false)
	private int status_id;
	
	/** The email. */
	@Column(name = "Email", nullable = false, length = 50)
	@NotBlank(message = "Email is empty !")
	@Email(message = "Email format is not correct !!!")
	private String email;

	/**
	 * Instantiates a new account.
	 */
	public Account() {
	}
	
	/**
	 * Instantiates a new account.
	 *
	 * @param username the username
	 * @param password the password
	 * @param fullname the fullname
	 * @param status_id the status id
	 * @param email the email
	 */
	public Account(String username, String password, String fullname, int status_id, String email) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.status_id = status_id;
		this.email = email;
	}
	
	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the username.
	 *
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the fullname.
	 *
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}
	
	/**
	 * Sets the fullname.
	 *
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	/**
	 * Gets the status id.
	 *
	 * @return the status_id
	 */
	public int getStatus_id() {
		return status_id;
	}
	
	/**
	 * Sets the status id.
	 *
	 * @param status_id the status_id to set
	 */
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}