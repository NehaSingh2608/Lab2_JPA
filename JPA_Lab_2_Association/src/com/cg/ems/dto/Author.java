package com.cg.ems.dto;

import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="author_master")
public class Author
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="auth_id",length=10)
	private int authId;
	@Column(name="auth_name",length=25)
	private String authName;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="book_author_table",
	joinColumns = {
			@JoinColumn(name="auth_id")},
	inverseJoinColumns=
			{@JoinColumn(name="ISBN_code")})
	Set<Book> authSet=new HashSet<>();
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
	public String getAuthName() {
		return authName;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	public Set<Book> getAuthSet() {
		return authSet;
	}
	public void setAuthSet(Set<Book> authSet) {
		this.authSet = authSet;
	}
	public Author(int authId, String authName, Set<Book> authSet) {
		super();
		this.authId = authId;
		this.authName = authName;
		this.authSet = authSet;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Author [authId=" + authId + ", authName=" + authName + ", authSet=" + authSet + "]";
	}
}
	