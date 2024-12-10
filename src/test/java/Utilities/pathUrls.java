package Utilities;

public enum pathUrls {
	
	LoginpathApi("api/ecom/auth/login");
	
	private String pathUrls;
	
	private pathUrls(String pathUrls) {
		this.pathUrls = pathUrls;
	}
	
	public String getUrls() {
		return pathUrls;
	}
	

}
