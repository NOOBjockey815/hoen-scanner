package com.skyscanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skyscanner.models.SearchResult;
import com.skyscanner.resources.SearchResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HoenScannerApplication extends Application<HoenScannerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HoenScannerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hoen-scanner";
    }

    @Override
    public void initialize(final Bootstrap<HoenScannerConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(final HoenScannerConfiguration configuration,
                    final Environment environment) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        List<SearchResult> searchResults = new ArrayList<>();

        // Load rental cars
        List<SearchResult> cars = mapper.readValue(
                new File("src/main/resources/rental_cars.json"),
                new TypeReference<List<SearchResult>>() {}
        );
        searchResults.addAll(cars);

        // Load hotels
        List<SearchResult> hotels = mapper.readValue(
                new File("src/main/resources/hotels.json"),
                new TypeReference<List<SearchResult>>() {}
        );
        searchResults.addAll(hotels);

        // Register SearchResource
        environment.jersey().register(new SearchResource(searchResults));
    }
}
