package logicTier.web.controller;

import spark.template.freemarker.FreeMarkerEngine;
import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import logicTier.data.Recipe;
import logicTier.service.RecipeService;
import spark.ModelAndView;

public class RestController {
	RecipeService rcpService = new RecipeService();

	

	public RestController(){

		get("/recipe/json/:id",(req,res) ->{
			String id = req.params(":id");
			id = id.trim();
		    System.out.println(id);
			Map<String, Object> attributes = new HashMap<>();

			Recipe rcp = rcpService.getRecipeById(id);
			
		    System.out.println(id);
		    
		    System.out.println(rcpService.getRecipeById("1").toJson());
		    
		    if(rcp == null){
		    	rcp = new Recipe("THE RECIPE ID NOT FOUND", "null", new ArrayList<String>());
		    	System.out.println("nenene");
		    }
		    
		    attributes.put("results", rcp.toJson());
			attributes.put("method", "get");
			System.out.println(rcp.toJson());
			return new ModelAndView(attributes, "recipe.ftl");
		},new FreeMarkerEngine());
		
		get("/recipe/xml/:id",(req,res) ->{
			String id = req.params(":id");
			id = id.trim();
		    System.out.println(id);
			Map<String, Object> attributes = new HashMap<>();

			Recipe rcp = rcpService.getRecipeById(id);
			
		    System.out.println(id);
		    
		    System.out.println(rcpService.getRecipeById("1").toJson());
		    
		    if(rcp == null){
		    	rcp = new Recipe("null", "null", new ArrayList<String>());
		    	System.out.println("nenene");
		    }
		    attributes.put("xml", rcp.toXML());
		    attributes.put("results", rcp.toXML());
			System.out.println(rcp.toJson());
			return new ModelAndView(attributes, "recipe_xml.ftl");
		},new FreeMarkerEngine());
		
		post("/upload/recipe", (req, res) ->{
			String name = req.queryParams("name");
	  		String id = req.queryParams("id");
	  		String ingredients = req.queryParams("ingredients");

			String[] spliting = ingredients.split(",");
			
			ArrayList<String> ingredientslist = new ArrayList<String>();
			for(int j = 0; j < spliting.length; j++){
				ingredientslist.add(spliting[j]);
				System.out.println(spliting[j]);
				System.out.println(ingredientslist.get(j));
			}
			Recipe rcp = new Recipe(id, name, ingredientslist);
			System.out.println(rcp.getIngredients());
			rcpService.addRecipe(id, name, ingredientslist);
			Map<String, Object> attributes = new HashMap<>();
			System.out.println("add...");
			attributes.put("results", rcp.toJson());
			attributes.put("method", "post");
			System.out.println(rcp.toJson());
			return new ModelAndView(attributes, "recipe.ftl");
			//return rcp.toJson();
		}, new FreeMarkerEngine());
	}
	
	public static void main(String[] args){
		RecipeService test = new RecipeService();
		Recipe rcp = test.getRecipeById("1");
		System.out.println(rcp.toJson());
	}
}
