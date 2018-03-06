package com.restAPi.RestAssured;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.http.pool.PoolStats;
import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class RestApiTest {


//	@Test
//	public void getTest() {
//		String rqsturl = "https://reqres.in/api/users?page=2"; 
//		Response resp = RestAssured.get(rqsturl);
//		int code = resp.getStatusCode();
//		System.out.println("Statut Code is: "+ code);
//		Assert.assertEquals(code, 201);
//		
//		String data = resp.asString();
//		System.out.println("Data is" +data);
//		ResponseBody respBody = resp.getBody();
//		System.out.println("Body is: " +respBody.asString());
//		
//		String body = respBody.asString();
//		Assert.assertEquals(body.contains("Eve"), true);
//		
//		JsonPath jsonPathValues = resp.jsonPath();
//		int total = jsonPathValues.get("total");
//		System.out.println("Total as per Response: " +total);
//		
//		int id = jsonPathValues.get("data[0].id");
//		System.out.println("Data as per Response: " +id);
//		
//		String fName = jsonPathValues.getString("data[0].first_name");
//		System.out.println("First Name is :" +fName);
//	}
//	
	@Test(priority = 1)
	public void postTest() {
		String rqsturl = "https://reqres.in/api/users";
		RequestSpecification request = RestAssured.given();
				
		JSONObject postPrm = new JSONObject();
		postPrm.put("name", "Faisal K");
		postPrm.put("job" ,"Tester");
		
		request.header("Content-Type", "application/json");
		request.body(postPrm.toJSONString());
		
		Response resp = request.post(rqsturl);
		
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		
		System.out.println("Post Test!!");
		JsonPath jsonPathValues = resp.jsonPath();
		String name = jsonPathValues.getString("name");
		Assert.assertEquals(name, "Faisal K");
		System.out.println("Name is :" +name);
		String job = jsonPathValues.getString("job");
		Assert.assertEquals(job, "Tester");
		System.out.println("Job is: "+ job);
	}

	
	@Test(priority = 2)
	public void putTest() {
		String rqsturl = "https://reqres.in/api/users/2";
		RequestSpecification request = RestAssured.given();
				
		JSONObject postPrm = new JSONObject();
		postPrm.put("name","Wasiq Bhamla" );
		postPrm.put("job" ,"Sr. Tester");
		
		request.header("Content-Type", "application/json");
		request.body(postPrm.toJSONString());
		
		Response resp = request.put(rqsturl);
		
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		System.out.println("Put Test!!");
		JsonPath jsonPathValues = resp.jsonPath();
		String name = jsonPathValues.getString("name");
		System.out.println("Name is :" +name);
		Assert.assertEquals(name, "Wasiq Bhamla");
		String job = jsonPathValues.getString("job");
		System.out.println("Job is: " +job);
		Assert.assertEquals(job, "Sr. Tester");
	}
	
	@Test(priority = 3)
	public void deleteTest() {
		String rqsturl = "https://reqres.in/api/users/2";
		RequestSpecification request = RestAssured.given();
			
		request.header("Content-Type", "application/json");
		Response resp = request.delete(rqsturl);
		
		System.out.println("Delete Test!!");
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 204);
	
}
}