package api_test;

import Pages.LoginPage;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigFileReader;
import utils.Hooks;
import utils.ConfigFileReader;

public class WeatherApi_Automate {
    String latitude = "33.44";
    String longitude = "-94.04";
    Response response;
    static ConfigFileReader configFileReader;
    public WeatherApi_Automate() {
        configFileReader = new ConfigFileReader();
        RequestSpecification httpRequest = RestAssured.given().log().all();
        response = httpRequest
                .queryParam("lat", latitude)
                .queryParam("lon", longitude)
                .queryParam("appid", configFileReader.getAppId())
                .get(configFileReader.getAPIBaseUrl());
    }

    @Test
    public void weatherAPIStatus() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is 200");
    }

    @Test
    public void weatherAPIResponseBody() {
        ResponseBody responseBody = response.getBody();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String responseBodyAsString = responseBody.asString();
        String cityName = jsonPathEvaluator.get("name");
        Assert.assertTrue(responseBodyAsString.contains("weather") , "Response body contains weather key");
        Assert.assertTrue(responseBodyAsString.contains(latitude) , "Response body contains given latitude");
        Assert.assertTrue(responseBodyAsString.contains(longitude) , "Response body contains given longitude");
        Assert.assertEquals(cityName, "Texarkana", "Expected city name received");
    }

}

