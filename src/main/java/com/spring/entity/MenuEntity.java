package com.spring.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "menu")
public class MenuEntity implements Serializable {

	private static final long serialVersionUID = -8716709783255197601L;

	@Id
	@Column(name = "menu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menuId;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "price", nullable = false, precision = 2)
	private double price;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "recommended")
	@Type(type = "numeric_boolean")
	private boolean isRecommended;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "menu_keyword_map",
			joinColumns = {@JoinColumn(name = "menu_id")},
			inverseJoinColumns = {@JoinColumn(name = "keyword_id")})
	private Set<MenuKeywordEntity> keywords = new LinkedHashSet<MenuKeywordEntity>();

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsRecommended() {
		return isRecommended;
	}

	public void setRecommended(boolean isRecommended) {
		this.isRecommended = isRecommended;
	}

	public boolean isRecommended() { return isRecommended; }

	public Set<MenuKeywordEntity> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<MenuKeywordEntity> keywords) {
		this.keywords = keywords;
	}
	
}
