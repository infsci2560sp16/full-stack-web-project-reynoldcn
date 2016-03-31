package logicTier.dto;

import java.io.Serializable;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import logicTier.utils.ListUtil;

@XmlRootElement(name = "name")
public class Recipe implements Serializable {
	private static final long serialVersionUID = -5461373449802431627L;
	private String name;

	private boolean isHot;
	private int id;
	private ListBean ingredients;

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = Name;
	}



	@XmlElement
	public boolean isHot() {
		return isHot;
	}

	public void setHot(boolean isHot) {
		this.isHot = isHot;
	}

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public ListBean getIngredients() {
		return ingredients;
	}

	public void setIngredients(ListBean ingredients) {
		this.ingredients = ingredients;
	}

	public String toString() {
		return "{\"id\":" + this.id + ",\"name\":\"" + this.name + "\",\"isHot\":\""
				+ this.isHot + "\",\"ingredients\":\""
				+ ListUtil.getString(this.ingredients.getList()) + "\"}";
	}

}
