package ru.weatherforecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class HealthCheck {
    //@Autowired
    //private HttpServletRequest request;

    @GetMapping(value = "/healthCheck")
    public String healthCheck() {
        return "healthCheck!";
    }

    @GetMapping(value = "/weatherTest")
    public String weatherTest() throws Exception  {
        //String APIUrl = System.getProperty("API_URL");
        String APIUrl = "https://api.weather.yandex.ru/v2/forecast";
        //APIUrl += "?lat=55°44′24.00″&lon=37°36′36.00″";

        StringBuilder result = new StringBuilder();
        URL url = new URL(APIUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        //conn.setRequestProperty("X-Yandex-API-Key", System.getProperty("API_URL"));
        conn.setRequestProperty("X-Yandex-API-Key", "36206828-9ac8-44c3-9ba0-4a2fe3f8ac63");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }

}
