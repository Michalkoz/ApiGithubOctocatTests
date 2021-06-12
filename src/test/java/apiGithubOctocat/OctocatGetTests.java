package apiGithubOctocat;

import base.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import octocat.Octocat;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OctocatGetTests extends BaseTest {

    @Test
    public void readOneUserNambedOctocatGetTest() {

        Octocat octocat1 = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + "/" + USERS + "/" + OCTOCAT)
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(Octocat.class);

        assertEquals(octocat1.getLogin(), "octocat");
        assertEquals(octocat1.getId(), 583231);
        assertEquals(octocat1.getNode_id(), "MDQ6VXNlcjU4MzIzMQ==");
        assertEquals(octocat1.isSite_admin(), false);
        assertEquals(octocat1.getBio(), null);
    }
}
