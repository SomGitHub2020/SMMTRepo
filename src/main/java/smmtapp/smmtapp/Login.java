package smmtapp.smmtapp;

public class Login {

	private String ip;
	private int port;
	private String user;
	private String password;
	private String stringURL;


	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStringURL() {
		return stringURL;
	}

	public void setStringURL(String stringURL) {
		this.stringURL = "http://"+ ip + ":" + port + "/XMII/Illuminator?service=scheduler&mode=List&content-type=text/xml&IllumLoginName=" + user + "&IllumLoginPassword=" + password;;
	}

}
