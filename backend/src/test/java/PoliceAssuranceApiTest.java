import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PoliceAssuranceApiTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    @Order(2)
    public void testListerPolices() {
        given()
                .contentType(ContentType.JSON)
                .queryParam("page", 0)
                .queryParam("size", 10)
            .when()
                .get("/api/polices")
            .then()
                .statusCode(200)
                .body("content", hasSize(greaterThan(1)))
                .body("totalElements", greaterThan(1))
                .body("numberOfElements", greaterThan(1));
    }

    @Test
    @Order(1)
    public void testCreerPolice() {
        String requestBody = "{\"nom\": \"Assurance Auto\", \"status\": \"ACTIVE\", \"dateDebutCouverture\": \"2023-01-01\", \"dateFinCouverture\": \"2024-01-01\"}";

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
            .when().post("/api/polices")
            .then().statusCode(200);
    }

    @Test
    public void testLirePolice() {
        given()
            .when().get("/api/polices/1")
            .then().statusCode(200);
    }

    @Test
    public void testEditerPolice() {
        String requestBody = "{\"nom\": \"Assurance Maison\", \"status\": \"INACTIVE\", \"dateDebutCouverture\": \"2023-01-01\", \"dateFinCouverture\": \"2024-01-01\"}";

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
            .when().put("/api/polices/1")
            .then().statusCode(200);
    }
}
