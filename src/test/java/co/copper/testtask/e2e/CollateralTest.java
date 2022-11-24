package co.copper.testtask.e2e;

import java.io.File;
import java.util.Map;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CollateralTest {
    File assetJson = new File("src/test/java/co/copper/testtask/e2e/data/asset.json");
    String appUrl = System.getenv("APP_URL");

    @Test
    @DisplayName("POST collateral with type 'asset' should be correctly saved ")
    public void testPostCollateralWithCorrectPayload() {
        String id = given()
                .header("Content-Type", "application/json")
                .body(assetJson)
                .when()
                .post(appUrl + "/collaterals/")
                .then()
                .statusCode(200)
                .log()
                .body().extract().asString();

        Map expectedResponseBody = (new JsonPath(assetJson)).getMap("");
        expectedResponseBody.put("id", Integer.valueOf(id));

        given()
                .when()
                .get(appUrl + "/collaterals/" + id)
                .then()
                .statusCode(200)
                .body("", equalTo(expectedResponseBody));
    }

    @Test
    @DisplayName("POST collateral with incorrect payload")
    public void testPostCollateralWithIncorrectPayload() {
        given()
                .header("Content-Type", "application/json")
                .body("{\"test\":\"json\"}")
                .when()
                .post(appUrl + "/collaterals/")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("GET not existing collateral")
    public void testGetNotExistingCollateral() {
        String notExistingCollateralId = "11111111";
        given()
                .when()
                .get(appUrl + "/collaterals/" + notExistingCollateralId)
                .then()
                .statusCode(404)
                .log().body();
    }

    @Test
    @DisplayName("GET not existing collateral")
    public void testGetCollateralByIdInStringType() {
        String incorrectTypeId = "abc";
        given()
                .when()
                .get(appUrl + "/collaterals/" + incorrectTypeId)
                .then()
                .statusCode(400);
    }
}
