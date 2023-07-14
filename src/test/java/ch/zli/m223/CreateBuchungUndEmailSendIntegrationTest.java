package ch.zli.m223;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class CreateBuchungUndEmailSendIntegrationTest {

    @Test
    public void testCreateBuchungWithEmailNotification() {
        given()
                .contentType("application/json")
                .body("{ \"datum\": \"2023-07-12\", \"zeitraum\": 1, \"mitglied\": { \"mitgliedId\": 1, \"vorname\": \"John\", \"nachname\": \"Doe\", \"email\": \"johndoe@example.com\", \"passwort\": \"secret\" }, \"raum\": { \"raumId\": 1, \"name\": \"Meeting Room\" } }")
                .when()
                .post("/buchung")
                .then()
                .statusCode(200)
                .body("datum", equalTo("2023-07-12"))
                .body("zeitraum", equalTo(1))
                .body("mitglied.vorname", equalTo("John"))
                .body("mitglied.nachname", equalTo("Doe"))
                .body("mitglied.email", equalTo("johndoe@example.com"))
                .body("mitglied.passwort", equalTo("secret"))
                .body("raum.name", equalTo("Meeting Room"))
                .body("emailSent", equalTo(true)); // Überprüfe, ob die E-Mail gesendet wurde
    }
}