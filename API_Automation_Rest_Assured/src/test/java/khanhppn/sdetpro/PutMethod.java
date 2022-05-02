package khanhppn.sdetpro;

import com.google.gson.Gson;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.PostBody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutMethod {

    public static void main(String[] args) {
        String baseUri = "https://jsonplaceholder.typicode.com";
        RequestSpecification request = given();
        request.baseUri(baseUri);
        request.header(new Header("Content-type", "application/json"));

        //Construct Body
        PostBody postBody = new PostBody();
        postBody.setId(1);
        postBody.setUserId(1);
        postBody.setTitle("New Titile");
        postBody.setBody("New Body");

        Gson gson = new Gson();
        String postBodyStr = gson.toJson(postBody);
        //Send Request
        final int TARGET_POST_NUM = 1;
        Response response = request.body(postBodyStr).put("/posts/".concat(String.valueOf(TARGET_POST_NUM)));
        response.then().body("title",equalTo(postBody.getTitle()));
        response.then().body("body",equalTo(postBody.getBody()));
        response.then().body("id",equalTo(postBody.getId()));
        response.then().body("userId",equalTo(postBody.getUserId()));
        response.prettyPrint();
    }
}
