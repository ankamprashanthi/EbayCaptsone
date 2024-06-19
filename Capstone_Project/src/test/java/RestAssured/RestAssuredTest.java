package RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;

public class RestAssuredTest {

    @Before
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGetUserById() {
        given()
            .when()
                .get("/users/1")
            .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("username", not(empty()))
                .body("email", containsString("@"))
                .log().all();
    }

    @Test
    public void testCreateUser() {
        String newUser = "{\"name\":\"Prashanthi Ankam\", \"username\": \"Prashathi\",\"email\": \"prashanthi@gmail.com\"}";

        given()
            .contentType("application/json")
            .body(newUser)
            .when()
                .post("/users")
            .then()
                .statusCode(201)
                .body("name", equalTo("Prashanthi Ankam"))
                .body("username", equalTo("Prashathi"))
                .body("email", equalTo("prashanthi@gmail.com"))
                .log().all();
    }
}
