import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTest {

    @Test
    public void makeSureThatGoogleIsUp() {
        Response res = given().when().get("http://localhost:3000/posts");
        int code = res.getStatusCode();

        if (code == 200){
            System.out.println("Response code:"+code);
        }

        System.out.println(res.getBody().prettyPrint());
    }

}