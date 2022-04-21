package khanhppn;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.BuildModelJSON;
import model.PostBody;
import model.RequestCapability;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchMethod implements RequestCapability {

    public static void main(String[] args) {
        String baseUri = "https://jsonplaceholder.typicode.com";


        //Form up request instance, header and baseUri
        RequestSpecification request = given();
        request.baseUri(baseUri);
        request.header(defaultHeader);

        //Form up body
        PostBody postBody = new PostBody();
        postBody.setTitle("New Title");
        String postBodyStr = BuildModelJSON.parseJSONString(postBody);

        final String TARGET_POST_ID = "1";
        Response response = request.body(postBodyStr).patch("");

        //Verify body
        response.then().body("title",equalTo(postBody.getTitle()));

        response.prettyPrint();
    }
}
