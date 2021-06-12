package restassured.test.http.methods;

import restassured.test.base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OctocatGetTimeResponseTest extends BaseTest {

    @Test
    public void givenExistingUserWhenGetUserOctocatThenReturnOctocatUserTimeResponseTest() {

        long responseTime = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + "/" + USERS + "/" + OCTOCAT)
                .then()
                .statusCode(SC_OK)
                .extract()
                .time();

        System.out.println("Response time is " + responseTime + " ms");
        assertTrue(responseTime <= 1000, "Response Time is less then 615 ms");
    }
}
