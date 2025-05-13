package com.egg;

import io.restassured.RestAssured;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SimpleTests {
    @Test
    public void verifyStatusCode() {
        given().when().get("https://jsonplaceholder.typicode.com/posts/1").then().statusCode(200);
    }

    @Test
    public void verifyUserId() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .body("userId", equalTo(1));
    }

    @Test
    public void verifyContentTypeHeader() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .header("Content-Type", "application/json; charset=utf-8");
    }

    @Test
    public void postRequest() {
        String requestBody = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";
        given().contentType("application/json").body(requestBody).when()
                .post("https://jsonplaceholder.typicode.com/posts").then().statusCode(201).body("title", equalTo("foo"))
                .body("body", equalTo("bar")).body("userId", equalTo(1));
    }

    @Test
    public void ejercicio5() {
        given().when().get("https://jsonplaceholder.typicode.com/comments/5").then().statusCode(200);
    }
    
    @Test
    public void ejercicio6() {
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/todos/1")
                .then()
                .body("userId", equalTo(1));
    }

    @Test
    public void ejercicio7() {
        Integer numeroPost = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts?userId=1").jsonPath().getList("$").size();
        assertTrue(numeroPost>5);

    }





}
