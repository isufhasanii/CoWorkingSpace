package ch.zli.m223;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
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
                .body("size()", greaterThanOrEqualTo(0)); // Überprüfe, ob die Liste nicht leer ist
    }

}