package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//实体 类entity  和表对应
@Entity
@Table(name = "t_user")
public class User{
	//类的属性和表的字段对应\.
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String pwd;
	private int age;
	private String sex;
	private String phone;
	
	@ManyToOne
	private UserFaceType face;
	
	@OneToOne
	private Cart cart;

	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public UserFaceType getFace() {
		return face;
	}

	public void setFace(UserFaceType face) {
		this.face = face;
	}

	public User(){
		
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User(int id, String name, String pwd, int age) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


}
