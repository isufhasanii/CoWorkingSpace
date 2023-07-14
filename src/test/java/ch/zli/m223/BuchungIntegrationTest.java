package ch.zli.m223;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.Test;

public class BuchungIntegrationTest {

    @Test
    public void testDeleteBuchungEndpoint() {
        // Erstellen einer Buchung vor dem Löschen
        given()
                .contentType("application/json")
                .body("{ \"datum\": \"2023-07-12\", \"zeitraum\": 1, \"mitglied\": { \"mitgliedId\": 1 }, \"raum\": { \"raumId\": 1 } }")
                .when()
                .post("/api/buchung")
                .then()
                .statusCode(201);

        // Löschen der erstellten Buchung
        given()
                .pathParam("buchungId", 1)
                .when()
                .delete("/api/buchung/{buchungId}")
                .then()
                .statusCode(204);
    }

    @Test
    public void testUpdateBuchungEndpoint() {
        // Erstellen einer Buchung vor der Aktualisierung
        given()
                .contentType("application/json")
                .body("{ \"datum\": \"2023-07-12\", \"zeitraum\": 1, \"mitglied\": { \"mitgliedId\": 1 }, \"raum\": { \"raumId\": 1 } }")
                .when()
                .post("/api/buchung")
                .then()
                .statusCode(201);

        // Aktualisieren der erstellten Buchung
        given()
                .contentType("application/json")
                .pathParam("buchungId", 1)
                .body("{ \"datum\": \"2023-07-13\", \"zeitraum\": 2, \"mitglied\": { \"mitgliedId\": 1 }, \"raum\": { \"raumId\": 2 } }")
                .when()
                .put("/api/buchung/{buchungId}")
                .then()
                .statusCode(200);
    }
}