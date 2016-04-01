package logicTier.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "list")
//Transfer list to XML
public class ListBean {

	public ListBean() {
	}

	public ListBean(List<?> list) {
		this.list = list;
	}

	private List<?> list;

	@XmlElements({ @XmlElement(name = "name", type = Recipe.class),
			@XmlElement(name = "Ingredients", type = String.class)
	})
	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
}
