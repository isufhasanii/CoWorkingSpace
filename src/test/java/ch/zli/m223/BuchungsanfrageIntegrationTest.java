package ch.zli.m223;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BuchungsanfrageIntegrationTest {

    private static final String BASE_URL = "http://localhost:8080/";
    private static final String USERNAME = "adimin";
    private static final String PASSWORD = "8953";

    @BeforeAll
    public static void setup() {
        baseURI = BASE_URL;
        authentication = basic(USERNAME, PASSWORD);
    }

    @Test
    public void testUpdateBuchungsanfrageStatusEndpoint() {
        given()
                .contentType(ContentType.JSON)
                .pathParam("buchungsanfrageId", 1)
                .body("{ \"status\": \"bestätigt\", \"buchungsanfrage\": { \"anfrageId\": 1, \"datum\": \"2023-07-12\", \"status\": \"offen\", \"member\": { \"mitgliedId\": 1 }, \"raum\": { \"raumId\": 1 } } }")
                .when()
                .put("/buchungsanfragen/{buchungsanfrageId}")
                .then()
                .statusCode(200)
                .body("status", equalTo("bestätigt"));
    }

}