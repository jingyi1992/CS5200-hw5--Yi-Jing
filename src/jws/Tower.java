package jws;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Entity implementation class for Entity: Tower
 *
 */


@Entity
@NamedQueries(value = { @NamedQuery(
		name = "findAllTowers",
		query = "select tower from Tower tower") })
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Tower implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	private int id;
	
	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private double height;
	
	@XmlAttribute
	private int sides;
	
	@ManyToOne
	@JoinColumn(name="siteId")
	@XmlTransient
	private Site site;
	
	@OneToMany(mappedBy="tower", cascade=CascadeType.ALL, orphanRemoval=true)
	@XmlElement(name="equipment")
	private List<Equipment> equipments;
	
	public Tower() {
		super();
	}

	public Tower(int id, String name, double height, int sides, Site site,
			List<Equipment> equipments) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.sides = sides;
		this.site = site;
		this.equipments = equipments;
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	
}
