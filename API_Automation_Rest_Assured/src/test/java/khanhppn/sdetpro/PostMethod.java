package khanhppn.sdetpro;

import com.google.gson.Gson;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.PostBody;

import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class PostMethod {
    public static void main(String[] args) {

        //Request specification object
        String baseUri = "https://jsonplaceholder.typicode.com";
        RequestSpecification request = given();
        request.baseUri(baseUri);

        //Content - type
        request.header(new Header("Content-type","application/json; charset=UTF-8"));

        //Form up request body
        // Gson
        Gson gson = new Gson();
        PostBody pB = new PostBody();
        pB.setUserId(1);
        pB.setId(1);
        pB.setTitle("The request title");
        pB.setBody("The request body");

        //Send POST request
        Response response =  request.body(gson.toJson(pB)).post("/posts");
        response.prettyPrint();


        System.out.println(response.statusCode());
        System.out.println(response.statusLine());


        //Verification
        response.then().statusCode(equalTo(201));
        response.then().statusLine(containsStringIgnoringCase("201 Created"));
        response.then().body("userId",equalTo(1));
        response.then().body("body", equalTo("The request body"));

        //Bulk action
    }
}
