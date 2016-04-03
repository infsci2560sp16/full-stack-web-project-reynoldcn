import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;

import logicTier.service.RecipeService;
import logicTier.web.controller.RestController;
import logicTier.webWriter.*;

public class Main {

	public static void main(String[] args) {

		//test. Use .ftl to generate .html file
		try{
			FtlWriter accountfw = new FtlWriter("account");
			accountfw.setParam("wangzhuoqun", false, new String[]{"Pittsburgh", "PA", "Tele: 4153415605", "Zipcode: 15213"});
		}catch(Exception e){
			e.printStackTrace();
		}
		port(Integer.valueOf(System.getenv("PORT")));
		//port(8888);
		staticFileLocation("/public");
		
		//RESTFul get/post JSON, get XML
		RestController rc = new RestController();
		
	    get("/", (req, res) ->{
	    	Map<String, Object> attributes = new HashMap<>();
	        try {
	          attributes.put("userName", "wzq");
	          attributes.put("isLogin", false);
	          attributes.put("profile", new String[]{"Pittsburgh", "PA", "Tele: 4153415605", "Zipcode: 15213"});
	          return new ModelAndView(attributes, "index.ftl");
	        } catch (Exception e) {
	          attributes.put("message", "There was an error: " + e);
	          return new ModelAndView(attributes, "error.ftl");
	        } 
	    }, new FreeMarkerEngine());
	    get("/user/:user", (req, res) ->{
	    	Map<String, Object> attributes = new HashMap<>();
	    	String name = req.params(":user");
	        try {
	          attributes.put("userName", name);
	          attributes.put("isLogin", true);
	          attributes.put("profile", new String[]{"Pittsburgh", "PA", "Tele: 4153415605", "Zipcode: 15213"});
	          return new ModelAndView(attributes, "index.ftl");
	        } catch (Exception e) {
	          attributes.put("message", "There was an error: " + e);
	          return new ModelAndView(attributes, "error.ftl");
	        } 
	    }, new FreeMarkerEngine());
	    
	    get("/account", (req, res) ->{
	    	Map<String, Object> attributes = new HashMap<>();
	        try {
	          attributes.put("userName", "..");
	          attributes.put("isLogin", false);
	          attributes.put("profile", new String[]{"Pittsburgh", "PA", "Tele: 4153415605", "Zipcode: 15213"});
	          return new ModelAndView(attributes, "account.ftl");
	        } catch (Exception e) {
	          attributes.put("message", "There was an error: " + e);
	          return new ModelAndView(attributes, "error.ftl");
	        } 
	    }, new FreeMarkerEngine());
	    
	    
	    get("/account/:user", (req, res) ->{
	    	Map<String, Object> attributes = new HashMap<>();
	    	String name = req.params(":user");
	        try {
	          attributes.put("userName", name);
	          attributes.put("isLogin", true);
	          attributes.put("profile", new String[]{"Pittsburgh", "PA", "Tele: 4153415605", "Zipcode: 15213"});
	          return new ModelAndView(attributes, "account.ftl");
	        } catch (Exception e) {
	          attributes.put("message", "There was an error: " + e);
	          return new ModelAndView(attributes, "error.ftl");
	        } 
	    }, new FreeMarkerEngine());
	
	    get("/hello", (req, res) -> "Hello World");

	
	    


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
	
	  }

}
