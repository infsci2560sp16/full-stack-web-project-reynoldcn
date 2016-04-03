package logicTier.data;

import java.util.ArrayList;

public class Recipe {
	String id;
	String name;
	ArrayList<String> Ingredients;
	
	public Recipe(String id, String name, ArrayList<String> Ingredients){
		this.id = id;
		this.name = name;
		this.Ingredients = Ingredients;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getIngredients(){
		if(this.Ingredients.isEmpty())
			return "The Ingredients is a secret. Please edit it";
		String Ingstr = "";
		for(String food : Ingredients){
			Ingstr += food + ",";
		}
		return Ingstr.substring(0, Ingstr.length()-1);
	}	
	public void addIngredient(String Ingredient){
		this.Ingredients.add(Ingredient);
	}
	
	public String toJson(){
		String rcpJson = "";
		rcpJson = "{\n\t\"id\":\"" + this.id + "\",\n\t\"name\":\""
				+ this.name + "\",\n\t\"Ingredients\":\"" + getIngredients()
				+ "\"\n}";
		return rcpJson;
	}
	
	public String toXML(){
//		String rcpXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
//		rcpXml += "<recipe>\n";
//		rcpXml += "\t<id>" + this.id + "</id>\n";
//		rcpXml += "\t<name>" + this.name + "</name>\n";
//		rcpXml += "\t<ingredients>\n";
//		for(String food : Ingredients){
//			rcpXml += "\t\t<ingredient>" + food + "</ingredient>\n";
//		}
//		rcpXml += "\t</ingredients>\n";
//		rcpXml += "</recipe>";
		String rcpXml = "";
		rcpXml += "<recipe>";
		rcpXml += "<id>" + this.id + "</id>";
		rcpXml += "<name>" + this.name + "</name>";
		rcpXml += "<ingredients>";
		for(String food : Ingredients){
			rcpXml += "<ingredient>" + food + "</ingredient>";
		}
		rcpXml += "</ingredients>";
		rcpXml += "</recipe>";
		return rcpXml;
	}
	
	public String toXMLPrint(){
		String rcpXml = "\"<?xml version=\"1.0\" encoding=\"UTF-8\"?><br>";
		rcpXml += "<recipe><br>";
		rcpXml += "  <id>" + this.id + "</id><br>";
		rcpXml += "  <name>" + this.name + "</name><br>";
		rcpXml += "  <ingredients>\n";
		for(String food : Ingredients){
			rcpXml += "    <ingredient>" + food + "</ingredient><br>";
		}
		rcpXml += "  </ingredients><br>";
		rcpXml += "</recipe>\"";
		return rcpXml;
	}
	
	public static void main(String[] args){
		ArrayList<String> ing = new ArrayList<String>();
		String name = "Kung Pao Chicken";
		String id = "4";
		ing.add("Chicken");
		ing.add("Pepper");
		Recipe rcp = new Recipe(id, name, ing);
		System.out.println(rcp.getId());
		System.out.println(rcp.getName());
		System.out.println(rcp.getIngredients());
		System.out.println(rcp.toJson());
		System.out.println(rcp.toXML());
	}
	
	
}
