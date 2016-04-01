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
import logicTier.webWriter.*;

public class Main {

  public static void main(String[] args) {

    //port(Integer.valueOf(System.getenv("PORT")));
	port(8888);
    staticFileLocation("/public");

    get("/hello", (req, res) -> "Hello World");
    //Test FreeMarker using index.html & account.html
    try{
		FtlWriter indexfw = new FtlWriter("index");
		indexfw.setParam("wzq", true, new String[]{"Pittsburgh", "PA", "Tele: 4153415605", "Zipcode: 15213"});
	}catch(Exception e){
		e.printStackTrace();
	}
	
	try{
		FtlWriter accountfw = new FtlWriter("account");
		accountfw.setParam("wangzhuoqun", true, new String[]{"Pittsburgh", "PA", "Tele: 4153415605", "Zipcode: 15213"});
	}catch(Exception e){
		e.printStackTrace();
	}


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
