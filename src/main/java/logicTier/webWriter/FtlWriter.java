package logicTier.webWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import set.Path;

public class FtlWriter {
	private Configuration conf;
	private Template t;
	private String filename;
	public FtlWriter(String filename) throws IOException{
		conf = new Configuration();
		conf.setDirectoryForTemplateLoading(new File(Path.ftldir));
		this.filename = filename;
		t = conf.getTemplate(filename + ".ftl");
	}
	

	public void setParam(String userName, boolean isLogin, String[] profile) throws TemplateException, IOException{
		Map datamap=new HashMap();
		datamap.put("userName", userName);
		datamap.put("isLogin", isLogin);
		datamap.put("profile", profile);
		t.process(datamap, new FileWriter(Path.htmldir + filename + ".html"));
	}

	
}
