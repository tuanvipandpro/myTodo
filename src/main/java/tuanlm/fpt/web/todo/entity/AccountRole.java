/**
 * 
 */
package tuanlm.fpt.web.todo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountRole.
 *
 * @author Tuan
 */

@Entity
public class AccountRole implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** The username. */
	@Column(name = "Username", length = 50, nullable = false)
	private String username;
	
	/** The role id. */
	@Column(name = "Role_Id", nullable = false)
	private int role_id;
	
	
	/**
	 * Instantiates a new account role.
	 *
	 * @param username the username
	 * @param role_id the role id
	 */
	public AccountRole(String username, int role_id) {
		this.username = username;
		this.role_id = role_id;
	}

	/**
	 * Instantiates a new account role.
	 */
	public AccountRole() {
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * Gets the role id.
	 *
	 * @return the role_id
	 */
	public int getRole_id() {
		return role_id;
	}
	
	/**
	 * Sets the role id.
	 *
	 * @param role_id the role_id to set
	 */
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
}
