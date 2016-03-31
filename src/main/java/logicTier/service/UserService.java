package logicTier.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import logicTier.dto.ListBean;
import logicTier.dto.Recipe;


@Service("userService")

public class UserService {

	@Autowired
	Recipe defaultRecipeInfo;

	List<Recipe> recipes = null;

	public UserService() {
		init();
	}
	
	public void addRecipe(Recipe rcp){
		recipes.add(rcp);
	}
	
	public Recipe createRecipe(String id, String name, String ingredients){
		Recipe rcp = new Recipe();
		int i = 0;
		try{
			i = Integer.parseInt(id);
		}catch(Exception e){
			return null;
		}
		rcp.setId(i);
		rcp.setName(name);
		String[] spliting = ingredients.split(",");
		List<String> ingredientslist = new ArrayList<String>();
		for(int j = 0; j < spliting.length; j++){
			ingredientslist.add(spliting[j]);
		}
		rcp.setIngredients(new ListBean(ingredientslist));
		recipes.add(rcp);
		return rcp;
	}
	private void init() {
		recipes = new ArrayList<Recipe>();
		Recipe rcp1 = new Recipe();

		rcp1.setId(1);
		rcp1.setName("Kung Pao Chicken");
		rcp1.setHot(true);

		List<String> ingredients = new ArrayList<String>();
		ingredients.add("chicken");
		ingredients.add("pepper");
		rcp1.setIngredients(new ListBean(ingredients));
		recipes.add(rcp1);

		Recipe rcp2 = new Recipe();

		rcp2.setId(2);
		rcp2.setName("Orange Chicken");
		rcp2.setHot(false);
		List<String> ingredients2 = new ArrayList<String>();
		ingredients2.add("orange");
		ingredients2.add("chicken");
		rcp2.setIngredients(new ListBean(ingredients2));
		recipes.add(rcp2);

	}

	public Recipe getUserInfo(int userId) {
		for (Recipe u : recipes) {
			if (u.getId() == userId) {
				return u;
			}
		}
		return defaultRecipeInfo;

	}

	public ListBean getAllUsers() {
		return new ListBean(recipes);
	}
}
