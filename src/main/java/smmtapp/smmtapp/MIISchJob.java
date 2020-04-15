package smmtapp.smmtapp;

public class MIISchJob {
	
	public String schid;
	public String name;
	public String path;
	public String pattern;
	
	public MIISchJob(){}
	
	public MIISchJob(String schid, String name, String path, String pattern){
	    
	    this.schid = schid;
	    this.name = name;
	    this.path = path;
	    this.pattern = pattern;
	   
	  }
	
	public String getSchid() {
		return schid;
	}
	public void setSchid(String schid) {
		this.schid = schid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	
	
}
