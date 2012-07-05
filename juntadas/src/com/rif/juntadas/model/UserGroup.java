package com.rif.juntadas.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Order;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * Every 
 * @author rfalco
 *
 */
@PersistenceCapable
public class UserGroup {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	@Persistent
    private String name;
	
	@Persistent
	private String description;
	
	@Persistent(mappedBy = "group")
	@Order(extensions = @Extension(vendorName="datanucleus",key="list-ordering", value="date asc, name asc"))
    private List<Meeting> meetings = new ArrayList<Meeting>();
	
	@Persistent
    private Date creationDate;
	
	public UserGroup(String name, String description) {
		this.name = name;
		this.description = description;
		this.creationDate = new Date();
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
	public void setMeetings(List<Meeting> meetingsSets) {
		this.meetings = meetingsSets;
	}
	public List<Meeting> getMeetings() {
		return meetings;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

}
