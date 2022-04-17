package khanhppn;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;


public class GetMethod {
    public static void main(String[] args) {
        //Request scope
        RequestSpecification request = given();


        //Response scope
        final String FIRST_TODO = "/1";
        Response response = request.get(FIRST_TODO);

        request.baseUri("https://jsonplaceholder.typicode.com");
        request.basePath("/todos");
        response.then().body("userId", equalTo(1));
        response.then().body("id", equalTo(1));
        response.then().body("title", equalTo("delectus aut autem"));
    }
}
