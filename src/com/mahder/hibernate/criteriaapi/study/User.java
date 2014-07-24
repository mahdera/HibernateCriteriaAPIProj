/**
 * 
 */
package com.mahder.hibernate.criteriaapi.study;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author alemayehu
 *
 */
@Entity
@Table(name="TBL_USER")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int id;
	
	@Column(name="FULL_NAME")
	private String fullName;
	
	public User(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}//end class
