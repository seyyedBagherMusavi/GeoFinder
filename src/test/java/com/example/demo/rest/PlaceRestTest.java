package com.example.demo.rest;

import com.example.demo.IntegrationTest;
import com.example.demo.domain.Place;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.service.PlaceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IntegrationTest
@AutoConfigureMockMvc
class PlaceRestTest {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private PlaceRepository placeRepository;

    @BeforeEach
    void setUp() {
        placeRepository.save(new Place()
                .setName("first Asset")
                .setLocation(new GeoJsonPoint(22.4,23.6))
        );
        placeRepository.save(new Place()
                .setName("second Asset")
                .setLocation(new GeoJsonPoint(22.5,23.6))
        );
        placeRepository.save(new Place()
                .setName("third Asset")
                .setLocation(new GeoJsonPoint(22.7,23.6))
        );
        placeRepository.save(new Place()
                .setName("fourth Asset")
                .setLocation(new GeoJsonPoint(22.8,23.6))
        );
    }

    @Test
    void findNearBy() {
        List<Place> all = placeRepository.findAll();
        List<Place> byLocationNear40 =
                placeRepository.findByLocationNear(new Point(22.1, 23.6),
                        new Distance(40.0, Metrics.KILOMETERS));
        List<Place> byLocationNear41 =
                placeRepository.findByLocationNear(new Point(22.1, 23.6),
                        new Distance(41.0, Metrics.KILOMETERS));
        assertThat(all).hasSize(5);
        assertThat(byLocationNear40).hasSize(2);
        assertThat(byLocationNear41).hasSize(3);
    }
}