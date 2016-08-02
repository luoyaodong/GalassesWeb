package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//ÊµÌåÀà×¢²á
@Entity
@Table(name = "t_glasses")
public class Glasses {

	@Id
	@GeneratedValue
	private int id;
	private int price;
	private String size;
	private String sex;
	private String name;
	private String image;
	
	@ManyToOne
	private GlassesBrand brand;
	
	@ManyToOne
	private GlassesColor color;
	
	@ManyToOne
	private GlassesType type;
	
	@ManyToOne
	private GlassesMaterial material;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public GlassesBrand getBrand() {
		return brand;
	}
	public void setBrand(GlassesBrand brand) {
		this.brand = brand;
	}
	public GlassesColor getColor() {
		return color;
	}
	public void setColor(GlassesColor color) {
		this.color = color;
	}
	public GlassesType getType() {
		return type;
	}
	public void setType(GlassesType type) {
		this.type = type;
	}
	public GlassesMaterial getMaterial() {
		return material;
	}
	public void setMaterial(GlassesMaterial material) {
		this.material = material;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
