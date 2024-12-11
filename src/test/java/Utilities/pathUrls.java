package Utilities;

public enum pathUrls {
	
	LoginpathApi("api/ecom/auth/login"),
	AddToCartpathApi("api/ecom/user/add-to-cart");
	
	private String url;
	
	private pathUrls(String url) {
		this.url = url;
	}
	
	public String getUrls() {
		return url;
	}
	

}
