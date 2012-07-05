package com.rif.juntadas.model;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * Meeting entity.
 *
 * @author rfalco
 */
@PersistenceCapable
public class Meeting {
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	@Persistent
    private String name;
	@Persistent
	private String description;
	@Persistent
    private Date date;
	@Persistent
    private UserGroup group;
	
	public Meeting(String name, String description, Date date) {
		this.name = name;
		this.description = description;
		this.date = date;
	}
	
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setGroup(UserGroup group) {
		this.group = group;
	}
	public UserGroup getGroup() {
		return group;
	}
	
}
