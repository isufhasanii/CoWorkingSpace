package ch.zli.m223;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MitgliederVerwaltungIntegrationTest {

    private static final String BASE_URL = "http://localhost:8080/api";
    private static final String USERNAME = "adimin";
    private static final int PASSWORD = 8953;

    @BeforeAll
    public static void setup() {
        baseURI = BASE_URL;
        authentication = basic(USERNAME, PASSWORD);
    }

    @Test
    public void testDeleteMitgliedEndpoint() {
        given()
                .contentType(ContentType.JSON)
                .pathParam("mitgliedId", 1)
                .when()
                .delete("/admin/{mitgliedId}")
                .then()
                .statusCode(204);
    }

    @Test
    public void testUpdateMitgliedEndpoint() {
        given()
                .contentType(ContentType.JSON)
                .pathParam("mitgliedId", 1)
                .body("{ \"vorname\": \"Max\", \"nachname\": \"Mustermann\", \"email\": \"max.mustermann@example.com\", \"passwort\": \"password\" }")
                .when()
                .put("/admin/{mitgliedId}")
                .then()
                .statusCode(200)
                .body("vorname", equalTo("Max"))
                .body("nachname", equalTo("Mustermann"))
                .body("email", equalTo("max.mustermann@example.com"))
                .body("passwort", equalTo("password"));
    }

}