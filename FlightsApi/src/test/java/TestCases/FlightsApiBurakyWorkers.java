package TestCases;

import Base.TestBase;
import Constants.Constants;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import variables.Var;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FlightsApiBurakyWorkers extends TestBase implements Constants {

    @Test
    public void T01_TestScenario() throws IOException {


        logger.info("Get flights-api.buraky.workers - 200");

        Response request = (Response) given().given()
                .contentType("application/json")
                .when()
                .get(Var.apiUrl + ENDPOINT)
                .then()
                .statusCode(200).and().contentType("application/json")
                .assertThat().body("data.id", notNullValue())
                .assertThat().body("data.from", notNullValue())
                .assertThat().body("data.to", notNullValue())
                .assertThat().body("data.date", notNullValue())
                .assertThat().body("data.id[0]", equalTo(1))
                .assertThat().body("data.from[0]", equalTo("IST"))
                .assertThat().body("data.to[0]", equalTo("LAX"))
                .assertThat().body("data.date[0]", equalTo("2022-12-13"))
                .log().all().extract();

        String responseOutput=request.asString();
        io.restassured.path.json.JsonPath js=new io.restassured.path.json.JsonPath(responseOutput);

        logger.info("Check Response For Id As ALL INTEGER");
        List<Integer> allID  = js.get("data.id");
        boolean allIntegersForId = areAllIntegers(allID);
        if (allIntegersForId) {
            System.out.println("All ID values in the list are integers.");
        } else {
            System.out.println("Not ID all values in the list are integers.");
        }
        System.out.println("ID : " + allID );

        logger.info("Check Response For FROM As ALL STRING");
        List<String> allFROM  = js.get("data.from");
        boolean allStringForFrom = areAllStringsNonEmpty(allFROM);

        if (allStringForFrom) {
            System.out.println("All FROM values strings are non-empty.");
        } else {
            System.out.println("Not FROM values all strings are non-empty.");
        }
        System.out.println("FROM : " + allFROM );


        logger.info("Check Response For TO As ALL STRING");
        List<String> allTO  = js.get("data.to");
        boolean allStringForTO = areAllStringsNonEmpty(allTO);

        if (allStringForTO) {
            System.out.println("All TO values strings are non-empty.");
        } else {
            System.out.println("Not TO values all strings are non-empty.");
        }
        System.out.println("TO : " + allTO );

        logger.info("Check Response For DATE As ALL STRING");
        List<String> allDATE  = js.get("data.date");
        boolean allStringForDATE = areAllStringsNonEmpty(allDATE);

        if (allStringForDATE) {
            System.out.println("All DATE values strings are non-empty.");
        } else {
            System.out.println("Not DATE values all strings are non-empty.");
        }
        System.out.println("DATE : " + allDATE );


    }


}