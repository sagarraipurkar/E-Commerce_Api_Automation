package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


import pojo.credentails;

public class Payloads {

	public static credentails cred;

	public credentails LoginPayload(String userEmail1, String userPassword1) {
		credentails cred = new credentails();
		cred.setUserEmail(userEmail1);
		cred.setUserPassword(userPassword1);
		return cred;
	}

	public static String addToCartPayload() {
		String payload = "{\r\n"
				+ "    \"_id\": \"66ffc3ccae2afd4c0b8ee658\",\r\n"
				+ "    \"product\": {\r\n"
				+ "        \"_id\": \"6749631dae2afd4c0bd1f7f8\",\r\n"
				+ "        \"productName\": \"ADIDAS ORIGINAL\",\r\n"
				+ "        \"productCategory\": \"household\",\r\n"
				+ "        \"productSubCategory\": \"shoes\",\r\n"
				+ "        \"productPrice\": 31500,\r\n"
				+ "        \"productDescription\": \"Adidas shoes for Men\",\r\n"
				+ "        \"productImage\": \"https://rahulshettyacademy.com/api/ecom/uploads/productImage_1650649488046.jpg\",\r\n"
				+ "        \"productRating\": \"0\",\r\n"
				+ "        \"productTotalOrders\": \"0\",\r\n"
				+ "        \"productStatus\": true,\r\n"
				+ "        \"productFor\": \"men\",\r\n"
				+ "        \"productAddedBy\": \"admin@gmail.com\",\r\n"
				+ "        \"__v\": 0\r\n"
				+ "    }\r\n"
				+ "}";
		return payload;
	
	}

}
