package com.heroclone.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sample")
public class Sample {
	@Id
	private String name;
	
	@Column(name = "icon")
	private String icon;
	
	@Column(name = "walkable")
	private boolean walkable;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIcon() {
		return this.icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public boolean getWalkable() {
		return this.walkable;
	}
	
	public void setWalkable(boolean walkable) {
		this.walkable = walkable;
	}
}
