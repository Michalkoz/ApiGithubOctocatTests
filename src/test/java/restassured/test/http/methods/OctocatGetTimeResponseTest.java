package restassured.test.http.methods;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;
import restassured.test.base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OctocatGetTimeResponseTest extends BaseTest {

    @BeforeClass
    public void setupConfiguration() {

        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType("application/json").build();
        RestAssured.responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).build();
    }

    @Test
    public void givenExistingUserWhenGetUserOctocatThenReturnOctocatUserTimeResponseTest() {

        long responseTime = given()
                .when()
                .get(BASE_URL + "/" + USERS + "/" + OCTOCAT)
                .then()
                .extract()
                .time();

        System.out.println("Response time is " + responseTime + " ms");
        assertTrue(responseTime <= 1000, "Response Time is less than avarage time that equals 615 ms");
    }
}
