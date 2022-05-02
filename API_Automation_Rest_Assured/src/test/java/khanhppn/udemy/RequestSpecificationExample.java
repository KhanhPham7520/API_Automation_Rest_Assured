package khanhppn.udemy;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestSpecificationExample {

    RequestSpecification requestSpecification;


    @Test
    public void validate_Status_Code(){
        requestSpecification = given().
                baseUri("https://api.postman.com").
                header("X-Api-Key","PMAK-60fd5c0bcfe50b00688945c0-79574cf111b5c83a410a963ed80b30bb20");
        given(requestSpecification).
        when().
                get("/workspaces").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }
}
