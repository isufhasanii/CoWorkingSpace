package ch.zli.m223;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.Test;

public class BuchungIntegrationTest {

    @Test
    public void testDeleteBuchungEndpoint() {
        given()
                .contentType("application/json")
                .body("{ \"datum\": \"2023-07-12\", \"zeitraum\": 1, \"mitglied\": { \"mitgliedId\": 1 }, \"raum\": { \"raumId\": 1 } }")
                .when()
                .post("/buchung")
                .then()
                .statusCode(201);

        given()
                .pathParam("buchungId", 1)
                .when()
                .delete("/buchung/{buchungId}")
                .then()
                .statusCode(204);
    }

    @Test
    public void testUpdateBuchungEndpoint() {
        given()
                .contentType("application/json")
                .body("{ \"datum\": \"2023-07-12\", \"zeitraum\": 1, \"mitglied\": { \"mitgliedId\": 1 }, \"raum\": { \"raumId\": 1 } }")
                .when()
                .post("/buchung")
                .then()
                .statusCode(201);

        given()
                .contentType("application/json")
                .pathParam("buchungId", 1)
                .body("{ \"datum\": \"2023-07-13\", \"zeitraum\": 2, \"mitglied\": { \"mitgliedId\": 1 }, \"raum\": { \"raumId\": 2 } }")
                .when()
                .put("/buchung/{buchungId}")
                .then()
                .statusCode(200);
    }
}