package jws;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Entity implementation class for Entity: Equipment
 *
 */


@Entity
@NamedQueries(value = { @NamedQuery(
		name = "findAllEquipment",
		query = "select equipment from Equipment equipment") })
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)

public class Equipment implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	private int id;
	
	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private String brand;
	
	@XmlAttribute
	private String description;
	
	@XmlAttribute
	private int price;
	
	@ManyToOne
	@JoinColumn(name="towerId")
	@XmlTransient
	private Tower tower;
	
	public Equipment() {
		super();
	}

	public Equipment(int id, String name, String brand, String description,
			int price, Tower tower) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.tower = tower;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Tower getTower() {
		return tower;
	}

	public void setTower(Tower tower) {
		this.tower = tower;
	}

   
}
