package com.example.demo.service;


import com.example.demo.domain.Place;
import com.example.demo.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;

    public List<Place> findByLocationNear(Point location, Distance maxDistance){
       return placeRepository.findByLocationNear(location,maxDistance);
    };
}
