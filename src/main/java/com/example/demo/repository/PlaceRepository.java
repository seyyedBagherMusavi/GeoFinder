package com.example.demo.repository;

import com.example.demo.domain.Place;
import org.springframework.data.geo.Distance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.geo.Point;

import java.util.List;

public interface PlaceRepository extends MongoRepository<Place,String> {
    List<Place> findByLocationNear(Point location, Distance maxDistance);
}
