package api_test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WeatherApi_Automate {

    @Test
    void getWeatherDetails() {
        RequestSpecification httpRequest = RestAssured.given().log().all();
        Response response = httpRequest
                .queryParam("lat", 33.44)
                .queryParam("lon", -94.04)
                // .queryParam("exclude", "111")
                .queryParam("appid", "1352c54c4c3647a344ed7368fa120dec")
                .get("https://api.openweathermap.org/data/2.5/weather");
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is :" + responseBody);
        int statusCode = response.getStatusCode();
        System.out.println("status code is :" + statusCode);
        Assert.assertEquals(statusCode, 200);
    }

}

