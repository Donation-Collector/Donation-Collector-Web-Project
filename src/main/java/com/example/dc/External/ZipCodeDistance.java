package com.example.dc.External;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class ZipCodeDistance {

    static final String APIKEY = "Jw8HU79QoBb4LJTY6QFYn0Ipskdfk32nLFHmhI2G29HgxG6vdK9tomzWibBsbkor";
    static final String FORMAT = "json";
    static final String UNITS = "km";

    public static int getDistance(int zipCode1, int zipCode2) {
        WebClient client = WebClient.create("http://www.zipcodeapi.com/rest/");
        WebClient.RequestBodySpec request =
                client
                .method(HttpMethod.GET)
                .uri(APIKEY+ "/distance." + FORMAT + "/" + zipCode1 + "/" + zipCode2 + "/" + UNITS);

        Exception e = new Exception();

        String response = request
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(response); // "distance":
        if (response.contains("distance")) {
            String s = response.replaceAll("[^0-9.]", "");
            double distance = Math.round(Double.parseDouble(s));
            return (int) distance;
        }
        else {
            return Integer.MAX_VALUE;
        }
    }
}
