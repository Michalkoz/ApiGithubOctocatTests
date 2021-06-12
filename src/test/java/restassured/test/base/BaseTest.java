package restassured.test.base;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    protected static final String BASE_URL = "https://api.github.com";
    protected static String USERS = "users";
    protected static String OCTOCAT = "octocat";


    protected static RequestSpecBuilder reqBuilder;
    protected static RequestSpecification reqSpec;
    public static Faker faker;

    @BeforeAll
    public static void beforeAll() {
        reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(ContentType.JSON);
        reqSpec = reqBuilder.build();
    }
}