import static javax.measure.unit.SI.KILOGRAM;
import javax.measure.quantity.Mass;
import org.jscience.physics.model.RelativisticModel;
import org.jscience.physics.amount.Amount;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.net.URI;
import java.net.URISyntaxException;
import org.json.JSONObject;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import spark.Route;



import com.heroku.sdk.jdbc.DatabaseUrl;

import logicTier.dto.ListBean;
import logicTier.dto.Recipe;
import logicTier.service.UserService;
import logicTier.utils.JsonUtil;
import logicTier.utils.ResponseTransformer;
import logicTier.web.controller.HomeController;
import logicTier.web.controller.RestController;
import logicTier.ftlWriter.*;
import com.google.gson.Gson;
public class Main {

  public static void main(String[] args) {


	try{
		FtlWriter indexfw = new FtlWriter("index");
		indexfw.setParam("zzzz", true, new String[]{"Pittsburgh", "PA", "Tele: 4153415605", "Zipcode: 15213"});
	}catch(Exception e){
		e.printStackTrace();
	}
	
	try{
		FtlWriter accountfw = new FtlWriter("account");
		accountfw.setParam("wangzhuoqun", true, new String[]{"Pittsburgh", "PA", "Tele: 4153415605", "Zipcode: 15213"});
	}catch(Exception e){
		e.printStackTrace();
	}
	try{
		port(Integer.valueOf(System.getenv("PORT")));
	}catch(Exception e){
		port(8888);
	}
    staticFileLocation("/public");
    
    UserService usrServ = new UserService();
    HomeController hc = new HomeController();

    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());
    Gson gson = new Gson();

    get("/recipe/json/:id",(request,response) ->{
        RestController rc = new RestController(new UserService());
        String id = request.params(":id");
        int i = 0;
        try{
        	i = Integer.parseInt(id);
        	System.out.println(i);
        }catch(Exception e){
        	i = 1;
        	System.out.println("error");
        	response.status(400);
        }       
        Recipe rcpInfo = rc.show(i,request,response);
        System.out.println(rcpInfo.toString());
        Map<String, Object> attributes = new HashMap<>();
       // attributes.put("results", gson.toJson(rcpInfo));
        attributes.put("results", rcpInfo.toString());

        return new ModelAndView(attributes, "recipe.ftl");
      }, new FreeMarkerEngine());
    
    
    
    get("/recipe/list",(request,response) ->{
        RestController rc = new RestController(new UserService());
        ListBean rcpInfo = rc.getAll(request,response);
        System.out.println(rcpInfo.toString());        
        return rcpInfo;
      }, gson::toJson);
    

    post("/upload/recipe", (req, res) -> {
  		  String name = req.queryParams("name");
  		  String id = req.queryParams("id");
  		  String ingredients = req.queryParams("ingredients");
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
		usrServ.addRecipe(rcp);
		return rcp;

  		}, gson::toJson);

  	}
  

}
