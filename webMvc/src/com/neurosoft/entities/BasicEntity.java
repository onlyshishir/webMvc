/**
 * 
 */
package com.neurosoft.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author Adnan
 * 
 */
public abstract class BasicEntity {
	@Id
	@GeneratedValue(generator = "fdgen")
	@GenericGenerator(name = "fdgen", strategy = "hilo", parameters = {
			@Parameter(name = "table", value = "keys_table"),
			@Parameter(name = "column", value = "next_hi"),
			@Parameter(name = "max_lo", value = "100") })
	protected Long id;

	public Long getId() {
		return id;
	}

}
