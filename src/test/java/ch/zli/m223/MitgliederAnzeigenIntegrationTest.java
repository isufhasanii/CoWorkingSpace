package ch.zli.m223;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MitgliederAnzeigenIntegrationTest {

    private static final String BASE_URL = "http://localhost:8080/";
    private static final String USERNAME = "adimin";
    private static final String PASSWORD = "8953";

    @BeforeAll
    public static void setup() {
        baseURI = BASE_URL;
        authentication = basic(USERNAME, PASSWORD);
    }

    @Test
    public void testIndexMitgliedEndpoint() {
        when()
                .get("/admin")
                .then()
                .statusCode(200)
                .body("size()", greaterThanOrEqualTo(0)); 
    }

}