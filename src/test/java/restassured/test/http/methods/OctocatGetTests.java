package restassured.test.http.methods;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import properties.EnvironmentConfig;
import restassured.test.base.BaseTest;
import pojo.user.Octocat;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OctocatGetTests extends BaseTest {

    @BeforeMethod
    public void setupConfiguration(){
        EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

        RestAssured.baseURI = environmentConfig.baseUri();
        RestAssured.basePath = environmentConfig.basePath();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType("application/json").build();
        RestAssured.responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).build();
    }

    @Test
    public void givenExistingUserWhenGetUserOctocatThenReturnOctocatUserTest() {

        Octocat octocat1 = given()
                .when()
                .get(USERS + "/" + OCTOCAT)
                .then()
                .extract()
                .as(Octocat.class);

        assertEquals(octocat1.getLogin(), "octocat");
        assertEquals(octocat1.getId(), 583231);
        assertEquals(octocat1.getNode_id(), "MDQ6VXNlcjU4MzIzMQ==");
        assertEquals(octocat1.isSite_admin(), false);
        assertEquals(octocat1.getBio(), null);
    }

}
