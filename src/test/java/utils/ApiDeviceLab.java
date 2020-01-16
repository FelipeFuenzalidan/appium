package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiDeviceLab {

    /**
     * Execute the rest services
     * @param endpoint rest url
     * @return response ion format json
     */
    private static Response executeServices(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;

        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get("https://api.opendevicelab.com/" + endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }

    /**
     * Get value of the key in the json
     * @param endpoint rest url
     * @param key key the json
     * @return value the specific key in the json
     */
    public static String getValueOfKeyResponse(String endpoint, String key) {
        return ApiDeviceLab.executeServices(endpoint).jsonPath().getString(key);
    }




}
