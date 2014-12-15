/**
 * 
 */
package com.vectorsf.springmvc_base.admin.controller.forms;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author icasado
 *
 */
public class ProfileForm {
	
	@NotBlank
	private String name;
	private String description;
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
