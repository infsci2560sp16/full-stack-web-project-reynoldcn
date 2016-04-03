package logicTier.service;

import java.util.ArrayList;

import logicTier.data.Recipe;

public class RecipeService {
	ArrayList<Recipe> list = new ArrayList<Recipe>();
	public RecipeService(){
		ArrayList<String> ing = new ArrayList<String>();
		ing.add("Chicken");
		ing.add("Pepper");
		this.list.add(new Recipe("1", "Kung Pao Chicken", ing));
		ing = new ArrayList<String>();
		ing.add("Chicken");
		ing.add("Orange");
		this.list.add(new Recipe("2", "Orange Chicken", ing));		
	}
	
	public Recipe getRecipeById(String id) throws NullPointerException{
		for(Recipe rcp : this.list){
			if(rcp.getId().equals(id)){
				return rcp;
			}
		}
		return null;
	}
	
	public void addRecipe(String id, String name, ArrayList<String> ing){
		list.add(new Recipe(id, name, ing));
	}
	
	public void addRecipe(Recipe rcp){
		list.add(rcp);
	}

}
