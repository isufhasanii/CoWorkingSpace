package ch.zli.m223;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class AuthIntegrationTest {

    @Test
    public void testRegistrationEndpoint() {
        given()
                .contentType("application/json")
                .body("{ \"vorname\": \"Max\", \"nachname\": \"Mustermann\", \"email\": \"max@example.com\", \"passwort\": \"pass123\" }")
                .when()
                .post("/register")
                .then()
                .statusCode(201);
    }

    @Test
    public void testAuthenticationEndpoint() {
        // Registrierung eines Mitglieds vor der Authentifizierung
        given()
                .contentType("application/json")
                .body("{ \"vorname\": \"Max\", \"nachname\": \"Mustermann\", \"email\": \"max@example.com\", \"passwort\": \"pass123\" }")
                .when()
                .post("/register")
                .then()
                .statusCode(201);

        // Authentifizierung mit den registrierten Anmeldedaten
        given()
                .contentType("application/json")
                .body("{ \"email\": \"max@example.com\", \"passwort\": \"pass123\" }")
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body("accessToken", not(emptyOrNullString()));
    }

    @Test
    public void testRegistrationWithInvalidData() {
        // Registrierung mit fehlenden Pflichtfeldern
        given()
                .contentType("application/json")
                .body("{ \"vorname\": \"Max\", \"nachname\": \"Mustermann\", \"passwort\": \"pass123\" }")
                .when()
                .post("/register")
                .then()
                .statusCode(404);
    }

    @Test
    public void testAuthenticationWithInvalidCredentials() {
        // Authentifizierung mit falschen Anmeldedaten
        given()
                .contentType("application/json")
                .body("{ \"email\": \"max@example.com\", \"passwort\": \"wrongpassword\" }")
                .when()
                .post("/login")
                .then()
                .statusCode(404);
    }
}